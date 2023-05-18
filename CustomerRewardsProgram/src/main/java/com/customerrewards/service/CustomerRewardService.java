package com.customerrewards.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.customerrewards.Entity.RewardsProgram;
import com.customerrewards.model.Rewards;
import com.customerrewards.repostiory.CustomerRepository;
import com.customerrewards.repostiory.RewardsProgramRepository;

@Service
public class CustomerRewardService {
	
	@Autowired
	CustomerRepository customRepository;
	
	@Autowired
	RewardsProgramRepository rewardsProgramRepository;
	
	final int daysInMonth = 30;
	final int rewardAmnt50 = 50;
	final int rewardAmnt100 = 100;
	
	public Rewards getCustomerRewardsById(int customerId) {
	
		//Calcualted for 3 months.,
		Timestamp lastMonthTimestamp = getDateBasedOnOffSetDays(daysInMonth);
		Timestamp lastSecondMonthTimestamp = getDateBasedOnOffSetDays(2*daysInMonth);
		Timestamp lastThirdMonthTimestamp = getDateBasedOnOffSetDays(3*daysInMonth);
				
		List<RewardsProgram> lastMonthTransactions = rewardsProgramRepository.
				findRewardsProgramByDateTransaction(
				customerId, lastMonthTimestamp, Timestamp.from(Instant.now()));
		List<RewardsProgram> lastSecondMonthTransactions = rewardsProgramRepository
				.findRewardsProgramByDateTransaction(customerId, lastSecondMonthTimestamp, lastMonthTimestamp);
		List<RewardsProgram> lastThirdMonthTransactions = rewardsProgramRepository
				.findRewardsProgramByDateTransaction(customerId, lastThirdMonthTimestamp,
						lastSecondMonthTimestamp);
		
		Long lastMonthRewardPoints = getRewardsPerMonth(lastMonthTransactions);
		Long lastSecondMonthRewardPoints = getRewardsPerMonth(lastSecondMonthTransactions);
		Long lastThirdMonthRewardPoints = getRewardsPerMonth(lastThirdMonthTransactions);
		
		Rewards custReward = new Rewards();
		custReward.getCustomerId();
		custReward.setLastMonthRewardPoints(lastMonthRewardPoints);
		custReward.setLastSecondMonthRewardPoints(lastSecondMonthRewardPoints);
		custReward.setLastThirdMonthRewardPoints(lastThirdMonthRewardPoints);
				
			
		return custReward;
		
	}
	
	private Long getRewardsPerMonth(List<RewardsProgram> rewardsPrograms) {
		return rewardsPrograms.stream().map(rewardsProgram -> calculateRewards(rewardsProgram))
				.collect(Collectors.summingLong(r -> r.longValue()));
	}
	
	
	private Long calculateRewards(RewardsProgram rp) {
		if (rp.getTransactionAmnt() > rewardAmnt50 && rp.getTransactionAmnt() <= rewardAmnt100) {
			return Math.round(rp.getTransactionAmnt() - rewardAmnt50);
		} else if (rp.getTransactionAmnt() > rewardAmnt100) {
			return Math.round(rp.getTransactionAmnt() - rewardAmnt100) * 2
					+ (rewardAmnt100 - rewardAmnt50);
		} else
			return 0l;

	}
	
	
	public Timestamp getDateBasedOnOffSetDays(int days) {
		return Timestamp.valueOf(LocalDateTime.now().minusDays(days));
	}

}
