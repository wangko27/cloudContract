package com.veight.cms.model;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 * Represents comment on article
 *
 * @author Oleg Filippov
 */
@Data
@XmlRootElement
public class Comment implements Serializable {

    @XmlElement(name = "id")
    private String id;
    /**
     * Comment content
     */
    @XmlElement(name = "content")
    private String content;

    /**
     * Creation date and time
     */
    @XmlElement(name = "created")
    private final Date created;

    /**
     * Article which owns comment
     */
    @XmlElement(name = "article")
    private Article article;

    /**
     * Default constructor. For Hibernate use only
     */
    protected Comment() {
        created = new Date();
    }

    /**
     * Constructor initializing required fields
     *
     * @param author
     * @param article
     * @param content
     */
    public Comment(Article article, String content) {
        created = new Date();
        this.article = article;
        this.content = content;
    }
}
