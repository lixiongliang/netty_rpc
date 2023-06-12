package design.model.command;

public class Client {
    public static void main(String[] args) {
        Broker broker = new Broker();
        broker.push(new Add());
        broker.push(new Discount());
        Context context = new Context();
        context.setA(10);
        context.setB(20);
        broker.action(context);
    }
}
