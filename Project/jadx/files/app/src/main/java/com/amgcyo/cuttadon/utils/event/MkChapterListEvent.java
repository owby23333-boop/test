package com.amgcyo.cuttadon.utils.event;

import com.amgcyo.cuttadon.api.entity.other.MkCatalog;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MkChapterListEvent implements Serializable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f4377s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f4378t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ArrayList<MkCatalog> f4379u;

    public MkChapterListEvent(int i2, String str, ArrayList<MkCatalog> arrayList) {
        this.f4377s = i2;
        this.f4378t = str;
        this.f4379u = arrayList;
    }

    public int f() {
        return this.f4377s;
    }

    public ArrayList<MkCatalog> g() {
        return this.f4379u;
    }

    public String h() {
        return this.f4378t;
    }
}
