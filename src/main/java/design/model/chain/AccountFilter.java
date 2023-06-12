package design.model.chain;

public class AccountFilter extends HttpFilter {
    @Override
    public String execute(HttpRequestParams params) {
        //比如查询数据库 校验
        if ("admin".equals(params.getUserName())
                && "123".equals(params.getPassword())) {
            System.out.println("账号验证通过");
            return OK;
        }
        throw new RuntimeException("检查账号异常啦");
    }
}
