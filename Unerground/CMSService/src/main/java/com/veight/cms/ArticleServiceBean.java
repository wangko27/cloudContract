/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.cms;

import com.veight.cms.api.ArticleService;
import com.veight.cms.entities.ArticleModel;
import com.veight.cms.entities.CategoryModel;
import com.veight.cms.entities.dao.ArticleDao;
import com.veight.cms.entities.dao.CategoryDao;
import com.veight.cms.model.Article;
import com.veight.cms.model.Category;
import com.veight.cms.utils.ArticleDTOUtils;
import com.veight.cms.utils.CategoryDTOUtils;
import com.veight.common.query.page.Page;
import com.veight.common.query.page.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import org.slf4j.Logger;

/**
 *
 * @author youyou
 */
@Remote
@Stateless
public class ArticleServiceBean implements ArticleService {

    @Inject
    Logger logger;

    @EJB
    ArticleDao articleDao;

    @EJB
    CategoryDao categoryDao;

    @Override
    public void create(Article article, String authorId, String categoryName, String tagString) {
        ArticleModel model = populateArticle(article, authorId, categoryName, tagString);

        logger.debug("create ArticleModel {}", model);
        articleDao.persist(model);
    }

    @Override
    public Page<Article> getByPage(Pageable pageable) {
        List<Article> content = new ArrayList<>();

        Page<ArticleModel> entites = articleDao.findPage(pageable);

        for (ArticleModel model : entites.getContent()) {
            CategoryModel cModel = model.getCategory();
            Category category = CategoryDTOUtils.getCategoryDTO(cModel, articleDao.getArticleCountByCategory(cModel));
            content.add(ArticleDTOUtils.getArticleDTO(model, category));
        }
        return new Page<>(content, entites.getTotal(), entites.getPageable());

    }

    /**
     * Populates an article with author, category and tags from tag-string
     *
     * @param article
     * @param authorId
     * @param categoryName
     * @param tagString
     * @return populated {@link Article}
     * @throws PersistenceException
     */
    private ArticleModel populateArticle(Article article, String authorId, String categoryName, String tagString)
            throws PersistenceException {
        ArticleModel model = new ArticleModel();

        //把Article 转换成Model
        model.setTitle(article.getTitle());
        model.setContent(article.getContent());
        model.setPreview(article.getPreview());

        //todo...
//		if (authorId != null) {	// Add article process
//			User author = userService.get(authorId);
//			article.setAuthor(author);
//		}
        if (categoryName.isEmpty()) {
//			categoryName = Common.DEFAULT_CATEGORY_NAME;
            categoryName = "Games";
            logger.debug("categoryName isEmpty defualt categoryName is Games");
        }
        CategoryModel category = categoryDao.getByName(categoryName);
        model.setCategory(category);

//        if (!tagString.isEmpty()) {
//            Set<Tag> tags = tagService.getTagsFromString(tagString);
//            article.setTags(tags);
//        }
        return model;
    }

    @Override
    public Article findById(String id) {

        ArticleModel model = articleDao.find(id);

        CategoryModel cModel = model.getCategory();
        Category category = CategoryDTOUtils.getCategoryDTO(cModel, articleDao.getArticleCountByCategory(cModel));

        Article article = ArticleDTOUtils.getArticleDTO(model, category);

        return article;
    }

    @Override
    public Page<Article> getPageByCategoryName(Pageable pageable, String categoryName) {
        List<Article> content = new ArrayList<>();
        Page<ArticleModel> entites = articleDao.getByPageByCategoryName(pageable, categoryName);

        for (ArticleModel model : entites.getContent()) {
            CategoryModel cModel = model.getCategory();
            Category category = CategoryDTOUtils.getCategoryDTO(cModel, articleDao.getArticleCountByCategory(cModel));
            content.add(ArticleDTOUtils.getArticleDTO(model, category));
        }
        return new Page<>(content, entites.getTotal(), entites.getPageable());
    }
}
