package com.virtue.codingtest.service;

import com.virtue.codingtest.model.Geoname;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface GeonameService {

    public Map getAll(int size, int page);

    Page<Geoname> findByNameLike(String name, Pageable pageable);


}
