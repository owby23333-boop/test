package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122;

import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.base.TTBaseAd;

/* JADX INFO: loaded from: classes.dex */
public class e implements Comparable<e> {
    public TTBaseAd a;
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f1551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1552d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AdSlot f1553e;

    public e(TTBaseAd tTBaseAd, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar, long j2, AdSlot adSlot) {
        this.a = tTBaseAd;
        this.b = dVar;
        this.f1551c = j2;
        this.f1553e = adSlot;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(e eVar) {
        return this.a.compareTo(eVar.a);
    }

    public AdSlot a() {
        return this.f1553e;
    }

    public void a(boolean z2) {
        this.f1552d = z2;
    }

    public long b() {
        return this.f1551c;
    }

    public boolean c() {
        return this.f1552d;
    }
}
