/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.cms.utils;

import com.veight.cms.entities.CategoryModel;
import com.veight.cms.model.Category;

/**
 * 栏目DTO
 *
 * @author youyou
 */
public class CategoryDTOUtils {

    public static Category getCategoryDTO(CategoryModel model, long articleCount) {

        Category result = null;
        if (model != null) {
            result = new Category();
            result.setId(model.getId());
            result.setName(model.getName());
            result.setArticleCount(articleCount);
        }
        return result;
    }
}
