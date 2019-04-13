package com.weshare.phoenix.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author MCC
 * @Create 2019/4/12 14:36
 */
@ConfigurationProperties("weshare.process.datasource")
@Component
@Data
public class WeShareProcessDataSourceProperties {
    private String jdbcDriver = "org.h2.Driver";
    private String jdbcUrl = "jdbc:h2:mem:testdb;MODE=MYSQL;DB_CLOSE_DELAY=-1";
    private String jdbcUsername = "sa";
    private String jdbcPassword = "";

    @Override
    public String toString() {
        return "WeShareProcessDataSourceProperties{" +
                "jdbcDriver='" + jdbcDriver + '\'' +
                ", jdbcUrl='" + jdbcUrl + '\'' +
                ", jdbcUsername='" + jdbcUsername + '\'' +
                ", jdbcPassword='" + jdbcPassword + '\'' +
                '}';
    }
}
