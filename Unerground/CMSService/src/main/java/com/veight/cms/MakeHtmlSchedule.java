/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.cms;

import com.veight.cms.entities.dao.ArticleDao;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.slf4j.Logger;

/**
 * 845885222@qq.com
 *
 * @author youyou
 */
@Stateless
@Singleton
public class MakeHtmlSchedule {

//    private static final Logger LOGGER = Logger.getLogger(MakeHtmlSchedule.class.getCanonicalName());
//    @Inject
//    Logger logger;

//    @EJB
//    private ArticleDao articleDao;
//
//    @Schedule(second = "*/5", minute = "*", hour = "*", persistent = false)
//    public void doWork() {
////        List<Article> lists = articleDao.finAll();
////        for (Article art : lists) {
////            LOGGER.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!-"+art.getId());
////        }
//        Date currentTime = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
//        logger.debug("logger ScheduleExample.doWork() invoked at " + simpleDateFormat.format(currentTime));
//        System.out.println("ScheduleExample.doWork() invoked at " + simpleDateFormat.format(currentTime));
//    }
}
