/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.cms.entities.dao.impl;

import com.veight.cms.entities.TagModel;
import com.veight.cms.entities.dao.TagDao;
import com.veight.common.dao.impl.BaseDaoImpl;
import java.util.List;
import javax.ejb.Stateless;

/**
 * 文章标签管理
 *
 * @author youyou
 */
@Stateless
public class TagDaoImpl extends BaseDaoImpl<TagModel, String> implements TagDao {

    @Override
    public TagModel getByName(String name) {
        return entityManager.createNamedQuery("TagModel.GET_BY_NAME", TagModel.class).setParameter("name", name).getSingleResult();
    }

    @Override
    public List<String> getAllNames() {
        return entityManager.createNamedQuery("TagModel.GET_ALL_NAMES", String.class).getResultList();
    }

    @Override
    public List<TagModel> getAll() {
        return entityManager.createNamedQuery("TagModel.GET_ALL", TagModel.class).getResultList();
    }

}
