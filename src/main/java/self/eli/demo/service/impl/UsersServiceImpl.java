package self.eli.demo.service.impl;

import org.springframework.stereotype.Service;
import self.eli.demo.mapper.UsersMapper;
import self.eli.demo.model.Users;
import self.eli.demo.service.UsersService;
import self.eli.demo.vo.UsersVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("usersServiceImpl")
public class UsersServiceImpl implements UsersService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public void insert(UsersVo usersVo, HttpServletRequest request) {
        usersVo.iniInsert(request);
        usersMapper.insert(usersVo);
    }

    @Override
    public void update(UsersVo usersVo, HttpServletRequest request) {
        usersVo.iniModify(request);
        usersMapper.updateByPrimaryKeySelective(usersVo);
    }

    @Override
    public void delete(Users model, HttpServletRequest request) {
        usersMapper.delete(model);
    }

    @Override
    public Users selectById(Users model, HttpServletRequest request) {
        return usersMapper.selectOne(model);
    }

    @Override
    public List<Users> selectAll(Users model, HttpServletRequest request) {
        return usersMapper.select(model);
    }
}
