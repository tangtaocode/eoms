package eoms.cn.api.controller.test;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import eoms.cn.commons.response.EomsResponse;

@RestController("/test")
public class TestController {
    @PostMapping("/hello")
    public EomsResponse<?> hello() {
        return EomsResponse.createOkEomsResponse();
    }

}
