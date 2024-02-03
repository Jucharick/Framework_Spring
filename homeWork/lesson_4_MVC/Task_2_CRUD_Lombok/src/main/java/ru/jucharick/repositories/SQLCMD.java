package ru.jucharick.repositories;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Конфигуратор SQL запросов
 */

@Configuration
@ConfigurationProperties(prefix = "sqlcmd")
@ConfigurationPropertiesScan
@PropertySource("classpath:sqlCMD.properties")
@Data
public class SQLCMD {
    private String findAll;
    private String save;
    private String delete;
    private String getById;
    private String update;
}
