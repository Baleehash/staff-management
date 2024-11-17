package com.example.staff_management.service;

import com.example.staff_management.model.Staff;
import com.example.staff_management.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public Staff createStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public Staff updateStaff(Long id, Staff staffDetails) {
        Staff staff = staffRepository.findById(id).orElseThrow(() -> new RuntimeException("Staff not found"));
        staff.setNama(staffDetails.getNama());
        staff.setGajiPokok(staffDetails.getGajiPokok());
        return staffRepository.save(staff);
    }

    public Staff addAbsensi(Long id) {
        Staff staff = staffRepository.findById(id).orElseThrow(() -> new RuntimeException("Staff not found"));
        staff.setAbsensiHari(staff.getAbsensiHari() + 1);
        return staffRepository.save(staff);
    }

    public Map<String, Object> calculate(String menu) {
        Map<String, Object> result = new HashMap<>();
        List<Staff> staffList = getAllStaff();

        if ("tunjangan".equalsIgnoreCase(menu)) {
            int totalTunjangan = staffList.stream().mapToInt(staff ->
                    staff.getAbsensiHari() * 20000).sum();
            result.put("totalTunjangan", totalTunjangan);
        } else if ("totalgaji".equalsIgnoreCase(menu)) {
            int totalGaji = staffList.stream().mapToInt(staff ->
                    staff.getGajiPokok() + (staff.getAbsensiHari() * 20000)).sum();
            result.put("totalGaji", totalGaji);
        }

        return result;
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }
}
