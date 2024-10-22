package com.example.cleanwashattempt2.model;

public class User {
    String id, nama, hp, cucian, tglmasuk, berat, harga, status;

    public User(String nama, String hp, String cucian, String tanggal, String berat, String harga, String status){
        this.nama = nama;
        this.hp = hp;
        this.cucian = cucian;
        this.tglmasuk = tanggal;
        this.berat = berat;
        this.harga = harga;
        this.status = status;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) { this.nama = nama; }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCucian() { return cucian; }

    public void setCucian(String cucian) { this.cucian = cucian; }

    public String getTanggal() { return tglmasuk; }

    public void setTanggal(String tanggal) { this.tglmasuk = tanggal; }

    public String getBerat() { return berat; }

    public void setBerat(String berat) { this.berat = berat; }

    public String getHarga() { return harga; }

    public void setHarga(String harga) { this.harga = harga; }
}
