package design.model.command;

public class Add implements Command {
    @Override
    public void execute(Context context) {
        int sum = context.getA() + context.getB();
        System.out.println("Add :" + sum);
    }
}
