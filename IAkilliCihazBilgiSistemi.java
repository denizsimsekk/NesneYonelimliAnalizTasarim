import java.sql.SQLException;

public interface IAkilliCihazBilgiSistemi
{
    public int kullaniciDogrula(String kullaniciAdi,String sifre);
    public void kullaniciOlustur(String kullaniciAdi,String sifre) throws SQLException;
}
