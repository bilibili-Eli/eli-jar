package self.eli.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Table(name = "users")
public class Users extends EliModel {
    /**
     * 用户id
     */
    @Id
    @Column(name = "user_id")
    private String userId;
    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;
    /**
     * 用户密码
     */
    @Column(name = "user_password")
    private String userPassword;
    /**
     * 用户邮箱
     */
    @Column(name = "user_mail")
    private String userMail;
    /**
     * 用户手机号
     */
    @Column(name = "user_phone")
    private String userPhone;
}
