package com.example.demo.util;

import org.apache.commons.collections4.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author liufei
 * @date 2019/10/16 16:27
 */
@Component
public class DBUtil {
    private static Logger logger = LoggerFactory.getLogger(DBUtil.class);
    @Autowired
    private Environment environment;

    public List<Map<String,Object>> execute(String tableSql){
        Connection conn = getConnection();
        PreparedStatement pStemt = null;
        List<Map<String,Object>> params = new ArrayList<>();
        try {
            pStemt = conn.prepareStatement(tableSql);

            ResultSetMetaData rsmd = pStemt.getMetaData();

            ResultSet resultSet = pStemt.executeQuery();
            while (resultSet.next()) {//或者while(rs.next())
                //表列数
                int size = rsmd.getColumnCount();
                Map<String,Object> param = new HashedMap();
                for (int i = 0; i < size; i++) {
                    param.put(rsmd.getColumnName(i+1),resultSet.getObject(rsmd.getColumnName(i+1)));
                }
                params.add(param);
            }
        } catch (SQLException e) {
            logger.error("getColumnValues failure", e);
        } finally {
            if (pStemt != null) {
                try {
                    pStemt.close();
                    closeConnection(conn);
                } catch (SQLException e) {
                    logger.error("getColumnValues close pstem and connection failure", e);
                }
            }
        }
        return params;
    }

     /**
     * 获取数据库连接
     *
     * @return
     */
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(environment.getProperty("spring.datasource.url"), environment.getProperty("spring.datasource.username"), environment.getProperty("spring.datasource.password"));
        } catch (SQLException e) {
            logger.error("get connection failure", e);
        }
        return conn;
    }


    /**
     * 关闭数据库连接
     * @param conn
     */
    public void closeConnection(Connection conn) {
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                logger.error("close connection failure", e);
            }
        }
    }
}
