/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.cms.api;

import com.veight.cms.api.model.ArticleModel;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author youyou
 */
@Remote
public interface CMSService {

    public List<ArticleModel> getAllArticles();

}
