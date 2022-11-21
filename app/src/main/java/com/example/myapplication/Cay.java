package com.example.myapplication;

public class Cay {
    String tencay,dactinh,hinhanh;

    public Cay() {
    }

    public String getTencay() {
        return tencay;
    }

    public void setTencay(String tencay) {
        this.tencay = tencay;
    }

    public String getDactinh() {
        return dactinh;
    }

    public void setDactinh(String dactinh) {
        this.dactinh = dactinh;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public Cay(String tencay, String dactinh, String hinhanh) {
        this.tencay = tencay;
        this.dactinh = dactinh;
        this.hinhanh = hinhanh;
    }
}
