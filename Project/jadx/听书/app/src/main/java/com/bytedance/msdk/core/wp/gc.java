package com.bytedance.msdk.core.wp;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedance.msdk.gz.hh;
import com.bytedance.sdk.component.utils.wp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static gc f421a;
    private final Set<String> z = new HashSet(1);
    private final List<m> g = new ArrayList(1);
    private final List<WeakReference<m>> dl = new ArrayList(1);

    public static gc z() {
        if (f421a == null) {
            f421a = new gc();
        }
        return f421a;
    }

    private gc() {
        g();
    }

    private void g() {
        PackageInfo packageInfo;
        String[] strArr;
        Context context = com.bytedance.msdk.core.g.getContext();
        if (context == null) {
            return;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(packageName, 4096)) != null && (strArr = packageInfo.requestedPermissions) != null && strArr.length != 0) {
                for (int i = 0; i < strArr.length; i++) {
                    if (!TextUtils.isEmpty(strArr[i])) {
                        this.z.add(strArr[i]);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private synchronized void z(String[] strArr, m mVar) {
        if (mVar != null) {
            mVar.z(strArr);
            this.g.add(mVar);
            this.dl.add(new WeakReference<>(mVar));
        }
    }

    private synchronized void z(m mVar) {
        Iterator<WeakReference<m>> it = this.dl.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            if (next.get() == mVar || next.get() == null) {
                it.remove();
            }
        }
        Iterator<m> it2 = this.g.iterator();
        while (it2.hasNext()) {
            if (it2.next() == mVar) {
                it2.remove();
            }
        }
    }

    public synchronized boolean z(Context context, String str) {
        if (context != null) {
            return hh.gc() ? g.z(context, str) && (dl.z(context, str) == 0 || !this.z.contains(str)) : dl.z(context, str) == 0 || !this.z.contains(str);
        }
        return false;
    }

    public synchronized void z(Activity activity, String[] strArr, m mVar) {
        if (activity != null) {
            try {
                z(strArr, mVar);
                List<String> listDl = dl(activity, strArr, mVar);
                if (listDl.isEmpty()) {
                    z(mVar);
                } else {
                    dl.requestPermissions(activity, (String[]) listDl.toArray(new String[listDl.size()]), 1);
                }
            } catch (Throwable th) {
                wp.z(th);
            }
        }
    }

    private void g(Activity activity, String[] strArr, m mVar) {
        boolean z;
        for (String str : strArr) {
            if (mVar != null) {
                try {
                    if (!this.z.contains(str)) {
                        z = mVar.z(str, a.NOT_FOUND);
                    } else if (dl.z(activity, str) != 0) {
                        z = mVar.z(str, a.DENIED);
                    } else {
                        z = mVar.z(str, a.GRANTED);
                    }
                    if (z) {
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
            if (this.z.contains(str)) {
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
                if ((iArr[i] == -1 || (hh.gc() && !g.z(activity, str))) && iArr[i] != -1) {
                    iArr[i] = -1;
                }
            }
            z(strArr, iArr);
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    private void z(String[] strArr, int[] iArr) {
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
            Iterator<m> it2 = this.g.iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }
}
