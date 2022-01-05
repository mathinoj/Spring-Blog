package com.codeup.springblog.Controller;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByMake(String make);
}
