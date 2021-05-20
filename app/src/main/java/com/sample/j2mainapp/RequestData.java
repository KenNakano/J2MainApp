package com.sample.j2mainapp;

public class RequestData {
    private String area;
    private String etc;
    private String deadline;
    private String about;
    private String name;
    public RequestData(String area , String etc, String deadline , String about, String name){
        this.area=area;
        this.etc=etc;
        this.deadline=deadline;
        this.about=about;
        this.name=name;
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

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public RequestData(String area , String about, String name){
        this.area=area;
        this.name=name;
        this.about=about;
    }
    public RequestData(){
    }
    public String toString(){
        return name + " : " + about ;
    }

}
