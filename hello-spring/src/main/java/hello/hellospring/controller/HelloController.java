package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    // 웹 어플리케이션에서 hello가 들어오면 이 메서드를 호출시켜줌(매칭시켜줌)
    @GetMapping("hello")
    public String hello(Model model){ // 모델은 스프링에서 자동으로 넘겨줌
        model.addAttribute("data", "hello!!");
        return "hello"; // resources/template 에 있는 hello.html 찾아감.
        // 뷰 리졸버(view resolver)가 화면을 찾아서 처리함
        // 즉, 거기 찾아가서 그 아이를 렌더링해라. 이 말임.
    }

}
