package com.taobao.accs.utl;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.init.Launcher_InitAccs;
import com.taobao.agoo.TaobaoRegister;
import java.util.ArrayList;
import java.util.Iterator;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class l implements Application.ActivityLifecycleCallbacks {
    public static final int STATE_BACK = 0;
    public static final int STATE_FORE = 1;
    private static volatile l b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ArrayList<a> f18331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ArrayList<b> f18332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Application f18333e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f18336g;
    private static final String a = l.class.getSimpleName();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f18334j = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f18335f = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f18337h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f18338i = 1;

    /* JADX INFO: compiled from: Taobao */
    public static class a implements Runnable {
        private String a;
        private int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f18339c = u.b(l.f18333e);

        public a(String str, int i2) {
            this.a = str;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            ALog.e(l.a, "click report", "lastActiveTime", Long.valueOf(this.f18339c), "currentActiveTime", Long.valueOf(jCurrentTimeMillis));
            long j2 = this.f18339c;
            if (j2 == 0 || UtilityImpl.a(j2, jCurrentTimeMillis)) {
                this.b |= 8;
            }
            TaobaoRegister.clickMessage(l.f18333e, this.a, null, this.b, this.f18339c);
        }
    }

    /* JADX INFO: compiled from: Taobao */
    public interface b {
        void a();

        void b();
    }

    private l() {
        f18331c = new ArrayList<>();
        f18332d = new ArrayList<>();
    }

    public static l a() {
        if (b == null) {
            synchronized (l.class) {
                if (b == null) {
                    b = new l();
                }
            }
        }
        return b;
    }

    public void b() {
        ArrayList<a> arrayList = f18331c;
        if (arrayList != null) {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                ThreadPoolExecutorFactory.getScheduledExecutor().execute(it.next());
            }
            f18331c.clear();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        int i2 = this.f18335f;
        if ((i2 & 1) != 1) {
            this.f18335f = i2 | 1;
            this.f18335f |= 2;
        } else if ((i2 & 2) == 2) {
            this.f18335f = i2 & (-3);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (this.f18336g) {
            u.a(f18333e, System.currentTimeMillis());
            if (!f18334j) {
                f18334j = true;
            }
        }
        this.f18336g = false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        int i2 = this.f18337h;
        this.f18337h = i2 + 1;
        if (i2 == 0) {
            ALog.i(a, "onActivityStarted back to force", new Object[0]);
            this.f18336g = true;
            this.f18338i = 1;
            ThreadPoolExecutorFactory.execute(new m(this));
        }
        int i3 = (this.f18336g ? 4 : 0) | ((this.f18335f & 2) == 2 ? 2 : 1);
        if (activity == null || activity.getIntent() == null) {
            return;
        }
        try {
            Intent intent = activity.getIntent();
            String stringExtra = intent.getStringExtra(AgooConstants.FLAG_FROM_AGOO_MESSAGE_ID);
            if (!TextUtils.isEmpty(stringExtra)) {
                ALog.i(a, "onActivityStarted isFromAgoo", new Object[0]);
                intent.removeExtra(AgooConstants.FLAG_FROM_AGOO_MESSAGE_ID);
                a aVar = new a(stringExtra, i3);
                if (TaobaoRegister.isRegisterSuccess() || Launcher_InitAccs.mIsInited) {
                    ThreadPoolExecutorFactory.execute(aVar);
                } else {
                    ThreadPoolExecutorFactory.getScheduledExecutor().execute(new n(this, aVar));
                }
            }
        } catch (Exception e2) {
            ALog.e(a, "onActivityStarted Error:", e2, new Object[0]);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i2 = this.f18337h - 1;
        this.f18337h = i2;
        if (i2 == 0) {
            this.f18338i = 0;
            ThreadPoolExecutorFactory.execute(new o(this));
        }
    }

    public void a(Application application) {
        if (f18333e == null) {
            GlobalClientInfo.a = application;
            f18333e = application;
            application.registerActivityLifecycleCallbacks(this);
        }
    }

    public void a(b bVar) {
        if (bVar != null) {
            f18332d.add(bVar);
        }
    }
}
