import java.util.Scanner;

public class AkilliCihaz
{
    IModulFactory eyleyiciFactory;
    IModulFactory sicaklikAlgilayiciFactory;
    ISicaklikAlgilayici sicaklikAlgilayici;
    IEyleyici eyleyiciModul;
    Subscriber s;
    Publisher p;
    int durum;
    private static final int kapali = 1;
    private static final int acilisTestiYapiliyor = 2;
    private static final int bekleme = 3;
    private static final int algilama = 4;
    private static final int servisDisi = 5;
    private static final int islemYapiliyor = 6;
    public AkilliCihaz()
    {
        System.out.println("Açılış testi yapılıyor");
        this.durum=2;
        cokluIstemciModul istemciModul = new cokluIstemciModul(new EyleyiciFactory(),new SicaklilAlgilayiciFactory());
        sicaklikAlgilayici= (ISicaklikAlgilayici) istemciModul.sicaklikAlgilayiciModul();
        eyleyiciModul= (IEyleyici) istemciModul.eyleyiciModul();
        s=new Subscriber();
        p=new Publisher();
        p.attach(s);

    }
    public void basla()
    {
        this.islemSecimi();
    }
    private void islemSecimi()
    {

        int secim;
        Scanner sc=new Scanner(System.in);

        do
        {
            System.out.println("\nAna Menü\n0-Sıcaklık Getir.\n1-Soğutucu Aç.\n2-Soğutucu Kapat.\n3-Çıkış");
            secim= sc.nextInt();
        }while( secim!=1 && secim!=0 && secim!=2 && secim!=3);
        this.durum=6;
        System.out.println("İşlem yapılıyor.");
       if(secim==0)
        {
            sicaklikAlgilayici.islemYap(secim);
            this.islemSecimi();
        }
        else if(secim==1)
        {

            //eyleyiciModul.islemYap(sicaklik.getSicaklik(),secim);
            sicaklikAlgilayici.setSicaklik(eyleyiciModul.sogutucuAc(sicaklikAlgilayici.getSicaklik()));
            eyleyiciModul.islemYap(secim);
            if(sicaklikAlgilayici.getSicaklik()<-10)
            {
                p.notify("Sıcaklık -10 derecenin altına indi.");
            }
            this.islemSecimi();
        }
        else if(secim==2)
        {
            sicaklikAlgilayici.setSicaklik(eyleyiciModul.sogutucuKapat(sicaklikAlgilayici.getSicaklik()));
            eyleyiciModul.islemYap(secim);
            if(sicaklikAlgilayici.getSicaklik()>40)
            {
                p.notify("Sıcaklık 40 derecenin üzerine çıktı.");
            }
            this.islemSecimi();
        }
        else if(secim==3)
        {
            this.durum=1;
            System.out.println("Kapalı");
            System.exit(0);

        }

    }
}
