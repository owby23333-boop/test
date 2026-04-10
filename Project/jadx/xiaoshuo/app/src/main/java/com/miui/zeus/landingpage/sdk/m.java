package com.miui.zeus.landingpage.sdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f7207a;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        if (iAvailableProcessors < 4) {
            iAvailableProcessors = 4;
        }
        f7207a = new ThreadPoolExecutor(iAvailableProcessors + 1, (iAvailableProcessors * 2) + 1, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque(128));
        Executors.newSingleThreadExecutor();
    }
}
