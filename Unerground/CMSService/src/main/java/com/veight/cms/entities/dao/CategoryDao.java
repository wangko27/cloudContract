/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.cms.entities.dao;

import com.veight.cms.entities.CategoryModel;
import com.veight.common.dao.BaseDao;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author youyou
 */
@Remote
public interface CategoryDao extends BaseDao<CategoryModel, String> {

    public CategoryModel getByName(String name);

    public List<CategoryModel> getAll();
}
