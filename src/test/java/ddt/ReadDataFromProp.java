package ddt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadDataFromProp {
public static void main(String[] args) throws Throwable {
	
	//Step 1
	FileInputStream fis = new FileInputStream("./\\src\\test\\resources\\ConfigAppData\\comm.properties");
	
	// Step 2 Create Obj of Prop
	Properties prop = new Properties();
	
	//step 3
	prop.load(fis);
	
	//step 4
	String BROWSER = prop.getProperty("browser");
	
	System.out.println(BROWSER);
	
}
}
