package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    //通过种类获取产品列表
    List<Product> getProductListByCategory(String category);

    //通过产品ID获取产品
    Product getProduct(String productId);

    //通过搜索获取产品列表
    List<Product> getProductListBySearch(String keywords);
}
