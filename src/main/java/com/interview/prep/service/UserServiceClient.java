package com.interview.prep.service;


import com.interview.prep.exception.UserClientErrorDecoder;
import com.interview.prep.model.User;
import com.interview.prep.model.UserEntity;
import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


@FeignClient(name = "user-service", url="http://localhost:8080")
public interface UserServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "/user")
    List<UserEntity> checkUserCredentials(@RequestParam String username, @RequestParam String password);

    @RequestMapping(method = RequestMethod.POST, value = "/user/create")
    UserEntity createUser(@RequestBody UserEntity user);
}
