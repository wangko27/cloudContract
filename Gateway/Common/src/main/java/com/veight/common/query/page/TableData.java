/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.common.query.page;

import com.veight.common.BaseObject;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import org.codehaus.jackson.annotate.JsonTypeInfo;

/**
 *
 * @author keven
 */
@XmlRootElement
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class TableData<T> extends BaseObject {

    private static final long serialVersionUID = 20131015L;

    @XmlElement(name = "sEcho")
    private int sEcho;

    @XmlElement(name = "iTotalRecords")
    private long totalResords;

    @XmlElement(name = "iTotalDisplayRecords")
    private long totalDisplayRecords;

    @XmlElement(name = "aaData")
    private List<T> results;

    public TableData() {
    }

    public TableData(final Page<T> pages,int sEcho) {
        results = pages.getContent();
        totalResords = pages.getTotalPages();
        totalDisplayRecords = pages.getTotal();
        this.sEcho = sEcho+1;
    }
}
