package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        //순수한 자바코드Ver.
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //스프링Ver.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // -> AppConfig의 설정정보를 가지고 @Bean붙었던걸 스프링컨테이너에 넣어 관리해준다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        // -> (이름, 반환타입) : 이름-AppConfig에서 가져와야할 것, 찾을 것의 이름. 기본적으로 메서드 이름이 이름으로 등록됨 / (반환)타입

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
