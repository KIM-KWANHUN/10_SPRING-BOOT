package com.ohgiraffers.fileupload;

import kotlin.uuid.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class FileController {

    @Autowired
    /* comment.
    *   yml 파일에 작성한 value 를 읽어드리기 위한 준비 */
    private ResourceLoader resourceLoader;

    @PostMapping("single-file")
    public String singleFileTest(
            @RequestParam MultipartFile singleFile, String description, Model model) throws IOException {
        /* comment.
        *   @RequestParam 어노테이션은 우리가 요청한 데이터를 받아올 수 있게
        *   하는 어노테이션이다.
        *   하지만, 매개변수 명이 일치한다면 생략이 가능하다. */
        System.out.println("singleFile = " + singleFile);
        System.out.println("description = " + description);

        /* index 1. 파일을 저장할 위치 설정 */
        Resource resource = resourceLoader.getResource("classpath:static/img/single");

        String filePath = null;
        // 만약에 위에서 지정한 파일의 저장위치가 존재하지 않는다면?
        if(!resource.exists()) {
            String root = "src/main/resources/static/img/single";
            File file = new File(root);
            // make directory 의 약자
            // 우리가 root 에 지정한 경로대로 디렉토리를 만들어준다.
            file.mkdirs();

            // 만든 폴더의 경로를 filePath 변수에 담아주기
            filePath = file.getAbsolutePath();
        } else {
            // 디렉토리가 만들어진 적이 있다면?
            filePath = resourceLoader.getResource("classpath:static/img/single").getFile().getAbsolutePath();
        }

        /* index 2. 파일 데이터 받아오고, 저장할 경로 가져왔다면
        *           데이터 변경처리 시작 */
        // 원본 파일명 담기
        String originFileName = singleFile.getOriginalFilename();
        System.out.println("originFileName = " + originFileName);
        // 확장자 제거
        String ext = originFileName.substring(originFileName.lastIndexOf(".")); // . 이라고 하는 부분을 뒤에서 부터 짜르기
        System.out.println("ext = " + ext);

        // 파일의 고유한 이름 부여
        // 고유 번호를 부여해주는 UUID 클래스
        String savedName = UUID.randomUUID().toString().replace("-", "") + ext;
        System.out.println("savedName = " + savedName);
        // 지금까지의 과정은 spring.png 라는 파일을 등록을 했다라고 가정하자..
        // originFile, ext<- 확장자 제거
        // spring, png 파일에 따로따로 담아둿다
        // UUID 를 하게된다라고 하면 ext 파일로 확장자를 제거했으니 고유하고 랜덤한 이름이 부여된다. replace 로 - 문자열을 "" 빈문자열로 치환해준다.

        /* index 3. 고유한 파일 식별번호 및 파일 저장경로 생성 완료
        *   이제 파일을 저장경로에 저장 */
        // 전달 받은 파일 객체를 변환
        singleFile.transferTo(new File(filePath + "/" + savedName));

        model.addAttribute("message", "파일업로드 성공!!");
        model.addAttribute("img", "static/img/single/" + savedName);

        return "result";

    }

    @PostMapping("multi-file")
    public String multiFile(@RequestParam List<MultipartFile> multiFile, String description, Model model) {

        return "result";
    }
}