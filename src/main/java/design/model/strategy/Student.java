package design.model.strategy;

public class Student implements BuyShop{
    @Override
    public void buy() {
        System.out.println("Student buy pen");
    }
}
