package pe.kr.ddakker.test.ignite.jdbc.app.svc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.kr.ddakker.test.ignite.jdbc.app.domain.User;
import pe.kr.ddakker.test.ignite.jdbc.app.mapper.ignite.UserIgniteMapper;
import pe.kr.ddakker.test.ignite.jdbc.app.mapper.mariadb.UserMariadbMapper;

import java.util.List;

@Service
public class UserService {
    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserMariadbMapper userMariadbMapper;

    @Autowired
    UserIgniteMapper userIgniteMapper;

    public List<User> getUsers() {
        List<User> users = userIgniteMapper.getUsers();
        logger.info("===== CACHE SELECT users: {}", users);

        if (users == null || users.size() == 0) {
            users = userMariadbMapper.getUsers();
            logger.info("===== DB SELECT users: {}", users);
            for (User user : users) {
                logger.info("===== CACHE INSERT user: {}", user);
                userIgniteMapper.save(user);
            }
        }


        return users;
    }

    public User getUser(String username) {
        User user = userIgniteMapper.getUser(username);
        logger.info("===== CACHE SELECT users: {}", user);

        if (user == null) {
            user = userMariadbMapper.getUser(username);
            logger.info("===== DB SELECT users: {}", user);
            userIgniteMapper.save(user);
        }
        return user;
    }
}
