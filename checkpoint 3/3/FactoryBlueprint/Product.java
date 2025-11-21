
interface Product {
    void showDetails();
}


class ConcreteProductA implements Product {
    @Override
    public void showDetails() {
        System.out.println("This is ConcreteProductA.");
    }
}

class ConcreteProductB implements Product {
    @Override
    public void showDetails() {
        System.out.println("This is ConcreteProductB.");
    }
}

class Factory {
    public Product createProduct(String type) {
        if ("A".equalsIgnoreCase(type)) {
            return new ConcreteProductA();
        } else if ("B".equalsIgnoreCase(type)) {
            return new ConcreteProductB();
        } else {
            return null;
        }
    }
}
