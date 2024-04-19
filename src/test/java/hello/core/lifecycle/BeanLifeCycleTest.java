package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {

        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}

//생성자 주입은 예외. 스프링빈생성단계에서 일어남.

//초기화작업 이란?: 객체가 뭔가 처음 제대로 일을 시작할 때

//생성자 파라미터로 넘기고...이렇게 해버리는게 낫지 않나요? -> 분리.
//외부와 커넥션 맺고... 이런 동작행위는 별도의 초기화메소드로 분리하는게 나음.
