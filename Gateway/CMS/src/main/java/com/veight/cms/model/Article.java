package com.veight.cms.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

/**
 * Represents an article with String content
 *
 * @author Oleg Filippov
 */
@Data
@XmlRootElement
public class Article implements Serializable {

    @XmlElement(name = "id")
    private String id;
    /**
     * Article title
     */
    @XmlElement(name = "title")
    private String title;

    /**
     * Article preview
     */
    @XmlElement(name = "preview")
    private String preview;

    /**
     * Article content
     */
    @XmlElement(name = "content")
    private String content;

    /**
     * Article creation date and time
     */
    @XmlElement(name = "created")
    private final Date created;

    /**
     * Article modification date and time
     */
    @XmlElement(name = "lastModified")
    private Date lastModified;

    /**
     * Article view count
     */
    @XmlElement(name = "viewCount")
    private int viewCount;

    /**
     * Article comment count
     */
    @XmlElement(name = "commentCount")
    private int commentCount;

    /**
     * Category of this article
     */
    @XmlElement(name = "category")
    private Category category;

    /**
     * Comments to this article
     */
    @XmlElement(name = "comments")
    private Set<Comment> comments;

    /**
     * Tags of this article
     */
    @XmlElement(name = "tags")
    private Set<Tag> tags;

    /**
     * Default constructor initializing needed fields
     */
    public Article() {
        created = new Date();
        viewCount = 0;
    }
}
