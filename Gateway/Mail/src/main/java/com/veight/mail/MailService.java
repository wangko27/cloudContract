/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.mail;

import com.veight.mail.enums.EmailType;
import java.util.concurrent.Future;
import javax.ejb.Remote;

/**
 * 邮件发送
 *
 * @author youyou
 */
@Remote
public interface MailService {

    /**
     * 通用的邮件发送接口
     *
     * @param type 邮件类型 用于查找邮件模板使用
     * @param subject 邮件标题
     * @param emailAddress 邮件目的地址
     * @param content 邮件内容
     * @return
     */
    Future<Boolean> send(EmailType type, String subject, String emailAddress, String... content);
}
