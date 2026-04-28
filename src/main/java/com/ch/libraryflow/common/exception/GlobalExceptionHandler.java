package com.ch.libraryflow.common.exception;

import com.ch.libraryflow.common.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // TODO : 이걸 businessException 으로 통합해서 받고싶은데 ErrorStatus 는 어디서 매핑해야될지 모르겠음
    // 글로벌 익셉션 핸들러에서 매핑하고싶은데 그러면 에러마다 연결해주는 메서드가 어쨌든 필요하고(세부 에러를 알고있어야하고)
    // Enum 에 넣어주기엔? 이건 응답용 status 값인데 enum 에 넣는게 맞나 싶고?
    // 세부 에러에 errorcode , message , status 를 다 넣는건 말이 안되는데? 궁금;
    // 비즈니스 익셉션 = 500으로 통일! // 이외 별도 코드가 필요한 애들을 나누기!@

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponse> handleApplicationException(ApplicationException ex) {
        return ResponseEntity.status(ex.getStatus())
                .body(new ErrorResponse(
                        ex.getErrorCode().name(),
                        ex.getMessage()
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                "INTERNAL_SERVER_ERROR",
                "서버 내부 오류가 발생했습니다."
        );

        return ResponseEntity.internalServerError().body(errorResponse);
    }

}
