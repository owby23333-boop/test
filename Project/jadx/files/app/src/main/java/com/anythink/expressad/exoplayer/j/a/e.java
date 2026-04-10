package com.anythink.expressad.exoplayer.j.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class e implements Comparable<e> {
    public final String a;
    public final long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f9618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f9619d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final File f9620e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f9621f;

    private e(String str, long j2, long j3) {
        this(str, j2, j3, com.anythink.expressad.exoplayer.b.b, null);
    }

    public final boolean a() {
        return this.f9618c == -1;
    }

    public final boolean b() {
        return !this.f9619d;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(@NonNull e eVar) {
        e eVar2 = eVar;
        if (!this.a.equals(eVar2.a)) {
            return this.a.compareTo(eVar2.a);
        }
        long j2 = this.b - eVar2.b;
        if (j2 == 0) {
            return 0;
        }
        return j2 < 0 ? -1 : 1;
    }

    public e(String str, long j2, long j3, long j4, @Nullable File file) {
        this.a = str;
        this.b = j2;
        this.f9618c = j3;
        this.f9619d = file != null;
        this.f9620e = file;
        this.f9621f = j4;
    }

    private int a(@NonNull e eVar) {
        if (!this.a.equals(eVar.a)) {
            return this.a.compareTo(eVar.a);
        }
        long j2 = this.b - eVar.b;
        if (j2 == 0) {
            return 0;
        }
        return j2 < 0 ? -1 : 1;
    }
}
