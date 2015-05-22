/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.mail.enums;

import com.veight.common.enums.BaseEnum;

/**
 * 邮件发送类型
 *
 * @author youyou
 */
public enum EmailType implements BaseEnum {

    MAIL_TEST("testMail.html");

    private final String key;

    private EmailType(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}
