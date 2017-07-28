package org.zx.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2017/7/28.
 */
public class InitProperties {
    private static Properties properties =null;
    private static Logger logger  = LoggerFactory.getLogger(InitProperties.class);
    static {
        InputStream input = InitProperties.class.getClassLoader().getResourceAsStream("config.properties");
        properties = new Properties();
        try {
            properties.load(input);
        } catch (IOException e) {
            logger.error("初始化配置文件失敗:"+e.getMessage());
        }
    }

    public static String getProperties(String key){
        return properties.get(key ) == null ? null : properties.get(key).toString();
    }
}
