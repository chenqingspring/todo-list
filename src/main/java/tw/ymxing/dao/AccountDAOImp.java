package tw.ymxing.dao;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
@Component
public class AccountDAOImp implements AccountDAO {
    @Resource
    private DataSource dataSource;
    public boolean hasAccount(String username) {
        try{
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            String sql="select * from accounts where username = \'" +username+"\'";
            ResultSet rs = stmt.executeQuery(sql);
            if(!rs.wasNull())return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public String itsPassword(String username) {
        try{
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            String sql="select password from accounts where username = \'"+username+"\'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                return rs.getString(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
