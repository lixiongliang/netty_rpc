package design.model.command;

public class Sub implements Command{
    @Override
    public void execute(Context context) {
        int result = context.getA() - context.getB();
        System.out.println("Sub :" + result);
    }
}
