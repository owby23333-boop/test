package com.yuewen;

import android.text.TextUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class ob4 {
    public static final int m = 150;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f15243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15244b;
    public boolean c;
    public String d;
    public boolean e;
    public long f;
    public long g;
    public long h;
    public int i;
    public int j;
    public boolean k;
    public long l;

    public ob4() {
        this.f15243a = "";
        this.f15244b = 0;
        this.c = false;
        this.e = false;
        this.f = 0L;
        this.k = false;
    }

    public static String g(long j) {
        int iCeil = (int) Math.ceil(((j - System.currentTimeMillis()) * 1.0d) / 60000.0d);
        if (iCeil < 1) {
            iCeil = 1;
        }
        if (iCeil < 60) {
            return iCeil + "分钟";
        }
        int i = iCeil / 60;
        if (i >= 24) {
            return (i / 24) + "天";
        }
        return i + "小时" + (iCeil % 60) + "分钟";
    }

    public long a() {
        return this.l;
    }

    public String b() {
        return String.valueOf(new BigDecimal(((this.g + this.h) * 1000.0f) / 3600000.0f).setScale(1, RoundingMode.DOWN).floatValue());
    }

    public long c() {
        return ((this.g + this.h) * 1000) / 60000;
    }

    public String d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("user_id", this.f15243a);
            int i = 1;
            jSONObject.put("is_vip", this.c ? 1 : 0);
            jSONObject.put("vip_id", this.f15244b);
            if (!this.e) {
                i = 0;
            }
            jSONObject.put("continuous", i);
            jSONObject.put("vip_expire", this.f);
            jSONObject.put("read_time", this.g);
            jSONObject.put("exchange_time", this.h);
            jSONObject.put("desc", this.d);
            jSONObject.put("coin", this.i);
            jSONObject.put("coin_pending", this.j);
            jSONObject.put("is_show_vip_update", this.k);
            jSONObject.put("mini_vip_expire_time", this.l);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    public String e() {
        float fCurrentTimeMillis = ((this.f * 1000) - System.currentTimeMillis()) / 8.64E7f;
        if (fCurrentTimeMillis >= 1.0f) {
            return ((int) Math.floor(fCurrentTimeMillis)) + "天";
        }
        return ((int) Math.ceil(fCurrentTimeMillis * 24.0f)) + "小时";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ob4)) {
            return false;
        }
        ob4 ob4Var = (ob4) obj;
        return this.f15243a.equals(ob4Var.f15243a) && this.f15244b == ob4Var.f15244b && this.c == ob4Var.c && this.e == ob4Var.e && this.f == ob4Var.f && this.g == ob4Var.g && this.h == ob4Var.h && TextUtils.equals(this.d, ob4Var.d) && this.i == ob4Var.i && this.j == ob4Var.j && this.k == ob4Var.k && this.l == ob4Var.l;
    }

    public String f() {
        return g(this.f * 1000);
    }

    public ob4(JSONObject jSONObject) {
        this.f15243a = "";
        this.f15244b = 0;
        this.c = false;
        this.e = false;
        this.f = 0L;
        this.k = false;
        if (jSONObject != null) {
            this.f15243a = jSONObject.optString("user_id");
            this.c = jSONObject.optInt("is_vip") == 1;
            this.f15244b = jSONObject.optInt("vip_id");
            this.e = jSONObject.optInt("continuous") == 1;
            this.f = jSONObject.optLong("vip_expire");
            this.g = jSONObject.optLong("read_time");
            this.h = jSONObject.optLong("exchange_time");
            this.d = jSONObject.optString("desc");
            this.i = jSONObject.optInt("coin");
            this.j = jSONObject.optInt("coin_pending");
            this.k = jSONObject.optInt("is_show_vip_update") == 1;
            this.l = jSONObject.optLong("mini_vip_expire_time");
        }
    }
}
