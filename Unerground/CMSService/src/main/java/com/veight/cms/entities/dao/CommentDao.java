/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.cms.entities.dao;

import com.veight.cms.entities.CommentModel;
import com.veight.common.dao.BaseDao;
import javax.ejb.Remote;

/**
 * 文章评论
 *
 * @author youyou
 */
@Remote
public interface CommentDao extends BaseDao<CommentModel, String> {

}
