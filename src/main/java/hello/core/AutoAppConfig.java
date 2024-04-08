package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.core.member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //기존의 AppConfig를 설정정보로 사용하지 않기 위해 @Configuration붙은애는 잠시 제외시킴.
        //@Configuration안에 @Component애노테이션이 포함되어있으므로
)
public class AutoAppConfig {
}
