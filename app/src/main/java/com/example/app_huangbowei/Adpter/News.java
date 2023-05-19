package com.example.app_huangbowei.Adpter;

public class News {
    private String biaoti;
    private  String neirong;
    private  int imgid;

    public News(String biaoti, String neirong, int imgid) {
        this.biaoti = biaoti;
        this.neirong = neirong;
        this.imgid = imgid;
    }

    public String getBiaoti() {
        return biaoti;
    }

    public String getNeirong() {
        return neirong;
    }



    public int getImgid() {
        return imgid;
    }

    public void setBiaoti(String biaoti) {
        this.biaoti = biaoti;
    }

    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }



    public void setImgid(int imgid) {
        this.imgid = imgid;
    }
}


