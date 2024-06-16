package com.example.demo.Controller;

import com.example.demo.Model.NHANVIEN;
import com.example.demo.Model.PHONGBAN;
import com.example.demo.Service.NhanvienService;
import com.example.demo.Service.PhongbanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nhanvien")
public class NhanvienController {

    @Autowired
    private NhanvienService nhanvienService;

    @Autowired
    private PhongbanService phongbanService;

    @GetMapping
    public String shownhanvien(Model model) {
        model.addAttribute("nhan_vien", nhanvienService.getallnhanvien());
        return "/nhanvien/nhanvien-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("NHANVIEN", new NHANVIEN());
        model.addAttribute("phong_ban", phongbanService.getallphongban());
        return "nhanvien/add-nhanvien";
    }

    @PostMapping("/add")
    public String addNhanvien(@Valid NHANVIEN nhanvien, BindingResult result) {
        if (result.hasErrors()) {
            return "/nhanvien/add-nhanvien";
        }
        nhanvienService.savenhanvien(nhanvien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/edit/{id}")
    public String showEditFormnhanvien(@PathVariable String id, Model model) {
        NHANVIEN nhanvien = nhanvienService.getnhanvienbyid(id);
        model.addAttribute("NHANVIEN", nhanvien);
        model.addAttribute("phong_ban", phongbanService.getallphongban());
        return "/nhanvien/update-nhanvien";
    }

    @PostMapping("/update/{id}")
    public String updatenhanvien(@PathVariable String id, @Valid NHANVIEN nhanvien, BindingResult result) {
        if (result.hasErrors()) {
            nhanvien.setMa_nv(id);
            return "/nhanvien/update-nhanvien";
        }
        nhanvienService.updatenhanvien(nhanvien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/delete/{id}")
    public String deletenhanvien(@PathVariable String id){
        nhanvienService.deletenhanvienById(id);
        return "redirect:/nhanvien";
    }
}
