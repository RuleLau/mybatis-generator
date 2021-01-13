package com.sinog2c.base.job.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

public class DbConnectUtils {

    private static Map<String, String> DRIVER_MAP = new HashMap<>();

    static {
        DRIVER_MAP.put("dm", "dm.jdbc.driver.DmDriver");
        DRIVER_MAP.put("mysql", "com.mysql.jdbc.Driver");
    }

    public static boolean connect(String url, String username, String password, String driverName) throws Exception {
//        String url = "jdbc:dm://124.70.18.186:5236/JUDICIAL_PLATFORM?zeroDateTimeBehavior=convertToNull&amp;useUnicode=true&amp;characterEncoding=utf-8";
//        String username = "BASE_FMWK";
//        String password = "BASE20_FMWK";
        Class.forName(DRIVER_MAP.get(driverName));
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            if ( conn.isValid(1000)) {
                return true;
            }
        }
       return false;
    }
/*    public static void main(String[] args) throws Exception {
        System.out.println(connect("jdbc:dm://124.70.18.186:5236/JUDICIAL_PLATFORM?zeroDateTimeBehavior=convertToNull&amp;useUnicode=true&amp;characterEncoding=utf-8", "BASE_FMWK", "BASE20_FMWK", "dm"));
    }*/
}
