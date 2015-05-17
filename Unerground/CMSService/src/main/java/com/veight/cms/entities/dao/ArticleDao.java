/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.cms.entities.dao;

import com.veight.cms.entities.Article;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author youyou
 */
@Stateless
public class ArticleDao{

    // Injected database connection:
    @PersistenceContext
    private EntityManager em;

    // Stores a new guest: 
    public void persist(Article guest) {
        em.persist(guest);
    }

    // Stores a new guest: 
    public Article get(long id) {
        return em.find(Article.class, id);
    }

    public List<Article> finAll() {
        try {
            List<Article> result = em.createNamedQuery("Article.GET_ALL", Article.class)
                    .getResultList();
            return result;
        } catch (NoResultException e) {
            return null;
        }
    }

}
