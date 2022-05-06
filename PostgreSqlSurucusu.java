import javax.swing.*;
import java.sql.*;

public class PostgreSqlSurucusu implements IAkilliCihazBilgiSistemi  {

    @Override
    public int kullaniciDogrula(String kullaniciAdi, String sifre) {


        //veritabani.baglan(hesapNumarasi, sifre);


        try
        {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AkilliCihaz",
                    "postgres", "*****");
            if (conn != null)
               System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");



           String sql="select * from kayitnosifre('"+kullaniciAdi+"','"+sifre+"')";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            //int donus="select * from public.kayitnosifre(1,'123')"
            //***** Bağlantı sonlandırma *****
            conn.close();

            int kayitno;
            if(rs.next())
            {
                kayitno  = rs.getInt("kayitnosifre");

                if(kayitno==1)
                    System.out.print("Giriş başarılı" );
                else {
                    System.out.println("Giriş Başarısız");
                    System.exit(0);
                }
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
    @Override
    public void kullaniciOlustur(String kullaniciAdi, String sifre) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AkilliCihaz",
                    "postgres", "*****");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
            Statement stmt=null;
            ResultSet rs=null;
            try {
                String sql = "insert into kullanicilar values('" + kullaniciAdi + "' , '" + sifre + "' )";

                 stmt = conn.createStatement();
                 rs = stmt.executeQuery(sql);

            } catch (SQLException e) {
                if(e.getMessage().contains("kullaniciAdiPK")) {
                    System.out.println("Bu kullanıcı adı zaten mevcut.");
                    System.exit(0);
                } else {
                    System.out.println("Kullanıcı Oluşturuldu.");

                }

            }
            if(rs!=null &&stmt!=null)
            {
                rs.close();
                stmt.close();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
