package com.liulishuo.filedownloader.services;

import android.R;
import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import com.liulishuo.filedownloader.R$string;

/* JADX INFO: compiled from: ForegroundServiceConfig.java */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(26)
public class i {
    private int a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f17299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Notification f17300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f17301e;

    /* JADX INFO: compiled from: ForegroundServiceConfig.java */
    public static class b {
        private int a;
        private String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f17302c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Notification f17303d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f17304e;

        public b a(boolean z2) {
            this.f17304e = z2;
            return this;
        }

        public i a() {
            i iVar = new i();
            String str = this.b;
            if (str == null) {
                str = "filedownloader_channel";
            }
            iVar.a(str);
            String str2 = this.f17302c;
            if (str2 == null) {
                str2 = "Filedownloader";
            }
            iVar.b(str2);
            int i2 = this.a;
            if (i2 == 0) {
                i2 = R.drawable.arrow_down_float;
            }
            iVar.a(i2);
            iVar.a(this.f17304e);
            iVar.a(this.f17303d);
            return iVar;
        }
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.f17299c;
    }

    public int c() {
        return this.a;
    }

    public boolean d() {
        return this.f17301e;
    }

    public String toString() {
        return "ForegroundServiceConfig{notificationId=" + this.a + ", notificationChannelId='" + this.b + "', notificationChannelName='" + this.f17299c + "', notification=" + this.f17300d + ", needRecreateChannelId=" + this.f17301e + '}';
    }

    private i() {
    }

    public Notification a(Context context) {
        if (this.f17300d == null) {
            if (com.liulishuo.filedownloader.h0.d.a) {
                com.liulishuo.filedownloader.h0.d.a(this, "build default notification", new Object[0]);
            }
            this.f17300d = b(context);
        }
        return this.f17300d;
    }

    public void b(String str) {
        this.f17299c = str;
    }

    private Notification b(Context context) {
        String string = context.getString(R$string.default_filedownloader_notification_title);
        String string2 = context.getString(R$string.default_filedownloader_notification_content);
        Notification.Builder builder = new Notification.Builder(context, this.b);
        builder.setContentTitle(string).setContentText(string2).setSmallIcon(R.drawable.arrow_down_float);
        return builder.build();
    }

    public void a(int i2) {
        this.a = i2;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(Notification notification) {
        this.f17300d = notification;
    }

    public void a(boolean z2) {
        this.f17301e = z2;
    }
}
