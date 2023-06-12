package design.model.command;

import java.util.ArrayList;
import java.util.List;

public class Broker {
    private List<Command> commands = new ArrayList<>();

    public void push(Command command){
        commands.add(command);
    }
    public void action(Context context){
        for(Command c : commands){
            c.execute(context);
        }
    }
}
