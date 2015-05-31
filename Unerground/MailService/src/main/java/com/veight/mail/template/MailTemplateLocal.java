/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.mail.template;

import com.veight.mail.enums.EmailType;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

/**
 * 加载模板
 *
 * @author youyou
 */
public class MailTemplateLocal {

    private Configuration configuration;

    private String templateDirectory;

    private Logger logger;

    public MailTemplateLocal() throws IOException {
        configuration = new Configuration();
        templateDirectory = this.getClass().getResource("").getPath();

        configuration.setDirectoryForTemplateLoading(new File(templateDirectory));
        configuration.setObjectWrapper(new DefaultObjectWrapper());

        logger = org.slf4j.LoggerFactory.getLogger(MailTemplateLocal.class);
    }

    /**
     * 获取要发送邮件的内容 通过freemarker来生成
     *
     * @param type
     * @param content
     * @return
     */
    public String getContent(EmailType type, String... content) {
        String sendContent = "";
        Map<String, String> root = new HashMap<>();
        switch (type) {
            case MAIL_TEST:
                //待做 生成内容
                root.put("p1", content[0]);
                root.put("p2", "这是测试邮件,如果不是本人操作,请忽略.");
                sendContent = makeContent(type.getKey(), root);
                break;
            default:
                logger.warn("邮件类型不正确,邮件发送失败.");
        }

        return sendContent;
    }

    public String makeContent(String templateName, Map<String, String> root) {
        Writer out = null;
        try {
            Template template = configuration.getTemplate(templateName);
            out = new StringWriter();
            template.process(root, out);

            out.flush();
            return out.toString();
        } catch (IOException | TemplateException ex) {
            logger.error("Fail to get content from freemaker. [mailTemplate={}][mail={}]", templateName, ex);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    logger.error("Fail to close StringWriter.", ex);
                }
            }
        }
        return StringUtils.EMPTY;
    }

}
