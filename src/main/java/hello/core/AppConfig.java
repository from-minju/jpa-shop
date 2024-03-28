package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    /*
    * 이전 : AppConfig를 보면 역할과 구현이 한눈에 보이지 않았음. 중복이 있었음.
    * 리팩어링 후 : 메서드 명을 보는 순간 역할이 드러남. 역할과 구현 클래스가 한눈에 들어옴. 전체구성을 빠르게 파악가능
    * 중복이 제거됨. ex) memory->jdbc로 나중에 구현체를 바꾼다 했을 때
    * 이전 코드는 memberService()와 orderService() 모두에게 가서 new MemoryMemberRepository() -> new JdbcMemberRepository()로 바꿔야 했음.
    * 하지만 리팩터링 이후에는 memberRepository()내부 하나만 바꾸면 됨.
    * */

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
