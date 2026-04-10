package com.bykv.vk.openvk.component.video.api.dl;

import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private String g;
    private int gz;
    private String z;
    private long dl = -2147483648L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f98a = Integer.MIN_VALUE;
    private long gc = -2147483648L;
    private double m = -2.147483648E9d;
    private double e = -2.147483648E9d;

    public JSONObject z() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.g)) {
                jSONObject.putOpt("audio_url", this.g);
            }
            if (!TextUtils.isEmpty(this.z)) {
                jSONObject.putOpt("file_hash", this.z);
            }
            long j = this.dl;
            if (j > 0) {
                jSONObject.put("size", j);
            }
            int i = this.f98a;
            if (i >= 0) {
                jSONObject.put("reward_audio_cached_type", i);
            }
            long j2 = this.gc;
            if (j2 >= 0) {
                jSONObject.put("audio_preload_size", j2);
            }
            double d = this.m;
            if (d > 0.0d) {
                jSONObject.put("audio_duration", d);
            }
            double d2 = this.e;
            if (d2 > 0.0d) {
                jSONObject.put(TtmlNode.START, d2);
            }
            int i2 = this.gz;
            if (i2 > 0) {
                jSONObject.put("repeat_count", i2);
            }
            return jSONObject;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public String g() {
        return this.z;
    }

    public void z(String str) {
        this.z = str;
    }

    public long dl() {
        return this.dl;
    }

    public void z(long j) {
        this.dl = j;
    }

    public void z(int i) {
        this.f98a = i;
    }

    public double a() {
        return this.e;
    }

    public void z(double d) {
        this.e = d;
    }

    public void g(long j) {
        this.gc = j;
    }

    public String gc() {
        return this.g;
    }

    public void g(String str) {
        this.g = str;
    }

    public double m() {
        return this.m;
    }

    public void g(double d) {
        this.m = d;
    }

    public void g(int i) {
        if (i < 0) {
            i = 0;
        }
        this.gz = i;
    }

    public int e() {
        return this.gz;
    }
}
