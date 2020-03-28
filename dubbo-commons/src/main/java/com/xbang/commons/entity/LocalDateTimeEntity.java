package com.xbang.commons.entity;

import java.time.LocalDateTime;

public class LocalDateTimeEntity {

    private String type;

    private LocalDateTime time;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
