package com.bykv.vk.openvk.component.video.api.d;

import android.text.TextUtils;
import com.yuewen.w51;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private String bf;
    private String e;
    private long d = -2147483648L;
    private int tg = Integer.MIN_VALUE;
    private long ga = -2147483648L;
    private double vn = -2.147483648E9d;
    private double p = -2.147483648E9d;

    public String bf() {
        return this.e;
    }

    public long d() {
        return this.d;
    }

    public JSONObject e() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.bf)) {
                jSONObject.putOpt("audio_url", this.bf);
            }
            if (!TextUtils.isEmpty(this.e)) {
                jSONObject.putOpt("file_hash", this.e);
            }
            long j = this.d;
            if (j > 0) {
                jSONObject.put("size", j);
            }
            int i = this.tg;
            if (i >= 0) {
                jSONObject.put("reward_audio_cached_type", i);
            }
            long j2 = this.ga;
            if (j2 >= 0) {
                jSONObject.put("audio_preload_size", j2);
            }
            double d = this.vn;
            if (d > w51.l) {
                jSONObject.put("audio_duration", d);
            }
            double d2 = this.p;
            if (d2 > w51.l) {
                jSONObject.put("start", d2);
            }
            return jSONObject;
        } catch (Exception e) {
            com.bykv.vk.openvk.component.video.api.vn.d.e(e.getMessage());
            return null;
        }
    }

    public double ga() {
        return this.vn;
    }

    public String tg() {
        return this.bf;
    }

    public void bf(long j) {
        this.ga = j;
    }

    public void bf(String str) {
        this.bf = str;
    }

    public void e(String str) {
        this.e = str;
    }

    public void e(long j) {
        this.d = j;
    }

    public void e(int i) {
        this.tg = i;
    }

    public void e(double d) {
        this.vn = d;
    }
}
