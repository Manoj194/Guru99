package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
	
	public String PropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("C:/EclipseIDE/Guru99/Files/Property.properties");
		Properties pop = new Properties();
		pop.load(fis);
		String data = pop.getProperty(key);
		return data;
	}

}
