package com.qwm.spring3.dao;

import com.qwm.spring3.bean.User;
import java.util.List;
/**
 * @author：qiwenming
 * @date：2017/10/26 0026   21:48
 * @description：
 */
public interface UserDao {
    //增
    void save(User u);
    //删
    void delete(Integer id);
    //改
    void update(User u);
    //查
    User getById(Integer id);
    //查
    int getTotalCount();
    //查
    List<User> getAll();
}
