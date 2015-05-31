package com.veight.cms.entities.dao.impl;

import com.veight.cms.entities.ArticleModel;
import com.veight.cms.entities.CategoryModel;
import com.veight.cms.entities.dao.ArticleDao;
import com.veight.cms.model.Article;
import com.veight.common.dao.impl.BaseDaoImpl;
import com.veight.common.query.page.Page;
import com.veight.common.query.page.Pageable;
import java.util.List;
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

    @Override
    public Page<ArticleModel> getByPageByCategoryName(Pageable pageable, String categoryName) {
        List<ArticleModel> lists = entityManager.createNamedQuery("ArticleModel.GET_ALL_BY_CATEGORY_NAME", ArticleModel.class)
                .setParameter("name", categoryName)
                .setFirstResult(pageable.getPageNumber())
                .setMaxResults(pageable.getPageSize()).getResultList();
        long count = getCountByCategoryName(categoryName);

        return new Page<>(lists, count, pageable);
    }

    /**
     * 根据栏目统计分页
     *
     * @param categoryName
     * @return
     */
    private long getCountByCategoryName(String categoryName) {
        long count = entityManager.createNamedQuery("ArticleModel.COUNT_ALL_BY_CATEGORY_NAME", long.class)
                .setParameter("name", categoryName)
                .getSingleResult();
        return count;
    }

}
