package com.bytedance.sdk.component.m.dl;

import android.content.Context;
import com.bytedance.sdk.component.m.fv;
import com.bytedance.sdk.component.m.hh;
import com.bytedance.sdk.component.m.js;
import com.bytedance.sdk.component.m.l;
import com.bytedance.sdk.component.m.sy;
import com.bytedance.sdk.component.m.x;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements js {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private hh f766a;
    private com.bytedance.sdk.component.m.gc dl;
    private sy e;
    private x fo;
    private ExecutorService g;
    private l gc;
    private com.bytedance.sdk.component.m.g gz;
    private com.bytedance.sdk.component.m.a m;
    private fv z;

    private gc(z zVar) {
        this.z = zVar.z;
        this.g = zVar.g;
        this.dl = zVar.dl;
        this.f766a = zVar.f767a;
        this.gc = zVar.gc;
        this.m = zVar.m;
        this.gz = zVar.gz;
        this.e = zVar.e;
        this.fo = zVar.fo;
    }

    @Override // com.bytedance.sdk.component.m.js
    public fv z() {
        return this.z;
    }

    @Override // com.bytedance.sdk.component.m.js
    public ExecutorService g() {
        return this.g;
    }

    @Override // com.bytedance.sdk.component.m.js
    public com.bytedance.sdk.component.m.gc a() {
        return this.dl;
    }

    @Override // com.bytedance.sdk.component.m.js
    public hh gc() {
        return this.f766a;
    }

    @Override // com.bytedance.sdk.component.m.js
    public l m() {
        return this.gc;
    }

    @Override // com.bytedance.sdk.component.m.js
    public com.bytedance.sdk.component.m.a e() {
        return this.m;
    }

    @Override // com.bytedance.sdk.component.m.js
    public sy gz() {
        return this.e;
    }

    @Override // com.bytedance.sdk.component.m.js
    public x dl() {
        return this.fo;
    }

    @Override // com.bytedance.sdk.component.m.js
    public com.bytedance.sdk.component.m.g fo() {
        return this.gz;
    }

    public static gc z(Context context) {
        return new z().z();
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private hh f767a;
        private com.bytedance.sdk.component.m.gc dl;
        private sy e;
        private x fo;
        private ExecutorService g;
        private l gc;
        private com.bytedance.sdk.component.m.g gz;
        private com.bytedance.sdk.component.m.a m;
        private fv z;

        public z z(com.bytedance.sdk.component.m.g gVar) {
            this.gz = gVar;
            return this;
        }

        public z z(ExecutorService executorService) {
            this.g = executorService;
            return this;
        }

        public z z(com.bytedance.sdk.component.m.gc gcVar) {
            this.dl = gcVar;
            return this;
        }

        public gc z() {
            return new gc(this);
        }
    }
}
