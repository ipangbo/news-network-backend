package cn.ipangbo.news;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.ipangbo.news.mapper")
public class NewsNetworkBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsNetworkBackendApplication.class, args);
    }

}
