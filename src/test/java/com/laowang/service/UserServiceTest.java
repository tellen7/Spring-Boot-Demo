package com.laowang.service;

import com.laowang.dataObject.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wangyonghao8 on 2018/3/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService service;

    @Test
    public void getAll() throws Exception {
        //...
    }

    @Test
    public void getByName() throws Exception {
        List<User> user = service.getByName("我");
        Assert.assertEquals(new Integer(11),user.get(0).getId());
    }

    @Test
    public void getByAge() throws Exception {
        List<User> user = service.getByAge(10);
        Assert.assertEquals("我",user.get(0).getName());
    }

}