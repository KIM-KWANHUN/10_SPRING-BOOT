package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
/* comment.
*   클래스 레벨에 RequestMapping 어노테이션 사용 가능
*   공통되는 URL 을 설정해두고 *(와일드카드) 를 이용하면
*   조금 더 포괄적인 URL 패턴을 설정 할 수 있다. */
@RequestMapping("/order/*")
public class ClassMappingController {

    /* 1. Class 레벨에 매핑하기 */
    @GetMapping("/regist")
    public String registOrder(Model model) {
        model.addAttribute("message","1번 메소드 실행 : GET 방식의 주문 등록 핸들러 메소드 호출됨...");
        return "mappingResult";
    }

    /* 2. 여러 URL 매핑하기 */
    // modify, delete 등의 여러개 작업 동시에 처리
    @RequestMapping(value = {"modify" , "delete"}, method = RequestMethod.POST)
    public String modifyAndDelete(Model model) {

        model.addAttribute("message","2번 메소드 실행 : POST 방식의 수정, 삭제 둘 다 처리하는 핸들러 메소드 호출됨...");

        return "mappingResult";
    }
    /* 3. path variable (ulr 경로를 타고 오는 값) */
    /* comment.
    *   @PathVariable 어노테이션을 통해 요청 URL 로 부터
    *   변수를 받아 올 수 있다.
    *   path variable 로 전달 되는 {변수명} 값을 반드시
    *   매개변수 명과 일치 해야 한다.
    *   만약에 동일하지 않으면 @PathVariable("이름") 을 설정해야 한다. */
    @GetMapping("/detail/{orderNo}") //설정할 때 {변수} 를 담아 놓는다.
    public String orderDetail(Model model, @PathVariable int orderNo) {
                                            // 매개변수랑 전달 되는 값이 같아야 한다. 하지만 동일하지 않을경우
                                            // @PathVariable("orderNo") 라고 입력 해주어야 오류가 발생하지 않는다.
        model.addAttribute("message",orderNo + "번 주문 상제 조회 핸들러 메소드 호출됨..");
        return "mappingResult";
    }
}
