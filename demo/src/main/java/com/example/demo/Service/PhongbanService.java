package com.example.demo.Service;


import com.example.demo.Model.PHONGBAN;
import com.example.demo.Repository.PhongbanRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PhongbanService {
    @Autowired
    private PhongbanRepository phongbanRepository;
    public List<PHONGBAN> getallphongban(){
        return phongbanRepository.findAll();
    }

    public PHONGBAN getphongbanbyid(String id){
        return phongbanRepository.findById(id).orElse(null);
    }
    public void addphongban(PHONGBAN pb){
        phongbanRepository.save(pb);
    }
    public void deletephongban(String id){
        phongbanRepository.deleteById(id);
    }
}
