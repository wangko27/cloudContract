/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.cms.utils;

import com.veight.cms.entities.ArticleModel;
import com.veight.cms.model.Article;
import com.veight.cms.model.Category;

/**
 *
 * @author youyou
 */
public class ArticleDTOUtils {

    /**
     * handle article
     *
     * @param model
     * @param category
     * @return
     */
    public static Article getArticleDTO(ArticleModel model, Category category) {

        Article result = null;
        if (model != null) {
            result = new Article();

            result.setId(model.getId());
            result.setTitle(model.getTitle());
            result.setPreview(model.getPreview());
            result.setContent(model.getContent());
            result.setCategory(category);
            result.setViewCount(model.getViewCount());
            result.setLastModified(model.getCreated());
        }
        return result;
    }
}
