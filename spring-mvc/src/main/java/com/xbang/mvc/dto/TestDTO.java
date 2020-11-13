package com.xbang.mvc.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/11/13
 * update date: 2020/11/13
 */
@Data
public class TestDTO {
    @NotBlank(message = "Id不能为空")
    private String testId;
    @NotBlank(message = "名称不能为空")
    private String testName;
}
