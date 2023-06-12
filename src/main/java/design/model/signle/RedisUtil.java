package design.model.signle;


public class RedisUtil {


    private int [] data = new int[1000000];
    private RedisUtil(){

    };

    /**
     * 懒汉试
     *
     * volatile: 增加线程的可见性
     */

    private static  volatile RedisUtil OBJ = null;

    public static RedisUtil getInstance(){
        if(OBJ == null){
            synchronized (RedisUtil.class){
                if(OBJ == null){
                    OBJ = new RedisUtil();
                }
            }
        }
        return OBJ;
    }



}
