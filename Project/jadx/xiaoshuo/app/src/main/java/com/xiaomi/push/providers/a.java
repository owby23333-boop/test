package com.xiaomi.push.providers;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.passport.sim.SIMInfo;
import com.yuewen.openapi.track.TrackConstants;

/* JADX INFO: loaded from: classes8.dex */
public class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f8166a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Object f884a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final String[] f885a = {"package_name", "TEXT", "message_ts", " LONG DEFAULT 0 ", "bytes", " LONG DEFAULT 0 ", TrackConstants.NETWORK_TYPE, " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", SIMInfo.SIM_INFO_TYPE_IMSI, "TEXT"};

    public a(Context context) {
        super(context, "traffic.db", (SQLiteDatabase.CursorFactory) null, f8166a);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder("CREATE TABLE traffic(_id INTEGER  PRIMARY KEY ,");
        int i = 0;
        while (true) {
            String[] strArr = f885a;
            if (i >= strArr.length - 1) {
                sb.append(");");
                sQLiteDatabase.execSQL(sb.toString());
                return;
            }
            if (i != 0) {
                sb.append(",");
            }
            sb.append(strArr[i]);
            sb.append(" ");
            sb.append(strArr[i + 1]);
            i += 2;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (f884a) {
            try {
                a(sQLiteDatabase);
            } catch (SQLException e) {
                b.a(e);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
