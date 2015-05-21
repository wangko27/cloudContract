package com.veight.cms.entities.dao;

import com.veight.cms.entities.ArticleModel;
import com.veight.cms.entities.CategoryModel;
import com.veight.common.dao.BaseDao;
import javax.ejb.Remote;

/**
 * 文章管理
 *
 * @author youyou
 */
@Remote
public interface ArticleDao extends BaseDao<ArticleModel, String> {

    /**
     * 获取该id栏目下的文章数
     *
     * @param category
     * @return
     */
    public long getArticleCountByCategory(CategoryModel category);

}
