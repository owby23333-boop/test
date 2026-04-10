package com.bytedance.sdk.component.adexpress.e.bf;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import com.yuewen.yd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ga {
    private static volatile ga e;
    private final Object d = new Object();
    private LruCache<String, com.bytedance.sdk.component.adexpress.e.d.bf> tg = new LruCache<String, com.bytedance.sdk.component.adexpress.e.d.bf>(2000) { // from class: com.bytedance.sdk.component.adexpress.e.bf.ga.1
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, com.bytedance.sdk.component.adexpress.e.d.bf bfVar) {
            return 1;
        }
    };
    private Set<String> bf = Collections.synchronizedSet(new HashSet());

    private ga() {
    }

    private void d(String str) {
        LruCache<String, com.bytedance.sdk.component.adexpress.e.d.bf> lruCache;
        if (TextUtils.isEmpty(str) || (lruCache = this.tg) == null || lruCache.size() <= 0) {
            return;
        }
        synchronized (this.d) {
            this.tg.remove(str);
        }
    }

    public static ga e() {
        if (e == null) {
            synchronized (ga.class) {
                if (e == null) {
                    e = new ga();
                }
            }
        }
        return e;
    }

    public Set<com.bytedance.sdk.component.adexpress.e.d.bf> bf(String str) {
        com.bytedance.sdk.component.adexpress.e.d.bf bfVar;
        if (TextUtils.isEmpty(str) || com.bytedance.sdk.component.adexpress.e.e.e.e().bf() == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Cursor cursorQuery = com.bytedance.sdk.component.adexpress.e.e.e.e().bf().query("template_diff_new", null, "rit=?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                        if (!TextUtils.isEmpty(string)) {
                            synchronized (this.d) {
                                bfVar = this.tg.get(string);
                            }
                            if (bfVar != null) {
                                hashSet.add(bfVar);
                            } else {
                                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("md5"));
                                String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                                String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("data"));
                                com.bytedance.sdk.component.adexpress.e.d.bf bfVarE = new com.bytedance.sdk.component.adexpress.e.d.bf().e(str).bf(string).d(string2).tg(string3).ga(string4).vn(cursorQuery.getString(cursorQuery.getColumnIndex("version"))).e(Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex(yd.m.a.c))));
                                hashSet.add(bfVarE);
                                synchronized (this.d) {
                                    this.tg.put(string, bfVarE);
                                }
                                this.bf.add(string);
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

    public static String d() {
        return "CREATE TABLE IF NOT EXISTS template_diff_new (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT ,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , version TEXT , " + yd.m.a.c + " TEXT)";
    }

    public com.bytedance.sdk.component.adexpress.e.d.bf e(String str) {
        com.bytedance.sdk.component.adexpress.e.d.bf bfVar;
        com.bytedance.sdk.component.adexpress.e.d.bf bfVarE;
        if (TextUtils.isEmpty(str) || com.bytedance.sdk.component.adexpress.e.e.e.e().bf() == null) {
            return null;
        }
        synchronized (this.d) {
            bfVar = this.tg.get(String.valueOf(str));
        }
        if (bfVar != null) {
            return bfVar;
        }
        Cursor cursorQuery = com.bytedance.sdk.component.adexpress.e.e.e.e().bf().query("template_diff_new", null, "id=?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("rit"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("md5"));
                        String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                        String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("data"));
                        bfVarE = new com.bytedance.sdk.component.adexpress.e.d.bf().e(string).bf(string2).d(string3).tg(string4).ga(string5).vn(cursorQuery.getString(cursorQuery.getColumnIndex("version"))).e(Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex(yd.m.a.c))));
                        synchronized (this.d) {
                            this.tg.put(string2, bfVarE);
                        }
                        this.bf.add(string2);
                    } while (cursorQuery.moveToNext());
                    return bfVarE;
                }
            } finally {
                try {
                } finally {
                }
            }
        }
        return null;
    }

    public List<com.bytedance.sdk.component.adexpress.e.d.bf> bf() {
        if (com.bytedance.sdk.component.adexpress.e.e.e.e().bf() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = com.bytedance.sdk.component.adexpress.e.e.e.e().bf().query("template_diff_new", null, null, null, null, null, null);
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("rit"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("md5"));
                    String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                    String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("data"));
                    arrayList.add(new com.bytedance.sdk.component.adexpress.e.d.bf().e(string).bf(string2).d(string3).tg(string4).ga(string5).vn(cursorQuery.getString(cursorQuery.getColumnIndex("version"))).e(Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex(yd.m.a.c)))));
                    synchronized (this.d) {
                        this.tg.put(string2, (com.bytedance.sdk.component.adexpress.e.d.bf) arrayList.get(arrayList.size() - 1));
                    }
                    this.bf.add(string2);
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }
        return arrayList;
    }

    public void e(com.bytedance.sdk.component.adexpress.e.d.bf bfVar) {
        if (bfVar == null || com.bytedance.sdk.component.adexpress.e.e.e.e().bf() == null || TextUtils.isEmpty(bfVar.bf())) {
            return;
        }
        Cursor cursorQuery = com.bytedance.sdk.component.adexpress.e.e.e.e().bf().query("template_diff_new", null, "id=?", new String[]{bfVar.bf()}, null, null, null);
        boolean z = cursorQuery != null && cursorQuery.getCount() > 0;
        if (cursorQuery != null) {
            try {
                cursorQuery.close();
            } catch (Throwable unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", bfVar.e());
        contentValues.put("id", bfVar.bf());
        contentValues.put("md5", bfVar.d());
        contentValues.put("url", bfVar.tg());
        contentValues.put("data", bfVar.ga());
        contentValues.put("version", bfVar.vn());
        contentValues.put(yd.m.a.c, bfVar.p());
        if (z) {
            com.bytedance.sdk.component.adexpress.e.e.e.e().bf().update("template_diff_new", contentValues, "id=?", new String[]{bfVar.bf()});
        } else {
            com.bytedance.sdk.component.adexpress.e.e.e.e().bf().insert("template_diff_new", contentValues);
        }
        synchronized (this.d) {
            this.tg.put(bfVar.bf(), bfVar);
        }
        this.bf.add(bfVar.bf());
    }

    public void e(Set<String> set) {
        if (set == null || set.isEmpty() || com.bytedance.sdk.component.adexpress.e.e.e.e().bf() == null) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                d(strArr[i]);
                com.bytedance.sdk.component.adexpress.e.e.e.e().bf().delete("template_diff_new", "id=?", new String[]{strArr[i]});
            }
        }
    }
}
