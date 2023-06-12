package design.model.chain;

public class IPFilter extends HttpFilter {
    @Override
    public String execute(HttpRequestParams params) {
        if (!"10.10.100.1".equals(params.getIp())) {
            throw new RuntimeException("Ip 检查不合法");
        }
        System.out.println("IP验证通过");

        return OK;
    }
}
