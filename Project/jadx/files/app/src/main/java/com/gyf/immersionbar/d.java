package com.gyf.immersionbar;

import android.app.Application;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: EMUI3NavigationBarObserver.java */
/* JADX INFO: loaded from: classes2.dex */
final class d extends ContentObserver {
    private ArrayList<g> a;
    private Application b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Boolean f16389c;

    /* JADX INFO: compiled from: EMUI3NavigationBarObserver.java */
    private static class b {
        private static final d a = new d();
    }

    static d a() {
        return b.a;
    }

    void b(g gVar) {
        ArrayList<g> arrayList;
        if (gVar == null || (arrayList = this.a) == null) {
            return;
        }
        arrayList.remove(gVar);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z2) {
        Application application;
        ArrayList<g> arrayList;
        super.onChange(z2);
        if (Build.VERSION.SDK_INT < 17 || (application = this.b) == null || application.getContentResolver() == null || (arrayList = this.a) == null || arrayList.isEmpty()) {
            return;
        }
        int i2 = Settings.System.getInt(this.b.getContentResolver(), "navigationbar_is_min", 0);
        NavigationBarType navigationBarType = NavigationBarType.CLASSIC;
        if (i2 == 1) {
            navigationBarType = NavigationBarType.GESTURES;
        }
        Iterator<g> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(i2 == 0, navigationBarType);
        }
    }

    private d() {
        super(new Handler(Looper.getMainLooper()));
        this.f16389c = false;
    }

    void a(Application application) {
        Application application2;
        Uri uriFor;
        this.b = application;
        if (Build.VERSION.SDK_INT < 17 || (application2 = this.b) == null || application2.getContentResolver() == null || this.f16389c.booleanValue() || (uriFor = Settings.System.getUriFor("navigationbar_is_min")) == null) {
            return;
        }
        this.b.getContentResolver().registerContentObserver(uriFor, true, this);
        this.f16389c = true;
    }

    void a(g gVar) {
        if (gVar == null) {
            return;
        }
        if (this.a == null) {
            this.a = new ArrayList<>();
        }
        if (this.a.contains(gVar)) {
            return;
        }
        this.a.add(gVar);
    }
}
