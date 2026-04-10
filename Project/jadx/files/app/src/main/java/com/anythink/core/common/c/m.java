package com.anythink.core.common.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class m extends com.anythink.core.common.c.a<com.anythink.core.common.a.i> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile m f7063c;
    private final String b;

    public static class a {
        public static final String a = "video_res_cache_info";
        public static final String b = "video_url";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f7064c = "file_path";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f7065d = "ready_rate";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f7066e = "download_size";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f7067f = "total_size";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String f7068g = "update_time";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String f7069h = "CREATE TABLE IF NOT EXISTS video_res_cache_info(video_url TEXT, file_path TEXT, ready_rate INTEGER, download_size INTEGER, total_size INTEGER, update_time INTEGER )";
    }

    private m(b bVar) {
        super(bVar);
        this.b = m.class.getSimpleName();
    }

    public static m a(b bVar) {
        if (f7063c == null) {
            synchronized (k.class) {
                if (f7063c == null) {
                    f7063c = new m(bVar);
                }
            }
        }
        return f7063c;
    }

    private boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursorQuery = a().query(a.a, new String[]{"video_url"}, "video_url=?", new String[]{str}, null, null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.close();
            return true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return false;
    }

    public final void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("update_time", Long.valueOf(System.currentTimeMillis()));
            b().update(a.a, contentValues, "video_url = ? ", new String[]{str});
        } catch (Throwable unused) {
        }
    }

    public final long c() {
        try {
            Cursor cursorRawQuery = a().rawQuery("SELECT sum(download_size) FROM video_res_cache_info", null);
            if (cursorRawQuery.moveToNext()) {
                return cursorRawQuery.getLong(0);
            }
            return 0L;
        } catch (Throwable th) {
            new StringBuilder("getDownloadedVideoSize fail:").append(th.getMessage());
            return 0L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x00b2, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00b3, code lost:
    
        new java.lang.StringBuilder("removeHalfVideoInfoByUpdateTime fail:").append(r0.getMessage());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.anythink.core.common.a.i> d() {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.m.d():java.util.List");
    }

    public final void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            b().delete(a.a, "video_url=?", new String[]{str});
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("removeVideoResCacheInfo fail:");
            sb.append(th.getMessage());
            sb.append(",videoUrl:");
            sb.append(str);
        }
    }

    public final synchronized void a(String str, String str2, long j2, long j3, int i2) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("video_url", str);
                    contentValues.put(a.f7064c, str2);
                    contentValues.put("ready_rate", Integer.valueOf(i2));
                    contentValues.put(a.f7066e, Long.valueOf(j3));
                    contentValues.put(a.f7067f, Long.valueOf(j2));
                    contentValues.put("update_time", Long.valueOf(System.currentTimeMillis()));
                    if (TextUtils.isEmpty(str)) {
                        z2 = false;
                    } else {
                        Cursor cursorQuery = a().query(a.a, new String[]{"video_url"}, "video_url=?", new String[]{str}, null, null, null);
                        if (cursorQuery == null || cursorQuery.getCount() <= 0) {
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            z2 = false;
                        } else {
                            cursorQuery.close();
                            z2 = true;
                        }
                    }
                    if (z2) {
                        b().update(a.a, contentValues, "video_url = ? ", new String[]{str});
                    } else {
                        b().insert(a.a, null, contentValues);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    private void d(String str) {
        try {
            Cursor cursorQuery = a().query(a.a, null, null, null, null, null, null);
            StringBuilder sb = new StringBuilder("logDBCurItemNumber ");
            sb.append(str);
            sb.append(":");
            sb.append(cursorQuery.getCount());
        } catch (Throwable th) {
            new StringBuilder("logDBCurItemNumber fail:").append(th.getMessage());
        }
    }

    public final com.anythink.core.common.a.i a(String str) {
        try {
            Cursor cursorQuery = a().query(a.a, null, "video_url=?", new String[]{str}, null, null, null);
            if (cursorQuery.moveToNext()) {
                com.anythink.core.common.a.i iVar = new com.anythink.core.common.a.i();
                iVar.a(str);
                iVar.b(cursorQuery.getString(cursorQuery.getColumnIndex(a.f7064c)));
                iVar.a(cursorQuery.getInt(cursorQuery.getColumnIndex("ready_rate")));
                iVar.b(cursorQuery.getLong(cursorQuery.getColumnIndex(a.f7066e)));
                iVar.a(cursorQuery.getLong(cursorQuery.getColumnIndex(a.f7067f)));
                iVar.c(cursorQuery.getLong(cursorQuery.getColumnIndex("update_time")));
                return iVar;
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
