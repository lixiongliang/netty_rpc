package design.model.fatory;

public class FactoryClient {
    public static void main(String[] args) {
     //   AbsFactory  factory = new DogFactory();
      //  AbsFactory  factory = new CatFactory();
        AbsFactory  factory = new TiggerFactory();
        Animal animal = factory.createAnimal();
        ILike like = factory.createLike();
        animal.eat();
        String things = like.doing();
        System.out.println(things);
    }

}
