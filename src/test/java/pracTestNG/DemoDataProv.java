package pracTestNG;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoDataProv {
	@Test(dataProvider = "loginDetails")
	public void login(String un, String pw) {
		System.out.println("Printed");
		Reporter.log(un + "====" + pw, true);
//	}
//
//	@DataProvider
//	public Object[][] loginDetails() {
//		Object[][] objArr = new Object[4][2];
//
//		objArr[0][0] = "divya"; // 1st un
//		objArr[0][1] = "d123"; // 1st pw
//		objArr[1][0] = "Shubha";// 2st un
//		objArr[1][1] = "s123"; // 2st pw
//		objArr[2][0] = "nancy";// 3st un
//		objArr[2][1] = "n123"; // 3st pw
//		objArr[3][0] = "shekar";// 4st un
//		objArr[3][1] = "sk123"; // 4st pw
//
//		return objArr;
	}
}
