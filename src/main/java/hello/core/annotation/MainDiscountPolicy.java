package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

//@Qualifier 안의 어노테이션들 (@MainDiscountPolicy자체가 퀄리파이역할할수있도록, 상속받은느낌?)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented

@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {


}
