package com.xbang.commons.entity;

import com.xbang.commons.validate.Create;
import com.xbang.commons.validate.Update;
import com.xbang.commons.validate.annotation.IdCard;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class UserInfo implements Serializable {
    @NotBlank(groups = Update.class,message = "用户ID不能为空")
    private String userId;
    @NotBlank(groups = {Create.class,Update.class},message = "用户名不能为空")
    @Length(groups = {Create.class,Update.class},max = 20,message = "用户名不能超过20个字符")
    private String userName;


    @NotNull(groups = {Create.class,Update.class},message = "身份证为必填项")
    @NotBlank(groups = {Create.class,Update.class},message = "身份证号不能为空")
    @IdCard(groups = {Create.class,Update.class},message = "身份证号码不合法,请核验后再提交")
    private String idCard;

    @NotNull(groups = {Create.class,Update.class},message = "性别为必填项")
    @Min(groups = {Create.class,Update.class},value = 1,message = "性别的码值在1-2")
    @Max(groups = {Create.class,Update.class},value = 2,message = "性别的码值在1-2")
    private Integer sex;

    @NotBlank(groups = {Create.class, Update.class}, message = "邮箱不能为空")
    @Email(groups = {Create.class, Update.class}, message = "邮箱格式不对")
    private String email;

    private String provider;

    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static AtomicLong getCount() {
        return count;
    }

    public static void setCount(AtomicLong count) {
        UserInfo.count = count;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", provider='" + provider + '\'' +
                '}';
    }

    private static AtomicLong count = new AtomicLong();
    public static UserInfo generate(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(""+ count.incrementAndGet());
        userInfo.setProvider("system");
        userInfo.setEmail(System.currentTimeMillis()+"@qq.com");
        userInfo.setIdCard(UUID.randomUUID().toString());
        return userInfo;
    }
}
