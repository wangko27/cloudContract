/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.cms.api;

import com.veight.cms.model.Article;
import com.veight.common.query.page.Page;
import com.veight.common.query.page.Pageable;
import javax.ejb.Remote;

/**
 *
 * @author youyou
 */
@Remote
public interface ArticleService {

    public void create(Article article, Long authorId, String categoryName, String tagString);

    public Page<Article> getByPage(Pageable pageable);
}
