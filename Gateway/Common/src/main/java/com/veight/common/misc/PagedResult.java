/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.common.misc;

import com.veight.common.BaseObject;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author sobranie
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PagedResult<T> extends BaseObject {

    private static final long serialVersionUID = 20131015L;

    private List<T> results;

    private int totalSize;

    public PagedResult() {
    }

    public PagedResult(List<T> results,
                       int totalSize) {
        this.results = results;
        this.totalSize = totalSize;
    }

    public List<T> getResults() {
        return results;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }
}
