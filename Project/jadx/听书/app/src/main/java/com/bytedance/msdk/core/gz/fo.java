package com.bytedance.msdk.core.gz;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class fo extends a {
    private String e;
    private long gz;
    private long m;

    public fo(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        super(str, str2, str3, str4, i);
        this.gz = 0L;
        this.m = 0L;
        try {
            this.m = Long.parseLong(str5);
        } catch (Exception unused) {
        }
        this.e = str6;
    }

    public fo(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7) {
        this(str, str2, str3, str4, i, str5, str6);
        this.gz = 0L;
        try {
            this.gz = Long.parseLong(str7);
        } catch (Exception unused) {
        }
    }

    public void z(long j) {
        this.gz = j;
    }

    public long fo() {
        return this.m;
    }

    public String uy() {
        return this.e;
    }

    public long kb() {
        return this.gz;
    }

    public boolean wp() {
        return this.gz != 0;
    }

    @Override // com.bytedance.msdk.core.gz.a
    public boolean gz() {
        return (TextUtils.isEmpty(this.e) || this.m == 0) ? false : true;
    }

    @Override // com.bytedance.msdk.core.gz.a
    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.z + "', showRulesVersion='" + this.dl + "', timingMode=" + this.gc + "}IntervalPacingBean{pacing=" + this.m + ", pacingRuleId='" + this.e + "', effectiveTime=" + this.gz + '}';
    }
}
