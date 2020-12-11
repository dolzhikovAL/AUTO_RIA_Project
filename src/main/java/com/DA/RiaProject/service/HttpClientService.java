package com.DA.RiaProject.service;

import com.DA.RiaProject.entities.ResponseMapper;
import com.DA.RiaProject.entities.search.request.CustomRequest;
import com.DA.RiaProject.entities.search.searchid.IdSearchResponse;
import com.DA.RiaProject.entities.search.searchid.IdSearchResponseSlim;

import java.io.IOException;
import java.util.List;

public interface HttpClientService {

    ResponseMapper<Integer, List<IdSearchResponseSlim>> searchList(CustomRequest jsonRequest) throws IOException;

    IdSearchResponse searchById(String params) throws IOException;

}

