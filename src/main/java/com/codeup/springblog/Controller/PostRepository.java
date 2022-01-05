package com.codeup.springblog.Controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Codeup, Long> {
//    Codeup findByName(String name);
//    Codeup findByCohort(String cohort);
//    Codeup findByBody(String body);


//    List<Codeup> searchByNameLike(@Param("name") String name);
//    List<Codeup> searchByCohortLike(@Param("cohort") String cohort);
//    List<Codeup> searchByBodyLike(@Param("body") String body);


    List<Codeup> findAllByName(String name);
//    List<Codeup> findAllByCohort(String cohort);
//    List<Codeup> findAllByBody(String body);

}
