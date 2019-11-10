package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: <a href="mailto:nonamelnl@126.com">NoNamelnl</a>
 * @version: 1.0
 * @create: 2018/6/20
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String index() {
        return "Hello World";
    }
}
