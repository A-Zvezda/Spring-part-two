package com.geekbrains.geekmarketwinter.repositories;

import com.geekbrains.geekmarketwinter.entites.Product;
import com.geekbrains.geekmarketwinter.entites.User;
import com.geekbrains.geekmarketwinter.services.CategoryService;
import com.geekbrains.geekmarketwinter.services.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Component
public class ProductRepositorySqlO2 {
    private final Sql2o sql2o;
    private CategoryService categoryService;

    @Autowired
    public void setCategoryService (CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    private static final String SELECT_PRODUCT_QUERY = "select id, category_id , vendor_code, title, short_description, " +
            "full_description, price,create_at, update_at from products " +
            " where id = :u_id;";

    public ProductRepositorySqlO2(@Autowired Sql2o sql2o) {
        this.sql2o = sql2o;
    }



    public Product findById(Long id) {
        //System.out.println(SELECT_USER_QUERY);
        try (Connection connection = sql2o.open()) {
            Product product = connection.createQuery(SELECT_PRODUCT_QUERY, false)
                    .addParameter("u_id", id)
                    .setColumnMappings(Product.COLUMN_MAPPINGS)
                    .executeAndFetchFirst(Product.class);

            // product.setCategory(categoryService.findById(product.getCategoryId()));

            return product;
        }
    }

}
