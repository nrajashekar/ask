package com.mapmylocation.dao;

public class CreateQuestionRequest {

	private String question;
	private int recipientIdList[];
	private int ownerId;

	public void setQuestion( String question ) {
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public void setRecipientIdList( int[] recipientIdList ) {
		this.recipientIdList = recipientIdList;
	}

	public int[] getRecipientIdList() {
		return recipientIdList;
	}

	public int getOwnerId() {
		return ownerId;
	}
	
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

}
