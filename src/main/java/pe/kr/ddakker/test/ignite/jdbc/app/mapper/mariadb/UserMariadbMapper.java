package pe.kr.ddakker.test.ignite.jdbc.app.mapper.mariadb;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import pe.kr.ddakker.test.ignite.jdbc.app.domain.User;

import java.util.List;

@Mapper
public interface UserMariadbMapper {

    @Select(" SELECT username, password FROM user ")
    public List<User> getUsers();

    @Select(" SELECT username, password FROM user where username = #{username} ")
    public User getUser(String username);
}
