package design.model.fatory;

public class CatFactory implements AbsFactory{
    @Override
    public Animal createAnimal() {
        return new Cat();
    }

    @Override
    public ILike createLike() {
        return new SleepIng();
    }
}
