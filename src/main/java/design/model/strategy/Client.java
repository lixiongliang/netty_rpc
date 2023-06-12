package design.model.strategy;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String roleName = scanner.nextLine();
            BuyShop buyShop = null;
            if ("boss".equals(roleName)) {
                buyShop = new Boss();
            } else if ("student".equals(roleName)) {
                buyShop = new Student();
            } else {
                buyShop = new Worker();
            }
            Context context = new Context(buyShop);
            context.buy();

        }
    }
}
