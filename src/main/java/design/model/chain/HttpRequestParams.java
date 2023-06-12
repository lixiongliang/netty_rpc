package design.model.chain;

import lombok.Data;

@Data
public class HttpRequestParams {
    /**
     * 验证ip
     * 账号
     * 流量控制
     */
    private String ip;
    private String userName;
    private String password;

}
