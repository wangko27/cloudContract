/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.market.resources;

import com.veight.cms.api.ArticleService;
import com.veight.cms.model.Article;
import com.veight.common.query.page.Page;
import com.veight.common.query.page.Pageable;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;

/**
 *
 * @author youyou
 */
@Path("/search")
public class SearchResource extends BaseResource {

    @Inject
    Logger logger;

    @EJB
    ArticleService articleService;

    @GET
    @Path("/category/{name}")
    public Response displayArticlesByCategory(@PathParam("name") String categoryName) {
        Map<String, Object> map = new HashMap<>();
        Pageable pageable = new Pageable(1, 20);
        Page<Article> page = articleService.getPageByCategoryName(pageable, categoryName);
        logger.debug("displayArticlesByCategory size {}", page.getTotalPages());
        map.put("page", page);
        return forward("/search", map);
    }
}
