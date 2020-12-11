package com.DA.RiaProject.service;

import com.DA.RiaProject.dao.CustomRequestRepository;
import com.DA.RiaProject.entities.ResponseMapper;
import com.DA.RiaProject.entities.search.request.CustomRequest;
import com.DA.RiaProject.entities.search.response.ApiSearchResponse;
import com.DA.RiaProject.entities.search.searchid.IdSearchResponse;
import com.DA.RiaProject.entities.search.searchid.IdSearchResponseSlim;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class OkHttpSearchServiceImpl implements HttpClientService{
    private static final Logger LOG = LogManager.getLogger(OkHttpSearchServiceImpl.class);
    private OkHttpClient clientFactory;
    private ObjectMapper mapper;
    private CustomRequestRepository requestRepository;
    private UserService userService;
    private UriMapper uriMapper;

    @Autowired
    public OkHttpSearchServiceImpl(OkHttpClient clientFactory, ObjectMapper mapper,
                                   CustomRequestRepository requestRepository,
                                   UserService userService) {
        this.clientFactory = clientFactory;
        this.mapper = mapper;
        this.requestRepository = requestRepository;
        this.userService = userService;
    }

    @Autowired
    public void setUriMapper(UriMapper uriMapper) {
        this.uriMapper = uriMapper;
    }

    @Autowired
    public void setClientFactory(OkHttpClient clientFactory) {
        this.clientFactory = clientFactory;
    }

    @Override
    public ResponseMapper<Integer,List<IdSearchResponseSlim>> searchList(CustomRequest jsonRequest) throws IOException {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = userService.getUser(principal.getUsername()).getId();
        jsonRequest.setUserId(userId);
        jsonRequest.setTimeCreated(System.currentTimeMillis());
        CustomRequest persistent = requestRepository.save(jsonRequest);
        ApiSearchResponse response = mapper.readValue(
                Objects.requireNonNull(getResponse(uriMapper.getSearchUrlPattern(jsonRequest)).body())
                        .bytes(), new TypeReference<>() {
                });

        List<IdSearchResponseSlim> list = new ArrayList<>();
        for (String id : response.getResponseResult().getSearchResult().getIds()) {
            final ResponseBody body = getResponse(uriMapper.getIdInfoUri(id))
                    .body();
            list.add(mapper.readValue(Objects.requireNonNull(body).bytes(), new TypeReference<>() {}));
        }
        ResponseMapper<Integer, List<IdSearchResponseSlim>> result = new ResponseMapper<>();
        result.setKey(persistent.getId());
        result.setValue(list);
        return result;
    }

    @Override
    public IdSearchResponse searchById(String autoId) throws IOException {
        return mapper.readValue(Objects.requireNonNull(getResponse(uriMapper.getIdInfoUri(autoId)).body())
                .bytes(), new TypeReference<>() {});
    }

    @NotNull
    private Response getResponse(String url) throws IOException {
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        Response response = clientFactory.newCall(request).execute();
        LOG.debug(String.format("getResponse code=%s,  url: %s", response.code(), url));
        return response;
    }

}
