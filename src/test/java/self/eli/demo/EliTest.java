package self.eli.demo;

import org.junit.Test;
import self.eli.demo.model.Users;
import self.eli.demo.vo.UsersVo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EliTest {
    @Test
    public void UUIDTest() {
        System.out.println(UUID.randomUUID().toString());
    }

    @Test
    public void VoTest() {
        List<Users> list = new ArrayList<>();
        list.add(new UsersVo());
        for (Users users : list) {
            System.out.println(users);
        }
        System.out.println(list);
    }
}
