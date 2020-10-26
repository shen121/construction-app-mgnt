package com.demo.mgnt.api.userApi;

import com.demo.mgnt.api.userApi.respDto.UserRespDto;
import com.demo.mgnt.api.util.RestResponse;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 *    用户管理api
 */
@Api(tags = "用户管理api")
@RequestMapping("/v1/mgnt/user")
public interface UserController {

    @GetMapping("/{id}")
    @ApiOperation(value = "通过用户id查询用户", notes = "通过用户id查询用户")
    RestResponse<UserRespDto> getUserById(@PathVariable("id") Long id);

    @GetMapping("/list")
    @ApiOperation(value = "获取所有用户", notes = "获取所有用户")
    RestResponse<PageInfo<UserRespDto>> getAllUser(@RequestParam("pageSize") Integer pageSize,
                                                   @RequestParam("pageNum")  Integer pageNum);
}
