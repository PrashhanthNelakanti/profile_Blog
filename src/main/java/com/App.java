package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.ArrayList;

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        
       SpringApplication.run(App.class, args);
    }

   
}