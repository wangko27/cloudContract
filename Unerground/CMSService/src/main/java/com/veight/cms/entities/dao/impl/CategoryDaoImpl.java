    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.cms.entities.dao.impl;

import com.veight.cms.entities.CategoryModel;
import com.veight.cms.entities.dao.CategoryDao;
import com.veight.common.dao.impl.BaseDaoImpl;
import javax.ejb.Stateless;

/**
 * 栏目管理
 *
 * @author youyou
 */
@Stateless
public class CategoryDaoImpl extends BaseDaoImpl<CategoryModel, String> implements CategoryDao {

    @Override
    public CategoryModel getByName(String name) {
        
        return entityManager.createNamedQuery("CategoryModel.GET_BY_NAME", CategoryModel.class)
                .setParameter("name", name).getSingleResult();
    }

}
