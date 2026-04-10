package com.bytedance.adsdk.ugeno.z;

import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f269a;
    private int dl;
    private String e;
    private int fo = 1;
    private long g;
    private long gc;
    private String gz;
    private z m;
    private JSONObject uy;
    private Map<String, TreeMap<Float, String>> z;

    public static class z {
        public String g;
        public String z;
    }

    public JSONObject z() {
        return this.uy;
    }

    public void z(JSONObject jSONObject) {
        this.uy = jSONObject;
    }

    public Map<String, TreeMap<Float, String>> g() {
        return this.z;
    }

    public void z(Map<String, TreeMap<Float, String>> map) {
        this.z = map;
    }

    public long dl() {
        return this.g;
    }

    public void z(long j) {
        this.g = j;
    }

    public int a() {
        return this.dl;
    }

    public void z(int i) {
        this.dl = i;
    }

    public String gc() {
        return this.f269a;
    }

    public void z(String str) {
        this.f269a = str;
    }

    public long m() {
        return this.gc;
    }

    public void g(long j) {
        this.gc = j;
    }

    public z e() {
        return this.m;
    }

    public void z(z zVar) {
        this.m = zVar;
    }

    public String gz() {
        return this.e;
    }

    public void g(String str) {
        this.e = str;
    }

    public String fo() {
        return this.gz;
    }

    public void dl(String str) {
        this.gz = str;
    }

    public int uy() {
        return this.fo;
    }

    public void g(int i) {
        this.fo = i;
    }

    public String toString() {
        return "AnimationModel{mKeyFramesMap=" + this.z + ", mDuration=" + this.g + ", mPlayCount=" + this.dl + ", mPlayDirection=" + this.f269a + ", mDelay=" + this.gc + ", mName=" + this.gz + ", mPlayState=" + this.fo + ", mTransformOrigin='" + this.m + "', mTimingFunction='" + this.e + "'}";
    }
}
