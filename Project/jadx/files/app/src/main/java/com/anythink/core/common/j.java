package com.anythink.core.common;

import android.app.Activity;
import android.content.Context;
import com.anythink.core.api.ATMediationRequestInfo;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {
    public String a;
    public ATMediationRequestInfo b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f7582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.anythink.core.common.b.b f7584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.anythink.core.common.b.a f7585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, Object> f7586g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Context f7587h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private WeakReference<Activity> f7588i;

    private int b() {
        return this.f7583d;
    }

    public final void a(Context context) {
        this.f7587h = com.anythink.core.common.b.n.a().g();
        if (context == null || !(context instanceof Activity)) {
            return;
        }
        this.f7588i = new WeakReference<>((Activity) context);
    }

    public final Context a() {
        Activity activity;
        WeakReference<Activity> weakReference = this.f7588i;
        if (weakReference != null && (activity = weakReference.get()) != null) {
            return activity;
        }
        Activity activityF = com.anythink.core.common.b.n.a().F();
        return activityF != null ? activityF : this.f7587h;
    }
}
