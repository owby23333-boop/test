package com.bytedance.sdk.component.dl.g;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
final class uf implements gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f645a;
    final sy dl;
    final com.bytedance.sdk.component.dl.g.z.dl.uy g;
    private ls gc;
    private boolean m;
    final zw z;

    private uf(zw zwVar, sy syVar, boolean z2) {
        this.z = zwVar;
        this.dl = syVar;
        this.f645a = z2;
        this.g = new com.bytedance.sdk.component.dl.g.z.dl.uy(zwVar, z2);
    }

    static uf z(zw zwVar, sy syVar, boolean z2) {
        uf ufVar = new uf(zwVar, syVar, z2);
        ufVar.gc = zwVar.io().z(ufVar);
        return ufVar;
    }

    @Override // com.bytedance.sdk.component.dl.g.gc
    public sy z() {
        return this.dl;
    }

    @Override // com.bytedance.sdk.component.dl.g.gc
    public h g() throws IOException {
        synchronized (this) {
            if (this.m) {
                throw new IllegalStateException("Already Executed");
            }
            this.m = true;
        }
        uy();
        try {
            try {
                if (this.dl.m != null) {
                    this.dl.m.z();
                }
                this.z.js().z(this);
                h hVarFo = fo();
                if (hVarFo == null) {
                    throw new IOException("Canceled");
                }
                if (hVarFo.dl != 0) {
                    return hVarFo;
                }
                throw new IOException(hVarFo.f629a);
            } catch (IOException e) {
                this.gc.z(this, e);
                return null;
            } catch (Exception e2) {
                this.gc.z(this, new IOException(e2));
                return null;
            }
        } finally {
            this.z.js().g(this);
        }
    }

    private void uy() {
        this.g.z(com.bytedance.sdk.component.dl.g.z.e.gc.g().z("response.body().close()"));
    }

    @Override // com.bytedance.sdk.component.dl.g.gc
    public void z(m mVar) {
        try {
            synchronized (this) {
                if (this.m) {
                    throw new IllegalStateException("Already Executed");
                }
                this.m = true;
            }
            uy();
            this.z.js().z(new z(mVar));
        } catch (Throwable th) {
            if (mVar != null) {
                mVar.z(this, new IOException(th.getMessage()));
            }
        }
    }

    @Override // com.bytedance.sdk.component.dl.g.gc
    public void dl() {
        this.g.z();
    }

    @Override // com.bytedance.sdk.component.dl.g.gc
    public boolean a() {
        return this.g.g();
    }

    @Override // com.bytedance.sdk.component.dl.g.gc
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public uf gc() {
        return z(this.z, this.dl, this.f645a);
    }

    final class z extends com.bytedance.sdk.component.dl.g.z.g {
        private final m dl;

        z(m mVar) {
            super("OkHttp %s", uf.this.gz());
            this.dl = mVar;
        }

        String z() {
            return uf.this.dl.z().e();
        }

        public void g() {
            if (uf.this.dl == null || uf.this.dl.m == null) {
                return;
            }
            uf.this.dl.m.kb();
        }

        @Override // com.bytedance.sdk.component.dl.g.z.g
        protected void dl() {
            boolean z = false;
            try {
                try {
                    try {
                        if (uf.this.dl != null && uf.this.dl.m != null) {
                            uf.this.dl.m.z();
                        }
                        h hVarFo = uf.this.fo();
                        try {
                            if (uf.this.g.g()) {
                                this.dl.z(uf.this, new IOException("Canceled"));
                            } else {
                                this.dl.z(uf.this, hVarFo);
                            }
                            if (hVarFo.dl == 0) {
                                throw new IOException(hVarFo.f629a);
                            }
                        } catch (IOException e) {
                            e = e;
                            z = true;
                            if (!z) {
                                uf.this.gc.z(uf.this, e);
                                this.dl.z(uf.this, e);
                            } else {
                                com.bytedance.sdk.component.dl.g.z.e.gc.g().z(4, "Callback failure for " + uf.this.e(), e);
                            }
                        }
                    } catch (Exception e2) {
                        uf.this.gc.z(uf.this, new IOException(e2));
                        this.dl.z(uf.this, new IOException(e2));
                    }
                } finally {
                    uf.this.z.js().g(this);
                }
            } catch (IOException e3) {
                e = e3;
            }
        }
    }

    String e() {
        return (a() ? "canceled " : "") + (this.f645a ? "web socket" : NotificationCompat.CATEGORY_CALL) + " to " + gz();
    }

    String gz() {
        return this.dl.z().i();
    }

    h fo() throws IOException {
        ArrayList arrayList = new ArrayList(this.z.iq());
        arrayList.add(this.g);
        arrayList.add(new com.bytedance.sdk.component.dl.g.z.dl.z(this.z.m()));
        arrayList.add(new com.bytedance.sdk.component.dl.g.z.z.z(this.z.e()));
        arrayList.add(new com.bytedance.sdk.component.dl.g.z.g.z(this.z));
        if (!this.f645a) {
            arrayList.addAll(this.z.zw());
        }
        arrayList.add(new com.bytedance.sdk.component.dl.g.z.dl.g(this.f645a));
        return new com.bytedance.sdk.component.dl.g.z.dl.e(arrayList, null, null, null, 0, this.dl, this, this.gc, this.z.z(), this.z.g(), this.z.dl()).z(this.dl);
    }
}
