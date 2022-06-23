package com.lihuia.flyaway.testing.mysql.mapper;

import com.lihuia.flyaway.testing.mysql.entity.UserDO;

/**
 * @author lihuia.com
 * @date 2022/6/21 11:59 AM
 */

public interface UserMapper {

    UserDO getById(Long id);
}
