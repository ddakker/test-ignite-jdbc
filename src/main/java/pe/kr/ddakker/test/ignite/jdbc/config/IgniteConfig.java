package pe.kr.ddakker.test.ignite.jdbc.config;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.kr.ddakker.test.ignite.jdbc.app.domain.User;

@Configuration
public class IgniteConfig {
    /**
     * Creating Apache Ignite instance bean. A bean will be passed
     * to IgniteRepositoryFactoryBean to initialize all Ignite based Spring Data      * repositories and connect to a cluster.
     */
    @Bean
    public Ignite igniteInstance() {
        IgniteConfiguration cfg = new IgniteConfiguration();

        // Setting some custom name for the node.
        cfg.setIgniteInstanceName("springDataNode");

        // Enabling peer-class loading feature.
        cfg.setPeerClassLoadingEnabled(true);

        // Defining and creating a new cache to be used by Ignite Spring Data
        // repository.
        CacheConfiguration ccfg = new CacheConfiguration("UserCache");
        ccfg.setIndexedTypes(String.class, User.class);

        cfg.setCacheConfiguration(ccfg);

        Ignite ignite = Ignition.start(cfg);

        ignite.getOrCreateCache("UserCache").query(new SqlFieldsQuery("CREATE TABLE user " +
                "(username varchar primary key, password varchar)").setSchema("PUBLIC")).getAll();
        return ignite;
    }
}