package com.xiaomi.push;

import android.content.Context;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
public class ec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ThreadPoolExecutor f7904a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static void a(Context context) {
    }
}
