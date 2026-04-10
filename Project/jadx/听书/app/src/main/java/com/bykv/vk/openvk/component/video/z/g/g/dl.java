package com.bykv.vk.openvk.component.video.z.g.g;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.uy.uy;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private static volatile dl g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f109a;
    private final a dl;
    private volatile SQLiteStatement gc;
    private final SparseArray<Map<String, z>> z;

    private dl(Context context) {
        SparseArray<Map<String, z>> sparseArray = new SparseArray<>(2);
        this.z = sparseArray;
        this.f109a = new com.bytedance.sdk.component.uy.a.a(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new uy(5, "video_proxy_db"));
        this.dl = new a(context.getApplicationContext());
        sparseArray.put(0, new ConcurrentHashMap());
        sparseArray.put(1, new ConcurrentHashMap());
    }

    public static dl z(Context context) {
        if (g == null) {
            synchronized (dl.class) {
                if (g == null) {
                    g = new dl(context);
                }
            }
        }
        return g;
    }

    public z query(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, z> map = this.z.get(i);
        z zVar = map == null ? null : map.get(str);
        if (zVar != null) {
            return zVar;
        }
        try {
            Cursor cursorQuery = this.dl.getReadableDatabase().query("video_http_header_t", null, "key=? AND flag=?", new String[]{str, String.valueOf(i)}, null, null, null, "1");
            if (cursorQuery != null) {
                if (cursorQuery.getCount() > 0 && cursorQuery.moveToNext()) {
                    zVar = new z(cursorQuery.getString(cursorQuery.getColumnIndex("key")), cursorQuery.getString(cursorQuery.getColumnIndex("mime")), cursorQuery.getInt(cursorQuery.getColumnIndex("contentLength")), i, cursorQuery.getString(cursorQuery.getColumnIndex("extra")));
                }
                cursorQuery.close();
            }
            if (zVar != null && map != null) {
                map.put(str, zVar);
            }
            return zVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void insert(final z zVar) {
        if (zVar != null) {
            Map<String, z> map = this.z.get(zVar.f110a);
            if (map != null) {
                map.put(zVar.z, zVar);
            }
            this.f109a.execute(new Runnable() { // from class: com.bykv.vk.openvk.component.video.z.g.g.dl.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (dl.this.gc != null) {
                            dl.this.gc.clearBindings();
                        } else {
                            dl dlVar = dl.this;
                            dlVar.gc = dlVar.dl.getWritableDatabase().compileStatement("INSERT INTO video_http_header_t (key,mime,contentLength,flag,extra) VALUES(?,?,?,?,?)");
                        }
                        dl.this.gc.bindString(1, zVar.z);
                        dl.this.gc.bindString(2, zVar.g);
                        dl.this.gc.bindLong(3, zVar.dl);
                        dl.this.gc.bindLong(4, zVar.f110a);
                        dl.this.gc.bindString(5, zVar.gc);
                        dl.this.gc.executeInsert();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public void delete(final String str, final int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Map<String, z> map = this.z.get(i);
        if (map != null) {
            map.remove(str);
        }
        this.f109a.execute(new Runnable() { // from class: com.bykv.vk.openvk.component.video.z.g.g.dl.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    dl.this.dl.getWritableDatabase().delete("video_http_header_t", "key=? AND flag=?", new String[]{str, String.valueOf(i)});
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void z(Collection<String> collection, int i) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        int size = collection.size() + 1;
        String[] strArr = new String[size];
        Map<String, z> map = this.z.get(i);
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
            this.dl.getWritableDatabase().delete("video_http_header_t", "key IN(" + g(size) + ") AND flag=?", strArr);
        } catch (Throwable unused) {
        }
    }

    private String g(int i) {
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

    public void z(final int i) {
        Map<String, z> map = this.z.get(i);
        if (map != null) {
            map.clear();
        }
        this.f109a.execute(new Runnable() { // from class: com.bykv.vk.openvk.component.video.z.g.g.dl.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    dl.this.dl.getWritableDatabase().delete("video_http_header_t", "flag=?", new String[]{String.valueOf(i)});
                } catch (Throwable unused) {
                }
            }
        });
    }
}
