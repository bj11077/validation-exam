package nn.jung.valid.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nn.jung.valid.dto.CommentRequestDto;
import nn.jung.valid.service.CommentService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService service;



    @Operation(summary = "댓글저장", description = "댓글 저장 기능")
    @PostMapping("")
    public ResponseEntity<String> saveComment(@Valid @RequestBody CommentRequestDto dto) {
        return ResponseEntity.ok("s");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable("id") Long id){
        log.info("deleteCall : {}",id);
        service.deleteById(id);
        return ResponseEntity.ok("success");
    }





    // comment에 특수문자 들어올시 예외발생
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<String> validException(MethodArgumentNotValidException ex){
      log.error("유효성 검사 실패 "+ ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
        return new ResponseEntity<>(ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage(),HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler({EmptyResultDataAccessException.class})
    public ResponseEntity<String> deleteException(EmptyResultDataAccessException ex){
        log.error("error : {}",ex.getMessage());
        return new ResponseEntity<>("존재하지않는 댓글입니다.",HttpStatus.BAD_REQUEST);
    }


}
