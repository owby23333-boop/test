package com.bytedance.adsdk.lottie.z.z;

import android.graphics.Path;
import com.bytedance.adsdk.lottie.z.g.z;

/* JADX INFO: loaded from: classes2.dex */
public class fv implements z.InterfaceC0041z, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.gz f208a;
    private final boolean dl;
    private final String g;
    private final com.bytedance.adsdk.lottie.z.g.i gc;
    private boolean m;
    private final Path z = new Path();
    private final g e = new g();

    public fv(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar, com.bytedance.adsdk.lottie.model.g.p pVar) {
        this.g = pVar.z();
        this.dl = pVar.dl();
        this.f208a = gzVar;
        com.bytedance.adsdk.lottie.z.g.i iVarZ = pVar.g().z();
        this.gc = iVarZ;
        dlVar.z(iVarZ);
        iVarZ.z(this);
    }

    @Override // com.bytedance.adsdk.lottie.z.g.z.InterfaceC0041z
    public void z() {
        g();
    }

    private void g() {
        this.m = false;
        this.f208a.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    @Override // com.bytedance.adsdk.lottie.z.z.dl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void z(java.util.List<com.bytedance.adsdk.lottie.z.z.dl> r6, java.util.List<com.bytedance.adsdk.lottie.z.z.dl> r7) {
        /*
            r5 = this;
            r7 = 0
            r0 = 0
        L2:
            int r1 = r6.size()
            if (r0 >= r1) goto L39
            java.lang.Object r1 = r6.get(r0)
            com.bytedance.adsdk.lottie.z.z.dl r1 = (com.bytedance.adsdk.lottie.z.z.dl) r1
            boolean r2 = r1 instanceof com.bytedance.adsdk.lottie.z.z.q
            if (r2 == 0) goto L26
            r2 = r1
            com.bytedance.adsdk.lottie.z.z.q r2 = (com.bytedance.adsdk.lottie.z.z.q) r2
            com.bytedance.adsdk.lottie.model.g.js$z r3 = r2.getType()
            com.bytedance.adsdk.lottie.model.g.js$z r4 = com.bytedance.adsdk.lottie.model.g.js.z.SIMULTANEOUSLY
            if (r3 != r4) goto L26
            com.bytedance.adsdk.lottie.z.z.g r1 = r5.e
            r1.z(r2)
            r2.z(r5)
            goto L36
        L26:
            boolean r2 = r1 instanceof com.bytedance.adsdk.lottie.z.z.js
            if (r2 == 0) goto L36
            if (r7 != 0) goto L31
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L31:
            com.bytedance.adsdk.lottie.z.z.js r1 = (com.bytedance.adsdk.lottie.z.z.js) r1
            r7.add(r1)
        L36:
            int r0 = r0 + 1
            goto L2
        L39:
            com.bytedance.adsdk.lottie.z.g.i r6 = r5.gc
            r6.z(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.z.z.fv.z(java.util.List, java.util.List):void");
    }

    @Override // com.bytedance.adsdk.lottie.z.z.i
    public Path a() {
        if (this.m) {
            return this.z;
        }
        this.z.reset();
        if (this.dl) {
            this.m = true;
            return this.z;
        }
        Path pathE = this.gc.e();
        if (pathE == null) {
            return this.z;
        }
        this.z.set(pathE);
        this.z.setFillType(Path.FillType.EVEN_ODD);
        this.e.z(this.z);
        this.m = true;
        return this.z;
    }
}
