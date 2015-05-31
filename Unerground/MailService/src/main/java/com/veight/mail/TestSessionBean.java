/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.mail;

import com.veight.mail.enums.EmailType;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import org.slf4j.Logger;

/**
 *
 * @author youyou
 */
@Singleton
public class TestSessionBean {

//    @Inject
//    Logger logger;
    @EJB
    MailService MailService;

//    @Schedule(hour = "*", minute = "*", second = "*/10")
    public void doWork() {
        System.out.println("doWork");
        MailService.send(EmailType.MAIL_TEST, "测试邮件-标题", "845885222@qq.com", "测试邮件");
    }
}
