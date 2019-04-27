package com.example.kboot

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KbootApplication

fun main(args: Array<String>) {
    runApplication<KbootApplication>(*args){
        setBannerMode(Banner.Mode.OFF)
    }
}
