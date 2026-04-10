package com.bytedance.adsdk.ugeno.gc.dl;

import android.content.Context;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends g {
    private boolean i;
    private float kb;
    private float wp;

    public gc(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.gc.dl.g
    public boolean z(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        return z(this.g, (MotionEvent) objArr[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean z(com.bytedance.adsdk.ugeno.g.dl r7, android.view.MotionEvent r8) {
        /*
            r6 = this;
            int r0 = r8.getAction()
            r1 = 1
            if (r0 == 0) goto L7c
            r2 = 1097859072(0x41700000, float:15.0)
            r3 = 0
            if (r0 == r1) goto L38
            r4 = 2
            if (r0 == r4) goto L17
            r4 = 3
            if (r0 == r4) goto L14
            goto L88
        L14:
            r6.i = r3
            goto L38
        L17:
            float r7 = r8.getRawX()
            float r8 = r8.getRawY()
            float r0 = r6.kb
            float r7 = r7 - r0
            float r7 = java.lang.Math.abs(r7)
            int r7 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r7 >= 0) goto L35
            float r7 = r6.wp
            float r8 = r8 - r7
            float r7 = java.lang.Math.abs(r8)
            int r7 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r7 < 0) goto L88
        L35:
            r6.i = r1
            goto L88
        L38:
            boolean r0 = r6.i
            r4 = 0
            if (r0 == 0) goto L44
            r6.i = r3
            r6.kb = r4
            r6.wp = r4
            return r3
        L44:
            float r0 = r8.getRawX()
            float r8 = r8.getRawY()
            float r5 = r6.kb
            float r0 = r0 - r5
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L79
            float r0 = r6.wp
            float r8 = r8 - r0
            float r8 = java.lang.Math.abs(r8)
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 < 0) goto L63
            goto L79
        L63:
            com.bytedance.adsdk.ugeno.gc.kb r8 = r6.z
            if (r8 == 0) goto L88
            com.bytedance.adsdk.ugeno.gc.kb r8 = r6.z
            java.lang.String r0 = r6.m
            com.bytedance.adsdk.ugeno.gc.m r2 = r6.dl
            java.util.List r2 = r2.g()
            r8.z(r7, r0, r2)
            r6.kb = r4
            r6.wp = r4
            return r1
        L79:
            r6.i = r3
            return r3
        L7c:
            float r7 = r8.getRawX()
            r6.kb = r7
            float r7 = r8.getRawY()
            r6.wp = r7
        L88:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.gc.dl.gc.z(com.bytedance.adsdk.ugeno.g.dl, android.view.MotionEvent):boolean");
    }
}
