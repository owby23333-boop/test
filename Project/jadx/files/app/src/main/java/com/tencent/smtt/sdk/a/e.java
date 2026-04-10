package com.tencent.smtt.sdk.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.smtt.utils.TbsLog;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public class e {
    private static String a = "EmergencyManager";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f18998f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static HandlerThread f18999g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Handler f19000h;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f19001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f19002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f19003e;

    public interface a {
        void a(String str);
    }

    public e(Context context, String str, String str2) {
        this(context, str, str2, "POST");
    }

    public e(Context context, String str, String str2, String str3) {
        this.b = str;
        this.f19001c = str2;
        this.f19002d = str3;
        this.f19003e = new Handler(context.getMainLooper());
    }

    private static Handler b() {
        Handler handler;
        synchronized (f18998f) {
            if (f19000h == null) {
                f18999g = new HandlerThread("HttpThread");
                f18999g.start();
                f19000h = new Handler(f18999g.getLooper());
            }
            handler = f19000h;
        }
        return handler;
    }

    public String a(String str) {
        TbsLog.e(a, "Request url: " + this.b + ",params: " + this.f19001c);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str.trim()).openConnection();
            httpURLConnection.setRequestMethod(this.f19002d);
            httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            httpURLConnection.setRequestProperty("Content-Length", this.f19001c.length() + "");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.getOutputStream().write(this.f19001c.getBytes());
            int responseCode = httpURLConnection.getResponseCode();
            if (200 != responseCode) {
                TbsLog.e(a, "Bad http request, code: " + responseCode);
                return null;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (-1 == i2) {
                    return byteArrayOutputStream.toString(com.anythink.expressad.foundation.g.a.bN);
                }
                byteArrayOutputStream.write(bArr, 0, i2);
                byteArrayOutputStream.flush();
            }
        } catch (Exception e2) {
            TbsLog.e(a, "Http exception: " + e2.getMessage());
            return null;
        }
    }

    public void a(final a aVar) {
        b().post(new Runnable() { // from class: com.tencent.smtt.sdk.a.e.1
            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                final String strA = eVar.a(eVar.b);
                if (strA != null) {
                    e.this.f19003e.post(new Runnable() { // from class: com.tencent.smtt.sdk.a.e.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a aVar2 = aVar;
                            if (aVar2 != null) {
                                aVar2.a(strA);
                            }
                        }
                    });
                    return;
                }
                TbsLog.e(e.a, "Unexpected result for an empty http response: " + e.this.b);
            }
        });
    }
}
