package com.hashtech.web.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author xujie
 * @description 编辑主题请求参数
 * @create 2021-11-24 10:01
 **/
@Data
public class ThemeUpdateRequest {

    /**
     * 主题id
     */
    private String themeId;
    /**
     * 主题名称
     */
    @NotBlank(message = "60000004")
    @Length(max = 12, message = "60000000")
    private String name;
}
