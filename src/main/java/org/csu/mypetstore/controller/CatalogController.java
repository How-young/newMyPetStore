package org.csu.mypetstore.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.CatelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/catalog")
public class CatalogController {
    @Autowired
    private CatelogService catelogService;

    @GetMapping("/view")
    public String view(){
        return "catalog/main";
    }

    @GetMapping("/viewCategory")
    public String viewCategory(String categoryId, Model model){
        if (categoryId != null){
            Category category = catelogService.getCategory(categoryId);
            List<Product> productList = catelogService.getProductListByCategory(categoryId);
            model.addAttribute("category", category);
            model.addAttribute("productList", productList);
        }
        return "catalog/category";
    }

    @GetMapping("/viewProduct")
    public String viewProduct(String productId, Model model){
        if (productId != null){
            Product product = catelogService.getProduct(productId);
            List<Item> itemList = catelogService.getItemListByProduct(productId);
            model.addAttribute("product", product);
            model.addAttribute("itemList", itemList);
        }
        return "catalog/product";
    }

    @GetMapping("/viewItem")
    public String viewItem(String itemId, Model model){
        Item item = catelogService.getItem(itemId);
        Product product = item.getProduct();
        processProductDescription(product);
        model.addAttribute("product", product);
        model.addAttribute("item", item);

        return "catalog/item";
    }

    @GetMapping("/searchProducts")
    public String searchProduct(String keyword, Model model){
        if (keyword == null || keyword.length() < 1){
            String msg = "Please enter a keyword to search for, then press the search button.";
            model.addAttribute("msg", msg);
            return "common/error";
        } else {
            List<Product> productList = catelogService.getProductListBySearch(keyword.toLowerCase());
            processProductDescription(productList);
            model.addAttribute("productList", productList);
            return "catalog/search_product";
        }
    }

    private void processProductDescription(Product product){
        String[] temp = product.getDescription().split("\"");
        product.setDescriptionIamge(temp[1]);
        product.setDescriptionText(temp[2].substring(1));
    }

    private void processProductDescription(List<Product> productList){
        for (Product product : productList){
            processProductDescription(product);
        }
    }


}
