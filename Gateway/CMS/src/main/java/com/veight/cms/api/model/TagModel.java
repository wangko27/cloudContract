package com.veight.cms.api.model;

import java.io.Serializable;
import java.util.Set;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 * Represents tag of article
 *
 * @author Oleg Filippov
 */
@Data
@XmlRootElement
public class TagModel implements Serializable {

    @XmlElement(name = "id")
    private String id;
    /**
     * Tag name
     */
    @XmlElement(name = "name")
    private String name;

    /**
     * Article count tagged with this tag
     */
    @XmlElement(name = "articleCount")
    private int articleCount;

    /**
     * Articles tagged with this tag
     */
    @XmlElement(name = "articles")
    private Set<ArticleModel> articles;

    /**
     * Default constructor
     */
    public TagModel() {
    }

}
