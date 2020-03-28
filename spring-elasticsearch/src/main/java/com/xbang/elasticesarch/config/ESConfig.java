package com.xbang.elasticesarch.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;
@Slf4j
//@Configuration
public class ESConfig {

    //@Bean
    public TransportClient transportClient(){
        TransportClient client = null;
        try {
            Settings settings = Settings.builder()
                    .put("cluster.name","xbang")
                    .put("client.transport.sniff",true)
                    .put("thread_pool.search.size",5).build();

            client = new PreBuiltTransportClient(settings);

            TransportAddress transportAddress = new TransportAddress(InetAddress.getByName("192.168.153.133"),9200);
            client.addTransportAddress(transportAddress);
        } catch (UnknownHostException e) {
            log.info("error:{}", e.getMessage());
        }
        return client;
    }

    @Bean
    public RestClient restClient(){
        RestClientBuilder builder = RestClient.builder(new HttpHost("192.168.153.133",9200));
        Header[] headers = new Header[]{new BasicHeader("sdfdf","sfdsfd")};
        builder.setDefaultHeaders(headers);
        builder.setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {
            @Override
            public RequestConfig.Builder customizeRequestConfig(RequestConfig.Builder builder) {
                builder.setSocketTimeout(10000);
                return builder;
            }
        });
        return builder.build();
    }
}
