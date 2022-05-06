import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici{

    private int sicaklik;
    @Override
    public void setSicaklik(int sicaklik) {
        this.sicaklik = sicaklik;
    }
    @Override
    public int getSicaklik()
    {
        return sicaklik;
    }

     public SicaklikAlgilayici()
        {
            Random rand = new Random(); //instance of random class
            int upperbound = 41;
            this.sicaklik = rand.nextInt(upperbound);
        }
    @Override
    public  int islemYap(int secim) {
        if(secim==0)
        {
            this.sicaklikGoruntule();
        }

        return sicaklik;
    }




    @Override
    public void sicaklikGoruntule() {
        System.out.println("Sıcaklık: "+ sicaklik);

    }
}
