package com.xiaomi.onetrack.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.xiaomi.onetrack.a.a;
import com.xiaomi.onetrack.util.p;
import java.util.Calendar;

/* JADX INFO: loaded from: classes8.dex */
class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f7496a;

    public c(a aVar) {
        this.f7496a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f7496a.i == null) {
            return;
        }
        synchronized (this.f7496a.i) {
            Cursor cursorQuery = null;
            try {
                try {
                    SQLiteDatabase writableDatabase = this.f7496a.i.getWritableDatabase();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(System.currentTimeMillis());
                    calendar.set(6, calendar.get(6) - 7);
                    calendar.set(11, 0);
                    calendar.set(12, 0);
                    calendar.set(13, 0);
                    String[] strArr = {Long.toString(calendar.getTimeInMillis())};
                    cursorQuery = writableDatabase.query(a.C0545a.f7489b, new String[]{"timestamp"}, "timestamp < ? ", strArr, null, null, "timestamp ASC");
                    if (cursorQuery.getCount() != 0) {
                        p.a("AdMonitorManager", "*** deleted obsolete ad monitor count=" + writableDatabase.delete(a.C0545a.f7489b, "timestamp < ? ", strArr));
                    }
                    if (p.f7764a) {
                        p.a("AdMonitorManager", "after delete obsolete ad monitor record remains=" + this.f7496a.e());
                    }
                } catch (Exception e) {
                    p.d("AdMonitorManager", "remove obsolete ad monitor failed with " + e);
                    if (cursorQuery != null) {
                    }
                }
                cursorQuery.close();
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        }
    }
}
