package self.eli.demo.service;

import self.eli.demo.exception.EliException;
import self.eli.demo.model.EliApiResult;
import self.eli.demo.model.Users;
import self.eli.demo.vo.UsersVo;

import javax.servlet.http.HttpServletRequest;

public interface UsersService extends EliService<Users, UsersVo> {
    /**
     * 登录
     *
     * @param users   用户实体
     * @param request request域
     * @return 用户扩展实体
     */
    EliApiResult login(Users users, HttpServletRequest request) throws EliException;

    /**
     * 退出登录
     *
     * @param request request域
     * @return 用户扩展实体
     */
    EliApiResult logout(HttpServletRequest request) throws EliException;
}
