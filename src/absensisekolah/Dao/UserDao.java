
package absensisekolah.Dao;

import absensisekolah.Entity.User;
import absensisekolah.Utility.DbUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDao {
    
    Connection con ;
    User usr ;

    public UserDao() {
    
        con = new DbUtility().getConnection();
    
    }

    
    
    
    
    public boolean isUserRegist (String Usrnm, String Passwd)
    {
        String query = "SELECT * FROM dblogin WHERE usrnm=(?) and passwd=(?)" ;
        PreparedStatement stmt = null ;
        
        try {
            
            stmt = con.prepareStatement(query) ;
            stmt.setString(1, Usrnm);
            stmt.setString(2, Passwd);
            
            ResultSet rs = stmt.executeQuery() ;
            while (rs.next())
            {
                usr = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                rs.getDate(6), rs.getString(7));
                return true ;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return false ;
        }
        
        
       return false ;
    
    }
    
    
    
}
