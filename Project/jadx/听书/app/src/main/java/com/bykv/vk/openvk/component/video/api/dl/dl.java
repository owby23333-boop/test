package com.bykv.vk.openvk.component.video.api.dl;

import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.umeng.analytics.pro.an;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f97a;
    private long dl;
    private String e;
    private String fo;
    private int g;
    private String gc;
    private String gz;
    private int i;
    private double kb;
    private String m;
    private String uy;
    private int wp;
    private int z;
    private float v = -1.0f;
    private int pf = 0;
    private int ls = 0;
    private int p = 0;
    private int fv = 0;
    private int js = 307200;
    private int tb = 1;

    public int z() {
        return this.wp;
    }

    public void z(int i) {
        this.wp = i;
    }

    public int g() {
        return this.z;
    }

    public void g(int i) {
        this.z = i;
    }

    public int dl() {
        return this.g;
    }

    public void dl(int i) {
        this.g = i;
    }

    public int a() {
        return this.i;
    }

    public long gc() {
        return this.dl;
    }

    public void z(long j) {
        this.dl = j;
    }

    public double m() {
        return this.f97a;
    }

    public void z(double d) {
        this.f97a = d;
    }

    public double e() {
        return this.kb;
    }

    public void g(double d) {
        this.kb = d;
    }

    public float gz() {
        return this.v;
    }

    public void z(float f) {
        this.v = f;
    }

    public String fo() {
        return this.gc;
    }

    public void z(String str) {
        this.gc = str;
    }

    public int[] uy() {
        try {
            int iIndexOf = this.gc.indexOf("x");
            return new int[]{Integer.parseInt(this.gc.substring(0, iIndexOf).trim()), Integer.parseInt(this.gc.substring(iIndexOf + 1).trim())};
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.dl.dl("VideoInfo", "getWidthAndHeight error", th);
            return null;
        }
    }

    public String kb() {
        return this.m;
    }

    public void g(String str) {
        this.m = str;
    }

    public String wp() {
        return this.e;
    }

    public void dl(String str) {
        this.e = str;
    }

    public String i() {
        return this.gz;
    }

    public void a(String str) {
        this.gz = str;
    }

    public String v() {
        return this.fo;
    }

    public String pf() {
        if (TextUtils.isEmpty(this.uy)) {
            this.uy = com.bykv.vk.openvk.component.video.api.m.g.z(this.e);
        }
        return this.uy;
    }

    public void gc(String str) {
        this.uy = str;
    }

    public int ls() {
        if (this.js < 0) {
            this.js = 307200;
        }
        long j = this.js;
        long j2 = this.dl;
        if (j > j2) {
            this.js = (int) j2;
        }
        return this.js;
    }

    public void a(int i) {
        this.js = i;
    }

    public int p() {
        return this.p;
    }

    public void gc(int i) {
        this.p = i;
    }

    public int fv() {
        return this.fv;
    }

    public void m(int i) {
        this.fv = i;
    }

    public JSONObject js() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cover_height", g());
            jSONObject.put("cover_url", kb());
            jSONObject.put("cover_width", dl());
            jSONObject.put("endcard", i());
            jSONObject.put("file_hash", pf());
            jSONObject.put(an.z, fo());
            jSONObject.put("size", gc());
            jSONObject.put("video_duration", m());
            jSONObject.put("video_url", wp());
            jSONObject.put("playable_download_url", v());
            jSONObject.put("if_playable_loading_show", tb());
            jSONObject.put("remove_loading_page_type", q());
            jSONObject.put("fallback_endcard_judge", z());
            jSONObject.put("video_preload_size", ls());
            jSONObject.put("reward_video_cached_type", p());
            jSONObject.put("execute_cached_type", fv());
            jSONObject.put("endcard_render", a());
            jSONObject.put("replay_time", io());
            jSONObject.put("play_speed_ratio", gz());
            if (e() > 0.0d) {
                jSONObject.put(TtmlNode.START, e());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public int tb() {
        return this.pf;
    }

    public int q() {
        return this.ls;
    }

    public boolean iq() {
        return this.fv == 1;
    }

    public boolean zw() {
        return this.p == 0;
    }

    public int io() {
        return this.tb;
    }
}
