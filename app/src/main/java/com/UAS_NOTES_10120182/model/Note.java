package com.UAS_NOTES_10120182.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {

    String title;
    String category;
    String desc;
    String date;

    public Note(){

    }
    public Note(String title, String category, String desc, String date){
        this.title = title;
        this.category = category;
        this.desc = desc;
        this.date = date;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(category);
        dest.writeString(desc);
        dest.writeString(date);
    }

    public static final Parcelable.Creator<Note> CREATOR = new Parcelable.Creator<Note>() {
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    private Note(Parcel in) {
        title = in.readString();
        category = in.readString();
        desc = in.readString();
        date = in.readString();
    }
}

/// 10120182, Daffa Surya Mahardhika, IF-5