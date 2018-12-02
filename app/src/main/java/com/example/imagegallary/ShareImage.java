package com.example.imagegallary;

/**
 * Created by Dell-pc on 11/7/2018.
 */

public class ShareImage {
    private String produtName;
    private String productPrice;
    private String productDetails;
    private int thumbname;

    public ShareImage() {
    }

    public ShareImage(String produtName,String productDetails, String productPrice, int thumbname) {
        this.produtName = produtName;
        this.productPrice = productPrice;
        this.productDetails = productDetails;
        this.thumbname = thumbname;
    }


    public void setTitle(String produtName) {
        this.produtName = produtName;
    }
    public int getThumbname() {
        return thumbname;
    }
    public void setThumbname(int thumbname) {
        this.thumbname = thumbname;
    }
    public String getProdutName() {
        return produtName;
    }
    public String getProductPrice() {
        return productPrice;
    }
    public String getProductDetails() {
        return productDetails;
    }


}
