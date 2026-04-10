package com.anythink.core.common.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.anythink.core.common.e.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class i extends com.anythink.core.common.c.a<i> {
    private static final String b = "com.anythink.core.common.c.i";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static i f7034c;

    public static class a {
        public List<w> a;
        public Map<String, w> b;
    }

    public static class b {
        public static final String a = "notice_url_fail_info";
        public static final String b = "id";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f7035c = "req_type";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f7036d = "req_url";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f7037e = "req_head";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f7038f = "first_fail_time";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String f7039g = "offer_out_date_time";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String f7040h = "retry_count";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final String f7041i = "CREATE TABLE IF NOT EXISTS notice_url_fail_info(id TEXT, req_type INTEGER, req_url TEXT, req_head TEXT, first_fail_time INTEGER, offer_out_date_time INTEGER, retry_count INTEGER )";
    }

    private i(com.anythink.core.common.c.b bVar) {
        super(bVar);
    }

    public static i a(com.anythink.core.common.c.b bVar) {
        if (f7034c == null) {
            synchronized (i.class) {
                if (f7034c == null) {
                    f7034c = new i(bVar);
                }
            }
        }
        return f7034c;
    }

    private synchronized void d() {
        try {
            if (b() == null) {
                return;
            }
            b().delete(b.a, null, null);
        } catch (Exception unused) {
        }
    }

    public final synchronized int b(w wVar) {
        if (b() == null || wVar == null) {
            return -1;
        }
        try {
            return b().delete(b.a, "id=?", new String[]{wVar.a});
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final synchronized a c() {
        a aVar = new a();
        List<w> listSynchronizedList = Collections.synchronizedList(new ArrayList(8));
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(8);
        aVar.a = listSynchronizedList;
        aVar.b = concurrentHashMap;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = a().query(b.a, null, null, null, null, null, b.f7038f);
            } catch (Exception unused) {
                if (cursorQuery != null) {
                }
            } catch (OutOfMemoryError unused2) {
                System.gc();
                if (cursorQuery != null) {
                }
            } catch (Throwable unused3) {
                if (cursorQuery != null) {
                }
            }
            if (cursorQuery == null || cursorQuery.getCount() <= 0) {
                if (cursorQuery != null) {
                }
                return aVar;
            }
            ArrayList<w> arrayList = new ArrayList(4);
            while (cursorQuery.moveToNext()) {
                w wVar = new w();
                wVar.a = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                wVar.b = cursorQuery.getInt(cursorQuery.getColumnIndex("req_type"));
                wVar.f7384d = cursorQuery.getString(cursorQuery.getColumnIndex("req_url"));
                wVar.f7383c = cursorQuery.getString(cursorQuery.getColumnIndex("req_head"));
                wVar.f7385e = cursorQuery.getLong(cursorQuery.getColumnIndex(b.f7038f));
                wVar.f7386f = cursorQuery.getLong(cursorQuery.getColumnIndex(b.f7039g));
                wVar.f7387g = cursorQuery.getInt(cursorQuery.getColumnIndex("retry_count"));
                if (System.currentTimeMillis() < wVar.f7386f) {
                    listSynchronizedList.add(wVar);
                    concurrentHashMap.put(wVar.a, wVar);
                } else {
                    arrayList.add(wVar);
                }
            }
            cursorQuery.close();
            if (arrayList.size() > 0) {
                for (w wVar2 : arrayList) {
                    new StringBuilder("delete out date-- ").append(wVar2.a());
                    b(wVar2);
                }
            }
            return aVar;
            cursorQuery.close();
            return aVar;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public final synchronized long a(w wVar) {
        boolean z2;
        if (b() == null || wVar == null) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", wVar.a);
            contentValues.put("req_type", Integer.valueOf(wVar.b));
            contentValues.put("req_url", wVar.f7384d);
            contentValues.put("req_head", wVar.f7383c);
            contentValues.put(b.f7038f, Long.valueOf(wVar.f7385e));
            contentValues.put(b.f7039g, Long.valueOf(wVar.f7386f));
            contentValues.put("retry_count", Integer.valueOf(wVar.f7387g));
            Cursor cursorQuery = a().query(b.a, new String[]{"id"}, "id=?", new String[]{wVar.a}, "id", null, null);
            if (cursorQuery == null || cursorQuery.getCount() <= 0) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                z2 = false;
            } else {
                cursorQuery.close();
                z2 = true;
            }
            if (z2) {
                return b().update(b.a, contentValues, "id = ? ", new String[]{wVar.a});
            }
            return b().insert(b.a, null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    private boolean a(String str) {
        Cursor cursorQuery = a().query(b.a, new String[]{"id"}, "id=?", new String[]{str}, "id", null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.close();
            return true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return false;
    }
}
