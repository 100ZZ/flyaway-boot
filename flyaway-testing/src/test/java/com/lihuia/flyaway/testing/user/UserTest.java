package com.lihuia.flyaway.testing.user;

import com.alibaba.fastjson.JSON;
import com.lihuia.flyaway.testing.mysql.entity.UserDO;
import com.lihuia.flyaway.testing.mysql.config.DataSourceConfig;
import com.lihuia.flyaway.testing.mysql.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

/**
 * @author lihuia.com
 * @date 2022/6/21 10:53 PM
 */

@Slf4j
@ContextConfiguration(classes = {DataSourceConfig.class})
public class UserTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeClass
    public void beforeClass() {

    }

    @Test(description = "user查询")
    public void userTest() {
        UserDO userDO = userMapper.getById(1L);
        log.info("userDO: {}", JSON.toJSONString(userDO, true));
        Assert.assertEquals(userDO.getId(), 1L);
    }

    @Test(description = "mysql查询")
    public void mysqlTest() {
        String sql = "select * from user where 1=1";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        log.info(JSON.toJSONString(result, true));
    }
}