/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.common.dao.criteria;

import com.veight.common.BaseObject;


/**
 *
 * @author rooseek
 */
public class SortItem extends BaseObject {

    private static final long serialVersionUID = 20131015L;

    private final String fieldName;

    private final boolean descending;

    public SortItem(final String fieldName,
                    final boolean descending) {
        this.fieldName = fieldName;
        this.descending = descending;
    }

    public String getFieldName() {
        return fieldName;
    }

    public boolean isDescending() {
        return descending;
    }
}
