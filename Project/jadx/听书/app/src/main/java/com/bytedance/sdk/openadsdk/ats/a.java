package com.bytedance.sdk.openadsdk.ats;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.SparseArray;
import com.bytedance.sdk.component.a.fo;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.zw;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class a implements fo, Function {
    private static final Set<String> dl = new HashSet();
    private static File g;
    private Map<String, com.bytedance.sdk.component.a.g.dl> z = new ConcurrentHashMap();

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            com.bytedance.sdk.component.a.g.dl dlVar = get((String) sparseArray.get(1));
            return dlVar != null ? new com.bytedance.sdk.component.a.g.a(dlVar) : dlVar;
        }
        if (iIntValue == 2) {
            com.bytedance.sdk.component.a.g.dl dlVarZ = z((String) sparseArray.get(1), ((Integer) sparseArray.get(2)).intValue());
            return dlVarZ != null ? new com.bytedance.sdk.component.a.g.a(dlVarZ) : dlVarZ;
        }
        if (iIntValue == 3) {
            com.bytedance.sdk.component.a.g.z encrypt = getEncrypt(((Integer) sparseArray.get(1)).intValue());
            return encrypt != null ? new com.bytedance.sdk.component.a.g.g(encrypt) : encrypt;
        }
        if (iIntValue == 4) {
            store();
            return null;
        }
        if (iIntValue != 5) {
            return null;
        }
        z();
        return null;
    }

    public a() {
        dl.add("sp_bidding_opt_libra");
    }

    @Override // com.bytedance.sdk.component.a.fo
    public com.bytedance.sdk.component.a.g.dl get(String str) {
        if (str == null) {
            str = "tt_sp";
        }
        com.bytedance.sdk.component.a.g.dl dlVar = this.z.get(str);
        if (dlVar != null) {
            return dlVar;
        }
        synchronized (this.z) {
            com.bytedance.sdk.component.a.g.dl dlVar2 = this.z.get(str);
            if (dlVar2 != null) {
                return dlVar2;
            }
            com.bytedance.sdk.component.a.g.dl dlVarDl = dl(str);
            this.z.put(str, dlVarDl);
            return dlVarDl;
        }
    }

    private com.bytedance.sdk.component.a.g.dl dl(String str) {
        int iIb = zw.g().ib();
        com.bytedance.sdk.openadsdk.core.gk.m mVarGd = zw.g().gd();
        if (iIb == 3 && Build.VERSION.SDK_INT != 27) {
            File fileG = g(str);
            return new com.bytedance.sdk.component.e.dl.dl(fileG, z(fileG, str), z(str, mVarGd.z), mVarGd.g);
        }
        return new com.bytedance.sdk.component.e.dl.a(zw.getContext().getSharedPreferences(a(str), 0));
    }

    public com.bytedance.sdk.component.a.g.dl z(String str, int i) {
        return get(str);
    }

    private com.bytedance.sdk.component.e.z z(File file, String str) {
        if (dl.contains(str)) {
            return g();
        }
        if (gk.dl >= 6900) {
            z(file);
            return new com.bytedance.sdk.component.e.dl.z(null);
        }
        return g();
    }

    private com.bytedance.sdk.component.e.g z(String str, boolean z) {
        if (dl.contains(str)) {
            return dl();
        }
        com.bytedance.sdk.component.e.z.z zVar = z ? new com.bytedance.sdk.component.e.z.z() : null;
        if (Build.VERSION.SDK_INT != 27 && gk.dl >= 6900) {
            return new com.bytedance.sdk.component.e.dl.z(zVar);
        }
        return dl();
    }

    private com.bytedance.sdk.component.e.z g() {
        if (com.bytedance.sdk.component.e.dl.gc.z()) {
            return new com.bytedance.sdk.component.e.dl.gc(null);
        }
        return new com.bytedance.sdk.component.e.dl.m(null);
    }

    private com.bytedance.sdk.component.e.g dl() {
        if (com.bytedance.sdk.component.e.dl.gc.z()) {
            return new com.bytedance.sdk.component.e.dl.gc(null);
        }
        return new com.bytedance.sdk.component.e.dl.m(null);
    }

    private void z(File file) {
        File file2 = new File(file.getParent(), file.getName() + ".prop");
        if (!file2.exists() || file2.length() <= 0) {
            return;
        }
        file.delete();
    }

    @Override // com.bytedance.sdk.component.a.fo
    public com.bytedance.sdk.component.a.g.z getEncrypt(int i) {
        if (i != 32) {
            return null;
        }
        return new com.bytedance.sdk.component.e.z.z();
    }

    @Override // com.bytedance.sdk.component.a.fo
    public void store() {
        Iterator<String> it = this.z.keySet().iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.component.a.g.dl dlVar = this.z.get(it.next());
            if (dlVar != null) {
                dlVar.apply();
            }
        }
    }

    public void z() {
        synchronized (this.z) {
            this.z.clear();
        }
    }

    public static com.bytedance.sdk.component.a.g.dl z(String str) {
        return ((fo) dl.z("kv_store_factory")).get(str);
    }

    public static SharedPreferences z(Context context, String str, int i) {
        return z(str);
    }

    private static File a() {
        String name;
        File filesDir = zw.getContext().getFilesDir();
        do {
            name = filesDir.getName();
            if (name == null) {
                break;
            }
            filesDir = filesDir.getParentFile();
        } while (!name.equals("files"));
        return new File(filesDir, "shared_prefs");
    }

    public static File g(String str) {
        if (g == null) {
            g = a();
        }
        return new File(g, a(str) + ".xml");
    }

    private static String a(String str) {
        return !str.startsWith("pangle_") ? "pangle_com.byted.pangle_".concat(String.valueOf(str)) : str;
    }
}
