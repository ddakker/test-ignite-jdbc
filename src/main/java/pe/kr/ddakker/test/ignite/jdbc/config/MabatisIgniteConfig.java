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

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "pe.kr.ddakker.test.ignite.jdbc.app.mapper.ignite", sqlSessionFactoryRef = "igniteSqlSessionFactory")
public class MabatisIgniteConfig {
    @Bean(name = "igniteDataSource")
    @ConfigurationProperties(prefix = "spring.ignite.datasource")
    public DataSource igniteDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "igniteSqlSessionFactory")
    public SqlSessionFactory igniteSqlSessionFactory(@Qualifier("igniteDataSource") DataSource igniteDataSource,
                                                      ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(igniteDataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "igniteSessionTemplate")
    public SqlSessionTemplate igniteSqlSessionTemplate(@Qualifier("igniteSqlSessionFactory") SqlSessionFactory igniteSqlSessionFactory) {
        return new SqlSessionTemplate(igniteSqlSessionFactory);
    }
}
