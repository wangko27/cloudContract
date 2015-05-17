/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.cms.utils;

import com.veight.cms.api.model.ArticleModel;
import com.veight.cms.entities.Article;

/**
 *
 * @author youyou
 */
public class ArticleDTOUtils {

    /**
     * handle article
     *
     * @param article
     * @return
     */
    public static ArticleModel getArticleModelDTO(Article article) {

        ArticleModel result = null;
        if (article != null) {
            result = new ArticleModel();
            result.setLastModified(article.getCreated());
        }
        return result;
    }
}
