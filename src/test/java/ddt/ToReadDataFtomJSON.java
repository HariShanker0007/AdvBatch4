package ddt;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ToReadDataFtomJSON {
public static void main(String[] args) throws Throwable {

	//step 1
	FileReader fir= new FileReader("./\\src\\test\\resources\\ConfigAppData\\commondata.json");
	
	//step 2 Creating JSON Parse
	JSONParser jparse= new JSONParser();
	//Create Java Object
	Object javaObj = jparse.parse(fir);
	
	
	//Step 3 convert Java object to json Object (DownCasting)
	JSONObject obj = (JSONObject)javaObj;
	
	//read data using get()
	String BROWSER = obj.get("browser").toString();
	String URL = obj.get("url").toString();
	String UN = obj.get("un").toString();
	String PW = obj.get("pw").toString();
	
	System.out.println(BROWSER);
	System.out.println(URL);
	System.out.println(UN);
	System.out.println(PW);	
}
}
