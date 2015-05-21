package com.veight.cms.entities.dao.impl;

import com.veight.cms.entities.ArticleModel;
import com.veight.cms.entities.CategoryModel;
import com.veight.cms.entities.dao.ArticleDao;
import com.veight.common.dao.impl.BaseDaoImpl;
import javax.ejb.Stateless;

/**
 * 文章管理
 *
 * @author youyou
 */
@Stateless
public class ArticleDaoImpl extends BaseDaoImpl<ArticleModel, String> implements ArticleDao {

    @Override
    public long getArticleCountByCategory(CategoryModel category) {
        return entityManager.createNamedQuery("ArticleModel.GET_ARTICLE_COUNT_BY_CATEGORY_ID", long.class).setParameter("category", category).getSingleResult();
    }

}
