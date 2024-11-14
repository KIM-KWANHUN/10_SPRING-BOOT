package com.ohgiraffers.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GlobalTestController {
    /* comment.
    *   다른 클래스에서 @ExceptionHandler 메소드를
    *   작성해두었다고 해서 지금 클래스에서 발생하는
    *   예외를 처리할 수는 없다.
    *   전혀 연관없는 클래스이기 때문이다. */
    @GetMapping("global-nullpointer")
    public String globalNull() {

        String str = null;
        System.out.println(str.charAt(0)); // 강제로 null

        return "/";
    }

    @GetMapping("global-userexception")
    public String globalUserException() throws MemberNotFoundException {
        boolean check = true;

        if(check) {
            throw new MemberNotFoundException("회원이 한놈도 없어... 우린 이제 끝이야");
        }
        return "/";
    }

    @GetMapping("global-default")
    public String manyException() {

        double[] array = new double[0];
        // 배열의 크기를 0으로 만들어두고
        // 1번째 데이터 출력하려고 할 때
        System.out.println(array[0]);

        return "/";
    }
}
