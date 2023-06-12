package design.model.strategy;

public class Context {

    private BuyShop person;

    public Context(BuyShop person){
        this.person =person;
    }
    public void buy(){
        person.buy();
    }
}
