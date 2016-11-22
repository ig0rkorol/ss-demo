package lv.ss.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    private ConfigProperties(){}
    private static final Properties props = new Properties();
    private static final Logger logger = LoggerFactory.getLogger(ConfigProperties.class);
    private static final String HTTP_URL = "http://%s";
    private static final String PATH_TO_RESOURCES = "src/main/resources/";
    public static final String BASE_URL;

    static {

        readProperties();
        BASE_URL = String.format(HTTP_URL, getProperty("BASE.URL"));

        logger.info("================== C O N F I G U R A T I O N =======================");
        logger.info("Base URI : {}", ConfigProperties.BASE_URL);
        logger.info("===================================================================");

    }

    private static void readProperties() throws AssertionError {
        String configFile = PATH_TO_RESOURCES + "/config.properties";
        try {
            logger.info(String.format("Reading configuration data from '%s' file", configFile));
            props.load(new FileReader(configFile));
        } catch (IOException e) {
            throw new AssertionError(String.format("An exception occurs during loading of '%s' config file", configFile), e);
        }
    }

    private static String getProperty(String propertyName, String defaultValue) {
        return System.getProperty(propertyName.toLowerCase(), props.getProperty(propertyName, defaultValue));
    }

    private static String getProperty(String propertyName) {
        return getProperty(propertyName, null);
    }

}
