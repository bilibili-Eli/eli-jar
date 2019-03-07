package self.eli.demo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import self.eli.demo.model.Users;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class UsersVo extends Users {
    private List<Users> usersList;
}
