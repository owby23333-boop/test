package com.yuewen;

import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class k01 {
    public static final boolean a() {
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }
}
