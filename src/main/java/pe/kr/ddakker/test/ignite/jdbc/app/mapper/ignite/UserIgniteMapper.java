package pe.kr.ddakker.test.ignite.jdbc.app.mapper.ignite;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import pe.kr.ddakker.test.ignite.jdbc.app.domain.User;

import java.util.List;

@Mapper
public interface UserIgniteMapper {
    @Select(" SELECT username, password FROM user ")
    public List<User> getUsers();

    @Select(" SELECT username, password FROM user WHERE username = #{username} ")
    public User getUser(String username);

    @Insert(" INSERT INTO user (username, password) values (#{username}, #{password}) ")
    public void save(User user);
}
