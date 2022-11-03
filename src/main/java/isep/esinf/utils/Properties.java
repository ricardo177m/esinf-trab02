package isep.esinf.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Modification of Thomas Ruski's properties class.
 */
public class Properties {
  public static java.util.Properties getProperties() {
    java.util.Properties props = new java.util.Properties();

    // Add default properties and values
    // props.setProperty("key", "value");

    // Read configured values
    try {
      InputStream in = new FileInputStream("./config.properties");
      props.load(in);
      in.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return props;
  }

}
