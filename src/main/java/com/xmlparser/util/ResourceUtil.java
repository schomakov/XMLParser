package com.xmlparser.util;

import org.apache.log4j.Logger;

public class ResourceUtil {

    private static final Logger LOGGER = Logger.getLogger(ResourceUtil.class);

    public static void logException(Exception exception) {
        LOGGER.error(String.format("Exception Message: %s", exception.getMessage()));
    }
}
