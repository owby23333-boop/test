package com.xiaomi.push.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.xiaomi.passport.sim.SIMInfo;
import com.xiaomi.push.hu;

/* JADX INFO: loaded from: classes8.dex */
public class TrafficProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final UriMatcher f8165a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Uri f882a = Uri.parse("content://com.xiaomi.push.providers.TrafficProvider/traffic");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private SQLiteOpenHelper f883a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f8165a = uriMatcher;
        uriMatcher.addURI("com.xiaomi.push.providers.TrafficProvider", "traffic", 1);
        uriMatcher.addURI("com.xiaomi.push.providers.TrafficProvider", "update_imsi", 2);
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        if (f8165a.match(uri) == 1) {
            return "vnd.android.cursor.dir/vnd.xiaomi.push.traffic";
        }
        throw new IllegalArgumentException("Unknown URI " + uri);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f883a = new a(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursorQuery;
        synchronized (a.f884a) {
            if (f8165a.match(uri) != 1) {
                throw new IllegalArgumentException("Unknown URI " + uri);
            }
            cursorQuery = this.f883a.getReadableDatabase().query("traffic", strArr, str, strArr2, null, null, str2);
        }
        return cursorQuery;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (f8165a.match(uri) != 2 || contentValues == null || !contentValues.containsKey(SIMInfo.SIM_INFO_TYPE_IMSI)) {
            return 0;
        }
        hu.m513a(contentValues.getAsString(SIMInfo.SIM_INFO_TYPE_IMSI));
        return 0;
    }
}
