package pracTestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Dummy {
@Test
public void Trial() {
	//System.out.println("Printed");
	Reporter.log("Printed",true);
}
}
