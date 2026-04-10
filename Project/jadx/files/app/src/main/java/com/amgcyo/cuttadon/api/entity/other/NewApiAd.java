package com.amgcyo.cuttadon.api.entity.other;

import android.text.TextUtils;
import com.amgcyo.cuttadon.utils.otherutils.g;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class NewApiAd implements Serializable {
    private String author;
    private String desc;
    private String down_package;
    private String down_package_name;
    private int down_type;
    private String down_url;
    private int id;
    private String image;
    private String image_logo;
    private String image_video;
    private int is_close;
    private int is_video;
    private String location;
    private String name;
    private String ownerType;
    private int score;
    private int second;
    private String type;
    private int video_sound;
    private int video_type;

    public NewApiAd() {
    }

    public String getAuthor() {
        return this.author;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getDown_package() {
        return this.down_package;
    }

    public String getDown_package_name() {
        return this.down_package_name;
    }

    public int getDown_type() {
        return this.down_type;
    }

    public String getDown_url() {
        return this.down_url;
    }

    public int getId() {
        return this.id;
    }

    public String getImage() {
        return !TextUtils.isEmpty(this.image) ? (this.image.startsWith("http") || this.image.startsWith("https")) ? this.image : String.format("%s%s", g.E(), this.image) : this.image;
    }

    public String getImage_logo() {
        return this.image_logo;
    }

    public String getImage_video() {
        return this.image_video;
    }

    public int getIs_close() {
        return this.is_close;
    }

    public int getIs_video() {
        return this.is_video;
    }

    public String getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }

    public String getOwnerType() {
        return this.ownerType;
    }

    public int getScore() {
        return this.score;
    }

    public int getSecond() {
        if (this.second <= 0) {
            this.second = 3;
        }
        return this.second;
    }

    public String getType() {
        return this.type;
    }

    public int getVideo_sound() {
        return this.video_sound;
    }

    public int getVideo_type() {
        return this.video_type;
    }

    public void setAuthor(String str) {
        this.author = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDown_package(String str) {
        this.down_package = str;
    }

    public void setDown_package_name(String str) {
        this.down_package_name = str;
    }

    public void setDown_type(int i2) {
        this.down_type = i2;
    }

    public void setDown_url(String str) {
        this.down_url = str;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public void setImage_logo(String str) {
        this.image_logo = str;
    }

    public void setImage_video(String str) {
        this.image_video = str;
    }

    public void setIs_close(int i2) {
        this.is_close = i2;
    }

    public void setIs_video(int i2) {
        this.is_video = i2;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOwnerType(String str) {
        this.ownerType = str;
    }

    public void setScore(int i2) {
        this.score = i2;
    }

    public void setSecond(int i2) {
        this.second = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setVideo_sound(int i2) {
        this.video_sound = i2;
    }

    public void setVideo_type(int i2) {
        this.video_type = i2;
    }

    public String toString() {
        return "NewApiAd{desc='" + this.desc + "', down_package='" + this.down_package + "', down_package_name='" + this.down_package_name + "', down_type=" + this.down_type + ", down_url='" + this.down_url + "', id=" + this.id + ", image='" + this.image + "', is_video=" + this.is_video + ", name='" + this.name + "'}";
    }

    public NewApiAd(String str, String str2, String str3, int i2, String str4, int i3, String str5, int i4, String str6) {
        this.desc = str;
        this.down_package = str2;
        this.down_package_name = str3;
        this.down_type = i2;
        this.down_url = str4;
        this.id = i3;
        this.image = str5;
        this.is_video = i4;
        this.name = str6;
    }
}
