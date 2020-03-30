package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {
    //获取种类的列表
    List<Category> getCategoryList();

    //通过种类的ID获得种类
    Category getCategory(String categoryId);
}
