package design.model.chain;

public abstract class  HttpFilter {

    private HttpFilter next;

    public void setNext(HttpFilter next) {
        this.next = next;
    }

    public void filter(HttpRequestParams params ){
        String execute = execute(params);
        if(!OK.equals(execute)){
            System.out.println("异常结束："+execute);
            return;
        }
        if(next != null){
            next.filter(params);
        }
    }

    public static final    String OK = "OK";
    abstract  String execute(HttpRequestParams params);
}
