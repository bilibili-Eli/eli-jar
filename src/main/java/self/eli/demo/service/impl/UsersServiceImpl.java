package self.eli.demo.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import self.eli.demo.exception.EliException;
import self.eli.demo.mapper.UsersMapper;
import self.eli.demo.model.EliApiResult;
import self.eli.demo.model.Users;
import self.eli.demo.service.UsersService;
import self.eli.demo.util.EliApiCode;
import self.eli.demo.vo.UsersVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Service("usersServiceImpl")
public class UsersServiceImpl extends BaseRedisServiceImpl<String> implements UsersService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public void insert(UsersVo usersVo, HttpServletRequest request) {
        usersVo.setUserId(UUID.randomUUID().toString());
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
        return usersMapper.selectAll();
    }

    @Override
    public List<Users> select(Users model, HttpServletRequest request) {
        return usersMapper.select(model);
    }

    @Override
    public EliApiResult login(Users users, HttpServletRequest request) throws EliException {
        try {
            Users user = usersMapper.selectOne(users);
            if (user != null) {
                if (user.getStatus().equals("1")) return EliApiResult.fail(EliApiCode.USER_ACCOUNT_FORBIDDEN);
                UsersVo usersVo = new UsersVo();
                BeanUtils.copyProperties(user, usersVo);
                String uuid = UUID.randomUUID().toString();
                put(uuid, usersVo.getUserId(), 1800);
                usersVo.setToken(uuid);
                return EliApiResult.success(EliApiCode.LOGIN_SUCCESS.getMsg(), usersVo);
            } else {
                return EliApiResult.fail(EliApiCode.USER_ACCOUNT_ERROR);
            }
        } catch (Exception e) {
            throw new EliException(EliApiCode.USER_DATA_EXCEPTION);
        }
    }

    @Override
    public EliApiResult logout(HttpServletRequest request) throws EliException {
        String token = request.getHeader("user-token");
        if (token != null) {
            remove(token);
            return EliApiResult.success();
        } else {
            return EliApiResult.fail(EliApiCode.USER_DATA_EXCEPTION);
        }
    }

}
