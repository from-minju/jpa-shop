package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    /*
    * 생성자를 통해 의존관계(DI)를 주입해줌.
    * OrderServiceImpl에는 이제 추상화(인터페이스)만 있음. 어떤 db를,할인정책을 써야할지 이런거 더이상 관여하지 않음.
    * OrderServiceImpl의 기능(주문생성)만을 실행시키는데 집중. 어떤 db,할인정책인지는 더이상 알 바 아님.
    * */

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
