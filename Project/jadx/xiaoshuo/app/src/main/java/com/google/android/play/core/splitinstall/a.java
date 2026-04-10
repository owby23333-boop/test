package com.google.android.play.core.splitinstall;

import com.yuewen.ir1;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReference<c> f6963a = new AtomicReference<>(null);

    public static c a() {
        return f6963a.get();
    }

    public static void a(c cVar) {
        ir1.a(f6963a, null, cVar);
    }
}
