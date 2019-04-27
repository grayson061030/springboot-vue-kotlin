package com.example.kboot

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping


@Controller
class RouteController {

    @RequestMapping("/")
    fun index():String = "index"

    @RequestMapping("/{path:[^\\.]*}")
    fun redirect(): String = "forward:/"
}