package pe.kr.ddakker.test.ignite.jdbc.app.domain;

import lombok.Data;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.io.Serializable;

@Data
public class User implements Serializable {
    @QuerySqlField(index=true)
    String username;

    @QuerySqlField(index=true)
    String password;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
