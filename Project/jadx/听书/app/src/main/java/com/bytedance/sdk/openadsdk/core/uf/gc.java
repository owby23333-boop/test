package com.bytedance.sdk.openadsdk.core.uf;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.un.sy;
import com.bytedance.sdk.openadsdk.core.zw;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    private static volatile gc gc = null;
    private static final String z = "gc";
    private final CopyOnWriteArraySet<String> g = new CopyOnWriteArraySet<>();
    private final List<WeakReference<m>> dl = new ArrayList(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<m> f1328a = new ArrayList(1);

    public static gc z() {
        if (gc == null) {
            synchronized (gc.class) {
                if (gc == null) {
                    gc = new gc();
                }
            }
        }
        return gc;
    }

    private gc() {
        g();
    }

    private void g() {
        dl();
    }

    private void dl() {
        PackageInfo packageInfo;
        String[] strArr;
        Context context = zw.getContext();
        if (context == null) {
            return;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(packageName, 4096)) != null && (strArr = packageInfo.requestedPermissions) != null && strArr.length != 0) {
                for (int i = 0; i < strArr.length; i++) {
                    if (!TextUtils.isEmpty(strArr[i])) {
                        this.g.add(strArr[i]);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private synchronized void z(String[] strArr, m mVar) {
        if (mVar == null) {
            return;
        }
        mVar.z(strArr);
        this.f1328a.add(mVar);
        this.dl.add(new WeakReference<>(mVar));
    }

    private synchronized void z(m mVar) {
        Iterator<WeakReference<m>> it = this.dl.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            if (next.get() == mVar || next.get() == null) {
                it.remove();
            }
        }
        Iterator<m> it2 = this.f1328a.iterator();
        while (it2.hasNext()) {
            if (it2.next() == mVar) {
                it2.remove();
            }
        }
    }

    public boolean z(Context context, String str) {
        if (context == null) {
            return false;
        }
        return sy.ls() ? dl.z(context, str) && g.z(context, str) == 0 : g.z(context, str) == 0;
    }

    public boolean g(Context context, String str) {
        if (context == null) {
            return false;
        }
        return sy.ls() ? dl.z(context, str) && g.z(context, str) == 0 : g.z(context, str) == 0;
    }

    public synchronized void z(Activity activity, String[] strArr, m mVar) {
        if (activity == null) {
            return;
        }
        try {
            z(strArr, mVar);
            List<String> listDl = dl(activity, strArr, mVar);
            if (listDl.isEmpty()) {
                z(mVar);
            } else {
                g.requestPermissions(activity, (String[]) listDl.toArray(new String[listDl.size()]), 1);
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    private void g(Activity activity, String[] strArr, m mVar) {
        boolean z2;
        for (String str : strArr) {
            if (mVar != null) {
                try {
                    if (!this.g.contains(str)) {
                        z2 = mVar.z(str, a.NOT_FOUND);
                    } else if (g.z(activity, str) != 0) {
                        z2 = mVar.z(str, a.DENIED);
                    } else {
                        z2 = mVar.z(str, a.GRANTED);
                    }
                    if (z2) {
                        break;
                    }
                } catch (Throwable th) {
                    wp.z(th);
                }
            }
        }
        z(mVar);
    }

    private List<String> dl(Activity activity, String[] strArr, m mVar) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (this.g.contains(str)) {
                if (!z(activity, str)) {
                    arrayList.add(str);
                } else if (mVar != null) {
                    mVar.z(str, a.GRANTED);
                }
            } else if (mVar != null) {
                mVar.z(str, a.NOT_FOUND);
            }
        }
        return arrayList;
    }

    public synchronized void z(Activity activity, String[] strArr, int[] iArr) {
        try {
            new ArrayList(3);
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String str = strArr[i];
                if ((iArr[i] == -1 || (sy.ls() && !dl.z(activity, str))) && iArr[i] != -1) {
                    iArr[i] = -1;
                }
            }
            z(strArr, iArr, (String[]) null);
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    private void z(String[] strArr, int[] iArr, String[] strArr2) {
        int i;
        try {
            int length = strArr.length;
            if (iArr.length < length) {
                length = iArr.length;
            }
            Iterator<WeakReference<m>> it = this.dl.iterator();
            while (it.hasNext()) {
                m mVar = it.next().get();
                while (i < length) {
                    i = (mVar == null || mVar.z(strArr[i], iArr[i])) ? 0 : i + 1;
                    it.remove();
                    break;
                }
            }
            Iterator<m> it2 = this.f1328a.iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }
}
