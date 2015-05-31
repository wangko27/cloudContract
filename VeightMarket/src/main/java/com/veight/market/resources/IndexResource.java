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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;

/**
 *
 * @author youyou
 */
@Path("/")
public class IndexResource extends BaseResource {

    @Inject
    Logger logger;

    @EJB
    ArticleService articleService;

    @EJB
    CategoryService categoryService;

    @EJB
    TagService tagService;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response displayIndex() {
        System.out.println("displayIndex");
        Map<String, Object> map = new HashMap<>();
        List<Category> categories = categoryService.findAll();
        logger.debug("categories size {}", categories.size());
        Pageable pageable = new Pageable(0, 20);
        Page<Article> pages = articleService.getByPage(pageable);
        List<Tag> tags = tagService.findAll();
        
        map.put("categories", categories);
        map.put("tags", tags);
        map.put("articles", pages.getContent());
        return forward("/index", map);
    }

}
