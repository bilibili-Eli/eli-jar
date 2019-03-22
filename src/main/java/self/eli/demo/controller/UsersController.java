package self.eli.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import self.eli.demo.model.EliApiResult;
import self.eli.demo.model.Users;
import self.eli.demo.service.UsersService;
import self.eli.demo.vo.UsersVo;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UsersController extends EliController<UsersService, Users, UsersVo> {
    @RequestMapping("/setSession")
    public EliApiResult setSession(HttpSession session) {
        try {
            String value = UUID.randomUUID().toString();
            session.setAttribute("user-key", value);
            return EliApiResult.success(value);
        } catch (Exception e) {
            e.printStackTrace();
            return EliApiResult.fail("操作失败");
        }
    }

    @RequestMapping("/getSession")
    public EliApiResult getSession(HttpSession session) {
        try {
            return EliApiResult.success(session.getAttribute("user-key"));
        } catch (Exception e) {
            e.printStackTrace();
            return EliApiResult.fail("操作失败");
        }
    }
}
