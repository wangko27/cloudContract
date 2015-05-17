/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.cms;

import com.veight.cms.api.CMSService;
import com.veight.cms.api.model.ArticleModel;
import com.veight.cms.entities.Article;
import com.veight.cms.entities.dao.ArticleDao;
import com.veight.cms.utils.ArticleDTOUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author youyou
 */
@Remote
@Stateless
public class CMSServiceBean implements CMSService {

    @Inject
    org.slf4j.Logger logger;

    @EJB
    private ArticleDao articleDao;

    public List<ArticleModel> getAllArticles() {
        logger.info("!!!!!!!!!!!getAllArticlesgetAllArticlesgetAllArticlesgetAllArticlesgetAllArticlesgetAllArticles!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        List<Article> lists = articleDao.finAll();
        List<ArticleModel> results = new ArrayList<ArticleModel>(lists.size());
        for (Article art : lists) {
            logger.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            results.add(ArticleDTOUtils.getArticleModelDTO(art));
        }
        return null;
    }

}
