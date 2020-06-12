package com.geekbrains.geekmarketwinter.repositories;

import com.geekbrains.geekmarketwinter.entites.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import com.geekbrains.geekmarketwinter.entites.User;

import java.util.List;

@Component
public class CategoryRepositorySqlO2 {
    private final Sql2o sql2o;

    private static final String SELECT_ALL_CATEGORY_QUERY = "select id, title, description from categories";

    public CategoryRepositorySqlO2(@Autowired Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public List<Category> getAllCategories() {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(SELECT_ALL_CATEGORY_QUERY, false)
                    .setColumnMappings(User.COLUMN_MAPPINGS)
                    .executeAndFetch(Category.class);
        }
    }
}