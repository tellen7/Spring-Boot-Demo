package com.laowang.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * Created by wangyonghao8 on 2018/3/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc//测试controller必须加入此注解
public class UserRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getOneUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/get/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}