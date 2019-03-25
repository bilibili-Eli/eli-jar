package self.eli.demo.exception;

import self.eli.demo.util.EliApiCode;

public class EliException extends Exception {
    private Integer code;

    public EliException() {
    }

    public EliException(String message) {
        super(message);
    }

    public EliException(EliApiCode code) {
        super(code.getMsg());
        this.code = code.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
