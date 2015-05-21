/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.cms;

import com.veight.cms.api.CMSService;
import com.veight.cms.entities.ArticleModel;
import com.veight.cms.model.Article;
import com.veight.cms.entities.dao.ArticleDao;
import com.veight.cms.utils.ArticleDTOUtils;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.slf4j.Logger;

/**
 *
 * @author youyou
 */
@Remote
@Stateless
public class CMSServiceBean implements CMSService {

    @Inject
    Logger logger;

    @EJB
    private ArticleDao articleDao;

    public List<Article> getAllArticles() {
//        List<ArticleModel> lists = articleDao.finAll();
//        List<Article> results = new ArrayList<>(lists.size());
//        for (ArticleModel art : lists) {
//            logger.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//            results.add(ArticleDTOUtils.getArticleDTO(art));
//        }
        return null;
    }

}
