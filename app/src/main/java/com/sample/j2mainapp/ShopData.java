package com.sample.j2mainapp;

public class ShopData {
    private String area;
    private String detail;
    private String tel;
    private String id;
    private String storeName;
    public ShopData(String area, String detail, String tel, String id, String storeName){
        this.area=area;
        this.detail=detail;
        this.tel=tel;
        this.id=id;
        this.storeName=storeName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }


    public ShopData(String id , String storeName){
        this.id=id;
        this.storeName=storeName;
    }
    public ShopData(){
    }
    public String toString(){
        return id + ":" + storeName;
    }
    //1:○○パン屋
}
