package com.example.kboot.member

import com.fasterxml.jackson.core.JsonParseException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.lang.Exception
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class ErrorHandler {
    @ExceptionHandler(JsonParseException::class)
    fun JsonParseExceptionHandler(servletRequest:HttpServletRequest, exception: Exception):ResponseEntity<String> {
        return ResponseEntity("Json Error", HttpStatus.BAD_REQUEST)
    }
}