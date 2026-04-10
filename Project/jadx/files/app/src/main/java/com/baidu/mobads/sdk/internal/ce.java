package com.baidu.mobads.sdk.internal;

import android.content.SharedPreferences;
import android.os.Handler;
import com.baidu.mobads.sdk.internal.bw;

/* JADX INFO: loaded from: classes2.dex */
class ce extends h {
    final /* synthetic */ bw.c b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Handler f12995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ bw f12996d;

    ce(bw bwVar, bw.c cVar, Handler handler) {
        this.f12996d = bwVar;
        this.b = cVar;
        this.f12995c = handler;
    }

    @Override // com.baidu.mobads.sdk.internal.h
    protected Object i() {
        try {
            try {
                synchronized (bw.class) {
                    this.f12996d.b(this.b, this.f12995c);
                }
                SharedPreferences.Editor editorEdit = this.f12996d.m().edit();
                editorEdit.putString(bw.f12970d, this.f12996d.a());
                editorEdit.apply();
                return null;
            } catch (Throwable th) {
                try {
                    this.f12996d.f12992z.a(bw.a, "Load APK Failed: " + th.toString());
                    this.f12996d.b(false);
                    SharedPreferences.Editor editorEdit2 = this.f12996d.m().edit();
                    editorEdit2.putString(bw.f12970d, this.f12996d.a());
                    editorEdit2.apply();
                    return null;
                } catch (Throwable th2) {
                    try {
                        SharedPreferences.Editor editorEdit3 = this.f12996d.m().edit();
                        editorEdit3.putString(bw.f12970d, this.f12996d.a());
                        editorEdit3.apply();
                    } catch (Throwable th3) {
                        this.f12996d.f12992z.a(bw.a, th3);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            this.f12996d.f12992z.a(bw.a, th4);
            return null;
        }
    }
}
