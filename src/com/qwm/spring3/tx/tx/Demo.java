package com.qwm.spring3.tx.tx;

import com.qwm.spring3.tx.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author：qiwenming
 * @date：2017/10/31 0031   21:32
 * @description：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/qwm/spring3/tx/applicationContext.xml")
public class Demo {

    @Resource(name = "accountService")
    private AccountService as;

    @Test
    public void test1(){
        as.updateMoney(1L,2L,100D);
    }

}
