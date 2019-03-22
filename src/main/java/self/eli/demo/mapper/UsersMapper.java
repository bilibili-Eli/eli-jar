package self.eli.demo.mapper;

import org.springframework.stereotype.Repository;
import self.eli.demo.model.Users;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UsersMapper extends Mapper<Users> {
    @Override
    List<Users> selectAll();
}
