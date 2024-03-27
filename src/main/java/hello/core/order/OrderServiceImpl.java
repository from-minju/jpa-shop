package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //단일책임원칙이 잘 지켜짐. FixDiscountPolicy()
    //할인정책이 변경되면 OrderService의 내용 안고쳐도됨. FixDiscountPolicy를 수정하거나 다른 구현클래스로 바꿔주기만 하면 됨.

    /*
    * <문제점 발견!> - OCP, DIP 위반
    * OCP 개방-폐쇄 원칙 : 확장에는 열려있고 변경에는 닫혀있어야 한다.
    * -> 지금 코드는 기능을 확장해서 변경하면, 클라이언트 코드도 같이 바뀜.
    *    FixDiscountPolicy를 RateDiscountPolicy로 변경하는 순간 OrderServiceImpl의 코드도 함께 변경해야 한다!
    *
    * DIP 의존관계 역전 원칙 : 추상화에 의존해야지, 구체화에 의존하면 안된다.
    * -> 추상(인터페이스)뿐만 아니라 구체(구현)클래스에도 의존하고 있다.
    *
    * -> 인터페이스에만 의존하도록 코드를 변경해야 한다.
    * */

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}
