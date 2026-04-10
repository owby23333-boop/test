package com.bytedance.sdk.component.m.dl;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.m.dl.dl;
import com.bytedance.sdk.component.m.iq;
import com.bytedance.sdk.component.m.js;
import com.bytedance.sdk.component.m.l;
import com.bytedance.sdk.component.m.pf;
import com.bytedance.sdk.component.m.v;
import com.bytedance.sdk.component.utils.wp;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g implements iq, Function {
    private volatile m z;

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                v vVarFrom = from((String) sparseArray.get(1));
                return vVarFrom != null ? new pf(vVarFrom) : vVarFrom;
            case 2:
                z(((Double) sparseArray.get(1)).doubleValue());
                return null;
            case 3:
                clearMemoryCache(((Double) sparseArray.get(1)).doubleValue());
                return null;
            case 4:
                g(((Double) sparseArray.get(1)).doubleValue());
                return null;
            case 5:
                z();
                return null;
            case 6:
                return getCacheStream((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 7:
                return z((String) sparseArray.get(1), (String) sparseArray.get(2), (String) sparseArray.get(3));
            case 8:
                return Boolean.valueOf(g((String) sparseArray.get(1), (String) sparseArray.get(2), (String) sparseArray.get(3)));
            default:
                return null;
        }
    }

    private g() {
    }

    public static iq z(Context context, js jsVar) {
        g gVar = new g();
        gVar.g(context, jsVar);
        return gVar;
    }

    private void g(Context context, js jsVar) {
        if (this.z != null) {
            wp.g("ImageLoader", "already init!");
        }
        if (jsVar == null) {
            jsVar = gc.z(context);
        }
        this.z = new m(context, jsVar);
    }

    @Override // com.bytedance.sdk.component.m.iq
    public v from(String str) {
        return new dl.g(this.z).from(str);
    }

    public void z(double d) {
        clearMemoryCache(d);
        g(d);
    }

    @Override // com.bytedance.sdk.component.m.iq
    public void clearMemoryCache(double d) {
        if (this.z != null) {
            z(this.z.z(), d);
            z(this.z.g(), d);
        }
    }

    public void g(double d) {
        if (this.z != null) {
            z(this.z.dl(), d);
        }
    }

    private void z(Collection<? extends com.bytedance.sdk.component.m.z> collection, double d) {
        if (collection == null) {
            return;
        }
        Iterator<? extends com.bytedance.sdk.component.m.z> it = collection.iterator();
        while (it.hasNext()) {
            it.next().z(d);
        }
    }

    public void z() {
        g(0.0d);
        clearMemoryCache(0.0d);
    }

    @Override // com.bytedance.sdk.component.m.iq
    public InputStream getCacheStream(String str, String str2) {
        if (this.z != null) {
            if (TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                str2 = com.bytedance.sdk.component.m.dl.dl.dl.z(str);
            }
            Collection<l> collectionG = this.z.g();
            if (collectionG != null) {
                Iterator<l> it = collectionG.iterator();
                while (it.hasNext()) {
                    byte[] bArrZ = it.next().z(str2);
                    if (bArrZ != null) {
                        return new ByteArrayInputStream(bArrZ);
                    }
                }
            }
            Collection<com.bytedance.sdk.component.m.a> collectionDl = this.z.dl();
            if (collectionDl != null) {
                Iterator<com.bytedance.sdk.component.m.a> it2 = collectionDl.iterator();
                while (it2.hasNext()) {
                    InputStream inputStreamZ = it2.next().z(str2);
                    if (inputStreamZ != null) {
                        return inputStreamZ;
                    }
                }
            }
        }
        return null;
    }

    public InputStream z(String str, String str2, String str3) {
        if (this.z == null || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            str2 = com.bytedance.sdk.component.m.dl.dl.dl.z(str);
        }
        com.bytedance.sdk.component.m.a aVarZ = this.z.z(str3);
        if (aVarZ != null) {
            return aVarZ.z(str2);
        }
        return null;
    }

    public boolean g(String str, String str2, String str3) {
        if (this.z == null || TextUtils.isEmpty(str3)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            str2 = com.bytedance.sdk.component.m.dl.dl.dl.z(str);
        }
        com.bytedance.sdk.component.m.a aVarZ = this.z.z(str3);
        if (aVarZ != null) {
            return aVarZ.g(str2);
        }
        return false;
    }
}
