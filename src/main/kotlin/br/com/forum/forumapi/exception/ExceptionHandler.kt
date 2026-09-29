package br.com.forum.forumapi.exception

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.net.URI
import java.time.LocalDateTime


@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun methodArgumentNotValidExceptionHandle(
        e: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ProblemDetail {
        val problemDetail = ProblemDetail.forStatusAndDetail(
            HttpStatus.BAD_REQUEST,
            "Um ou mais parâmetros estão incorretos ou em branco!"
        ).apply {
            title = "Validation Error"
            setProperty("timestamp", LocalDateTime.now())
            instance = URI(request.servletPath)
        }

        val errors = e.bindingResult.fieldErrors.associate{ e->
            e.field to e.defaultMessage
        }

        problemDetail.setProperty("errors", errors)

        return problemDetail
    }


    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun notFoundExceptionHandler(
        e: NotFoundException,
        request: HttpServletRequest
    ): ProblemDetail {
        val problemDetail = ProblemDetail.forStatusAndDetail(
            HttpStatus.NOT_FOUND,
            e.message
        ).apply {
            title = "Not Found"
            instance = URI(request.servletPath)
            setProperty("timestamp", LocalDateTime.now())
        }

        return problemDetail

    }


}