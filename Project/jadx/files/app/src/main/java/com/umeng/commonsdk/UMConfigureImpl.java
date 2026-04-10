package com.umeng.commonsdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.utils.onMessageSendListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class UMConfigureImpl {
    private static String a = "delayed_transmission_flag_new";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f19855e = 1000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static ScheduledExecutorService f19856f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Context f19857g;
    private static CopyOnWriteArrayList<onMessageSendListener> b = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f19853c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f19854d = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f19858h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Runnable f19859i = new Runnable() { // from class: com.umeng.commonsdk.UMConfigureImpl.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (UMConfigureImpl.f19853c == 0 || UMConfigureImpl.f19858h >= 10) {
                    if (!UMConfigureImpl.f19854d) {
                        boolean unused = UMConfigureImpl.f19854d = true;
                        UMConfigureImpl.b(UMConfigureImpl.f19857g);
                    }
                    if (UMConfigureImpl.f19856f != null) {
                        UMConfigureImpl.f19856f.shutdown();
                        ScheduledExecutorService unused2 = UMConfigureImpl.f19856f = null;
                    }
                }
                UMConfigureImpl.f();
            } catch (Exception unused3) {
            }
        }
    };

    static /* synthetic */ int f() {
        int i2 = f19858h;
        f19858h = i2 + 1;
        return i2;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        f19857g = context;
        try {
            if (f19853c < 1 || d(context)) {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
            } else {
                UMEnvelopeBuild.setTransmissionSendFlag(false);
                c(context);
                if (f19856f == null) {
                    f19856f = Executors.newScheduledThreadPool(1);
                    f19856f.scheduleAtFixedRate(f19859i, 0L, 100L, TimeUnit.MILLISECONDS);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static synchronized void registerInterruptFlag() {
        try {
            f19853c++;
        } catch (Exception unused) {
        }
    }

    public static synchronized void registerMessageSendListener(onMessageSendListener onmessagesendlistener) {
        try {
            if (b != null) {
                b.add(onmessagesendlistener);
            }
            if (UMEnvelopeBuild.getTransmissionSendFlag() && b != null && b.size() > 0) {
                Iterator<onMessageSendListener> it = b.iterator();
                while (it.hasNext()) {
                    it.next().onMessageSend();
                }
            }
        } catch (Exception unused) {
        }
    }

    public static synchronized void removeInterruptFlag() {
        try {
            f19853c--;
        } catch (Exception unused) {
        }
    }

    public static synchronized void removeMessageSendListener(onMessageSendListener onmessagesendlistener) {
        try {
            if (b != null) {
                b.remove(onmessagesendlistener);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void b(Context context) {
        try {
            UMEnvelopeBuild.setTransmissionSendFlag(true);
            if (b != null && b.size() > 0) {
                Iterator<onMessageSendListener> it = b.iterator();
                while (it.hasNext()) {
                    it.next().onMessageSend();
                }
            }
        } catch (Exception unused) {
        }
    }

    private static void c(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
            if (sharedPreferences == null || sharedPreferences == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean(a, true);
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    private static boolean d(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
            if (sharedPreferences == null || sharedPreferences == null) {
                return false;
            }
            return sharedPreferences.getBoolean(a, false);
        } catch (Throwable unused) {
            return false;
        }
    }
}
