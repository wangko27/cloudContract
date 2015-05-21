/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.cms.entities.dao.impl;

import com.veight.cms.entities.TagModel;
import com.veight.cms.entities.dao.TagDao;
import com.veight.common.dao.impl.BaseDaoImpl;
import javax.ejb.Stateless;

/**
 * 文章标签管理
 *
 * @author youyou
 */
@Stateless
public class TagDaoImpl extends BaseDaoImpl<TagModel, String> implements TagDao {

}
