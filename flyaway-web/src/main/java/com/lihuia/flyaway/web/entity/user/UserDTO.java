package com.lihuia.flyaway.web.entity.user;

import lombok.Builder;
import lombok.Data;

/**
 * @author lihuia.com
 * @date 2022/6/21 10:11 AM
 */

@Data
public class UserDTO {

    private Long id;
    private String name;
    private Integer age;
    private String url;
    private String sex;
}
