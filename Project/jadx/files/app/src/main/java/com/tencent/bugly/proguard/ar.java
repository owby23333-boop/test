package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class ar implements Comparable<ar> {
    public long a = -1;
    public long b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f18563c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f18564d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f18565e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f18566f = 0;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(ar arVar) {
        ar arVar2 = arVar;
        if (arVar2 == null) {
            return 1;
        }
        long j2 = this.b - arVar2.b;
        if (j2 <= 0) {
            return j2 < 0 ? -1 : 0;
        }
        return 1;
    }
}
