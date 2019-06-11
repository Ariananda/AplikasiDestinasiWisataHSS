package com.example.aplikasidestinasiwisata.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Destination implements Parcelable {
    private String name,location,photo,article,time,fasiltas, address,url;

    public Destination() {
    }

    protected Destination(Parcel in) {
        name = in.readString();
        location = in.readString();
        photo = in.readString();
        article = in.readString();
        time = in.readString();
        fasiltas = in.readString();
        address = in.readString();
        url = in.readString();
    }

    public static final Creator<Destination> CREATOR = new Creator<Destination>() {
        @Override
        public Destination createFromParcel(Parcel in) {
            return new Destination(in);
        }

        @Override
        public Destination[] newArray(int size) {
            return new Destination[size];
        }
    };

    public String getFasiltas() {
        return fasiltas;
    }

    public void setFasiltas(String fasiltas) {
        this.fasiltas = fasiltas;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(this.name);
        dest.writeString(this.location);
        dest.writeString(this.photo);
        dest.writeString(this.article);
        dest.writeString(this.time);
        dest.writeString(this.fasiltas);
        dest.writeString(this.address);
        dest.writeString(this.url);
    }
}
