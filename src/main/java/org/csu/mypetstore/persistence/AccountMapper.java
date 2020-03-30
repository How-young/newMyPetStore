package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper {
    //通过用户名获取用户账号
    Account getAccountByUsername(String username);

    //通过用户名和密码获取用户账号
    Account getAccountByUsernameAddPassword(String username, String password);

    //插入账户
    void insertAccount(Account account);
}
