package com.anythink.expressad.exoplayer.h;

import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.h.s;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends f<Integer> {
    private static final int a = -1;
    private final s[] b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<s> f9447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final h f9448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.anythink.expressad.exoplayer.ae f9449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f9450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f9451g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private a f9452h;

    public static final class a extends IOException {
        public static final int a = 0;
        public final int b = 0;

        /* JADX INFO: renamed from: com.anythink.expressad.exoplayer.h.v$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes.dex */
        @Retention(RetentionPolicy.SOURCE)
        public @interface InterfaceC0196a {
        }
    }

    private v(s... sVarArr) {
        this(new j(), sVarArr);
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a(com.anythink.expressad.exoplayer.h hVar, boolean z2) {
        super.a(hVar, z2);
        for (int i2 = 0; i2 < this.b.length; i2++) {
            a(Integer.valueOf(i2), this.b[i2]);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.s
    public final void b() throws a {
        a aVar = this.f9452h;
        if (aVar != null) {
            throw aVar;
        }
        super.b();
    }

    private v(h hVar, s... sVarArr) {
        this.b = sVarArr;
        this.f9448d = hVar;
        this.f9447c = new ArrayList<>(Arrays.asList(sVarArr));
        this.f9451g = -1;
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final r a(s.a aVar, com.anythink.expressad.exoplayer.j.b bVar) {
        r[] rVarArr = new r[this.b.length];
        for (int i2 = 0; i2 < rVarArr.length; i2++) {
            rVarArr[i2] = this.b[i2].a(aVar, bVar);
        }
        return new u(this.f9448d, rVarArr);
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(r rVar) {
        u uVar = (u) rVar;
        int i2 = 0;
        while (true) {
            s[] sVarArr = this.b;
            if (i2 >= sVarArr.length) {
                return;
            }
            sVarArr[i2].a(uVar.a[i2]);
            i2++;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a() {
        super.a();
        this.f9449e = null;
        this.f9450f = null;
        this.f9451g = -1;
        this.f9452h = null;
        this.f9447c.clear();
        Collections.addAll(this.f9447c, this.b);
    }

    private void a(s sVar, com.anythink.expressad.exoplayer.ae aeVar, @Nullable Object obj) {
        if (this.f9452h == null) {
            if (this.f9451g == -1) {
                this.f9451g = aeVar.c();
            } else {
                a aVar = aeVar.c() != this.f9451g ? new a() : null;
                this.f9452h = aVar;
            }
            this.f9452h = aVar;
        }
        if (this.f9452h != null) {
            return;
        }
        this.f9447c.remove(sVar);
        if (sVar == this.b[0]) {
            this.f9449e = aeVar;
            this.f9450f = obj;
        }
        if (this.f9447c.isEmpty()) {
            a(this.f9449e, this.f9450f);
        }
    }

    private a a(com.anythink.expressad.exoplayer.ae aeVar) {
        if (this.f9451g == -1) {
            this.f9451g = aeVar.c();
            return null;
        }
        if (aeVar.c() != this.f9451g) {
            return new a();
        }
        return null;
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    protected final /* synthetic */ void a(Integer num, s sVar, com.anythink.expressad.exoplayer.ae aeVar, @Nullable Object obj) {
        if (this.f9452h == null) {
            if (this.f9451g == -1) {
                this.f9451g = aeVar.c();
            } else {
                a aVar = aeVar.c() != this.f9451g ? new a() : null;
                this.f9452h = aVar;
            }
            this.f9452h = aVar;
        }
        if (this.f9452h == null) {
            this.f9447c.remove(sVar);
            if (sVar == this.b[0]) {
                this.f9449e = aeVar;
                this.f9450f = obj;
            }
            if (this.f9447c.isEmpty()) {
                a(this.f9449e, this.f9450f);
            }
        }
    }
}
