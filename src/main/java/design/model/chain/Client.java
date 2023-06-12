package design.model.chain;

import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.
                newFixedThreadPool(3);
        HttpFilter chainHttpFilter = getChainHttpFilter();
        for (int i = 0; i < 3; i++) {

            executorService.submit(() -> {

                HttpRequestParams params = new HttpRequestParams();
                params.setIp("10.10.100.1");
                params.setUserName("admin");
                params.setPassword("123");
                chainHttpFilter.filter(params);
            });
        }
        executorService.shutdown();

    }

    public static HttpFilter getChainHttpFilter() {
        HttpFilter root = new IPFilter();
        HttpFilter next = new AccountFilter();
        root.setNext(next);

        HttpFilter next2 = new RateLimiter();
        next.setNext(next2);
        return root;

    }
}
