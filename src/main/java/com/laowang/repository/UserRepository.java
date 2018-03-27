package com.laowang.repository;

import com.laowang.dataObject.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wangyonghao8 on 2018/3/27.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByName(String name);
    List<User> findByAge(Integer age);
}
