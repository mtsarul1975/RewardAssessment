package com.customerrewards.Entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RewardsProgram")
public class RewardsProgram {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="Transaction_Id")
	private Long transationId;
	
	@Column(name = "Cusotmer_Id")
	private int customerId;
	
	@Column(name = "Trans_Amnt")
	private Double transactionAmnt;
	
	@Column(name = "Rewards_date")
	private Date rewardsDate;
	
	public Double getTransactionAmnt() {
		return transactionAmnt;
	}

	public void setTransactionAmnt(Double transactionAmnt) {
		this.transactionAmnt = transactionAmnt;
	}
	
	public Long getTransationId() {
		return transationId;
	}

	public void setTransationId(Long transationId) {
		this.transationId = transationId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	
	public Date getRewardsDate() {
		return rewardsDate;
	}

	public void setRewardsDate(Date rewardsDate) {
		this.rewardsDate = rewardsDate;
	}

	
}
