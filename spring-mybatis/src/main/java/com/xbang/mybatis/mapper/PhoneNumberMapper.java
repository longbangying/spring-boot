package com.xbang.mybatis.mapper;

import com.xbang.mybatis.entity.PhoneNumber;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author admin
 * @date 2020/5/14
 */
@Mapper
public interface PhoneNumberMapper {

    int saveList(List<PhoneNumber> list);

    /**
     * 保存一个号码
     * @param phoneNumber
     * @return
     */
    int saveOne(PhoneNumber phoneNumber);
}
