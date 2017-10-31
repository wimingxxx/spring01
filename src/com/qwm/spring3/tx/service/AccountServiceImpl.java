package com.qwm.spring3.tx.service;

import com.qwm.spring3.tx.dao.AccountDao;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author：qiwenming
 * @date：2017/10/31 0031   21:02
 * @description：
 */
@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = false)
public class AccountServiceImpl implements AccountService {

    private AccountDao ad;
    private TransactionTemplate tt;

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = false)
    public void updateMoney(Long fromId, Long toId, Double money) {
        //减钱
        ad.decreaseMoney(fromId,money);
//        int i = 1/0;
        //加钱
        ad.increaseMoney(toId,money);
    }

//    @Override
//    public void updateMoney(Long fromId, Long toId, Double money) {
//        tt.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
//                //减钱
//                ad.decreaseMoney(fromId,money);
//                int i=1/0;
//                //加钱
//                ad.increaseMoney(toId,money);
//            }
//        });
//    }


    public void setAd(AccountDao ad) {
        this.ad = ad;
    }

    public void setTt(TransactionTemplate tt) {
        this.tt = tt;
    }
}