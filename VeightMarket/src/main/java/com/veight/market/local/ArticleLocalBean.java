/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.market.local;

import com.veight.cms.api.ArticleService;
import com.veight.cms.model.Article;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.slf4j.Logger;

/**
 *
 * @author youyou
 */
@LocalBean
@Stateless
public class ArticleLocalBean {

    @Inject
    Logger logger;

    @EJB
    ArticleService articleService;

    public void create(String title,
            String preview,
            String content,
            String authorId,
            String categoryName,
            String tagString) {

        Article article = new Article();
        article.setTitle(title);
        article.setPreview(preview);
        article.setContent(content);

        articleService.create(article, authorId, categoryName, tagString);

    }

    /**
     * 文章详细
     *
     * @param id
     * @return
     */
    public Article getArticleById(String id) {
        return articleService.findById(id);
    }

}
