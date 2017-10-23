package com.itmayiedu.entity;

import java.util.List;

public class Gifts {
    private Integer giftsid;

    private Integer proid;

    private String giftsname;

    private List<Product> productList;
    
    public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

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