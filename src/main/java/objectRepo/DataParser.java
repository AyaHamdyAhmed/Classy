package objectRepo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataParser {

	private FileInputStream stream;
	private String RepositoryFile;
	private Properties propertyFile = new Properties();

	public DataParser(String fileName) throws IOException {
		this.RepositoryFile = fileName;
		stream = new FileInputStream(RepositoryFile);
		propertyFile.load(stream);
	}

	public String getData(String dataKey) {
		String dataProperty = propertyFile.getProperty(dataKey);
		System.out.println(dataProperty);
		String dataType = dataProperty.split(":")[0];
		String dataValue = dataProperty.split(":")[1];

		String value = null;
		switch (dataType) {
		case "url":
			value = dataValue;
			break;
		case "username":
			value = dataValue;
			break;
		case "pass":
			value = dataValue;
			break;
		case "cName":
			value = dataValue;
			break;
		case "Fgoal":
			value = dataValue;
			break;
		}
		return value;
	}
}