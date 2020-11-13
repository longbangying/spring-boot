package com.xbang.commons.jackjson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.xbang.commons.utils.LocalDateUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/11/13
 * update date: 2020/11/13
 */
public class LolcalDateTimeSerializer  extends JsonSerializer {
    @Override
    public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if(o instanceof LocalDateTime){
            jsonGenerator.writeString(LocalDateUtils.localDateTimeToString((LocalDateTime)o));
        }
        if(o instanceof LocalDate){
            jsonGenerator.writeString(LocalDateUtils.localDateToString((LocalDate)o));
        }
    }
}
