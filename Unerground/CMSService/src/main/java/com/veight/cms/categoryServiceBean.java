/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.cms;

import com.veight.cms.api.CategoryService;
import com.veight.cms.entities.CategoryModel;
import com.veight.cms.entities.dao.ArticleDao;
import com.veight.cms.entities.dao.CategoryDao;
import com.veight.cms.model.Category;
import com.veight.cms.utils.CategoryDTOUtils;
import com.veight.common.query.page.Page;
import com.veight.common.query.page.Pageable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author youyou
 */
@Stateless
public class categoryServiceBean implements CategoryService {

    @EJB
    CategoryDao categoryDao;

    @EJB
    ArticleDao articleDao;

    @Override
    public Category getByName(String name) {

        CategoryModel model = categoryDao.getByName(name);

        Category category = new Category();

        category.setId(model.getId());
        category.setName(model.getName());
        category.setArticleCount(articleDao.getArticleCountByCategory(model));
//        category.setArticles();

        return null;
    }

    @Override
    public Page<Category> findByPage(Pageable pageable) {

        List<Category> content = new ArrayList<>();
        Page<CategoryModel> entities = categoryDao.findPage(pageable);

        for (CategoryModel model : entities.getContent()) {
            long articleCount = articleDao.getArticleCountByCategory(model);//该栏目文章总数
            Category category = CategoryDTOUtils.getCategoryDTO(model, articleCount);
            content.add(category);

        }
        return new Page<>(content, entities.getTotal(), entities.getPageable());
    }

    @Override
    public List<Category> findAll() {
        List<Category> content = new ArrayList<>();
        List<CategoryModel> lists = categoryDao.getAll();

        for (CategoryModel model : lists) {
            long articleCount = articleDao.getArticleCountByCategory(model);//该栏目文章总数
            Category category = CategoryDTOUtils.getCategoryDTO(model, articleCount);
            content.add(category);

        }
        return content;
    }
}
