package com.hmz.spring_jpa;

import lombok.Data;
import lombok.Setter;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
@PropertySource("classpath:custom.properties")
@Data
public class MyFirstService {
    private MySprBoot mySprBoot;

    @Value("${my.school}")
    private String myCustom;

    public MyFirstService(@Qualifier("bean2") MySprBoot mySprBoot) {
        this.mySprBoot = mySprBoot;
    }

    public String tellAStory(){
        return "the dependency is saying " + mySprBoot.sayHello();
    }
}
