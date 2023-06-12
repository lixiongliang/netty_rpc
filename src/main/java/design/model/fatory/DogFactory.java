package design.model.fatory;

public class DogFactory implements AbsFactory{
    @Override
    public Animal createAnimal() {
        return new Dog();
    }

    @Override
    public ILike createLike() {
        return new Walking();
    }
}
