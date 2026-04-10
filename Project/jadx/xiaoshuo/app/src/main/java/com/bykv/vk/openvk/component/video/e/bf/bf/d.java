package com.bykv.vk.openvk.component.video.e.bf.bf;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.zk.v;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static volatile d bf;
    private final tg d;
    private final SparseArray<Map<String, e>> e;
    private volatile SQLiteStatement ga;
    private final Executor tg;

    private d(Context context) {
        SparseArray<Map<String, e>> sparseArray = new SparseArray<>(2);
        this.e = sparseArray;
        this.tg = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new v(5, "video_proxy_db"));
        this.d = new tg(context.getApplicationContext());
        sparseArray.put(0, new ConcurrentHashMap());
        sparseArray.put(1, new ConcurrentHashMap());
    }

    public void delete(final String str, final int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Map<String, e> map = this.e.get(i);
        if (map != null) {
            map.remove(str);
        }
        this.tg.execute(new Runnable() { // from class: com.bykv.vk.openvk.component.video.e.bf.bf.d.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    d.this.d.getWritableDatabase().delete("video_http_header_t", "key=? AND flag=?", new String[]{str, String.valueOf(i)});
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void insert(final e eVar) {
        if (eVar != null) {
            Map<String, e> map = this.e.get(eVar.tg);
            if (map != null) {
                map.put(eVar.e, eVar);
            }
            this.tg.execute(new Runnable() { // from class: com.bykv.vk.openvk.component.video.e.bf.bf.d.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (d.this.ga == null) {
                            d dVar = d.this;
                            dVar.ga = dVar.d.getWritableDatabase().compileStatement("INSERT INTO video_http_header_t (key,mime,contentLength,flag,extra) VALUES(?,?,?,?,?)");
                        } else {
                            d.this.ga.clearBindings();
                        }
                        d.this.ga.bindString(1, eVar.e);
                        d.this.ga.bindString(2, eVar.bf);
                        d.this.ga.bindLong(3, eVar.d);
                        d.this.ga.bindLong(4, eVar.tg);
                        d.this.ga.bindString(5, eVar.ga);
                        d.this.ga.executeInsert();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public e query(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, e> map = this.e.get(i);
        e eVar = map == null ? null : map.get(str);
        if (eVar != null) {
            return eVar;
        }
        try {
            Cursor cursorQuery = this.d.getReadableDatabase().query("video_http_header_t", null, "key=? AND flag=?", new String[]{str, String.valueOf(i)}, null, null, null, "1");
            if (cursorQuery != null) {
                if (cursorQuery.getCount() > 0 && cursorQuery.moveToNext()) {
                    eVar = new e(cursorQuery.getString(cursorQuery.getColumnIndex("key")), cursorQuery.getString(cursorQuery.getColumnIndex("mime")), cursorQuery.getInt(cursorQuery.getColumnIndex("contentLength")), i, cursorQuery.getString(cursorQuery.getColumnIndex("extra")));
                }
                cursorQuery.close();
            }
            if (eVar != null && map != null) {
                map.put(str, eVar);
            }
            return eVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    private String bf(int i) {
        if (i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i << 1);
        sb.append("?");
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(",?");
        }
        return sb.toString();
    }

    public static d e(Context context) {
        if (bf == null) {
            synchronized (d.class) {
                if (bf == null) {
                    bf = new d(context);
                }
            }
        }
        return bf;
    }

    public void e(Collection<String> collection, int i) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        int size = collection.size() + 1;
        String[] strArr = new String[size];
        Map<String, e> map = this.e.get(i);
        int i2 = -1;
        for (String str : collection) {
            if (map != null) {
                map.remove(str);
            }
            i2++;
            strArr[i2] = str;
        }
        strArr[i2 + 1] = String.valueOf(i);
        try {
            this.d.getWritableDatabase().delete("video_http_header_t", "key IN(" + bf(size) + ") AND flag=?", strArr);
        } catch (Throwable unused) {
        }
    }

    public void e(final int i) {
        Map<String, e> map = this.e.get(i);
        if (map != null) {
            map.clear();
        }
        this.tg.execute(new Runnable() { // from class: com.bykv.vk.openvk.component.video.e.bf.bf.d.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    d.this.d.getWritableDatabase().delete("video_http_header_t", "flag=?", new String[]{String.valueOf(i)});
                } catch (Throwable unused) {
                }
            }
        });
    }
}
