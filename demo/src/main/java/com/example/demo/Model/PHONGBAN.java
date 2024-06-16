package com.example.demo.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phong_ban")
public class PHONGBAN {
    @Id
    @Length(min = 0,max = 2)
    @NotNull
    private String ma_phong;

    @Length(min = 0,max = 30)
    @NotNull
    private String ten_phong;

//    @OneToMany(mappedBy = "phongban")
//    private List<NHANVIEN> nhanviens;
}
