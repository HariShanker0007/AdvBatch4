package com.comcast.crm.genricUtilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	/**
	 * @param 
	 * To get a Random Number between 1-1000
	 * @author harij
	 * @return int
	 */
	public int getRandomNumber() {
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;
	}

	public String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
		String currDate = sim.format(date);
		return currDate;
	}

	public String toGetReqDate(int days) {
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
		sim.format(date);
		Calendar cal = sim.getCalendar();
		cal.add(cal.DAY_OF_MONTH, days);
		String reqDate = sim.format(cal.getTime());
		return reqDate;
	}

	// To generate 10 digi Num
	public long getTenDigitRandomNumber() {
		Random ran = new Random();
		long number = 1000000000L + (long) (ran.nextDouble() * 9000000000L);
		return number;
	}
}
