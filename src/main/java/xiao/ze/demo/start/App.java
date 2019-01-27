package xiao.ze.demo.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * App
 *
 * @author xiaoze
 * @date 2018/6/3
 *
 * ComponentScan(basePackages = "xiao.ze.demo")  这里指定你要扫描的包及其子包子类
 * MapperScan("xiao.ze.demo.mapper") 扫描：该包下相应的class,主要是MyBatis的持久化类，
 * 这里用的是mapper的扫描，不是mybatis自身扫描
 *
 */

@ComponentScan(basePackages = "xiao.ze.demo")
@MapperScan("xiao.ze.demo.mapper")
@SpringBootApplication
@EnableTransactionManagement
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
