package com.veight.cms.api.model;

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
public class CommentModel implements Serializable {

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
    private ArticleModel article;

    /**
     * Default constructor. For Hibernate use only
     */
    protected CommentModel() {
        created = new Date();
    }

    /**
     * Constructor initializing required fields
     *
     * @param author
     * @param article
     * @param content
     */
    public CommentModel(ArticleModel article, String content) {
        created = new Date();
        this.article = article;
        this.content = content;
    }
}
