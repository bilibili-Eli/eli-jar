package self.eli.demo.util;

public enum EliApiCode {
    SUCCESS(0, "操作成功");

    private final int code;
    private final String msg;

    private EliApiCode(int code, String message) {
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
