package self.eli.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import self.eli.demo.model.Users;
import self.eli.demo.service.UsersService;
import self.eli.demo.vo.UsersVo;

@RestController
@RequestMapping("users")
public class UsersController extends EliController<UsersService, Users, UsersVo> {
    public UsersController(UsersService impl) {
        super(impl);
    }
}
