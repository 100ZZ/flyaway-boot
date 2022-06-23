package com.lihuia.flyaway.testing.mysql.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lihuia.com
 * @date 2022/6/21 11:57 AM
 */

@Data
public class UserDO {

    private Long id;

    /** 用户 */
    private String username;

    /** 密码 */
    private String password;

    /** token */
    private String token;

    /** 生效时间 */
    private LocalDateTime effectTime;

    /** 失效时间 */
    private LocalDateTime expireTime;
}
