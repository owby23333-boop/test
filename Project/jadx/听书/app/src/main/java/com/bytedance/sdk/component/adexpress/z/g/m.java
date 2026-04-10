package com.bytedance.sdk.component.adexpress.z.g;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private static volatile m g = null;
    public static int z = 2000;
    private volatile ConcurrentHashMap<String, com.bytedance.sdk.component.adexpress.z.dl.dl> gc;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f621a = new Object();
    private AtomicBoolean m = new AtomicBoolean(false);
    private LruCache<String, com.bytedance.sdk.component.adexpress.z.dl.g> e = new LruCache<String, com.bytedance.sdk.component.adexpress.z.dl.g>(z) { // from class: com.bytedance.sdk.component.adexpress.z.g.m.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, com.bytedance.sdk.component.adexpress.z.dl.g gVar) {
            return 1;
        }
    };
    private Set<String> dl = Collections.synchronizedSet(new HashSet());

    public static String dl() {
        return "CREATE TABLE IF NOT EXISTS template_diff_new (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT ,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , version TEXT , update_time TEXT)";
    }

    public static m z() {
        if (g == null) {
            synchronized (m.class) {
                if (g == null) {
                    g = new m();
                }
            }
        }
        return g;
    }

    private m() {
    }

    com.bytedance.sdk.component.adexpress.z.dl.g z(String str) {
        com.bytedance.sdk.component.adexpress.z.dl.g gVar;
        com.bytedance.sdk.component.adexpress.z.dl.g gVarZ;
        if (TextUtils.isEmpty(str) || com.bytedance.sdk.component.adexpress.z.z.z.z().g() == null) {
            return null;
        }
        synchronized (this.f621a) {
            gVar = this.e.get(String.valueOf(str));
        }
        if (gVar != null) {
            return gVar;
        }
        Cursor cursorQuery = com.bytedance.sdk.component.adexpress.z.z.z.z().g().query("template_diff_new", null, "id=?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("rit"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex(TKDownloadReason.KSAD_TK_MD5));
                        String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                        String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("data"));
                        gVarZ = new com.bytedance.sdk.component.adexpress.z.dl.g().z(string).g(string2).dl(string3).a(string4).gc(string5).m(cursorQuery.getString(cursorQuery.getColumnIndex("version"))).z(Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("update_time"))));
                        synchronized (this.f621a) {
                            this.e.put(string2, gVarZ);
                        }
                        this.dl.add(string2);
                    } while (cursorQuery.moveToNext());
                    return gVarZ;
                }
            } finally {
                try {
                } finally {
                }
            }
        }
        return null;
    }

    Set<com.bytedance.sdk.component.adexpress.z.dl.g> g(String str) {
        com.bytedance.sdk.component.adexpress.z.dl.g gVar;
        if (TextUtils.isEmpty(str) || com.bytedance.sdk.component.adexpress.z.z.z.z().g() == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Cursor cursorQuery = com.bytedance.sdk.component.adexpress.z.z.z.z().g().query("template_diff_new", null, "rit=?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                        if (!TextUtils.isEmpty(string)) {
                            synchronized (this.f621a) {
                                gVar = this.e.get(string);
                            }
                            if (gVar != null) {
                                hashSet.add(gVar);
                            } else {
                                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(TKDownloadReason.KSAD_TK_MD5));
                                String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                                String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("data"));
                                com.bytedance.sdk.component.adexpress.z.dl.g gVarZ = new com.bytedance.sdk.component.adexpress.z.dl.g().z(str).g(string).dl(string2).a(string3).gc(string4).m(cursorQuery.getString(cursorQuery.getColumnIndex("version"))).z(Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("update_time"))));
                                hashSet.add(gVarZ);
                                synchronized (this.f621a) {
                                    this.e.put(string, gVarZ);
                                }
                                this.dl.add(string);
                            }
                        }
                    } while (cursorQuery.moveToNext());
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
            cursorQuery.close();
        }
        return hashSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00f0 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.util.List<com.bytedance.sdk.component.adexpress.z.dl.g> g() {
        /*
            Method dump skipped, instruction units count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.z.g.m.g():java.util.List");
    }

    void z(com.bytedance.sdk.component.adexpress.z.dl.g gVar, boolean z2) {
        if (gVar == null || com.bytedance.sdk.component.adexpress.z.z.z.z().g() == null || TextUtils.isEmpty(gVar.g())) {
            return;
        }
        Cursor cursorQuery = com.bytedance.sdk.component.adexpress.z.z.z.z().g().query("template_diff_new", null, "id=?", new String[]{gVar.g()}, null, null, null);
        boolean z3 = cursorQuery != null && cursorQuery.getCount() > 0;
        if (cursorQuery != null) {
            try {
                string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("rit")) : null;
                cursorQuery.close();
            } catch (Throwable unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", gVar.z());
        contentValues.put("id", gVar.g());
        contentValues.put(TKDownloadReason.KSAD_TK_MD5, gVar.dl());
        contentValues.put("url", gVar.a());
        contentValues.put("data", gVar.gc());
        contentValues.put("version", gVar.m());
        contentValues.put("update_time", gVar.e());
        if (z3) {
            com.bytedance.sdk.component.adexpress.z.z.z.z().g().update("template_diff_new", contentValues, "id=?", new String[]{gVar.g()});
        } else {
            com.bytedance.sdk.component.adexpress.z.z.z.z().g().insert("template_diff_new", contentValues);
        }
        synchronized (this.f621a) {
            this.e.put(gVar.g(), gVar);
        }
        this.dl.add(gVar.g());
        if (z2) {
            return;
        }
        try {
            if (com.bytedance.sdk.component.adexpress.z.z.z.z().m() == null) {
                return;
            }
            if (this.gc == null) {
                this.gc = new ConcurrentHashMap<>();
            }
            com.bytedance.sdk.component.adexpress.z.dl.dl dlVar = new com.bytedance.sdk.component.adexpress.z.dl.dl(gVar.z(), gVar.g(), gVar.dl());
            this.gc.put(gVar.g(), dlVar);
            if (string != null) {
                com.bytedance.sdk.component.adexpress.z.z.z.z().m().delete(string, dlVar.g());
            }
            com.bytedance.sdk.component.adexpress.z.z.z.z().m().update(gVar.z(), dlVar);
        } catch (Throwable unused2) {
        }
    }

    void z(Set<String> set) {
        if (set == null || set.isEmpty() || com.bytedance.sdk.component.adexpress.z.z.z.z().g() == null) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                a(strArr[i]);
                com.bytedance.sdk.component.adexpress.z.z.z.z().g().delete("template_diff_new", "id=?", new String[]{strArr[i]});
                dl(strArr[i]);
            }
        }
    }

    void dl(String str) {
        com.bytedance.sdk.component.adexpress.z.dl.dl dlVar;
        try {
            if (this.gc == null || this.gc.isEmpty() || (dlVar = this.gc.get(str)) == null) {
                return;
            }
            String strZ = dlVar.z();
            if (!TextUtils.isEmpty(strZ) && com.bytedance.sdk.component.adexpress.z.z.z.z().m() != null) {
                com.bytedance.sdk.component.adexpress.z.z.z.z().m().delete(strZ, str);
            }
            this.gc.remove(str);
        } catch (Throwable unused) {
        }
    }

    private void a(String str) {
        LruCache<String, com.bytedance.sdk.component.adexpress.z.dl.g> lruCache;
        if (TextUtils.isEmpty(str) || (lruCache = this.e) == null || lruCache.size() <= 0) {
            return;
        }
        synchronized (this.f621a) {
            this.e.remove(str);
        }
    }
}
