package com.veight.common.entities;

import com.veight.common.listener.EntityListener;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import lombok.Getter;
import lombok.Setter;

/**
 * Base class for all entity-classes. Defines the primary id and version.
 *
 * @author Oleg Filippov
 */
@EntityListeners(EntityListener.class)
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1520556867799623763L;

    /**
     * "ID"属性名称
     */
    public static final String ID_PROPERTY_NAME = "id";

    /**
     * "创建日期"属性名称
     */
    public static final String CREATE_DATE_PROPERTY_NAME = "createDate";

    /**
     * "修改日期"属性名称
     */
    public static final String MODIFY_DATE_PROPERTY_NAME = "modifyDate";
    /**
     * Version of the persistent object
     */
    @Getter
    @Setter
    @Version
    @Column(nullable = false, insertable = false, columnDefinition = "INT DEFAULT 0")
    private Integer version;

    /**
     * 创建日期
     */
    @Getter
    @Setter
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    /**
     * 修改日期
     */
    @Getter
    @Setter
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;
}
