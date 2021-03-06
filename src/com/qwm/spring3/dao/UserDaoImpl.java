package com.qwm.spring3.dao;

import com.qwm.spring3.bean.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author：qiwenming
 * @date：2017/10/26 0026   21:49
 * @description：
 * 使用JDBC模板实现增删改查
 */
public class UserDaoImpl implements UserDao{
    private JdbcTemplate jt;

    public JdbcTemplate getJt() {
        return jt;
    }

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }

    @Override
    public void save(User u) {
        String sql = "insert into t_user values(null,?)";
        jt.update(sql,u.getName());
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from t_user where id=?";
        jt.update(sql,id);
    }

    @Override
    public void update(User u) {
        String sql = "update t_user set name=? where id=?";
        jt.update(sql,u.getName(),u.getId());
    }

    @Override
    public User getById(Integer id) {
        String sql = "select * from t_user where id=?";
        return jt.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int index) throws SQLException {
                User u = new User();
                u.setId(resultSet.getInt("id"));
                u.setName(resultSet.getString("user"));
                return u;
            }
        }, id);
    }

    @Override
    public int getTotalCount() {
        String sql = "select count(*) from t_user";
        int count = jt.queryForObject(sql,Integer.class);
        return count;
    }

    @Override
    public List<User> getAll() {
        String sql = "select * from t_user";
        return jt.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId( resultSet.getInt("id") );
                user.setName( resultSet.getString("name") );
                return user;
            }
        });
    }
}
