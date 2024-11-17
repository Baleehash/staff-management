package com.example.staff_management.controller;

import com.example.staff_management.model.Staff;
import com.example.staff_management.service.StaffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping("/create")
    public Staff createStaff(@RequestBody Staff staff) {
        return staffService.createStaff(staff);
    }

    @PutMapping("/edit/{id}")
    public Staff editStaff(@PathVariable Long id, @RequestBody Staff staffDetails) {
        return staffService.updateStaff(id, staffDetails);
    }

    @PostMapping("/absensi")
    public Staff addAbsensi(@RequestBody Map<String, Long> request) {
        return staffService.addAbsensi(request.get("id"));
    }

    @PostMapping("/hitung")
    public Map<String, Object> calculate(@RequestBody Map<String, String> request) {
        return staffService.calculate(request.get("menu"));
    }

    @GetMapping("/laporan")
    public List<Staff> getLaporan() {
        return staffService.getAllStaff();
    }
}
