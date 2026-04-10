package com.ss.android.downloadlib.event;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.exception.b;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ox {
    private static volatile ox ox;
    private SQLiteDatabase mb;

    private ox() {
        try {
            this.mb = new mb(x.getContext()).getWritableDatabase();
        } catch (Throwable th) {
            b.mb().mb(th, "ClickEventHelper");
        }
    }

    public static ox mb() {
        if (ox == null) {
            synchronized (ox.class) {
                if (ox == null) {
                    ox = new ox();
                }
            }
        }
        return ox;
    }

    public boolean b() {
        return DownloadSetting.obtainGlobal().optInt("click_event_switch", 0) == 2;
    }

    public boolean ox() {
        return DownloadSetting.obtainGlobal().optInt("click_event_switch", 0) == 1;
    }

    private void b(long j2, String str) {
        SQLiteDatabase sQLiteDatabase = this.mb;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j2 <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strOptString = new JSONObject(str).optString("req_id");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            this.mb.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j2), strOptString});
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean ox(long j2, String str) {
        SQLiteDatabase sQLiteDatabase = this.mb;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j2 <= 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursorQuery = null;
        try {
            try {
                String strOptString = new JSONObject(str).optString("req_id");
                if (TextUtils.isEmpty(strOptString)) {
                    return false;
                }
                cursorQuery = this.mb.query("click_event", mb.mb, "time > ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j2), strOptString}, null, null, null, null);
                boolean z2 = cursorQuery.getCount() > 0;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return z2;
            } catch (Exception e2) {
                e2.printStackTrace();
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

    public void mb(long j2, String str) {
        SQLiteDatabase sQLiteDatabase = this.mb;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j2 <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strOptString = new JSONObject(str).optString("req_id");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(GMAdConstant.EXTRA_ADID, Long.valueOf(j2));
            contentValues.put("req_id", strOptString);
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            this.mb.insert("click_event", null, contentValues);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        b(j2, str);
    }
}
