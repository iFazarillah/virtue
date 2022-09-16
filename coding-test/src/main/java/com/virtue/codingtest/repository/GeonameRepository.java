package com.virtue.codingtest.repository;


import com.virtue.codingtest.model.Geoname;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;


@Repository
public interface GeonameRepository extends PagingAndSortingRepository<Geoname, Long> {

    @Query("select gn from Geoname gn")
    public Page<Geoname> getAllData(Pageable pageable);

    @Query("select gn from Geoname gn WHERE gn.id = :idgn")
    public Geoname getById(@Param("idgn") Long idgn);

    public Page<Geoname> findByNameLike(String name, Pageable pageable);

    @Query("select gn.name, gn.latitude, gn.longtitudw from Geoname gn where gn.name like :name")
    Page<Geoname> getSomeData(String name, Pageable pageable);

//    @Query(value ="SELECT *, ( 6371 * acos( cos( radians(?1) ) * cos( radians(  latitude ) ) * cos( radians( longitude ) - radians(?2) ) + sin(     radians(?1) ) * sin( radians( latitude ) ) ) ) AS range FROM user WHERE roles='USER' HAVING distance < 20 ORDER BY distance LIMIT 0 , 20",nativeQuery = true)
//    List<User> findAllNearByUsers(double lat,  double longt);

}
