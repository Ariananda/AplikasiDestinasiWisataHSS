package com.aria.aplikasidestinasiwisata.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Destination implements Parcelable {
    private String name, location, photo, article, time, facilities, address, mapUrl;

    public Destination(String name, String location, String photo, String article, String time, String facilities, String address, String mapUrl) {
        this.name = name;
        this.location = location;
        this.photo = photo;
        this.article = article;
        this.time = time;
        this.facilities = facilities;
        this.address = address;
        this.mapUrl = mapUrl;
    }

    protected Destination(Parcel in) {
        name = in.readString();
        location = in.readString();
        photo = in.readString();
        article = in.readString();
        time = in.readString();
        facilities = in.readString();
        address = in.readString();
        mapUrl = in.readString();
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

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
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

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
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
        dest.writeString(this.facilities);
        dest.writeString(this.address);
        dest.writeString(this.mapUrl);
    }
}
