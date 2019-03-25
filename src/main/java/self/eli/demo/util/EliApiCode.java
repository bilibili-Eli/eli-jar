package self.eli.demo.util;

public enum EliApiCode {
    SUCCESS(0, "操作成功"),
    LOGIN_SUCCESS(0, "登录成功"),
    USER_DATA_EXCEPTION(30007, "用户数据异常"),
    USER_ACCOUNT_ERROR(30004, "用户名或密码错误"),
    USER_ACCOUNT_FORBIDDEN(30005, "用户账户已被禁用"),
    PARAMS_IS_INVALID(40001, "参数对象无效");

    private final int code;
    private final String msg;

    EliApiCode(int code, String message) {
        this.code = code;
        this.msg = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
