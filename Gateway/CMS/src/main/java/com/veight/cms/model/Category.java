package com.veight.cms.model;

import java.io.Serializable;
import java.util.Set;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 * Represents category of article
 *
 * @author Oleg Filippov
 */
@Data
@XmlRootElement
public class Category implements Serializable {

    @XmlElement(name = "id")
    private String id;
    /**
     * Category name
     */
    @XmlElement(name = "name")
    private String name;

    /**
     * Article count having this category
     */
    @XmlElement(name = "articleCount")
    private long articleCount;

    /**
     * Articles having this category
     */
    @XmlElement(name = "articles")
    private Set<Article> articles;

    /**
     * Default constructor
     */
    public Category() {
    }
}
