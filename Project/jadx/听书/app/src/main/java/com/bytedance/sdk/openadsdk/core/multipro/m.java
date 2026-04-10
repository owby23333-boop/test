package com.bytedance.sdk.openadsdk.core.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.ti.z.a;
import com.bytedance.sdk.openadsdk.core.zw;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class m implements a.z {
    private static List<a.z> dl;
    private static WeakReference<Context> g;
    private static volatile m z;

    private boolean g(Uri uri) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public String getTableName() {
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public void init() {
    }

    static {
        List<a.z> listSynchronizedList = Collections.synchronizedList(new ArrayList());
        dl = listSynchronizedList;
        listSynchronizedList.add(new dl());
        dl.add(new com.bytedance.sdk.openadsdk.core.multipro.z.g());
        dl.add(new com.bytedance.sdk.openadsdk.core.multipro.dl.z());
        dl.add(new z(new com.bytedance.sdk.component.gz.g.g.g.z("csj")));
        Iterator<a.z> it = dl.iterator();
        while (it.hasNext()) {
            it.next().init();
        }
    }

    public static m z(Context context) {
        if (context != null) {
            g = new WeakReference<>(context.getApplicationContext());
        }
        if (z == null) {
            synchronized (m.class) {
                if (z == null) {
                    z = new m();
                }
            }
        }
        return z;
    }

    private m() {
    }

    private a.z z(Uri uri) {
        if (uri == null || !g(uri)) {
            return null;
        }
        String[] strArrSplit = uri.getPath().split("/");
        if (strArrSplit.length < 2) {
            return null;
        }
        String str = strArrSplit[1];
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (a.z zVar : dl) {
            if (str.equals(zVar.getTableName())) {
                return zVar;
            }
        }
        return null;
    }

    private Context getContext() {
        WeakReference<Context> weakReference = g;
        return (weakReference == null || weakReference.get() == null) ? zw.getContext() : g.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public void injectContext(Context context) {
        Iterator<a.z> it = dl.iterator();
        while (it.hasNext()) {
            it.next().injectContext(context);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            a.z zVarZ = z(uri);
            if (zVarZ != null) {
                return zVarZ.query(uri, strArr, str, strArr2, str2);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public String getType(Uri uri) {
        try {
            a.z zVarZ = z(uri);
            if (zVarZ != null) {
                return zVarZ.getType(uri);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public Uri insert(Uri uri, ContentValues contentValues) {
        try {
            a.z zVarZ = z(uri);
            if (zVarZ != null) {
                return zVarZ.insert(uri, contentValues);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public int delete(Uri uri, String str, String[] strArr) {
        try {
            a.z zVarZ = z(uri);
            if (zVarZ != null) {
                return zVarZ.delete(uri, str, strArr);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            a.z zVarZ = z(uri);
            if (zVarZ != null) {
                return zVarZ.update(uri, contentValues, str, strArr);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }
}
