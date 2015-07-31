
package tr.gov.ptt.rehberwebprj.dao;
import java.sql.*;
import tr.gov.ptt.rehberwebprj.dto.GirisDTO;
import tr.gov.ptt.rehberwebprj.util.VTBaglanti;

public class GirisDAO {
    public static boolean giriseYetkilimi(GirisDTO p_giris) throws ClassNotFoundException, SQLException{
        String vtSifre = null;
        Connection conn = VTBaglanti.baglantiGetir();
        PreparedStatement ps = conn.prepareStatement("select sifre from giris where kullanici=?");
        ps.setString(1, p_giris.getKullanici());
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            vtSifre = rs.getString("sifre");
        }
        rs.close();
        VTBaglanti.baglantiKapat(conn);
        
        if(vtSifre!=null && vtSifre.equals(p_giris.getSifre())){
            return true;
        }else{
            return false;
        }
       
    }
}
