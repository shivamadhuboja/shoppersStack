package utilities;

import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.util.Properties;

public class Utilities {

	public static Properties prop;
	
	public static final int implicitWaitTime=10;
	public static final int expilictWaitTime=30;
	public static final int pageLoadWaitTime=30;
	
	public static Properties intializeProperties()
	{
		prop=new Properties();
		try {
			FileInputStream file=new FileInputStream("./src/test/resources/configer/config.properties");
			prop.load(file);
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		
		return prop;
	}
	

	public static String generateEmail()
	{
		String time=LocalDateTime.now().toString().replace(":", "");
		
		return "siva"+time+"@gmail.com";
	}
}
