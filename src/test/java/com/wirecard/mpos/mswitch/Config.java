package com.wirecard.mpos.mswitch;

import org.apache.commons.lang3.StringUtils;

public class Config {

    public static final String HOST_URL = "URL";//getSwitchBaseUrl();
    
    private static String getSwitchBaseUrl() {
        String hostProperty = System.getProperty("HOSTNAME");
        if (StringUtils.isBlank(hostProperty)) {
            hostProperty = System.getenv("HOSTNAME");
        }

        if (StringUtils.isNotBlank(hostProperty)) {
            return hostProperty;
        } else {
            return "http://localhost:8080/mswitch-gui/#";
        }
    }
}
