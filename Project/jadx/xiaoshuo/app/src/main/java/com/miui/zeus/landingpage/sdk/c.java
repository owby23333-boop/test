package com.miui.zeus.landingpage.sdk;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c f7192b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<OnAppLaunchListener> f7193a = new CopyOnWriteArrayList();

    public static c a() {
        if (f7192b == null) {
            synchronized (c.class) {
                if (f7192b == null) {
                    f7192b = new c();
                }
            }
        }
        return f7192b;
    }
}
