/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.cms.entities.dao;

import com.veight.cms.entities.TagModel;
import com.veight.common.dao.BaseDao;
import java.util.List;
import javax.ejb.Remote;

/**
 * 标签管理
 *
 * @author youyou
 */
@Remote
public interface TagDao extends BaseDao<TagModel, String> {

    public TagModel getByName(String name);

    public List<String> getAllNames();

    public List<TagModel> getAll();

}
