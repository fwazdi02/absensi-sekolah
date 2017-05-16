package absensisekolah.controler;

import absensisekolah.Dao.UserDao;
import absensisekolah.view.Login;
import javax.swing.JOptionPane;

public class LoginControler {

    Login LoginFrame;
    UserDao UsrDao;

    public LoginControler(Login LoginFrame) {
        this.LoginFrame = LoginFrame;
        UsrDao = new UserDao() ;
    }
    
    
    

    public boolean login() {
        if (LoginFrame.getUsrnm().getText().isEmpty()) {
            JOptionPane.showMessageDialog(LoginFrame, "Masukan Username Anda");
            LoginFrame.getUsrnm().requestFocus();

        } else if (LoginFrame.getPasswd().getText().isEmpty()) {
            JOptionPane.showMessageDialog(LoginFrame, "Masukan Password Anda");
            LoginFrame.getPasswd().requestFocus();
        } else {
        
            String Usrnm = LoginFrame.getUsrnm().getText() ;
            String Pwd = LoginFrame.getPasswd().getText() ;
            
            if (UsrDao.isUserRegist(Usrnm, Pwd))
            {
                return true;
            } else 
            {
                JOptionPane.showMessageDialog(LoginFrame, "Username atau Password anda salah, \n "
                        + "pastikan anda mengetik username dan password dengan benar ");
                LoginFrame.getUsrnm().requestFocus();
            }

        }

        return false ;
    }

}
