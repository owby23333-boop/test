package com.bytedance.sdk.component.adexpress.a;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap z(android.content.Context r4, android.graphics.Bitmap r5, int r6) {
        /*
            r0 = 0
            boolean r1 = com.bytedance.sdk.component.adexpress.a.z()     // Catch: java.lang.Throwable -> L7a
            if (r5 == 0) goto L79
            boolean r1 = r5.isRecycled()     // Catch: java.lang.Throwable -> L7a
            if (r1 == 0) goto Lf
            goto L79
        Lf:
            int r1 = r5.getWidth()     // Catch: java.lang.Throwable -> L7a
            float r1 = (float) r1     // Catch: java.lang.Throwable -> L7a
            r2 = 1045220557(0x3e4ccccd, float:0.2)
            float r1 = r1 * r2
            int r1 = java.lang.Math.round(r1)     // Catch: java.lang.Throwable -> L7a
            int r3 = r5.getHeight()     // Catch: java.lang.Throwable -> L7a
            float r3 = (float) r3     // Catch: java.lang.Throwable -> L7a
            float r3 = r3 * r2
            int r2 = java.lang.Math.round(r3)     // Catch: java.lang.Throwable -> L7a
            r3 = 0
            android.graphics.Bitmap r5 = android.graphics.Bitmap.createScaledBitmap(r5, r1, r2, r3)     // Catch: java.lang.Throwable -> L7a
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r5)     // Catch: java.lang.Throwable -> L7a
            android.renderscript.RenderScript r4 = android.renderscript.RenderScript.create(r4)     // Catch: java.lang.Throwable -> L7a
            if (r4 != 0) goto L3b
            if (r4 == 0) goto L3a
            r4.destroy()
        L3a:
            return r0
        L3b:
            android.renderscript.Element r2 = android.renderscript.Element.U8_4(r4)     // Catch: java.lang.Throwable -> L76
            android.renderscript.ScriptIntrinsicBlur r2 = android.renderscript.ScriptIntrinsicBlur.create(r4, r2)     // Catch: java.lang.Throwable -> L76
            android.renderscript.Allocation r5 = android.renderscript.Allocation.createFromBitmap(r4, r5)     // Catch: java.lang.Throwable -> L72
            android.renderscript.Allocation r3 = android.renderscript.Allocation.createFromBitmap(r4, r1)     // Catch: java.lang.Throwable -> L6f
            float r6 = (float) r6
            r2.setRadius(r6)     // Catch: java.lang.Throwable -> L6d
            r2.setInput(r5)     // Catch: java.lang.Throwable -> L6d
            r2.forEach(r3)     // Catch: java.lang.Throwable -> L6d
            r3.copyTo(r1)     // Catch: java.lang.Throwable -> L6d
            if (r5 == 0) goto L5d
            r5.destroy()
        L5d:
            if (r3 == 0) goto L62
            r3.destroy()
        L62:
            if (r2 == 0) goto L67
            r2.destroy()
        L67:
            if (r4 == 0) goto L6c
            r4.destroy()
        L6c:
            return r1
        L6d:
            r6 = move-exception
            goto L7f
        L6f:
            r6 = move-exception
            r3 = r0
            goto L7f
        L72:
            r6 = move-exception
            r5 = r0
            r3 = r5
            goto L7f
        L76:
            r6 = move-exception
            r5 = r0
            goto L7d
        L79:
            return r0
        L7a:
            r6 = move-exception
            r4 = r0
            r5 = r4
        L7d:
            r2 = r5
            r3 = r2
        L7f:
            com.bytedance.sdk.component.utils.wp.z(r6)     // Catch: java.lang.Throwable -> L97
            if (r5 == 0) goto L87
            r5.destroy()
        L87:
            if (r3 == 0) goto L8c
            r3.destroy()
        L8c:
            if (r2 == 0) goto L91
            r2.destroy()
        L91:
            if (r4 == 0) goto L96
            r4.destroy()
        L96:
            return r0
        L97:
            r6 = move-exception
            if (r5 == 0) goto L9d
            r5.destroy()
        L9d:
            if (r3 == 0) goto La2
            r3.destroy()
        La2:
            if (r2 == 0) goto La7
            r2.destroy()
        La7:
            if (r4 == 0) goto Lac
            r4.destroy()
        Lac:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.a.g.z(android.content.Context, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }
}
