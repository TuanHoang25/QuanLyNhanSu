package com.example.demo.Repository;

import com.example.demo.Model.PHONGBAN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongbanRepository extends JpaRepository<PHONGBAN,String> {
}
