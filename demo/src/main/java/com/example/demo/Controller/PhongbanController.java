package com.example.demo.Controller;

import com.example.demo.Model.PHONGBAN;
import com.example.demo.Service.PhongbanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PhongbanController {
    @Autowired
    private PhongbanService phongbanService;

    @GetMapping("/phongban/add")
    public String showAddForm(Model model) {
        model.addAttribute("PHONGBAN", new PHONGBAN());
        return "phongban/add-phongban";
    }
    //thêm phòng ban mới
    @PostMapping("/phongban/add")
    public String addphongban(@Valid PHONGBAN phongban, BindingResult result) {
        if (result.hasErrors()) {
            return "phongban/add-phongban";
        }
        phongbanService.addphongban(phongban);
        return "redirect:/phongban";
    }


    // Hiển thị danh sách phòng ban
    @GetMapping("/phongban")
    public String listphongban(Model model) {
        List<PHONGBAN> phongbanList = phongbanService.getallphongban();
        model.addAttribute("phong_ban", phongbanList);
        return "/phongban/phongban-list";

    }

    //test
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}

