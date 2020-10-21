package com.demo.mgnt.api.userApi;

import com.demo.mgnt.api.userApi.respDto.UserRespDtp;
import com.demo.mgnt.api.config.util.RestResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/user")
@RestController
public interface UserController {

    @GetMapping("/{id}")
    RestResponse<UserRespDtp> getUser(@PathVariable("id") Long id);

}
