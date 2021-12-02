package com.trying.helloworld;

class Contact {
    private String id, name, course, photo, photo2, photo3, photo4;

    public Contact(String id, String name, String course, String photo, String photo2, String photo3, String photo4){
        this.id = id;
        this.name = name;
        this.course = course;
        this.photo = photo;
        this.photo2 = photo2;
        this.photo3 = photo3;
        this.photo4 = photo4;
    }


    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getCourse() {

        return course;
    }

    public void setCourse(String course){

        this.course = course;
    }

    public String getPhoto(){

        return photo;
    }

    public void setPhoto(String photo) {

        this.photo = photo;
    }
    public String getPhoto2() {

        return photo2;
    }

    public void setPhoto2(String photo2) {

        this.photo2 = photo2;
    }

    public String getPhoto3() {

        return photo3;
    }

    public void setPhoto3(String photo3) {

        this.photo3 = photo3;
    }

    public String getPhoto4() {

        return photo4;
    }

    public void setPhoto4(String photo4) {

        this.photo4 = photo4;
    }
}