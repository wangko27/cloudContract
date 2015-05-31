/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.mail;

import com.veight.mail.enums.EmailType;
import com.veight.mail.template.MailTemplateLocal;
import java.io.IOException;
import java.util.concurrent.Future;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.Session;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;

/**
 * 邮件发送实现
 *
 * @author youyou
 */
@Remote
@Stateless
public class MailServiceBean implements MailService {

    @Inject
    Logger logger;

    @Resource(mappedName = "MyMailSession")
    Session mailSession;

    /**
     * get text/html template for email
     */
    private MailTemplateLocal template;

    @PostConstruct
    void init() {
        try {
            template = new MailTemplateLocal();
        } catch (IOException ex) {
            logger.error("Failed to initialize the EmailTemplate", ex);
        }
    }

    /**
     * 邮件真是发送中.需要自己定义邮件发送模板 放到resources 的com.veight.mail.template下
     *
     * @param type
     * @param subject
     * @param emailAddress
     * @param content
     * @return
     */
    @Override
    public Future<Boolean> send(EmailType type, String subject, String emailAddress, String... content) {
        try {
            logger.debug("邮件发送");
            String text = template.getContent(type, content);
            Message message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress("845885222@qq.com"));
            Address toAddress = new InternetAddress(emailAddress);
            message.addRecipient(Message.RecipientType.TO, toAddress);
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);

            return new AsyncResult<>(true);
        } catch (MessagingException ex) {
            logger.error("Exception happend when sending email.[emailAddress={}][type={}]", emailAddress, type, ex);
            return new AsyncResult<>(false);
        }
    }

}
