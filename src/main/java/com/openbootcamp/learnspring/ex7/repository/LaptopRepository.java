package com.openbootcamp.learnspring.ex7.repository;

import com.openbootcamp.learnspring.ex7.domain.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {


}
