package com.lq.liequ.common.vo;


import java.util.List;

public class MenuVo {
    private Integer mid;

    private Integer mparentid;

    private String mname;

    private String imgurl;

    private Integer level;

    private List<MenuVo> childenMenu;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

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
        this.mname = mname;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public List<MenuVo> getChildenMenu() {
        return childenMenu;
    }

    public void setChildenMenu(List<MenuVo> childenMenu) {
        this.childenMenu = childenMenu;
    }
}
