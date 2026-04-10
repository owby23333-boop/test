package d1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* JADX INFO: compiled from: C0040b.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {
    public static Context a;
    public static boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f20770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static d1.a f20771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static b f20772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static b f20773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static b f20774g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Object f20775h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static HandlerThread f20776i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Handler f20777j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f20778k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f20779l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f20780m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static String f20781n;

    /* JADX INFO: compiled from: C0040b.java */
    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 11) {
                v.c.b("VMS_IDLG_SDK_Client", "message type valid");
                return;
            }
            try {
                c.f20778k = c.f20771d.a(message.getData().getInt("type"), message.getData().getString("appid"));
            } catch (Exception e2) {
                c.f20778k = "";
                v.c.b("VMS_IDLG_SDK_Client", "exception", e2);
            }
            Context context = c.a;
            Object obj = c.f20775h;
            synchronized (obj) {
                obj.notify();
            }
        }
    }

    public static c a(Context context) {
        String str;
        if (f20770c == null) {
            f20770c = new c();
            a = context;
            HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
            f20776i = handlerThread;
            handlerThread.start();
            f20777j = new a(f20776i.getLooper());
            f20771d = new d1.a(a);
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str = (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, "persist.sys.identifierid.supported", "unknown");
            } catch (Exception e2) {
                e2.printStackTrace();
                str = "0";
            } catch (Throwable unused) {
                str = "0";
            }
            b = "1".equals(str);
        }
        return f20770c;
    }

    public static void a(Context context, int i2, String str) {
        if (i2 == 0) {
            f20772e = new b(f20770c, 0, null);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, f20772e);
            return;
        }
        if (i2 == 1) {
            f20773f = new b(f20770c, 1, str);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, f20773f);
            return;
        }
        if (i2 == 2) {
            f20774g = new b(f20770c, 2, str);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str), false, f20774g);
        }
    }

    public void a(int i2, String str) {
        Object obj = f20775h;
        synchronized (obj) {
            Message messageObtainMessage = f20777j.obtainMessage();
            messageObtainMessage.what = 11;
            Bundle bundle = new Bundle();
            bundle.putInt("type", i2);
            if (i2 == 1 || i2 == 2) {
                bundle.putString("appid", str);
            }
            messageObtainMessage.setData(bundle);
            f20777j.sendMessage(messageObtainMessage);
            long jUptimeMillis = SystemClock.uptimeMillis();
            try {
                obj.wait(com.anythink.expressad.exoplayer.i.a.f9492f);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (SystemClock.uptimeMillis() - jUptimeMillis < com.anythink.expressad.exoplayer.i.a.f9492f) {
                if (i2 == 0) {
                    f20779l = f20778k;
                } else if (i2 == 1) {
                    String str2 = f20778k;
                    if (str2 != null) {
                        f20780m = str2;
                    } else {
                        v.c.b("VMS_IDLG_SDK_Client", "get vaid failed");
                    }
                } else if (i2 == 2) {
                    String str3 = f20778k;
                    if (str3 != null) {
                        f20781n = str3;
                    } else {
                        v.c.b("VMS_IDLG_SDK_Client", "get aaid failed");
                    }
                }
                f20778k = null;
            } else {
                v.c.b("VMS_IDLG_SDK_Client", "query timeout");
            }
        }
    }
}
