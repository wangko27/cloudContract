/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.common.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.persistence.annotations.UuidGenerator;

@MappedSuperclass
public abstract class UUIDEntity extends BaseEntity {

    @Id
    @UuidGenerator(name = "UUID_GEN")
    @GeneratedValue(generator = "UUID_GEN")
    @Column(name = "ID", length = 36)
    @Getter
    @Setter
    private String id;
}
