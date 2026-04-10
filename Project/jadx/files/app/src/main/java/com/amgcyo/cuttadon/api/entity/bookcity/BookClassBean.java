package com.amgcyo.cuttadon.api.entity.bookcity;

import com.amgcyo.cuttadon.api.entity.other.MkBookclassifyBean;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class BookClassBean implements Serializable {
    private ArrayList<BannerBean> banner;
    private ArrayList<MkBookclassifyBean> comics;
    private ArrayList<MkBookclassifyBean> female;
    private ArrayList<?> label;
    private ArrayList<MkBookclassifyBean> male;
    private ArrayList<?> publish;

    public ArrayList<BannerBean> getBanner() {
        return this.banner;
    }

    public ArrayList<MkBookclassifyBean> getComics() {
        return this.comics;
    }

    public ArrayList<MkBookclassifyBean> getFemale() {
        return this.female;
    }

    public ArrayList<?> getLabel() {
        return this.label;
    }

    public ArrayList<MkBookclassifyBean> getMale() {
        return this.male;
    }

    public ArrayList<?> getPublish() {
        return this.publish;
    }

    public void setBanner(ArrayList<BannerBean> arrayList) {
        this.banner = arrayList;
    }

    public void setComics(ArrayList<MkBookclassifyBean> arrayList) {
        this.comics = arrayList;
    }

    public void setFemale(ArrayList<MkBookclassifyBean> arrayList) {
        this.female = arrayList;
    }

    public void setLabel(ArrayList<?> arrayList) {
        this.label = arrayList;
    }

    public void setMale(ArrayList<MkBookclassifyBean> arrayList) {
        this.male = arrayList;
    }

    public void setPublish(ArrayList<?> arrayList) {
        this.publish = arrayList;
    }
}
