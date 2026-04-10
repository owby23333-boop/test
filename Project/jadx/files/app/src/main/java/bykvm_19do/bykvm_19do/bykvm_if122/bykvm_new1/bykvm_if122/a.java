package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122;

import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.Logger;

/* JADX INFO: loaded from: classes.dex */
public class a implements b {
    private final String a = a.class.getSimpleName();
    private long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f1762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f1763d;

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.b
    public void c(String str) {
        this.f1763d = str;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.b
    public boolean h() {
        return TextUtils.isEmpty(this.f1763d);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.b
    public long i() {
        Logger.i(this.a, "getIfUseNewSdkinit = " + bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().o());
        long j2 = this.f1762c - this.b;
        Logger.i(this.a, "InitMethodDuration = " + j2);
        return j2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.b
    public void j() {
        this.f1762c = System.currentTimeMillis();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.b
    public long k() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.b;
        Logger.i(this.a, "SplashFillDuration = " + jCurrentTimeMillis);
        return jCurrentTimeMillis;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.b
    public long l() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.b;
        Logger.i(this.a, "SplashRequestDuration = " + jCurrentTimeMillis);
        return jCurrentTimeMillis;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.b
    public boolean m() {
        boolean zEquals = TextUtils.equals(this.f1763d, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a.f1669c);
        Logger.i(this.a, "canUploadInitDuration = " + zEquals + " 当sessionId = " + bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a.f1669c + " 存储的sessionId = " + this.f1763d);
        return !zEquals;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.b
    public void n() {
        this.b = System.currentTimeMillis();
    }
}
