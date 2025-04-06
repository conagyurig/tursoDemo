package com.conagyurig.tursoDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.relational.core.dialect.Dialect;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

@Configuration
@EnableJdbcRepositories
public class LibSqlConfig extends AbstractJdbcConfiguration {

    @Bean
    @Override
    public Dialect jdbcDialect(NamedParameterJdbcOperations operations) {
        return new LibSQLDialect();
    }

}
