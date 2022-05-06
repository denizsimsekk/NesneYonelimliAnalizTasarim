public class EyleyiciFactory implements IModulFactory{
    @Override
    public IModulIslemYap factoryMethod() {
        Eyleyici eyleyici=new Eyleyici();
        return eyleyici;
    }
}
