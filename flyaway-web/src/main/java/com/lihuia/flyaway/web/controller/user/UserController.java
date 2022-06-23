package com.lihuia.flyaway.web.controller.user;

import com.lihuia.flyaway.common.exception.FlyawayException;
import com.lihuia.flyaway.common.response.Response;
import com.lihuia.flyaway.common.response.ResponseUtil;
import com.lihuia.flyaway.web.entity.user.UserDTO;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author lihuia.com
 * @date 2022/6/21 9:59 AM
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping(value = "/get")
    public Response<UserDTO> getUser(@RequestParam(value = "id") Long id) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setName("lihui");
        userDTO.setAge(18);
        userDTO.setUrl("lihuia.com");
        userDTO.setSex("male");
        return ResponseUtil.buildSuccessResponse(userDTO);
    }

    @PostMapping(value = "/postJson")
    public Response<Boolean> postJSON(@RequestBody UserDTO body) {
        if (ObjectUtils.isEmpty(body.getId())) {
            throw new FlyawayException("body不合法");
        }
        return ResponseUtil.buildSuccessResponse(Boolean.TRUE);
    }

}
