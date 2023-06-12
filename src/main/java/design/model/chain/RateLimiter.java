package design.model.chain;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class RateLimiter extends HttpFilter {
    private Semaphore semaphore = new Semaphore(2);

    @Override
    public String execute(HttpRequestParams params) {
        try {
            boolean b = semaphore.tryAcquire();
            if (b) {
                System.out.println("限流验证通过");
                return OK;
            }
        } catch (Exception e) {
            throw new RuntimeException("限流啦");
        }
        throw new RuntimeException("限流啦");
    }
}
