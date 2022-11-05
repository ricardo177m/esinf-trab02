package isep.esinf.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import isep.esinf.shared.Constants;

public class PropertiesUtils {
  public static Properties getProperties() {
    Properties props = new Properties();

    // Read configured values
    try {
      InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
      props.load(in);
      in.close();
    } catch (IOException ex) {
      System.out.println("Error reading properties file:!");
      System.out.println(
          "Ensure that the file " + Constants.PARAMS_FILENAME + " exists and the path is correct.");
    }

    return props;
  }
}
