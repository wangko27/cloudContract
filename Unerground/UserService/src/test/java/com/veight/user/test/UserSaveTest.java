package com.veight.user.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.veight.user.entities.UserModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author youyou
 */
public class UserSaveTest {

    public UserSaveTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSimple() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("db-manager");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            for (int i = 0; i < 100; i++) {
                UserModel model = new UserModel("username"+i,"user"+i, "123456", "84585@qq.com", "127.0.0.1");
//                em.persist(model);
            }

            // [INSERT code here to persist object required for testing]
            tx.commit();
        } catch (Throwable thr) {
            fail("Failed to persist data : " + thr.getMessage());
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            em.close();
        }
        emf.close();
    }
}
