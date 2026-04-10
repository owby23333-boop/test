package l.b.a;

import android.app.AppOpsManager;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.InvocationTargetException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: compiled from: ToastStrategy.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends Handler implements c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private volatile Queue<CharSequence> f21038s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private volatile boolean f21039t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Toast f21040u;

    public i() {
        super(Looper.getMainLooper());
        this.f21038s = a();
    }

    @Override // l.b.a.c
    public Toast a(Application application) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            return new a(application);
        }
        return !(i2 >= 29 || a((Context) application) || AgooConstants.MESSAGE_SYSTEM_SOURCE_XIAOMI.equals(Build.MANUFACTURER.toLowerCase())) ? new a(application) : Build.VERSION.SDK_INT >= 25 ? new g(application) : new e(application);
    }

    protected int b(CharSequence charSequence) {
        return charSequence.length() > 20 ? 3500 : 2000;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            CharSequence charSequencePeek = this.f21038s.peek();
            if (charSequencePeek == null) {
                this.f21039t = false;
                return;
            }
            this.f21040u.setText(charSequencePeek);
            this.f21040u.show();
            sendEmptyMessageDelayed(2, b(charSequencePeek) + 200);
            return;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                return;
            }
            this.f21039t = false;
            this.f21038s.clear();
            this.f21040u.cancel();
            return;
        }
        this.f21038s.poll();
        if (this.f21038s.isEmpty()) {
            this.f21039t = false;
        } else {
            sendEmptyMessage(1);
        }
    }

    @Override // l.b.a.c
    public void a(Toast toast) {
        this.f21040u = toast;
    }

    @Override // l.b.a.c
    public void a(CharSequence charSequence) {
        if ((this.f21038s.isEmpty() || !this.f21038s.contains(charSequence)) && !this.f21038s.offer(charSequence)) {
            this.f21038s.poll();
            this.f21038s.offer(charSequence);
        }
        if (this.f21039t) {
            return;
        }
        this.f21039t = true;
        sendEmptyMessageDelayed(1, 200L);
    }

    protected Queue<CharSequence> a() {
        return new ArrayBlockingQueue(3);
    }

    protected boolean a(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            return ((NotificationManager) context.getSystemService(NotificationManager.class)).areNotificationsEnabled();
        }
        if (i2 < 19) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        try {
            return ((Integer) appOpsManager.getClass().getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) appOpsManager.getClass().getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(context.getApplicationInfo().uid), context.getPackageName())).intValue() == 0;
        } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }
}
