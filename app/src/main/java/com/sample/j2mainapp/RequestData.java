package com.sample.j2mainapp;

public class RequestData {
    private String area;
    private String etc;
    private String deadline;
    private String about;
    private String requester;
    private String id;
    public RequestData(String area , String etc, String deadline , String about, String requester, String id){
        this.area=area;
        this.etc=etc;
        this.deadline=deadline;
        this.about=about;
        this.requester=requester;
        this.id=id;
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

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public RequestData(String id , String about, String name){
        this.id=id;
        this.requester=name;
        this.about=about;
    }
    public RequestData(){
    }
    public String toString(){
        return "依頼:" + id + ":" + requester + ":" + about ;
    }


}
