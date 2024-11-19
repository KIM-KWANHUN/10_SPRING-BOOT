package com.ohgiraffers.thymeleaf;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
// 공통으로 들어가는 url 을 클래스에 매핑
@RequestMapping("/lecture/*")

public class LectureController {
    // 요청 받은 경로
    @GetMapping("expression")
    public ModelAndView expression(ModelAndView mv) {

        // 요청받은 것을 반환 해 줄 뷰에 대한 경로(우리가 지정 한 이름으로 templates 에 .html 로 만들어야 함)

        mv.addObject("member", new MemberDTO("김관훈",30,'남',"경기도 파주시"));
        // memberDTO 파일 가져와서 값 넣어주기 KEY 값 = member VALUE 값 = new MemberDTO
        mv.setViewName("lecture/expression");

        mv.addObject("hello","hi~<h2>타임리프</h2>");

        return mv;
    }



}

