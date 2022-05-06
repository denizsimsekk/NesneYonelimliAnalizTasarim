import java.util.Random;

public class Eyleyici implements IEyleyici{

    Eyleyici()
    {
    }
    @Override
    public int sogutucuAc(int sicaklik)
    {
        Random rand = new Random(); //instance of random class
        int upperbound = 11;
        int miktar;
        miktar = rand.nextInt(upperbound);
        sicaklik-=miktar;
        return sicaklik;
    }
    @Override
    public int sogutucuKapat(int sicaklik)
    {

        Random rand = new Random(); //instance of random class
        int upperbound = 11;
        int miktar;
        miktar = rand.nextInt(upperbound);
        sicaklik+=miktar;
        return sicaklik;
    }

    @Override
        public int islemYap(int secim)
    {
        if(secim==1)
        {
            System.out.println("Soğutucu açıldı.");
        }
        if(secim==2)
        {
            System.out.println("Soğutucu kapatıldı.");
        }

            return 0;

    }


}
