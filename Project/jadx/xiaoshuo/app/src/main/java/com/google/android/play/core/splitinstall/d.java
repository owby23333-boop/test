package com.google.android.play.core.splitinstall;

import com.yuewen.ir1;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReference<e> f6966a = new AtomicReference<>(null);

    public static e a() {
        return f6966a.get();
    }

    public static void a(e eVar) {
        ir1.a(f6966a, null, eVar);
    }
}
