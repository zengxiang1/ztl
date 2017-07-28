package org.zx.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zx.util.InitProperties;

import java.sql.*;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/28.
 */
public class DbHelper {

    private static Logger logger = LoggerFactory.getLogger(DbHelper.class);
    private String url;

    private String username;

    private String password;

    private Connection connection;

    public DatabaseModel warpModel(String tableName) throws SQLException {
        if (tableName == null && "".equals(tableName) ){
            throw new IllegalArgumentException("tableName is should't be null");
        }
        DatabaseModel databaseModel = new DatabaseModel();

        String sql = "select * from "+tableName.trim();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs =  ps.executeQuery();
        ResultSetMetaData rsm = rs.getMetaData();
        databaseModel.setTableName(tableName);
        for(int i = 1 ;  i+1 < rsm.getColumnCount(); i++){
            if ( rsm.getColumnName(i) == null || "".equals(rsm.getColumnName(i).trim())){
                continue;
            }else{
                String columnType = rsm.getColumnClassName(i).split("\\.")[rsm.getColumnClassName(i).split("\\.").length - 1];
                databaseModel.addField(rsm.getColumnName(i),columnType,rsm.getColumnLabel(i));
                databaseModel.addTypes(rsm.getColumnClassName(i));
            }
        }
        return databaseModel;
    }

    public DbHelper() throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
        this.url = InitProperties.getProperties("url");
        this.username = InitProperties.getProperties("username");
        this.password = InitProperties.getProperties("password");
        Class.forName("com.mysql.jdbc.Driver");
        this.connection = DriverManager.getConnection(url,username,password);
    }
}
