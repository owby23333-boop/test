package com.amgcyo.cuttadon.api.entity.bookcity;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RankIndexLeft implements Serializable {
    private List<BaseMaleFemaleBean> comics;
    private List<BaseMaleFemaleBean> female;
    private List<BaseMaleFemaleBean> male;

    public List<BaseMaleFemaleBean> getComics() {
        return this.comics;
    }

    public List<BaseMaleFemaleBean> getFemale() {
        return this.female;
    }

    public List<BaseMaleFemaleBean> getMale() {
        return this.male;
    }

    public void setComics(List<BaseMaleFemaleBean> list) {
        this.comics = list;
    }

    public void setFemale(List<BaseMaleFemaleBean> list) {
        this.female = list;
    }

    public void setMale(List<BaseMaleFemaleBean> list) {
        this.male = list;
    }
}
