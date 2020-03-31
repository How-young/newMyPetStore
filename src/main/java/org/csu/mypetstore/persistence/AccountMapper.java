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

    //插入profile
    void insertProfile(Account account);

    //插入登录
    void insertSignon(Account account);

    //更新账户
    void updateAccount(Account account);

    //更新profile
    void updateProfile(Account account);

    //更新signon
    void updateSignon(Account account);
}
