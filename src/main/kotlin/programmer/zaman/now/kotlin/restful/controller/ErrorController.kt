package programmer.zaman.now.kotlin.restful.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import programmer.zaman.now.kotlin.restful.model.WebResponse
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException): WebResponse<String> {
        return WebResponse(
                code = 400,
                status = "Bad Request",
                data = constraintViolationException.message!!
        )
    }
}