public class SicaklilAlgilayiciFactory implements IModulFactory{
    @Override
    public IModulIslemYap factoryMethod() {
        SicaklikAlgilayici sicaklikAlgilayici=new SicaklikAlgilayici();
        return sicaklikAlgilayici;
    }
}
