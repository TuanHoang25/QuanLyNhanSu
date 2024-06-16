package com.example.demo.Service;

import com.example.demo.Model.NHANVIEN;
import com.example.demo.Repository.NhanvienRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class NhanvienService {

    @Autowired
    private  NhanvienRepository nhanvienRepository;
    public List<NHANVIEN> getallnhanvien(){
        return nhanvienRepository.findAll();
    }

    public NHANVIEN getnhanvienbyid(String id){
        return nhanvienRepository.findById(id).orElse(null);
    }
    public NHANVIEN savenhanvien(NHANVIEN nv){
        return nhanvienRepository.save(nv);
    }
    public void deletenhanvien(String id){
        nhanvienRepository.deleteById(id);
    }

    // Update an existing product
    public NHANVIEN updatenhanvien(@NotNull NHANVIEN nv) {
        NHANVIEN existingNhanvien = nhanvienRepository.findById(nv.getMa_nv())
                .orElseThrow(() -> new IllegalStateException("Nhan vien with ID " +
                        nv.getMa_nv() + " does not exist."));

        existingNhanvien.setTen_nv(nv.getTen_nv());
        existingNhanvien.setPhai(nv.getPhai());
        existingNhanvien.setNoi_sinh(nv.getNoi_sinh());
        existingNhanvien.setPhongban(nv.getPhongban());
        existingNhanvien.setLuong(nv.getLuong());

        return nhanvienRepository.save(existingNhanvien);
    }

    // Delete a product by its id
    public void deletenhanvienById(String id) {
        if (!nhanvienRepository.existsById(id)) {
            throw new IllegalStateException("nhanvien with ID " + id + " does not exist.");
        }
        nhanvienRepository.deleteById(id);
    }
}

