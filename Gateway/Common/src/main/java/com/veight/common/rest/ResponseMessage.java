/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.common.rest;

import com.veight.common.rest.enums.ResponseMessageType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import org.codehaus.jackson.annotate.JsonTypeInfo;

/**
 *消息
 * @author youyou
 */
@XmlRootElement
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class ResponseMessage {
	

	/** 类型 */
	private ResponseMessageType type;

	/** 内容 */
	private String content;

	/**
	 * 初始化一个新创建的 Message 对象，使其表示一个空消息。
	 */
	public ResponseMessage() {

	}

	/**
	 * 初始化一个新创建的 Message 对象
	 * 
	 * @param type
	 *            类型
	 * @param content
	 *            内容
	 */
	public ResponseMessage(ResponseMessageType type, String content) {
		this.type = type;
		this.content = content;
	}

	

	/**
	 * 返回成功消息
	 * 
	 * @param content
	 *            内容
	 * @return 成功消息
	 */
	public static ResponseMessage success(String content) {
		return new ResponseMessage(ResponseMessageType.SUCCESS, content);
	}

	/**
	 * 返回警告消息
	 * 
	 * @param content
	 *            内容
	 * @return 警告消息
	 */
	public static ResponseMessage warn(String content) {
		return new ResponseMessage(ResponseMessageType.WARN, content);
	}

	/**
	 * 返回错误消息
	 * 
	 * @param content
	 *            内容
	 * @return 错误消息
	 */
	public static ResponseMessage error(String content) {
		return new ResponseMessage(ResponseMessageType.ERROR, content);
	}
	
}