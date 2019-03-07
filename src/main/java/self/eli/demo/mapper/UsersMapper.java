package self.eli.demo.mapper;

import org.springframework.stereotype.Repository;
import self.eli.demo.model.Users;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UsersMapper extends Mapper<Users> {

}
