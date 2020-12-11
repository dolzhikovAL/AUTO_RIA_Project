package com.DA.RiaProject.controller;

import com.DA.RiaProject.entities.search.request.CustomRequest;
import com.DA.RiaProject.entities.search.searchid.IdSearchResponse;
import com.DA.RiaProject.service.HttpClientService;
import com.DA.RiaProject.service.OkHttpSearchServiceImpl;
import com.DA.RiaProject.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path = "/search")
public class SearchRequestController {
    private HttpClientService httpClientService;
    private ObjectMapper mapper;
    private UserService userService;

    @Autowired
    public SearchRequestController(HttpClientService httpClientService, UserService userService) {
        this.httpClientService = httpClientService;
        this.userService = userService;
    }

    @Autowired
    public void setMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping(path = "/autoId")
    public ResponseEntity<?> params(@RequestParam(value = "id") String autoId) {
        IdSearchResponse response = null;
        try {
            response = httpClientService.searchById(autoId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(response);
    }

    @SneakyThrows
    @PostMapping(path = "/list")
    public ResponseEntity<?> searchRequest(@RequestBody CustomRequest jsonRequest) {
        return ResponseEntity.ok(mapper.writeValueAsString(httpClientService.searchList(jsonRequest)));
    }

}
