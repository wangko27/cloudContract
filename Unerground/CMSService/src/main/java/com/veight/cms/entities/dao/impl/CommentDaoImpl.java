/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.cms.entities.dao.impl;

import com.veight.cms.entities.CommentModel;
import com.veight.cms.entities.dao.CommentDao;
import com.veight.common.dao.impl.BaseDaoImpl;
import javax.ejb.Stateless;

/**
 * 文章评论
 *
 * @author youyou
 */
@Stateless
public class CommentDaoImpl extends BaseDaoImpl<CommentModel, String> implements CommentDao {

}
