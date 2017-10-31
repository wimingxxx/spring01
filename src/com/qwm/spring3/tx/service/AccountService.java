package com.qwm.spring3.tx.service;

/**
 * @author：qiwenming
 * @date：2017/10/31 0031   21:00
 * @description：
 */
public interface AccountService {
    void updateMoney(Long fromId , Long toId, Double money);
}
