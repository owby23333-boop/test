package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tbs.video.interfaces.IUserStateChangedListener;

/* JADX INFO: loaded from: classes3.dex */
class r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static r f19075e;
    t a;
    Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    com.tencent.tbs.video.interfaces.a f19076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    IUserStateChangedListener f19077d;

    private r(Context context) {
        this.a = null;
        this.b = context.getApplicationContext();
        this.a = new t(this.b);
    }

    public static synchronized r a(Context context) {
        if (f19075e == null) {
            f19075e = new r(context);
        }
        return f19075e;
    }

    public void a(int i2, int i3, Intent intent) {
        com.tencent.tbs.video.interfaces.a aVar = this.f19076c;
        if (aVar != null) {
            aVar.a(i2, i3, intent);
        }
    }

    void a(Activity activity, int i2) {
        this.a.a(activity, i2);
    }

    public boolean a() {
        this.a.a();
        return this.a.b();
    }

    public boolean a(String str, Bundle bundle, com.tencent.tbs.video.interfaces.a aVar) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("videoUrl", str);
        }
        if (aVar != null) {
            this.a.a();
            if (!this.a.b()) {
                return false;
            }
            this.f19076c = aVar;
            this.f19077d = new IUserStateChangedListener() { // from class: com.tencent.smtt.sdk.r.1
                @Override // com.tencent.tbs.video.interfaces.IUserStateChangedListener
                public void onUserStateChanged() {
                    r.this.a.c();
                }
            };
            this.f19076c.a(this.f19077d);
            bundle.putInt("callMode", 3);
        } else {
            bundle.putInt("callMode", 1);
        }
        this.a.a(bundle, aVar == null ? null : this);
        return true;
    }
}
