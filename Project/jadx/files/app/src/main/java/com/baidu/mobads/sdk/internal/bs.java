package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mobads.sdk.internal.bw;
import com.baidu.mobads.sdk.internal.cf;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class bs extends Thread {
    private static final String b = "ApkDownloadThread";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f12952c = 900000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile bs f12953h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile String f12954d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f12955e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f12956f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Handler f12957g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Context f12958i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final bu f12960k;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private cf f12959j = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private bq f12961l = bq.a();
    cf.a a = new bt(this);

    private bs(Context context, bu buVar, String str, Handler handler) {
        this.f12955e = null;
        this.f12958i = context;
        this.f12960k = buVar;
        a(buVar.c());
        this.f12957g = handler;
        this.f12955e = str;
    }

    private boolean b() throws bw.a {
        try {
            try {
                this.f12959j = new cf(this.f12958i, new URL(this.f12954d), this.f12960k, this.a);
            } catch (MalformedURLException unused) {
                this.f12959j = new cf(this.f12958i, this.f12954d, this.f12960k, this.a);
            }
            double d2 = bw.f12983q != null ? bw.f12983q.b : bw.f12982p != null ? bw.f12982p.b > PangleAdapterUtils.CPM_DEFLAUT_VALUE ? bw.f12982p.b : bw.f12982p.b : 0.0d;
            this.f12961l.a(b, "isNewApkAvailable: local apk version is: " + d2 + ", remote apk version: " + this.f12960k.b());
            if (d2 > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                if (this.f12960k.b() <= PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                    this.f12961l.a(b, "remote is null, local apk version is null, do not upgrade");
                    return false;
                }
                this.f12961l.a(b, "remote not null, local apk version is null, force upgrade");
                this.f12956f = this.f12960k.b();
                return true;
            }
            if (this.f12960k.b() > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                if (this.f12960k.b() <= d2) {
                    return false;
                }
                this.f12956f = this.f12960k.b();
                return true;
            }
            this.f12961l.a(b, "remote apk version is: null, local apk version is: " + d2 + ", do not upgrade");
            return false;
        } catch (Exception e2) {
            String str = "parse apk failed, error:" + e2.toString();
            this.f12961l.a(b, str);
            throw new bw.a(str);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (b()) {
                try {
                    a();
                    this.f12961l.a(b, "download apk successfully, downloader exit");
                    f12953h = null;
                } catch (IOException e2) {
                    this.f12961l.a(b, "create File or HTTP Get failed, exception: " + e2.getMessage());
                }
                this.f12961l.a(b, "no newer apk, downloader exit");
                f12953h = null;
            }
        } catch (Throwable unused) {
        }
    }

    public static bs a(Context context, bu buVar, String str, Handler handler) {
        if (f12953h == null) {
            f12953h = new bs(context, buVar, str, handler);
        }
        return f12953h;
    }

    public void a(String str) {
        this.f12954d = str;
        interrupt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, bu buVar, String str2) {
        if (str.equals(bw.f12977k) || str.equals(bw.f12978l)) {
            Message messageObtainMessage = this.f12957g.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putParcelable(bw.f12979m, buVar);
            bundle.putString(bw.f12980n, str);
            messageObtainMessage.setData(bundle);
            this.f12957g.sendMessage(messageObtainMessage);
        }
    }

    private String a() throws IOException {
        String str = "__xadsdk__remote__final__" + UUID.randomUUID().toString() + ".jar";
        String str2 = this.f12955e + str;
        File file = new File(str2);
        try {
            file.createNewFile();
            this.f12959j.a(this.f12955e, str);
            return str2;
        } catch (IOException e2) {
            file.delete();
            throw e2;
        }
    }
}
