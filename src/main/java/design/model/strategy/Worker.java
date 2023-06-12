package design.model.strategy;

public class Worker implements BuyShop{
    @Override
    public void buy() {
        System.out.println("Worker buy car");
    }
}
