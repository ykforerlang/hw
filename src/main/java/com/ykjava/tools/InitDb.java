package com.ykjava.tools;

import org.apache.commons.io.IOUtils;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by baoz on 2017/3/12.
 */
public class InitDb {

    public static void main(String[] args) {
        System.out.println("init db start ...");
        //TODO should 区分环境
        try {
            initDev();
            System.out.println("init db end.");
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("init db error: " +  e.getMessage());
        }
    }

    private static void initDev() throws Exception{
        Properties pps = new Properties();
        InputStream in = InitDb.class.getClassLoader().getResourceAsStream("resources.properties");
        pps.load(in);

        Class.forName(pps.getProperty("driver"));
        Connection c = DriverManager.getConnection(pps.getProperty("url"),
                pps.getProperty("user"),
                pps.getProperty("password"));

        ScriptRunner run = new ScriptRunner(c);
        run.setLogWriter(null);
        File f = new File(InitDb.class.getClassLoader().getResource("./initSql").toURI());
        File[] files = f.listFiles();
        for(File file: files) {
            run.runScript(new FileReader(file));
        }
        c.close();
    }
}
