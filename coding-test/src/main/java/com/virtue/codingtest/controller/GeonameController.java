package com.virtue.codingtest.controller;


import com.virtue.codingtest.config.Config;
import com.virtue.codingtest.model.Geoname;
import com.virtue.codingtest.repository.GeonameRepository;
import com.virtue.codingtest.service.GeonameService;
import com.virtue.codingtest.utils.TemplateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/geoname")
public class GeonameController {

    @Autowired
    public GeonameService geonameService;

    Config config = new Config();

    @Autowired
    public GeonameRepository geonameRepository;

    @Autowired
    public TemplateResponse templateResponse;

    @GetMapping("/list")
    public ResponseEntity<Map> listByName(
            @RequestParam() Integer page,
            @RequestParam() Integer size,
            @RequestParam(required = false) String name) {
        Map map = new HashMap();
        Page<Geoname> list = null;
        Pageable show_data = PageRequest.of(page, size, Sort.by("id").ascending());
        if ( name != null && !name.isEmpty() ) {
            list = geonameRepository.findByNameLike("%" + name + "%", show_data);
        } else {
            list = geonameRepository.getAllData(show_data);
        }
        return new ResponseEntity<Map>(templateResponse.templateSukses(list), new HttpHeaders(), HttpStatus.OK);
    }

//    @GetMapping("/suggestions")
//    public ResponseEntity<Map> listSuggestions(
//            @RequestParam() String q,
//            @RequestParam(required = false)BigDecimal lat,
//            @RequestParam(required = false) BigDecimal longt,
//            @RequestParam() Integer p,
//            @RequestParam() Integer s){
//        Map map = new HashMap();
//        Pageable show_data = PageRequest.of(p, s, Sort.by("name").ascending());
//        if ( lat != null && longt != null){
//            list =
//        }
//    }

}
