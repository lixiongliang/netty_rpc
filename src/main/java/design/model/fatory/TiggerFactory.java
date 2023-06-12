package design.model.fatory;

public class TiggerFactory implements AbsFactory{
    @Override
    public Animal createAnimal() {
        return new Tigger();
    }

    @Override
    public ILike createLike() {
        return new SleepIng();
    }
}
