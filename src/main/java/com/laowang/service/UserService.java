package com.laowang.service;

import com.laowang.dataObject.User;
import com.laowang.enums.ResultEnums;
import com.laowang.exceptions.UserExceptions;
import com.laowang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by wangyonghao8 on 2018/3/27.
 */
@Service
public class UserService {
    @Autowired
    UserRepository repository;

    /**返回一个用户的信息*/
    public User getOneUser(Integer id){
        return repository.getOne(id);
    }

    /**添加一个用户
     * @param user*/
    public User addUser(User user){
        return repository.save(user);
    }


    /**返回所有用户信息*/
    public List<User> getAll(){
        return repository.findAll();
    }

    /** 通过名字查找所有*/
    public List<User> getByName(String name){
        return repository.findByName(name);
    }

    /**通过age查找*/
    public List<User> getByAge(Integer age){
        return repository.findByAge(age);
    }

    /**添加两个用户，开启事务*/
    @Transactional //age为unique时，回滚成功
    public void addTwo() {
        User user1 = new User();
        user1.setName("aaa");
        user1.setAge(22);
        user1.setEmail("456@qw.com");
        user1.setMoney(123.5f);
        repository.save(user1);

        User user2 = new User();
        user2.setName("aaa");
        user2.setAge(20);
        user2.setEmail("456@qw.com");
        user2.setMoney(123.5f);
        repository.save(user2);

    }

    /**测试抛出自定义异常*/
    public String doSomeService(Integer id) throws Exception{//这里不抛出异常没有报错
        User user = repository.findOne(id);
        if(user.getAge() > 30){
            throw new UserExceptions(ResultEnums.TOO_YOUNG);
        }else if(user.getAge() < 20){
            throw new UserExceptions(ResultEnums.GOOD_AGE);
        }else{
            return "你才20多岁，我借给你钱";
        }
    }

    /**更新id用户的部分信息或则全部信息*/
    public User updateOneUser(User user){
        User old = repository.findOne(user.getId());
        if(user.getName()!= null) old.setName(user.getName());
        if(user.getMoney()!=null) old.setMoney(user.getMoney());
        if(user.getEmail()!=null) old.setEmail(user.getEmail());
        if(user.getAge() != null) old.setAge(user.getAge());
        return repository.save(old);
    }

    /**删除id用户信息*/
    public void deleteOneUser(Integer id){
        repository.delete(id);
    }
}
