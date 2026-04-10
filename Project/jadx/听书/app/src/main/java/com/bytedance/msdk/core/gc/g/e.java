package com.bytedance.msdk.core.gc.g;

/* JADX INFO: loaded from: classes2.dex */
public class e implements Comparable<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.msdk.api.z.g f393a;
    private boolean dl = false;
    private long g;
    public com.bytedance.msdk.g.dl z;

    public e(com.bytedance.msdk.g.dl dlVar, long j, com.bytedance.msdk.api.z.g gVar) {
        this.z = dlVar;
        this.g = j;
        this.f393a = gVar;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public int compareTo(e eVar) {
        return this.z.compareTo(eVar.z);
    }

    public long z() {
        return this.g;
    }

    public String g() {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar == null) {
            return null;
        }
        return dlVar.yz();
    }

    public boolean dl() {
        return this.dl;
    }

    public void z(boolean z) {
        this.dl = z;
    }

    public com.bytedance.msdk.api.z.g a() {
        return this.f393a;
    }

    public boolean gc() {
        com.bytedance.msdk.g.dl dlVar = this.z;
        return (dlVar == null || this.f393a == null || dlVar.jq() || !this.z.un(this.f393a.zw())) ? false : true;
    }

    public String m() {
        com.bytedance.msdk.api.z.g gVar = this.f393a;
        if (gVar == null) {
            return null;
        }
        return gVar.zw();
    }

    public void g(boolean z) {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar == null) {
            return;
        }
        dlVar.z(z);
    }

    public boolean e() {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar == null) {
            return false;
        }
        return dlVar.iq();
    }
}
