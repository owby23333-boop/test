package com.google.android.play.core.splitcompat;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes7.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Executor f6928a = Executors.newSingleThreadScheduledExecutor(new b());

    public static Executor a() {
        return f6928a;
    }
}
