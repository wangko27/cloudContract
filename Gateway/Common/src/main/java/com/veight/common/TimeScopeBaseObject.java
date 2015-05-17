/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.common;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * 对应数据自动创建时间和修改时间
 *
 * @author youyou
 */
@Data
@NoArgsConstructor
@XmlRootElement
public abstract class TimeScopeBaseObject extends BaseObject {

    public Date createDate;

    public Date modifyDate;
}
