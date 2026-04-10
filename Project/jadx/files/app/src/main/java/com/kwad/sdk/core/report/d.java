package com.kwad.sdk.core.report;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d implements n<f> {
    protected c ahL;

    public d(c cVar) {
        a(cVar);
    }

    private void a(c cVar) {
        this.ahL = cVar;
    }

    private synchronized void c(f fVar) {
        com.kwad.sdk.core.d.b.d(getTag(), "deleteAction action = " + fVar);
        try {
            this.ahL.getReadableDatabase().delete(xg(), "actionId=?", new String[]{fVar.actionId});
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    @Override // com.kwad.sdk.core.report.n
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final synchronized void e(f fVar) {
        ContentValues contentValues;
        com.kwad.sdk.core.d.b.d(getTag(), "write = " + fVar);
        try {
            contentValues = new ContentValues();
            contentValues.put("actionId", fVar.actionId);
            contentValues.put("aLog", fVar.toJson().toString());
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
        try {
            this.ahL.getReadableDatabase().insert(xg(), null, contentValues);
        } catch (Exception e3) {
            com.kwad.sdk.core.d.b.printStackTrace(e3);
        }
    }

    protected abstract f e(@NonNull Cursor cursor);

    protected abstract String getTag();

    @Override // com.kwad.sdk.core.report.n
    public final synchronized void q(List<f> list) {
        com.kwad.sdk.core.d.b.d(getTag(), "delete size= " + list.size());
        SQLiteDatabase readableDatabase = null;
        try {
            try {
                readableDatabase = this.ahL.getReadableDatabase();
                readableDatabase.beginTransaction();
                Iterator<f> it = list.iterator();
                while (it.hasNext()) {
                    c(it.next());
                }
                readableDatabase.setTransactionSuccessful();
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
                if (readableDatabase != null) {
                    try {
                        readableDatabase.endTransaction();
                    } catch (Exception e3) {
                        com.kwad.sdk.core.d.b.printStackTrace(e3);
                    }
                }
            }
        } finally {
            if (readableDatabase != null) {
                try {
                    readableDatabase.endTransaction();
                } catch (Exception e4) {
                    com.kwad.sdk.core.d.b.printStackTrace(e4);
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.report.n
    public final synchronized long size() {
        long j2;
        j2 = 0;
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = this.ahL.getReadableDatabase().rawQuery("select count(*) from " + xg(), null);
                cursorRawQuery.moveToFirst();
                j2 = cursorRawQuery.getLong(0);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
        }
        return j2;
    }

    protected abstract String xg();

    @Override // com.kwad.sdk.core.report.n
    public final synchronized List<f> xh() {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = this.ahL.getReadableDatabase().rawQuery("select  * from " + xg(), null);
                if (cursorRawQuery != null) {
                    ArrayList<f> arrayList = new ArrayList();
                    while (cursorRawQuery.moveToNext()) {
                        try {
                            arrayList.add(e(cursorRawQuery));
                        } catch (Exception e2) {
                            com.kwad.sdk.core.d.b.printStackTrace(e2);
                        }
                    }
                    com.kwad.sdk.core.d.b.d(getTag(), "read size= " + arrayList.size());
                    for (f fVar : arrayList) {
                        com.kwad.sdk.core.d.b.d(getTag(), "read action=" + fVar);
                    }
                    return arrayList;
                }
            } catch (Exception e3) {
                com.kwad.sdk.core.d.b.printStackTrace(e3);
            }
            return new ArrayList();
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
        }
    }
}
