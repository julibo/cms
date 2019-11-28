package com.julibo.pig.cms.controller;

import com.julibo.pig.cms.domain.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author carson
 * @date 2019-11-28
 */
@RestController
@RequestMapping("/cms/test")
public class Test extends BaseController {

    @GetMapping(value = "/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping(value = "/hello")
    public Result<String> hello() {
        return ok("hello pig cms");
    }

}
