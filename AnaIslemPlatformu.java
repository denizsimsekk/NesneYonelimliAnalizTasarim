import java.sql.SQLException;
import java.util.Scanner;

public class AnaIslemPlatformu {
    public static void main(String[] args) throws SQLException {
        IAkilliCihazBilgiSistemi akilliCihazSistemi=new AkilliCihazBilgiSistemi(new PostgreSqlSurucusu());
        Scanner sc=new Scanner(System.in);
        int secim;
        do {
            System.out.println("Hoşgeldiniz.\n Giriş yapmak için 0,Kayıt olmak için 1 tuşlayınız.\n");
             secim= sc.nextInt();
        }while( secim!=1 && secim!=0);
        Scanner sc1=new Scanner(System.in);
        System.out.println("Kullanıcı adınızı giriniz:\n");
        String kullaniciAdi= sc1.nextLine();
        System.out.println("\n");
        System.out.println("Şifrenizi giriniz:\n");
        String sifre= sc1.next();
        switch (secim)
        {
            case 0:
                akilliCihazSistemi.kullaniciDogrula(kullaniciAdi,sifre);
                break;
            case 1:
                akilliCihazSistemi.kullaniciOlustur(kullaniciAdi,sifre);
                break;
            default:
                System.out.println("Geçersiz seçim");

        }
        /*ISicaklikalgilayici s=new SicaklikAlgilayici();
        IEyleyici e=new Eyleyici(s);
        e.sogutucuAc();*/
       AkilliCihaz a=new AkilliCihaz();
       a.basla();


    }
}
