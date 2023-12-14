package com.game;

public class Player {
	
	private String name;
	private double balance;
	private double totalBet;
	private double win;

	private double rtp;

	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getTotalBet() {
		return totalBet;
	}
	public void setTotalBet(double totalBet) {
		this.totalBet = totalBet;
	}
	public double getWin() {
		return win;
	}
	public void setWin(double win) {
		this.win = win;
	}
	public double getRtp() {
		return rtp;
	}
	public void setRtp(double rtp) {
		this.rtp = rtp;
	}
}
