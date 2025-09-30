package vn.hoidanit.laptopshop.controller.admin;

import org.springframework.web.bind.annotation.GetMapping;

public class ProductController {
    @GetMapping("/admin/product") 
    public String getDashboard(){
        return "admin/product/product_show";
   } 
}
