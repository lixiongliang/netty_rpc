package design.model.strategy;

public class Boss implements BuyShop{
    @Override
    public void buy() {
        System.out.println("Boss buy house");
    }
}
