package com.sample.j2mainapp;

public class ShopData {
    private String area;
    private String etc;
    private String id;
    private String sales;
    private String storeName;
    public ShopData(String area , String etc, String id, String sales, String storeName){
        this.area=area;
        this.etc=etc;
        this.id=id;
        this.sales=sales;
        this.storeName=storeName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
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
