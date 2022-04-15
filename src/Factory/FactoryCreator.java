package Factory;

public class FactoryCreator {
    public FactoryCreator(){

    }
    public AbstractFactory createFactory(int choice){
        switch (choice){
            case 0:
                return new BarFactory();
            case 1:
                return new ColorFactory();
            case 2:
                return new FontFactory();
            case 3:
                return new GraphFactory();
        }
        return new GraphFactory();
    }
}
