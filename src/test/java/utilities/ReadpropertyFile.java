package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadpropertyFile {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("C:\\Users\\Admin\\eclipse-workspace\\TestScript\\src\\test\\resources\\configFiles\\config.properties");
		Properties p = new Properties();
		p.load(fr);
		System.out.println(p.getProperty("testurl"));
		System.out.println(p.getProperty("browser"));
		
	}

}
