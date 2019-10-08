package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.Test;

public class TestObjecRep {
	
	@Test
	public void objRep() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\ObjectRepository.properties");
		prop.load(fis);
		String s = prop.getProperty("Login.id");
		System.out.println(s);
	}

}
