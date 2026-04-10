package com.anythink.expressad.exoplayer;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.w;
import com.anythink.expressad.exoplayer.x;

/* JADX INFO: loaded from: classes2.dex */
public interface h extends w {

    @Deprecated
    public static final int a = 1;

    @Deprecated
    public static final int b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public static final int f9156c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public static final int f9157d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public static final int f9158e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public static final int f9159f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Deprecated
    public static final int f9160g = 2;

    @Deprecated
    public interface a extends w.c {
    }

    @Deprecated
    public interface b extends x.b {
    }

    @Deprecated
    public static final class c {
        public final x.b a;
        public final int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f9161c;

        @Deprecated
        private c(x.b bVar, int i2, Object obj) {
            this.a = bVar;
            this.b = i2;
            this.f9161c = obj;
        }
    }

    Looper a();

    x a(x.b bVar);

    void a(@Nullable ac acVar);

    void a(com.anythink.expressad.exoplayer.h.s sVar);

    void a(com.anythink.expressad.exoplayer.h.s sVar, boolean z2, boolean z3);

    @Deprecated
    void a(c... cVarArr);

    @Deprecated
    void b(c... cVarArr);
}
