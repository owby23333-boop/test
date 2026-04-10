package com.bytedance.sdk.openadsdk.core.nativeexpress.z;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.zw;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private static volatile dl g = null;
    public static int z = 20;
    private volatile ConcurrentHashMap<String, com.bytedance.sdk.component.adexpress.z.dl.dl> gc;
    private final Object dl = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LruCache<String, z> f1286a = new LruCache<String, z>(z) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.z.dl.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, z zVar) {
            return 1;
        }
    };
    private AtomicBoolean m = new AtomicBoolean(false);

    public static String dl() {
        return "CREATE TABLE IF NOT EXISTS ugen_template (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , rit TEXT , update_time TEXT)";
    }

    private dl() {
    }

    public static dl z() {
        if (g == null) {
            synchronized (dl.class) {
                if (g == null) {
                    g = new dl();
                }
            }
        }
        return g;
    }

    z z(String str, String str2) {
        z zVar;
        z zVarZ;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.dl) {
            zVar = this.f1286a.get(str);
        }
        if (zVar != null) {
            if (TextUtils.equals(str2, zVar.g())) {
                return zVar;
            }
            dl(str2);
            return null;
        }
        Cursor cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.z.z.query(zw.getContext(), "ugen_template", null, "id=? AND md5=?", new String[]{str, str2}, null, null, null);
        if (cursorQuery == null) {
            return null;
        }
        try {
        } catch (Throwable th) {
            try {
                wp.dl("UGTmplDbHelper", "getGgenTemplate error", th);
                if (cursorQuery != null) {
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        if (!cursorQuery.moveToFirst()) {
            if (cursorQuery != null) {
            }
            return null;
        }
        do {
            int columnIndex = cursorQuery.getColumnIndex("id");
            int columnIndex2 = cursorQuery.getColumnIndex(TKDownloadReason.KSAD_TK_MD5);
            int columnIndex3 = cursorQuery.getColumnIndex("url");
            int columnIndex4 = cursorQuery.getColumnIndex("data");
            int columnIndex5 = cursorQuery.getColumnIndex("update_time");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex5 != -1 && columnIndex4 != -1) {
                int columnIndex6 = cursorQuery.getColumnIndex("rit");
                String string = cursorQuery.getString(columnIndex);
                String string2 = cursorQuery.getString(columnIndex2);
                zVarZ = new z().z(string).g(string2).a(cursorQuery.getString(columnIndex4)).dl(cursorQuery.getString(columnIndex3)).gc(columnIndex6 != -1 ? cursorQuery.getString(columnIndex6) : null).z(Long.valueOf(cursorQuery.getLong(columnIndex5)));
                synchronized (this.dl) {
                    this.f1286a.put(string, zVarZ);
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } while (cursorQuery.moveToNext());
        return zVarZ;
        cursorQuery.close();
        return null;
    }

    void z(z zVar, boolean z2) {
        if (zVar == null || TextUtils.isEmpty(zVar.z())) {
            return;
        }
        Cursor cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.z.z.query(zw.getContext(), "ugen_template", null, "id=?", new String[]{zVar.z()}, null, null, null);
        boolean z3 = cursorQuery != null && cursorQuery.getCount() > 0;
        if (z3) {
            try {
                string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("rit")) : null;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", zVar.z());
        contentValues.put(TKDownloadReason.KSAD_TK_MD5, zVar.g());
        contentValues.put("url", zVar.dl());
        contentValues.put("data", zVar.gc());
        contentValues.put("rit", zVar.m());
        contentValues.put("update_time", zVar.a());
        if (z3) {
            com.bytedance.sdk.openadsdk.core.multipro.z.z.update(zw.getContext(), "ugen_template", contentValues, "id=?", new String[]{zVar.z()});
        } else {
            com.bytedance.sdk.openadsdk.core.multipro.z.z.insert(zw.getContext(), "ugen_template", contentValues);
        }
        synchronized (this.dl) {
            this.f1286a.put(zVar.z(), zVar);
        }
        if (z2) {
            return;
        }
        try {
            if (this.gc == null) {
                this.gc = new ConcurrentHashMap<>();
            }
            com.bytedance.sdk.component.adexpress.z.dl.dl dlVar = new com.bytedance.sdk.component.adexpress.z.dl.dl(zVar.m(), zVar.z(), zVar.g());
            this.gc.put(zVar.z(), dlVar);
            if (string != null) {
                com.bytedance.sdk.openadsdk.core.dl.g.z().delete(string, dlVar.g(), true);
            }
            com.bytedance.sdk.openadsdk.core.dl.g.z().update(zVar.m(), dlVar, true);
        } catch (Throwable unused2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00e1 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.util.List<com.bytedance.sdk.openadsdk.core.nativeexpress.z.z> g() {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.z.dl.g():java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00cf A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.util.Set<com.bytedance.sdk.openadsdk.core.nativeexpress.z.z> z(java.lang.String r10) {
        /*
            Method dump skipped, instruction units count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.z.dl.z(java.lang.String):java.util.Set");
    }

    void z(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                dl(strArr[i]);
                com.bytedance.sdk.openadsdk.core.multipro.z.z.delete(zw.getContext(), "ugen_template", "id=?", new String[]{strArr[i]});
                g(strArr[i]);
            }
        }
    }

    void g(String str) {
        com.bytedance.sdk.component.adexpress.z.dl.dl dlVar;
        try {
            if (this.gc == null || this.gc.isEmpty() || (dlVar = this.gc.get(str)) == null) {
                return;
            }
            String strZ = dlVar.z();
            if (!TextUtils.isEmpty(strZ)) {
                com.bytedance.sdk.openadsdk.core.dl.g.z().delete(strZ, str, true);
            }
            this.gc.remove(str);
        } catch (Throwable unused) {
        }
    }

    private void dl(String str) {
        if (!TextUtils.isEmpty(str) && this.f1286a.size() > 0) {
            synchronized (this.dl) {
                this.f1286a.remove(str);
            }
        }
    }
}
