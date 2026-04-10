package com.kwad.sdk.core.report;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d implements l<e> {
    private static final String[] aGs = {"count(*)"};
    private static boolean aGt;
    protected c aGu;

    protected abstract String Ip();

    protected abstract String[] Iq();

    protected abstract e f(Cursor cursor);

    protected abstract String getTag();

    public d(c cVar) {
        a(cVar);
    }

    private void a(c cVar) {
        this.aGu = cVar;
    }

    @Override // com.kwad.sdk.core.report.l
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final synchronized void l(e eVar) {
        if (aGt) {
            Log.d(getTag(), "write = " + eVar);
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("actionId", eVar.actionId);
            contentValues.put("aLog", eVar.toJson().toString());
            try {
                this.aGu.getReadableDatabase().insert(Ip(), null, contentValues);
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.c.printStackTrace(e2);
        }
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized long size() {
        long j;
        Cursor cursorQuery = null;
        try {
            cursorQuery = this.aGu.getReadableDatabase().query(Ip(), aGs, null, null, null, null, null);
            cursorQuery.moveToFirst();
            j = cursorQuery.getLong(0);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            j = 0;
        } finally {
        }
        return j;
    }

    public final synchronized List<e> Ir() {
        Cursor cursorQuery = null;
        try {
            try {
                String[] strArrIq = Iq();
                cursorQuery = this.aGu.getReadableDatabase().query(Ip(), strArrIq.length == 0 ? null : strArrIq, null, null, null, null, null);
                if (cursorQuery != null) {
                    ArrayList arrayList = new ArrayList();
                    while (cursorQuery.moveToNext()) {
                        try {
                            arrayList.add(f(cursorQuery));
                        } catch (Exception e) {
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                        }
                    }
                    if (aGt) {
                        Log.d(getTag(), "read size= " + arrayList.size());
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Log.d(getTag(), "read action=" + ((e) it.next()));
                        }
                    }
                    return arrayList;
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.c.printStackTrace(e2);
            }
            return new ArrayList();
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
        }
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized List<e> dE(int i) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.aGu.getReadableDatabase().query(Ip(), Iq(), null, null, null, null, null, "0,200");
                while (cursorQuery.moveToNext()) {
                    try {
                        arrayList.add(f(cursorQuery));
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                    }
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.c.printStackTrace(e2);
            }
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized void B(List<e> list) {
        if (aGt) {
            Log.d(getTag(), "delete size= " + list.size());
        }
        SQLiteDatabase readableDatabase = null;
        try {
            try {
                readableDatabase = this.aGu.getReadableDatabase();
                readableDatabase.beginTransaction();
                Iterator<e> it = list.iterator();
                while (it.hasNext()) {
                    c(it.next());
                }
                readableDatabase.setTransactionSuccessful();
            } finally {
                if (readableDatabase != null) {
                    try {
                        readableDatabase.endTransaction();
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                    }
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.c.printStackTrace(e2);
            if (readableDatabase != null) {
                try {
                    readableDatabase.endTransaction();
                } catch (Exception e3) {
                    com.kwad.sdk.core.d.c.printStackTrace(e3);
                }
            }
        }
    }

    private synchronized void c(e eVar) {
        if (aGt) {
            Log.d(getTag(), "deleteAction action = " + eVar);
        }
        try {
            this.aGu.getReadableDatabase().delete(Ip(), "actionId=?", new String[]{eVar.actionId});
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }
}
