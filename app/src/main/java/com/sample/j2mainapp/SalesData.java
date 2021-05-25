package com.sample.j2mainapp;

public class SalesData {
    private String sales;
    private String storeId;
    private String storeName;
    public SalesData(String sales, String storeId, String storeName){
        this.sales=sales;
        this.storeId=storeId;
        this.storeName=storeName;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }


    public SalesData(String storeId , String storeName){
        this.storeId=storeId;
        this.storeName=storeName;
    }
    public SalesData(){
    }
    public String toString(){
        return "店舗より:" + storeId + ":" + storeName + ":" + sales;
    }
    //1:○○パン屋
}
