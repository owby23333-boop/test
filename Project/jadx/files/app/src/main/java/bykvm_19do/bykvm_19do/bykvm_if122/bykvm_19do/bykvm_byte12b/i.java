package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class i extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f1410g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f1411h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f1412i;

    public i(String str, String str2, String str3, String str4, int i2, String str5, String str6) {
        super(str, str2, str3, str4, i2);
        this.f1412i = 0L;
        this.f1410g = 0L;
        try {
            this.f1410g = Long.parseLong(str5);
        } catch (Exception unused) {
        }
        this.f1411h = str6;
    }

    public i(String str, String str2, String str3, String str4, int i2, String str5, String str6, String str7) {
        this(str, str2, str3, str4, i2, str5, str6);
        this.f1412i = 0L;
        try {
            this.f1412i = Long.parseLong(str7);
        } catch (Exception unused) {
        }
    }

    public void a(long j2) {
        this.f1412i = j2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.d
    public boolean a() {
        return (TextUtils.isEmpty(this.f1411h) || this.f1410g == 0) ? false : true;
    }

    public long i() {
        return this.f1410g;
    }

    public String j() {
        return this.f1411h;
    }

    public long k() {
        return this.f1412i;
    }

    public boolean l() {
        return this.f1412i != 0;
    }

    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.a + "', showRulesVersion='" + this.f1399c + "', timingMode=" + this.f1401e + "}IntervalPacingBean{pacing=" + this.f1410g + ", pacingRuleId='" + this.f1411h + "', effectiveTime=" + this.f1412i + '}';
    }
}
