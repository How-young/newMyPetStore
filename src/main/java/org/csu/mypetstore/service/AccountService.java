package org.csu.mypetstore.service;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.persistence.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    //通过用户名查看账户
    public Account getAccount(String username){
        return accountMapper.getAccountByUsername(username);
    }

    //通过用户名和密码查看用户
    public Account getAccount(String username, String password){
        return accountMapper.getAccountByUsernameAddPassword(username, password);
    }

    //插入账户
    public void insertAccount(Account account){
        accountMapper.insertAccount(account);
    }
}
