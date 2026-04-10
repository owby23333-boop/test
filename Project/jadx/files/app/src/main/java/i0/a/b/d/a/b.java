package i0.a.b.d.a;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* JADX INFO: compiled from: IdentifierIdClient.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static Context a = null;
    private static boolean b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static c f20854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static c f20855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static c f20856e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Object f20857f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static HandlerThread f20858g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Handler f20859h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f20860i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static String f20861j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile b f20862k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile i0.a.b.d.a.a f20863l;

    /* JADX INFO: compiled from: IdentifierIdClient.java */
    static class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 11) {
                String unused = b.f20860i = b.f20863l.a(message.getData().getInt("type"), message.getData().getString("appid"));
                synchronized (b.f20857f) {
                    b.f20857f.notify();
                }
            }
        }
    }

    private b() {
    }

    public static void c() {
        b = "1".equals(a("persist.sys.identifierid.supported", "0"));
    }

    private static void f() {
        f20858g = new HandlerThread("SqlWorkThread");
        f20858g.start();
        f20859h = new a(f20858g.getLooper());
    }

    public String b() {
        if (!a()) {
            return null;
        }
        String str = f20861j;
        if (str != null) {
            return str;
        }
        a(0, (String) null);
        if (f20854c == null) {
            a(a, 0, null);
        }
        return f20861j;
    }

    public static b a(Context context) {
        if (f20862k == null) {
            synchronized (b.class) {
                a = context.getApplicationContext();
                f20862k = new b();
            }
        }
        if (f20863l == null) {
            synchronized (b.class) {
                a = context.getApplicationContext();
                f();
                f20863l = new i0.a.b.d.a.a(a);
                c();
            }
        }
        return f20862k;
    }

    private void b(int i2, String str) {
        Message messageObtainMessage = f20859h.obtainMessage();
        messageObtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i2);
        if (i2 == 1 || i2 == 2) {
            bundle.putString("appid", str);
        }
        messageObtainMessage.setData(bundle);
        f20859h.sendMessage(messageObtainMessage);
    }

    public boolean a() {
        return b;
    }

    public void a(int i2, String str) {
        synchronized (f20857f) {
            b(i2, str);
            long jUptimeMillis = SystemClock.uptimeMillis();
            try {
                f20857f.wait(com.anythink.expressad.exoplayer.i.a.f9492f);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (SystemClock.uptimeMillis() - jUptimeMillis < com.anythink.expressad.exoplayer.i.a.f9492f) {
                if (i2 == 0) {
                    f20861j = f20860i;
                    f20860i = null;
                } else if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 4) {
                        }
                    } else if (f20860i != null) {
                        f20860i = null;
                    }
                    f20860i = null;
                } else if (f20860i != null) {
                    f20860i = null;
                }
            }
        }
    }

    public static String a(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, "unknown");
            } catch (Exception e2) {
                e2.printStackTrace();
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static void a(Context context, int i2, String str) {
        if (i2 == 0) {
            f20854c = new c(f20862k, 0, null);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, f20854c);
            return;
        }
        if (i2 == 1) {
            f20855d = new c(f20862k, 1, str);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, f20855d);
            return;
        }
        if (i2 != 2) {
            return;
        }
        f20856e = new c(f20862k, 2, str);
        context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str), false, f20856e);
    }
}
