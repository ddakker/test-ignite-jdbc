package pe.kr.ddakker.test.ignite.jdbc.app.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.kr.ddakker.test.ignite.jdbc.app.domain.User;
import pe.kr.ddakker.test.ignite.jdbc.app.svc.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public User getUsers(@PathVariable("username") String username) {
        return userService.getUser(username);
    }
}
