/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author youyou
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
@Data
public class DataTables<T> extends BaseObject {

    private static final long serialVersionUID = 20131015L;

    @XmlElement(name = "page")
    private long page; // 当前页

    @XmlElement(name = "total")
    private long total;  // 总页数

    @XmlElement(name = "records")
    private long records;  // 总记录数

    @XmlElement(name = "rows")
    private List<T> rows;

    public DataTables() {
    }

    public DataTables(final Page<T> pages) {
        page = pages.getPageNumber();
        total = pages.getTotalPages();
        records = pages.getTotal();
        rows = pages.getContent();
    }

}
