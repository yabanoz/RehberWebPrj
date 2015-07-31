
package tr.gov.ptt.rehberwebprj.test;
import java.sql.*;
import tr.gov.ptt.rehberwebprj.dao.GirisDAO;
import tr.gov.ptt.rehberwebprj.dto.GirisDTO;

public class GirisDAOTest {
    public static void main(String[] args) {
        
        try { 
            GirisDTO giris = new GirisDTO();
            giris.setKullanici("BORA");
            giris.setSifre("123456");
          
            boolean sonuc = GirisDAO.giriseYetkilimi(giris);
            if(sonuc){
                System.out.println("Giriş başarılı."); 
            }else
            {
                System.out.println("Kullanıcı adı yada şifre yanlış."); 
            }
        } catch (ClassNotFoundException ex) {            
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
