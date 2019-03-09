package com.lq.liequ.pojo;

public class Menu {
    private Integer mid;

    private Integer mparentid;

    private String mname;

    private String imgurl;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getMparentid() {
        return mparentid;
    }

    public void setMparentid(Integer mparentid) {
        this.mparentid = mparentid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname == null ? null : mname.trim();
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }
}