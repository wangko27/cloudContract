/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.market.resources;

import com.veight.cms.api.ArticleService;
import com.veight.cms.api.CategoryService;
import com.veight.cms.api.TagService;
import com.veight.cms.model.Article;
import com.veight.cms.model.Category;
import com.veight.cms.model.Tag;
import com.veight.common.query.page.Page;
import com.veight.common.query.page.Pageable;
import com.veight.market.local.ArticleLocalBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;

/**
 * market
 *
 * @author youyou
 */
@Path("/article")
public class ArticleResource extends BaseResource {

    @Inject
    Logger logger;

    @EJB
    ArticleService articleService;

    @EJB
    CategoryService categoryService;

    @EJB
    TagService tagService;

    @EJB
    ArticleLocalBean articleLocalBean;

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_HTML)
    public Response displayArticleDetails(@PathParam("id") String id) {
        logger.debug("id ={}", id);
        Map<String, Object> map = new HashMap<>();
        Article article = articleLocalBean.getArticleById(id);
        map.put("article", article);
        return forward("/article/details", map);
    }

    @GET
    @Path("/add")
    @Produces(MediaType.TEXT_HTML)
    public Response displayAddArticle() {

        Map<String, Object> map = new HashMap<>();
        List<Category> categories = categoryService.findAll();
        List<Tag> tags = tagService.findAll();

        map.put("categories", categories);
        map.put("tags", tags);
        return forward("/article/add", map);
    }

    @GET
    @Path("/tags/autocomplete")
    @Produces({MediaType.APPLICATION_JSON})
    public String tagsAutocomplete() {
        String json = tagService.getAutocompleteJson();
        logger.debug("tagsAutocomplete json {}", json);
        return json;
    }

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createArticle(@FormParam("title") String title,
            @FormParam("categoryName") String categoryName,
            @FormParam("tagString") String tagString,
            @FormParam("preview") String preview,
            @FormParam("content") String content) {

        logger.debug("createArticle+++++++++++++++");

        logger.debug("article {}", title);
        logger.debug("categoryName {}", categoryName);
        logger.debug("tagString {}", tagString);
        logger.debug("preview {}", preview);
        logger.debug("content {}", content);

        //创建提交用户
//        Long authorId = (Long) session.getAttribute("loggedUserId");
//        articleService.add(article, authorId, categoryName, tagString);
        articleLocalBean.create(title, preview, content, title, categoryName, tagString);
        return redirect("/");
    }

}
