/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.cms.api;

import com.veight.cms.model.Category;
import com.veight.common.query.page.Page;
import com.veight.common.query.page.Pageable;
import javax.ejb.Remote;

/**
 *
 * @author youyou
 */
@Remote
public interface CategoryService {

    public Category getByName(String name);

    public Page<Category> findByPage(Pageable pageable);
;

}
