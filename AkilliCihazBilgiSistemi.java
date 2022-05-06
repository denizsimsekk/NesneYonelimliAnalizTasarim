import java.sql.SQLException;

public class AkilliCihazBilgiSistemi implements IAkilliCihazBilgiSistemi
{
    private IAkilliCihazBilgiSistemi veritabani;

    public AkilliCihazBilgiSistemi(IAkilliCihazBilgiSistemi veritabani) {
        this.veritabani=veritabani;
    }

    public int kullaniciDogrula(String kullaniciAdi, String sifre) {

        return veritabani.kullaniciDogrula(kullaniciAdi, sifre);

    }

    @Override
    public void kullaniciOlustur(String kullaniciAdi, String sifre) throws SQLException {
         veritabani.kullaniciOlustur(kullaniciAdi, sifre);
    }

}
