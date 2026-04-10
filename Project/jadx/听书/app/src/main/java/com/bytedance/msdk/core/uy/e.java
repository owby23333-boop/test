package com.bytedance.msdk.core.uy;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private gz f406a;
    private String dl;
    private List<gz> e;
    private double fo;
    private String g;
    private z gc;
    private JSONObject gz;
    private double kb;
    private List<m> m;
    private int uy;
    private String z;

    public double z() {
        return this.fo;
    }

    public void z(String str) {
        try {
            this.fo = Double.valueOf(str).doubleValue();
        } catch (Throwable unused) {
        }
    }

    public int g() {
        return this.uy;
    }

    public void z(int i) {
        this.uy = i;
    }

    public double dl() {
        return this.kb;
    }

    public void g(String str) {
        try {
            this.kb = Double.valueOf(str).doubleValue();
        } catch (Throwable unused) {
        }
    }

    public List<gz> a() {
        return this.e;
    }

    public void z(List<gz> list) {
        this.e = list;
    }

    public List<m> gc() {
        return this.m;
    }

    public void g(List<m> list) {
        this.m = list;
    }

    public void dl(String str) {
        this.z = str;
    }

    public void a(String str) {
        this.g = str;
    }

    public String m() {
        return this.dl;
    }

    public void gc(String str) {
        this.dl = str;
    }

    public void z(gz gzVar) {
        this.f406a = gzVar;
    }

    public void z(z zVar) {
        this.gc = zVar;
    }

    public void z(JSONObject jSONObject) {
        this.gz = jSONObject;
    }

    public JSONObject e() {
        return this.gz;
    }

    public boolean gz() {
        z zVar = this.gc;
        return (zVar == null || TextUtils.isEmpty(zVar.z)) ? false : true;
    }

    public List<uy> fo() {
        z zVar = this.gc;
        if (zVar == null) {
            return null;
        }
        return zVar.g;
    }

    public static class z {
        private List<uy> g = new ArrayList();
        private String z;

        public void z(String str) {
            this.z = str;
        }

        public void z(List<uy> list) {
            this.g = list;
        }
    }
}
