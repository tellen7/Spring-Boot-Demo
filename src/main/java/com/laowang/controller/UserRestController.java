package com.laowang.controller;

import com.laowang.dataObject.Result;
import com.laowang.dataObject.User;
import com.laowang.service.UserService;
import com.laowang.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by wangyonghao8 on 2018/3/27.
 */
@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    UserService service;

    /**获取id用户信息*/
    @GetMapping(value = "/get/{id}")
    public Result getOneUser(@PathVariable Integer id){
        return ResultUtils.success(service.getOneUser(id));
    }

    /**获取所有用户信息*/
    @GetMapping(value = "/get/all")
    public Result getAll(){
        return ResultUtils.success(service.getAll());//result对象里的List对象也会被解析成json
    }

    /**添加新的用户信息*/
    @PostMapping(value = "/add")
    public Result addOneUser(@Valid User user){
        return ResultUtils.success(service.addUser(user));
    }


    /**删除id用户*/
    @DeleteMapping(value = "/{id}")
    public Result deleteOneUser(@PathVariable("id") Integer id){
        service.deleteOneUser(id);
        return ResultUtils.success("成功删除");
    }

    /**更新id用户信息*/
    @PostMapping(value = "update/{id}")
    public Result updateOneUser(@Valid User user, BindingResult bind){
        //：此方法内，post请求体中没有id则会自动把url上的id封装到user内
        //user相关属性在请求体内没有设置，则置为null
        if(bind.hasErrors()){
            return ResultUtils.error(2,bind.getFieldError().getDefaultMessage());
        }
        return ResultUtils.success(service.updateOneUser(user));
    }

    //通过路径参数查询
    @GetMapping(value = "/get") //路径上如 get?name=老王
    public Result findUserByName(@RequestParam("name") String name){
        return ResultUtils.success(service.getByName(name));
    }

    //通过路经查询
    @GetMapping(value = "/gets")
    public Result findUserByAge(@RequestParam("age") Integer age){
        return ResultUtils.success(service.getByAge(age));
    }

    /**添加两个用户，演示事务回滚*/
    @RequestMapping(value = "/add/two") //演示数据库事务回滚，数据库字段加约束
    public Result addTwo(){
        service.addTwo();
        return ResultUtils.success();
    }

    /**id借钱*/
    @GetMapping(value = "/{id}/borrowMoney")
    public Result borrowMoney(@PathVariable("id") Integer id) throws Exception{
        return ResultUtils.success(service.doSomeService(id));//这里竟然能把自定义异常捕获
    }
}
