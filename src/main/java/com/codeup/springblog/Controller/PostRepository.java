package com.codeup.springblog.Controller;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Codeup, String> {
    Codeup findByName(String name);
//    Codeup findByTitle(String title);

//    List<Post> searchByTitleLike(@Param("term") long id);
//    List<Codeup> searchByTitleLike(@Param("term") String name);
    List<Codeup> findAllByName(String name);
//    List<Codeup> findAllByTitle(String title);


}
