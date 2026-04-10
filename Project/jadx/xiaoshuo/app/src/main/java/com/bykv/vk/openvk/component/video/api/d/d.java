package com.bykv.vk.openvk.component.video.api.d;

import android.text.TextUtils;
import com.market.sdk.utils.Constants;
import com.yuewen.w51;
import com.yuewen.yn3;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private int bf;
    private int bh;
    private long d;
    private int e;
    private String ga;
    private String m;
    private String p;
    private double tg;
    private String v;
    private String vn;
    private double wu;
    private int xu;
    private String zk;
    private float t = -1.0f;
    private int s = 0;
    private int w = 0;
    private int l = 0;
    private int f = 0;
    private int k = yn3.x;
    private int dt = 1;

    public int bf() {
        return this.e;
    }

    public String bh() {
        return this.v;
    }

    public boolean cv() {
        return this.l == 0;
    }

    public int d() {
        return this.bf;
    }

    public int dt() {
        return this.s;
    }

    public int e() {
        return this.xu;
    }

    public int f() {
        return this.f;
    }

    public long ga() {
        return this.d;
    }

    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cover_height", bf());
            jSONObject.put("cover_url", wu());
            jSONObject.put("cover_width", d());
            jSONObject.put("endcard", bh());
            jSONObject.put("file_hash", s());
            jSONObject.put(Constants.JSON_RESOLUTION, zk());
            jSONObject.put("size", ga());
            jSONObject.put("video_duration", vn());
            jSONObject.put("video_url", xu());
            jSONObject.put("playable_download_url", t());
            jSONObject.put("if_playable_loading_show", dt());
            jSONObject.put("remove_loading_page_type", pe());
            jSONObject.put("fallback_endcard_judge", e());
            jSONObject.put("video_preload_size", w());
            jSONObject.put("reward_video_cached_type", l());
            jSONObject.put("execute_cached_type", f());
            jSONObject.put("endcard_render", tg());
            jSONObject.put("replay_time", wl());
            jSONObject.put("play_speed_ratio", v());
            if (p() > w51.l) {
                jSONObject.put("start", p());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public int l() {
        return this.l;
    }

    public int[] m() {
        try {
            int iIndexOf = this.ga.indexOf("x");
            return new int[]{Integer.parseInt(this.ga.substring(0, iIndexOf).trim()), Integer.parseInt(this.ga.substring(iIndexOf + 1).trim())};
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.vn.d.d("VideoInfo", "getWidthAndHeight error", th);
            return null;
        }
    }

    public double p() {
        return this.wu;
    }

    public int pe() {
        return this.w;
    }

    public String s() {
        if (TextUtils.isEmpty(this.m)) {
            this.m = com.bykv.vk.openvk.component.video.api.vn.bf.e(this.p);
        }
        return this.m;
    }

    public String t() {
        return this.zk;
    }

    public int tg() {
        return this.bh;
    }

    public float v() {
        return this.t;
    }

    public double vn() {
        return this.tg;
    }

    public int w() {
        if (this.k < 0) {
            this.k = yn3.x;
        }
        long j = this.k;
        long j2 = this.d;
        if (j > j2) {
            this.k = (int) j2;
        }
        return this.k;
    }

    public int wl() {
        return this.dt;
    }

    public String wu() {
        return this.vn;
    }

    public String xu() {
        return this.p;
    }

    public boolean y() {
        return this.f == 1;
    }

    public String zk() {
        return this.ga;
    }

    public void bf(int i) {
        this.e = i;
    }

    public void d(int i) {
        this.bf = i;
    }

    public void e(int i) {
        this.xu = i;
    }

    public void ga(String str) {
        this.m = str;
    }

    public void tg(String str) {
        this.v = str;
    }

    public void vn(int i) {
        this.f = i;
    }

    public void bf(String str) {
        this.vn = str;
    }

    public void d(String str) {
        this.p = str;
    }

    public void e(long j) {
        this.d = j;
    }

    public void ga(int i) {
        this.l = i;
    }

    public void tg(int i) {
        this.k = i;
    }

    public void e(double d) {
        this.tg = d;
    }

    public void e(float f) {
        this.t = f;
    }

    public void e(String str) {
        this.ga = str;
    }
}
