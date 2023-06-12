package design.model.command;

public class Discount implements Command {
    @Override
    public void execute(Context context) {
        double sum = (context.getA() + context.getB()) * 0.9;
        System.out.println("Discount :" + sum);
    }
}
