package com.itmayiedu.entity;

public class Gifts {
    private Integer giftsid;

    private Integer proid;

    private String giftsname;

    public Integer getGiftsid() {
        return giftsid;
    }

    public void setGiftsid(Integer giftsid) {
        this.giftsid = giftsid;
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public String getGiftsname() {
        return giftsname;
    }

    public void setGiftsname(String giftsname) {
        this.giftsname = giftsname == null ? null : giftsname.trim();
    }
}