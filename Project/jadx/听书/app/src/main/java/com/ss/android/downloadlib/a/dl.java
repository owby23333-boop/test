package com.ss.android.downloadlib.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ss.android.downloadlib.addownload.wp;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class dl {
    private static volatile dl g;
    private SQLiteDatabase z;

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

    private dl() {
        try {
            this.z = new g(wp.getContext()).getWritableDatabase();
        } catch (Throwable th) {
            com.ss.android.downloadlib.gc.dl.z().z(th, "ClickEventHelper");
        }
    }

    public boolean g() {
        return com.ss.android.socialbase.downloader.i.z.dl().z("click_event_switch", 0) == 1;
    }

    public boolean dl() {
        return com.ss.android.socialbase.downloader.i.z.dl().z("click_event_switch", 0) == 2;
    }

    public void z(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.z;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strOptString = new JSONObject(str).optString("req_id");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(MediationConstant.EXTRA_ADID, Long.valueOf(j));
            contentValues.put("req_id", strOptString);
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            this.z.insert("click_event", null, contentValues);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        dl(j, str);
    }

    public boolean g(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.z;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursorQuery = null;
        try {
            try {
                String strOptString = new JSONObject(str).optString("req_id");
                if (TextUtils.isEmpty(strOptString)) {
                    return false;
                }
                cursorQuery = this.z.query("click_event", g.z, "time > ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), strOptString}, null, null, null, null);
                boolean z = cursorQuery.getCount() > 0;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return z;
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    private void dl(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.z;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strOptString = new JSONObject(str).optString("req_id");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            this.z.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), strOptString});
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }
}
