package com.qwm.spring3.tx.dao;

/**
 * @author：qiwenming
 * @date：2017/10/31 0031   20:48
 * @description：
 */
public interface AccountDao {
    /**
     * 加钱
     * @param id
     * @param money
     */
    void increaseMoney(Long id,double money);

    /**
     * 减钱
     * @param id
     * @param money
     */
    void decreaseMoney(Long id,double money);
}
