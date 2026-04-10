package com.bytedance.sdk.component.gz.z;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class z implements gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f752a;
    private String dl;
    private com.bytedance.sdk.component.gz.g.a.g.z e;
    private com.bytedance.sdk.component.gz.g.a.g.z fo;
    private kb g;
    private com.bytedance.sdk.component.gz.g.a.g.z gc;
    private com.bytedance.sdk.component.gz.g.a.g.z gz;
    private int i;
    private a kb;
    private com.bytedance.sdk.component.gz.g.a.g.z m;
    private boolean uy;
    private int v;
    private AtomicBoolean wp;
    private m z;

    private z() {
        this.wp = new AtomicBoolean(false);
        this.i = 200;
        this.v = 10;
    }

    @Override // com.bytedance.sdk.component.gz.z.gc
    public com.bytedance.sdk.component.gz.g.a.g.z z() {
        return this.gz;
    }

    @Override // com.bytedance.sdk.component.gz.z.gc
    public Context getContext() {
        return this.f752a;
    }

    @Override // com.bytedance.sdk.component.gz.z.gc
    public m g() {
        return this.z;
    }

    @Override // com.bytedance.sdk.component.gz.z.gc
    public void z(m mVar) {
        this.z = mVar;
    }

    @Override // com.bytedance.sdk.component.gz.z.gc
    public void z(boolean z) {
        this.wp.set(z);
    }

    @Override // com.bytedance.sdk.component.gz.z.gc
    public boolean dl() {
        return this.wp.get();
    }

    @Override // com.bytedance.sdk.component.gz.z.gc
    public a a() {
        return this.kb;
    }

    @Override // com.bytedance.sdk.component.gz.z.gc
    public String gc() {
        return this.dl;
    }

    @Override // com.bytedance.sdk.component.gz.z.gc
    public com.bytedance.sdk.component.gz.g.a.g.z m() {
        return this.fo;
    }

    @Override // com.bytedance.sdk.component.gz.z.gc
    public com.bytedance.sdk.component.gz.g.a.g.z e() {
        return this.gc;
    }

    @Override // com.bytedance.sdk.component.gz.z.gc
    public com.bytedance.sdk.component.gz.g.a.g.z gz() {
        return this.m;
    }

    @Override // com.bytedance.sdk.component.gz.z.gc
    public com.bytedance.sdk.component.gz.g.a.g.z fo() {
        return this.e;
    }

    @Override // com.bytedance.sdk.component.gz.z.gc
    public kb uy() {
        return this.g;
    }

    @Override // com.bytedance.sdk.component.gz.z.gc
    public boolean kb() {
        return this.uy;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.gz.z.z$z, reason: collision with other inner class name */
    public static class C0136z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.bytedance.sdk.component.gz.g.a.g.z f753a;
        private com.bytedance.sdk.component.gz.g.a.g.z dl;
        private a e;
        private com.bytedance.sdk.component.gz.g.a.g.z g;
        private com.bytedance.sdk.component.gz.g.a.g.z gc;
        private m gz;
        private Context i;
        private boolean m;
        private String wp;
        private kb z;
        private final AtomicBoolean fo = new AtomicBoolean(false);
        private int uy = 5000;
        private int kb = 10;

        public C0136z z(Context context) {
            this.i = context;
            return this;
        }

        public C0136z z(String str) {
            this.wp = str;
            return this;
        }

        public C0136z z(boolean z) {
            this.fo.set(z);
            return this;
        }

        public C0136z z(m mVar) {
            this.gz = mVar;
            return this;
        }

        public C0136z z(a aVar) {
            this.e = aVar;
            return this;
        }

        public C0136z g(boolean z) {
            this.m = z;
            return this;
        }

        public C0136z z(com.bytedance.sdk.component.gz.g.a.g.z zVar) {
            this.g = zVar;
            return this;
        }

        public C0136z g(com.bytedance.sdk.component.gz.g.a.g.z zVar) {
            this.dl = zVar;
            return this;
        }

        public C0136z dl(com.bytedance.sdk.component.gz.g.a.g.z zVar) {
            this.f753a = zVar;
            return this;
        }

        public C0136z z(kb kbVar) {
            this.z = kbVar;
            return this;
        }

        public z z() {
            z zVar = new z();
            zVar.g = this.z;
            zVar.gc = this.g;
            zVar.m = this.dl;
            zVar.e = this.f753a;
            zVar.gz = this.gc;
            zVar.uy = this.m;
            zVar.kb = this.e;
            zVar.z = this.gz;
            zVar.wp = this.fo;
            zVar.dl = this.wp;
            zVar.f752a = this.i;
            zVar.v = this.kb;
            zVar.i = this.uy;
            return zVar;
        }
    }
}
