package com.yuewen;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.DrawableRes;
import com.duokan.reader.ui.reading.ReadingTheme;
import com.yuewen.st2;

/* JADX INFO: loaded from: classes5.dex */
public class hz3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @DrawableRes
    public static final int[] f12316a = {st2.h.r20, st2.h.n20, st2.h.p20, st2.h.t20};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @DrawableRes
    public static final int[] f12317b = {st2.h.s20, st2.h.o20, st2.h.q20};

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12318a;

        static {
            int[] iArr = new int[ReadingTheme.values().length];
            f12318a = iArr;
            try {
                iArr[ReadingTheme.THEME20.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12318a[ReadingTheme.THEME21.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12318a[ReadingTheme.THEME22.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12318a[ReadingTheme.THEME23.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static BitmapDrawable a(Context context, int i, int[] iArr) {
        if (i < iArr.length) {
            return (BitmapDrawable) context.getResources().getDrawable(iArr[i]);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.BitmapDrawable[] b(android.content.Context r4, com.duokan.reader.ui.reading.ReadingTheme r5) {
        /*
            int[] r0 = com.yuewen.hz3.a.f12318a
            int r5 = r5.ordinal()
            r5 = r0[r5]
            r0 = 2
            r1 = 1
            r2 = 0
            if (r5 == r1) goto L15
            r3 = 3
            if (r5 == r0) goto L1a
            if (r5 == r3) goto L19
            r3 = 4
            if (r5 == r3) goto L17
        L15:
            r3 = r2
            goto L1a
        L17:
            r3 = r0
            goto L1a
        L19:
            r3 = r1
        L1a:
            android.graphics.drawable.BitmapDrawable[] r5 = new android.graphics.drawable.BitmapDrawable[r0]
            int[] r0 = com.yuewen.hz3.f12317b
            android.graphics.drawable.BitmapDrawable r0 = a(r4, r3, r0)
            r5[r2] = r0
            int[] r0 = com.yuewen.hz3.f12316a
            android.graphics.drawable.BitmapDrawable r4 = a(r4, r3, r0)
            r5[r1] = r4
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yuewen.hz3.b(android.content.Context, com.duokan.reader.ui.reading.ReadingTheme):android.graphics.drawable.BitmapDrawable[]");
    }
}
