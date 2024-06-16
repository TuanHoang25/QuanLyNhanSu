package com.example.demo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nhan_vien")
public class NHANVIEN {
    @Id
    @Length(min = 0,max = 3)
    @NotNull
    private String Ma_nv;

    @Length(min = 0,max = 100)
    @NotNull
    private String ten_nv;

    @Length(min = 0,max = 3)
    private String phai;

    @Length(min = 0,max = 200)
    private String noi_sinh;


    @ManyToOne
    @JoinColumn(name = "ma_phong" )
    private PHONGBAN phongban;

    private int luong;




}
