import java.util.Random;
import java.util.Scanner;

public class cokluIstemciModul {
    IModulFactory eyleyiciFactory;
    IModulFactory sicaklikAlgilayiciFactory;
    public cokluIstemciModul( IModulFactory eyleyiciFactory, IModulFactory sicaklikAlgilayiciFactory) {

        this.eyleyiciFactory = eyleyiciFactory;
        this.sicaklikAlgilayiciFactory = sicaklikAlgilayiciFactory;
    }

    public IModulIslemYap sicaklikAlgilayiciModul(){
        IModulIslemYap modul2=  sicaklikAlgilayiciFactory.factoryMethod();
        return modul2;
    }
    public IModulIslemYap eyleyiciModul(){
        IModulIslemYap modul1= eyleyiciFactory.factoryMethod();
        return modul1;
    }
}
