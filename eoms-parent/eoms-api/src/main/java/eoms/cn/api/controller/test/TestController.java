package eoms.cn.api.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import eoms.cn.business.model.dto.TestDTO;
import eoms.cn.business.service.TestService;
import eoms.cn.commons.response.EomsResponse;
import io.swagger.annotations.ApiOperation;

@RestController("/test")
public class TestController {
    @Autowired
    private TestService testService;
    
    @PostMapping("/hello")
    @ApiOperation(value="测试接口", notes="测试接口")
    public EomsResponse<?> hello(@RequestBody TestDTO dto) {
        return testService.test(dto);
    }

}
