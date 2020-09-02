package pe.kr.ddakker.test.ignite.jdbc.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "pe.kr.ddakker.test.ignite.jdbc.app.mapper.mariadb", sqlSessionFactoryRef = "mairadbSqlSessionFactory")
public class MabatisMariadbConfig {
    @Primary
    @Bean(name = "mairadbDataSource")
    @ConfigurationProperties(prefix = "spring.mariadb.datasource")
    public DataSource mairadbDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "mairadbSqlSessionFactory")
    public SqlSessionFactory mairadbSqlSessionFactory(@Qualifier("mairadbDataSource") DataSource mairadbDataSource,
                                                    ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mairadbDataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Primary
    @Bean(name = "mairadbSessionTemplate")
    public SqlSessionTemplate mairadbSqlSessionTemplate(@Qualifier("mairadbSqlSessionFactory") SqlSessionFactory mairadbSqlSessionFactory) {
        return new SqlSessionTemplate(mairadbSqlSessionFactory);
    }
}
