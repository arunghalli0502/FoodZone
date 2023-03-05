package com.foodzone;

public class DebitCard 
{
	private long cardnumber;
	private int cvv;
	
	
	
	public long getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(long cardnumber) {
		this.cardnumber = cardnumber;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
	
	public DebitCard()
	{
		
	}
	
	
	public DebitCard(long cardnumber, int cvv) {
		super();
		this.cardnumber = cardnumber;
		this.cvv = cvv;
	}
	
	
}
