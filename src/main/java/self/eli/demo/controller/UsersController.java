package self.eli.demo.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import self.eli.demo.exception.EliException;
import self.eli.demo.model.EliApiResult;
import self.eli.demo.model.Users;
import self.eli.demo.service.UsersService;
import self.eli.demo.util.EliApiCode;
import self.eli.demo.vo.UsersVo;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("users")
public class UsersController extends EliController<UsersService, Users, UsersVo> {
    /**
     * 登录方法
     *
     * @param users   存储用户名密码
     * @param request request域
     * @return 用户token及详情
     */
    @RequestMapping("login")
    public EliApiResult login(@RequestBody Users users, HttpServletRequest request) {
        try {
            if (users == null) {
                return EliApiResult.fail(EliApiCode.PARAMS_IS_INVALID);
            }
            return impl.login(users, request);
        } catch (EliException e) {
            return EliApiResult.fail(e.getCode() + "：" + e.getMessage());
        }
    }

    /**
     * 查询用户详情方法
     *
     * @param token   用户token
     * @param request request域
     * @return 用户token及详情
     */
    @RequestMapping("info")
    public EliApiResult info(@RequestHeader(name = "user-token") String token, HttpServletRequest request) {
        Map<String, List> admin = new HashMap<>();
        List<String> roles = new ArrayList<>();
        roles.add("vip");
        admin.put("roles", roles);
        return EliApiResult.success(admin);
    }

    /**
     * 退出登录
     *
     * @param request request域
     * @return 用户token及详情
     */
    @RequestMapping("logout")
    public EliApiResult logout(HttpServletRequest request) {
        try {
            return impl.logout(request);
        } catch (EliException e) {
            return EliApiResult.fail(e.getCode() + "：" + e.getMessage());
        }
    }
}
