package com.virtue.codingtest.service.impl;

import com.virtue.codingtest.model.Geoname;
import com.virtue.codingtest.repository.GeonameRepository;
import com.virtue.codingtest.service.GeonameService;
import com.virtue.codingtest.utils.TemplateResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Map;

@Service
public class GeonameServiceImpl implements GeonameService {

    @Autowired
    public GeonameRepository geonameRepository;

    @Autowired
    public TemplateResponse templateResponse;

    public static final Logger log = LoggerFactory.getLogger(GeonameServiceImpl.class);

    @Override
    public Map getAll(int size, int page) {
        try {
            Pageable show_data = PageRequest.of(page, size);
            Page<Geoname> list = geonameRepository.getAllData(show_data);
            return templateResponse.templateSukses(list);
        } catch (Exception e) {
            log.error("Error in method getAll:" + e);
            return templateResponse.templateError(e);
        }
    }

    @Override
    public Page<Geoname> findByNameLike(String name, Pageable pageable) {
        try { Page<Geoname> list = geonameRepository.findByNameLike("%" + name + "%", pageable);
            return list;
        } catch ( Exception e ) {
            log.error("Error in method findNameLike:" + e);
            return null;
        }

    }


}
