package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = true) String name, Model model){ //웹에서 파라미터 받을 것. -> @RequestParam.
        // required는 기본값이 true이므로 무조건 매개변수를 넘겨야하는 형식.
        // model에 담으면 View에서 렌더링할 때 쓰임.
        model.addAttribute("name", name); // key와 value
        return "hello-template";
    }
    @GetMapping("hello-string")
    @ResponseBody //http의 바디부분. 그 바디 부분에다가 밑에 있는 함수의 return값을 바로 넣어주겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
        // template와 다른 점: view가 없음(ViewResorver). 그냥 클라이언트에게 바로 내려감.
    }



}
