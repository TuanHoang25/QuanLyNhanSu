package com.example.demo.Repository;


import com.example.demo.Model.NHANVIEN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface NhanvienRepository extends JpaRepository<NHANVIEN,String> {

}
