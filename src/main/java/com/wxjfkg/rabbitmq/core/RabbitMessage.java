package com.wxjfkg.rabbitmq.core;

import java.io.Serializable;

public class RabbitMessage implements Serializable {
	
	private static final long serialVersionUID = 8959472114282493488L;

	private String subject;

	private String content;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
