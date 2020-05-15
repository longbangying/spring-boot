package com.xbang.mybatis.number.impl;

import com.xbang.mybatis.entity.PhoneNumber;
import com.xbang.mybatis.mapper.PhoneNumberMapper;
import com.xbang.mybatis.number.service.NumberLoadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * @author admin
 * @date 2020/5/14
 */
@Slf4j
@Service
public class DefaultServiceImpl implements NumberLoadService {

    private Integer fieldCount  = 7;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PhoneNumberMapper phoneNumberMapper;

    @Override
    public Integer getAreaId() {
        return 1;
    }

    @Override
    public Integer getIsp() {
        return 1;
    }

    @Override
    public Integer getChannelNo() {
        return 1;
    }

    @Override
    public void loadNumber() {
       int pageSize = 1000;
       int pageNumber = 1;
       List<PhoneNumber> numberList = null;
       while (true){
           numberList = getNumber(pageSize,pageNumber);
           if(numberList.isEmpty()){
               break;
           }
           saveNumber(numberList);
           log.info("current pageNo:{}",pageNumber++);
       }

       log.info("跑完了");


    }


    private List<PhoneNumber> getNumber(int pageSize,int pageNumber){

        try {
            String url = "http://sz.haoma.com/io/5.asp?cnt="+pageSize+"&page_no="+pageNumber+"&numcategory=0&dis=6&lanmu=0";
            URI uri = new URI(url);
            MultiValueMap<String, String> header = new LinkedMultiValueMap<String, String>();

            header.put(HttpHeaders.COOKIE,getCookies());
            header.put("Host", Arrays.asList("sz.haoma.com"));
            header.put("Referer",Arrays.asList("http://sz.haoma.com/xh/?adid=6&dis=6&bd_vid=7893278677273777409"));
            header.put("User-Agent",Arrays.asList("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36"));
            RequestEntity requestEntity = new RequestEntity(header,HttpMethod.GET,uri);

            ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity,String.class);
            String result = responseEntity.getBody();
            List<PhoneNumber> numberList = coverResult(result);
            return numberList;
        }catch (URISyntaxException e){
            e.printStackTrace();
        }
        return Collections.emptyList();

    }



    private void saveNumber(List<PhoneNumber> numberList){
        phoneNumberMapper.saveList(numberList);
    }


    public List<String> getCookies(){

        List<String> cookies =new ArrayList<String>();
        cookies.add("adid=6");
        cookies.add("ASPSESSIONIDSCDTDSTT=IOBOIPFCFBJOLNPJBDOALGMD");
        cookies.add("__51cke__=");
        cookies.add("ComeUrl=");
        cookies.add("guanjianzi=");
        cookies.add("__51laig__=3");
        cookies.add("__tins__1998171=%7B%22sid%22%3A%201589463348672%2C%20%22vd%22%3A%203%2C%20%22expires%22%3A%201589465188012%7D");
        cookies.add("ASPSESSIONIDSACSDTTT=LCEBHLCDJIAIHOMJIAOKGOJO");
        return cookies;
    }


    private List<PhoneNumber> coverResult(String resultStr){

        List<String> list = Arrays.asList(resultStr.split("\\|"));
        List<PhoneNumber> resultList = new ArrayList<>(list.size());
        for(String item : list){
            PhoneNumber number = str2Number(item);
            if(null == number){
                continue;
            }
            resultList.add(number);
        }
        return resultList;
    }

    /**
     * 13028818888,6,1,100000,0,0,477300314,
     *  号码,区域,运营商，价格，话费，，ID,
     * @param str
     * @return
     */
    private PhoneNumber str2Number(String str){
        if(StringUtils.isEmpty(str)){
            return null;
        }
        List<String> stringList = Arrays.asList(str.split(","));
        if(stringList.size() < fieldCount){
            return null;
        }
        PhoneNumber number = new PhoneNumber();
        number.setPhoneNumber(stringList.get(0));
        number.setAreaId(getAreaId());
        if("6".equals(stringList.get(1))){
            number.setAreaId(1);

        }
        number.setIsp(getIsp());
        if("0".equals(stringList.get(1))){
            number.setIsp(1);
        }
        number.setPrice(new BigDecimal(stringList.get(3)));
        number.setTelephoneCharge(new BigDecimal(stringList.get(4)));
        number.setThirdParty(stringList.get(6));
        number.setChannelNo(getChannelNo());
        number.setDataState(1);
        number.setPhoneState(1);
        number.setDateCreated(new Date());
        number.setDateUpdated(new Date());
        number.setCreatedBy("system");
        number.setUpdatedBy("system");


        return number;
    }




}
