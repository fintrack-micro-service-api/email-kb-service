package org.example.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.example.model.SmtpDto;
import org.example.model.request.EmailUser;
import org.example.model.request.SmtpRequest;
import org.example.model.response.ApiResponse;
import org.example.service.EmailKbService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/configEmail")
@SecurityRequirement(name = "app")
@CrossOrigin
public class EmailKBServiceController {
    private final EmailKbService emailKbService;

    public EmailKBServiceController(EmailKbService emailKbService) {
        this.emailKbService = emailKbService;
    }

//    @PostMapping("/")
//    public ResponseEntity<?> configEmail(@RequestBody SmtpRequest smtpRequest){
//        SmtpDto smtp = emailKbService.configEmail(smtpRequest);
//        return ResponseEntity.ok(smtp);
//    }
    @PutMapping("/")
    public ApiResponse<?> updateConfigEmail(@RequestBody SmtpRequest smtpRequest){
        emailKbService.updateConfigEmail(smtpRequest);
        return ApiResponse.builder()
                .message("successfully update configuration")
                .status(201)
                .build();
    }

    @GetMapping("/")
    public ApiResponse<?> getEmailConfig(){
        List<SmtpDto> smtpDtos = emailKbService.getConfigEmail();
        return ApiResponse.builder()
                .message("get Email Successfully")
                .payload(smtpDtos)
                .status(200)
                .build();
    }

    @GetMapping("/Email")
    public ApiResponse getEmailReciver( @RequestParam(name = "page", defaultValue = "0") int page,
                                        @RequestParam(name = "size", defaultValue = "5") int size){
        Page<EmailUser> emailUsers = emailKbService.getAllEmailReciver(page,size);
        return ApiResponse.builder()
                .message("get Email Reciver Successfully")
                .payload(emailUsers.getContent())
                .total(emailUsers.getTotalElements())
                .status(200)
                .build();
    }

}
