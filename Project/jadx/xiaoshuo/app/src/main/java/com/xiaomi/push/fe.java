package com.xiaomi.push;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
@SuppressLint({"NewApi"})
public class fe extends Notification.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7960a;

    public fe(Context context) {
        super(context);
        this.f7960a = context;
    }

    public fe a(Map<String, String> map) {
        return this;
    }

    @Override // android.app.Notification.Builder
    public Notification build() {
        mo418a();
        return super.build();
    }

    /* JADX INFO: renamed from: a */
    public void mo418a() {
    }

    public Context a() {
        return this.f7960a;
    }

    public int a(Resources resources, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return resources.getIdentifier(str, str2, str3);
    }

    public final int a(String str) {
        return a(a().getResources(), str, "id", a().getPackageName());
    }

    @Override // android.app.Notification.Builder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public fe addExtras(Bundle bundle) {
        super.addExtras(bundle);
        return this;
    }

    @Override // android.app.Notification.Builder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public fe setCustomContentView(RemoteViews remoteViews) {
        super.setCustomContentView(remoteViews);
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public fe mo420a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                bj.a((Object) this, "setColor", Integer.valueOf(Color.parseColor(str)));
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to set color. " + e);
            }
        }
        return this;
    }
}
