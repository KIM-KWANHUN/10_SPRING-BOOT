package com.ohgiraffers.thymeleaf;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @GetMapping("conditional")
    public ModelAndView conditional(ModelAndView mv) {

        mv.addObject("num", 1);
        mv.addObject("str", "바나나");

        List<MemberDTO> memberList = new ArrayList<>();
        memberList.add(new MemberDTO("루피",37,'남',"LA"));
        memberList.add(new MemberDTO("나플라",35,'남',"LA"));
        memberList.add(new MemberDTO("오왼",33,'남',"LA"));
        memberList.add(new MemberDTO("블루",33,'남',"LA"));

        mv.addObject("memberList", memberList);

        mv.setViewName("lecture/conditional");


        return mv;
    }

    @GetMapping("etc")
    public ModelAndView etc(ModelAndView mv) {

        SearchCriteria criteria = new SearchCriteria(1,10,3);

        // key 와 value 형식으로 작성 가능하지만, key 를 작성하지 않을 시
        // 해당하는 인스턴스의 타입 = 클래스 가 key 값이 된다.
        mv.addObject(criteria);

        List<MemberDTO> memberList = new ArrayList<>();
        memberList.add(new MemberDTO("제이통",37,'남',"LA"));
        memberList.add(new MemberDTO("제네더질라",35,'남',"LA"));
        memberList.add(new MemberDTO("플리키뱅",33,'남',"LA"));
        memberList.add(new MemberDTO("던밀스",33,'남',"LA"));

        mv.addObject("memberList", memberList);

        Map<String, MemberDTO> memberMap = new HashMap<>();
        memberMap.put("1", new MemberDTO("모하메드 살라", 33, '남', "이집트"));
        memberMap.put("2", new MemberDTO("루이스 디아즈", 29, '남', "콜롬비아"));
        memberMap.put("3", new MemberDTO("버질 반다이크", 33, '남', "네덜란드"));
        memberMap.put("4", new MemberDTO("알렉산더 아놀드", 33, '남', "이집트"));
        mv.setViewName("lecture/etc");

        return mv;
    }

    @GetMapping("fragment")
    public ModelAndView fragment(ModelAndView mv) {

        mv.addObject("test","value");
        mv.addObject("test2","value2");

        mv.setViewName("lecture/fragment");
        // view 의 이름을 설정하게되면 templates 에 fragment 를 만들어라 라는뜻

        return mv;
    }




}

