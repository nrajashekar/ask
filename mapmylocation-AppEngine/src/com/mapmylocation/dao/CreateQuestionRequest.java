package com.mapmylocation.dao;

public class CreateQuestionRequest {

	private String question;
	private int recipientId;
	private int ownerId;

	public void setQuestion( String question ) {
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public void setRecipientId( int recipientId ) {
		this.recipientId = recipientId;
	}

	public int getRecipientId() {
		return recipientId;
	}

	public int getOwnerId() {
		return ownerId;
	}
	
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

}
