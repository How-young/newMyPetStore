package org.csu.mypetstore;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.AccountService;
import org.csu.mypetstore.service.CatelogService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("org.csu.mypetstore.persistence")
class MypetstoreApplicationTests {

    @Autowired
    CatelogService catelogService;

    @Autowired
    AccountService accountService;

    @Test
    void contextLoads() {
    }

    @Test
    void testCategory(){
        Category c = catelogService.getCategory("BIRDS");
        List<Category> categoryList = catelogService.getCategoryList();
        System.out.println(c.getCategoryId() + c.getDescription() + c.getName());
        System.out.println(categoryList.size());
    }

    @Test
    void testProduct(){
        List<Product> productList = catelogService.getProductListByCategory("BIRDS");
        System.out.println(productList.size());
        List<Product> list = catelogService.getProductListBySearch("A");
        System.out.println(list.size());
    }

    @Test
    void testItem(){
        List<Item> itemList = catelogService.getItemListByProduct("RP-SN-01");
        System.out.println(itemList.size());
        Item item = catelogService.getItem("EST-1");
        System.out.println(item.toString());
        System.out.println(catelogService.isItemInStock("EST-1"));
    }

    @Test
    void testAccount(){
        Account account = accountService.getAccount("ACID");
        System.out.println(account.toString());
//        Account a = accountService.getAccount("ACID", "ACID");
//        System.out.println(a.toString());

        Account account1 = new Account();
        account1.setUsername("123456789");
        account1.setPassword("123456789");
        account1.setAddress2("zhyzhyzhy");
        accountService.insertAccount(account1);
    }
}
