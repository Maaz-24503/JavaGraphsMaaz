package Factory;

public class FactoryCreator {
    public FactoryCreator(){

    }
    public AbstractFactory createFactory(int choice){
        return switch (choice) {
            case 0 -> new BarFactory();
            case 1 -> new ColorFactory();
            case 2 -> new FontFactory();
            case 3 -> new GraphFactory();
            default -> new GraphFactory();
        };
    }
}
