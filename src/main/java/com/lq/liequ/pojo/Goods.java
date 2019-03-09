package com.lq.liequ.pojo;

public class Goods {
    private Integer gid;

    private String gname;

    private Double gprice;

    private String gimgurl;

    private String gaddress;

    private String gcomment;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public Double getGprice() {
        return gprice;
    }

    public void setGprice(Double gprice) {
        this.gprice = gprice;
    }

    public String getGimgurl() {
        return gimgurl;
    }

    public void setGimgurl(String gimgurl) {
        this.gimgurl = gimgurl == null ? null : gimgurl.trim();
    }

    public String getGaddress() {
        return gaddress;
    }

    public void setGaddress(String gaddress) {
        this.gaddress = gaddress == null ? null : gaddress.trim();
    }

    public String getGcomment() {
        return gcomment;
    }

    public void setGcomment(String gcomment) {
        this.gcomment = gcomment == null ? null : gcomment.trim();
    }
}