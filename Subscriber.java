public class Subscriber implements IObserver{
    @Override
    public void update(String mesaj) {
        System.out.println("Uyarı!" + mesaj);
    }
}
