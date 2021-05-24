package com.sample.j2mainapp;

public class SuggestData {
    private String area;
    private String etc;
    private String deadline;
    private String about;
    private String proposer;
    private String id;
    public SuggestData(String area , String etc, String deadline , String about, String proposer, String id){
        this.area=area;
        this.etc=etc;
        this.deadline=deadline;
        this.about=about;
        this.proposer=proposer;
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

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public SuggestData(String id , String about, String name){
        this.id=id;
        this.proposer=name;
        this.about=about;
    }
    public SuggestData(){
    }
    public String toString(){
        return id + ":" + proposer + ":" + about ;
    }
}
