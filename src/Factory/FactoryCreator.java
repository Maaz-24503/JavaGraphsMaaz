package Factory;

public class FactoryCreator {
	/**
	 * this constructor creates a FactoryCreator
	 */
    public FactoryCreator(){

    }
    /**
     * 
     * @param choice 0 for BarFactory, 1 for ColorFactory, 2 for FontFactory,
     * 3 for GraphFactory
     * 
     * @return returns the Factory depending on the choice
     */
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
