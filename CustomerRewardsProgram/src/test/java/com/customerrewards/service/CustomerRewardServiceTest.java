package com.customerrewards.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.customerrewards.Entity.RewardsProgram;
import com.customerrewards.repostiory.CustomerRepository;

//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration
public class CustomerRewardServiceTest {
	
	@Autowired
	CustomerRepository customRepository;
	
	@Autowired
	CustomerRewardService customerRewardService;
	
	
	@SuppressWarnings("deprecation")
	public void findRewardsProgramByDateTransaction() {
		
		
		RewardsProgram rewardsProgram = new RewardsProgram();
		
		List<RewardsProgram> RewardsProgramList = new ArrayList();
		
		rewardsProgram.setTransationId(new Long(10001));
		rewardsProgram.setCustomerId(1001);
		rewardsProgram.setRewardsDate(new Date("2023/03/22"));
		rewardsProgram.setTransactionAmnt(130.0);
		RewardsProgramList.add(rewardsProgram);
		
		RewardsProgram rewardsProgram1 = new RewardsProgram();
		rewardsProgram1.setTransationId(new Long(10002));
		rewardsProgram1.setCustomerId(1002);
		rewardsProgram1.setRewardsDate(new Date("2023/04/21"));
		rewardsProgram1.setTransactionAmnt(110.0);
		RewardsProgramList.add(rewardsProgram1);
		
		RewardsProgram rewardsProgram2 = new RewardsProgram();
		rewardsProgram2.setTransationId(new Long(10003));
		rewardsProgram2.setCustomerId(1003);
		rewardsProgram2.setRewardsDate(new Date("2023/02/13"));
		rewardsProgram2.setTransactionAmnt(70.0);
		RewardsProgramList.add(rewardsProgram2);
		
		RewardsProgram rewardsProgram3 = new RewardsProgram();
		rewardsProgram3.setTransationId(new Long(10004));
		rewardsProgram3.setCustomerId(1004);
		rewardsProgram3.setRewardsDate(new Date("2023/01/06"));
		rewardsProgram3.setTransactionAmnt(90.0);
		RewardsProgramList.add(rewardsProgram3);
		
		
		
		
	}

	//@Test
	public void getCustomerRewardsByIdTest(){
		
	//	getCustomerRewardsById
	}
	
	//@Test
	public void findRewardsProgramByDateTransactionTest() {
		
	}
	
	//@Test
	public void getDateBasedOnOffSetDaysTest() {
		int daysInConst = 30;
		//assertNotNull(customerRewardService.getDateBasedOnOffSetDays(daysInConst));
	}
	

}
