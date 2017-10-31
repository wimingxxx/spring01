package com.qwm.spring3.tx.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @author：qiwenming
 * @date：2017/10/31 0031   20:49
 * @description：
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao{
    @Override
    public void increaseMoney(Long id, double money) {
        getJdbcTemplate().update("update t_account set money=money+? where id=?",money,id);
    }

    @Override
    public void decreaseMoney(Long id, double money) {
        getJdbcTemplate().update("update t_account set money=money-? where id=?",money,id);
    }
}
