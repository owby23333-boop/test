package jp.wasabeef.glide.transformations.internal;

/* JADX INFO: loaded from: classes4.dex */
public class SupportRSBlur {
    /* JADX WARN: Removed duplicated region for block: B:26:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap blur(android.content.Context r5, android.graphics.Bitmap r6, int r7) throws java.lang.Throwable {
        /*
            r0 = 0
            androidx.renderscript.RenderScript r5 = androidx.renderscript.RenderScript.create(r5)     // Catch: java.lang.Throwable -> L54
            androidx.renderscript.RenderScript$RSMessageHandler r1 = new androidx.renderscript.RenderScript$RSMessageHandler     // Catch: java.lang.Throwable -> L4e
            r1.<init>()     // Catch: java.lang.Throwable -> L4e
            r5.setMessageHandler(r1)     // Catch: java.lang.Throwable -> L4e
            androidx.renderscript.Allocation$MipmapControl r1 = androidx.renderscript.Allocation.MipmapControl.MIPMAP_NONE     // Catch: java.lang.Throwable -> L4e
            r2 = 1
            androidx.renderscript.Allocation r1 = androidx.renderscript.Allocation.createFromBitmap(r5, r6, r1, r2)     // Catch: java.lang.Throwable -> L4e
            androidx.renderscript.Type r2 = r1.getType()     // Catch: java.lang.Throwable -> L4b
            androidx.renderscript.Allocation r2 = androidx.renderscript.Allocation.createTyped(r5, r2)     // Catch: java.lang.Throwable -> L4b
            androidx.renderscript.Element r3 = androidx.renderscript.Element.U8_4(r5)     // Catch: java.lang.Throwable -> L46
            androidx.renderscript.ScriptIntrinsicBlur r0 = androidx.renderscript.ScriptIntrinsicBlur.create(r5, r3)     // Catch: java.lang.Throwable -> L46
            r0.setInput(r1)     // Catch: java.lang.Throwable -> L46
            float r7 = (float) r7     // Catch: java.lang.Throwable -> L46
            r0.setRadius(r7)     // Catch: java.lang.Throwable -> L46
            r0.forEach(r2)     // Catch: java.lang.Throwable -> L46
            r2.copyTo(r6)     // Catch: java.lang.Throwable -> L46
            if (r5 == 0) goto L36
            androidx.renderscript.RenderScript.releaseAllContexts()
        L36:
            if (r1 == 0) goto L3b
            r1.destroy()
        L3b:
            if (r2 == 0) goto L40
            r2.destroy()
        L40:
            if (r0 == 0) goto L45
            r0.destroy()
        L45:
            return r6
        L46:
            r6 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L58
        L4b:
            r6 = move-exception
            r2 = r0
            goto L51
        L4e:
            r6 = move-exception
            r1 = r0
            r2 = r1
        L51:
            r0 = r5
            r5 = r2
            goto L58
        L54:
            r6 = move-exception
            r5 = r0
            r1 = r5
            r2 = r1
        L58:
            if (r0 == 0) goto L5d
            androidx.renderscript.RenderScript.releaseAllContexts()
        L5d:
            if (r1 == 0) goto L62
            r1.destroy()
        L62:
            if (r2 == 0) goto L67
            r2.destroy()
        L67:
            if (r5 == 0) goto L6c
            r5.destroy()
        L6c:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.wasabeef.glide.transformations.internal.SupportRSBlur.blur(android.content.Context, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }
}
