package com.example.staff_management.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_karyawan")
    private Long idKaryawan;

    @JsonProperty("nama")
    private String nama;

    @JsonProperty("gapok")
    @Column(name = "gaji_pokok")
    private int gajiPokok;

    @JsonProperty("absensi")
    @Column(name = "absensi_hari")
    private int absensiHari;

    // Getters and Setters
    public Long getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(Long idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getGajiPokok() {
        return gajiPokok;
    }

    public void setGajiPokok(int gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    public int getAbsensiHari() {
        return absensiHari;
    }

    public void setAbsensiHari(int absensiHari) {
        this.absensiHari = absensiHari;
    }
}
