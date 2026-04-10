package com.yuewen;

import com.duokan.reader.ui.store.data.cms.Fiction;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class pw0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("row")
    private int f16317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("column")
    private int f16318b;

    @SerializedName("title")
    private int c;

    @SerializedName("items")
    private List<Fiction> d;

    @SerializedName("count")
    private int e;

    @SerializedName("traceId")
    private String f;

    @SerializedName(so2.Tb)
    private boolean g;

    @SerializedName("result")
    private int h;

    @SerializedName("msg")
    private String i;

    public int a() {
        return this.f16318b;
    }

    public int b() {
        return this.e;
    }

    public List<Fiction> c() {
        return this.d;
    }

    public boolean d() {
        return this.g;
    }

    public String e() {
        return this.i;
    }

    public int f() {
        return this.h;
    }

    public int g() {
        return this.f16317a;
    }

    public int h() {
        return this.c;
    }

    public String i() {
        return this.f;
    }
}
