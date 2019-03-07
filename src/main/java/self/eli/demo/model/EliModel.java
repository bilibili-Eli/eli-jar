package self.eli.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public abstract class EliModel implements Serializable {
    @Column(name = "create_on")
    private Date createOn;
    @Column(name = "create_by")
    private String createBy;
    @Column(name = "modify_on")
    private Date modifyOn;
    @Column(name = "modify_by")
    private String modifyBy;
    @Column(name = "owner")
    private String owner;
    @Column(name = "status")
    private String status;

    public void iniInsert(HttpServletRequest request) {
        setCreateOn(new Date());
        setModifyOn(new Date());
        setStatus("0");
    }

    public void iniModify(HttpServletRequest request) {
        setModifyOn(new Date());
    }
}
