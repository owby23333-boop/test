package me.jessyan.art.d;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: AppManager.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile d f21175d;
    private Application a;
    private List<Activity> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Activity f21176c;

    private d() {
    }

    public static d e() {
        if (f21175d == null) {
            synchronized (d.class) {
                if (f21175d == null) {
                    f21175d = new d();
                }
            }
        }
        return f21175d;
    }

    public d a(Application application) {
        this.a = application;
        return f21175d;
    }

    @Nullable
    public Activity b() {
        return this.f21176c;
    }

    public void c(Activity activity) {
        this.f21176c = activity;
    }

    public void d() {
        synchronized (d.class) {
            Iterator<Activity> it = a().iterator();
            while (it.hasNext()) {
                Activity next = it.next();
                it.remove();
                next.finish();
            }
        }
    }

    public void startActivity(Intent intent) {
        if (c() != null) {
            c().startActivity(intent);
        } else {
            intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            this.a.startActivity(intent);
        }
    }

    public void b(Activity activity) {
        if (this.b == null) {
            return;
        }
        synchronized (d.class) {
            if (this.b.contains(activity)) {
                this.b.remove(activity);
            }
        }
    }

    @Nullable
    public Activity c() {
        List<Activity> list = this.b;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.b.get(r0.size() - 1);
    }

    public void a(Class<?>... clsArr) {
        synchronized (d.class) {
            for (Class<?> cls : clsArr) {
                a(cls);
            }
        }
    }

    public void startActivity(Class cls) {
        startActivity(new Intent(this.a, (Class<?>) cls));
    }

    public List<Activity> a() {
        if (this.b == null) {
            this.b = new LinkedList();
        }
        return this.b;
    }

    public void a(Activity activity) {
        synchronized (d.class) {
            List<Activity> listA = a();
            if (!listA.contains(activity)) {
                listA.add(activity);
            }
        }
    }

    public void a(Class<?> cls) {
        if (this.b == null) {
            return;
        }
        synchronized (d.class) {
            Iterator<Activity> it = a().iterator();
            while (it.hasNext()) {
                Activity next = it.next();
                if (next.getClass().equals(cls)) {
                    it.remove();
                    next.finish();
                }
            }
        }
    }
}
