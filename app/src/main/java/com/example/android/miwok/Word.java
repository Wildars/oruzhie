package com.example.android.miwok;

public class Word {

    private String defaultTranslation;
    private String miwokTranslation;
    private int imageResourceId;
    private String  showAddress;
    private String number;
    private int someInfo;



    public Word(String defaultTranslation, String miwokTranslation,int imageResourceId,String  showAddress,int someInfo, String number ) {
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.imageResourceId=imageResourceId;
        this.showAddress=showAddress;
        this.someInfo= someInfo;
        this.number=number;

    }
    public Word(String defaultTranslation, String miwokTranslation,int imageResourceId,String showAddress,int someInfo ) {
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.imageResourceId=imageResourceId;
        this.showAddress=showAddress;
        this.someInfo= someInfo;


    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }
    public String getMiwokTranslation() {
        return miwokTranslation;
    }
    public int getImageResourceId(){return imageResourceId;}
    public String getShowAddress(){return showAddress;}
    public int getSomeInfo(){ return someInfo;}
    public String getNumber() {
        return number;
    }



}

