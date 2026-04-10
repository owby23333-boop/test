package com.bytedance.adsdk.lottie;

import android.graphics.Bitmap;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class fo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f143a;
    private final String dl;
    private final String e;
    private final List<g> fo;
    private final int g;
    private final String gc;
    private final String gz;
    private final z i;
    private final int[][] kb;
    private final String m;
    private final String uy;
    private Bitmap v;
    private final JSONArray wp;
    private final int z;

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f144a;
        public String dl;
        public int e;
        public String fo;
        public int g;
        public String gc;
        public int gz;
        public int i;
        public z kb;
        public int m;
        public z uy;
        public int wp;
        public int z;

        public static class z {
            public String g;
            public int z;
        }
    }

    public static class z {
        public boolean g;
        public C0038z z = null;

        /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.fo$z$z, reason: collision with other inner class name */
        public static class C0038z {
            public float z = 5.0f;
        }
    }

    public fo(int i, int i2, String str, String str2, String str3, String str4, List<g> list, String str5, int[][] iArr, JSONArray jSONArray, String str6, String str7, z zVar) {
        this.z = i;
        this.g = i2;
        this.dl = str;
        this.f143a = str2;
        this.gc = str3;
        this.m = str4;
        this.e = str6;
        this.gz = str7;
        this.fo = list;
        this.uy = str5;
        this.kb = iArr;
        this.wp = jSONArray;
        this.i = zVar;
    }

    public int z() {
        return this.z;
    }

    public int g() {
        return this.g;
    }

    public List<g> dl() {
        return this.fo;
    }

    public String a() {
        return this.m;
    }

    public String gc() {
        return this.e;
    }

    public String m() {
        return this.gz;
    }

    public String e() {
        return this.uy;
    }

    public int[][] gz() {
        return this.kb;
    }

    public JSONArray fo() {
        return this.wp;
    }

    public z uy() {
        return this.i;
    }

    public String kb() {
        return this.dl;
    }

    public String wp() {
        return this.f143a;
    }

    public String i() {
        return this.gc;
    }

    public Bitmap v() {
        return this.v;
    }

    public void z(Bitmap bitmap) {
        this.v = bitmap;
    }
}
