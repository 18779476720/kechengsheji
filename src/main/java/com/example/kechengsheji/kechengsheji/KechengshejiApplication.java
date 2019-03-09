package com.example.kechengsheji.kechengsheji;
/**
* @Description:    springboot主类
* @Author:          longhua.wang
* @CreateDate:     2019/2/23 16:35
* @UpdateUser:     longhua.wang
* @UpdateDate:     2019/2/23 16:35
*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//解决数据库驱动未明确指定问题
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class KechengshejiApplication {

    public static void main(String[] args) {
        SpringApplication.run(KechengshejiApplication.class, args);
    }

}
