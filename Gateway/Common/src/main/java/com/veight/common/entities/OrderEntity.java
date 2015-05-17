package com.veight.common.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Min;
import org.apache.commons.lang3.builder.CompareToBuilder;

/**
 * Entity - 排序基类
 *
 *
 *
 */
@MappedSuperclass
public abstract class OrderEntity extends UUIDEntity implements Comparable<OrderEntity> {

    private static final long serialVersionUID = 5995013015967525827L;

    /**
     * "排序"属性名称
     */
    public static final String ORDER_PROPERTY_NAME = "order";

    public static final String CREATE_DATE_PROPERTY_NAME = "createDate";

    /**
     * 排序
     */
    private Integer order;

    /**
     * 获取排序
     *
     * @return 排序
     */
    @Min(0)
    @Column(name = "orders")
    public Integer getOrder() {
        return order;
    }

    /**
     * 设置排序
     *
     * @param order 排序
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * 实现compareTo方法
     *
     * @param orderEntity 排序对象
     * @return 比较结果
     */
    public int compareTo(OrderEntity orderEntity) {
        return new CompareToBuilder().append(getOrder(), orderEntity.getOrder()).append(getId(), orderEntity.getId()).toComparison();
    }

}