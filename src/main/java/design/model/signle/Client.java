package design.model.signle;

public class Client {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            RedisUtil redisUtil = RedisUtil.getInstance();
            System.out.println(redisUtil.toString());
        }
        long end = System.currentTimeMillis();
        System.out.println("对象创建耗时：" + (end - start));
    }
}
