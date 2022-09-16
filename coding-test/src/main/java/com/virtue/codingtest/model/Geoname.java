package com.virtue.codingtest.model;



import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "geoname")
public class Geoname implements Serializable {

    @Id
    @Column(name="id")
    private long id;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "ascii", nullable = false, length = 200)
    private String asciiname;

    @Column(name = "alt_name", columnDefinition = "TEXT")
    private String altNameList;

    @Column(name = "lat", precision=10, scale=5)
    private BigDecimal latitude;

    @Column(name = "long", precision=10, scale=5)
    private BigDecimal longtitude;

    @Column(name = "feat_class")
    private char featureClass;

    @Column(name = "feat_code", length = 10)
    private String featureCode;

    @Column(name = "country", length = 2)
    private String countryCode;

    @Column(name = "cc2", length = 60)
    private String cc2;

    @Column(name = "admin1", length = 20)
    private String admin1Code;

    @Column(name = "admin2", length = 80)
    private String admin2Code;

    @Column(name = "admin3", length = 20)
    private String admin3Code;

    @Column(name = "admin4", length = 20)
    private String admin4Code;

    @Column(name = "population")
    private Long population;

    @Column(name = "elevation")
    private Integer elevation;

    @Column(name = "dem")
    private Integer dem;

    @Column(name = "tz", length = 40)
    private String timezone;

    @Column(name = "modified_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date modificationDate;


}
