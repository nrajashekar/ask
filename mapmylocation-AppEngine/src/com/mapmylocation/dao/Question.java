package com.mapmylocation.dao;

public class Question {
	
	private int ownerId;
	private int[] recipientIdList;
	private String[] answers;
	private String questionStr;
	
	public int getOwnerId() {
		return ownerId;
	}
	
	public String getQuestionStr() {
		return questionStr;
	}
	
	public int[] getRecipientIdList() {
		return recipientIdList;
	}
	
	public String[] getAnswers() {
		return answers;
	}
	
	public void setOwnerId( int ownerId ) {
		this.ownerId = ownerId;
	}
	
	public void setRecipientIdList( int[] recipientIdList ) {
		this.recipientIdList = recipientIdList;;
	}
	
	public void setAnswers( String[] answers ) {
		this.answers = answers;
	}
	
	public void setQuestionStr( String qStr ) {
		this.questionStr = qStr;
	}

}
