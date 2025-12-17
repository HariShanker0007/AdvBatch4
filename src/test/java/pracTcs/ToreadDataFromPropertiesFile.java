package pracTcs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ToreadDataFromPropertiesFile {
public static void main(String[] args) throws Throwable {
	//step 1
	FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo-QSP\\OneDrive\\Desktop\\CommonData\\propertyData.properties");
	
	//step 2
	Properties prop = new Properties();
	
	//step 3
	prop.load(fis);
	
	//Step 4
	String BROWSER = prop.getProperty("browser");
	String URL = prop.getProperty("url");
	String UN = prop.getProperty("un");
	String PW = prop.getProperty("pw");
	
	System.out.println(BROWSER);
	System.out.println(URL);
	System.out.println(UN);
	System.out.println(PW);
}
}
