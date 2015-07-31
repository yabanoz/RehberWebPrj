package tr.gov.ptt.rehberwebprj.dto;

public class GirisDTO {

    private String kullanici;
    private String sifre;
    
    public GirisDTO() {
    }
       
    public String getKullanici() {
        return kullanici;
    }

    public void setKullanici(String kullanici) {
        this.kullanici = kullanici;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

}
