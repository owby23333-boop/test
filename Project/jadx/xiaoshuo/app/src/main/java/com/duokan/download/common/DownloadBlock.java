package com.duokan.download.common;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.duokan.download.common.DownloadDatabaseHelper;
import com.duokan.download.common.DownloadTask;
import com.yuewen.kt0;
import com.yuewen.rt1;
import java.nio.channels.FileChannel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public abstract class DownloadBlock {
    public static final String p = "com.duokan.download.common.DownloadBlock";
    public static final int q = 3;
    public static final /* synthetic */ boolean r = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3532b;
    public final long c;
    public long d;
    public final long e;
    public BlockState f;
    public long g;
    public final String i;
    public final com.duokan.download.common.a l;
    public final SQLiteDatabase m;
    public final rt1 n;
    public long h = 0;
    public FileChannel j = null;
    public long k = 0;
    public DownloadTask.DownloadingStage o = DownloadTask.DownloadingStage.UNKNOWN;

    public enum BlockState {
        SUCCEEDED,
        FAILED,
        UNFINISHED,
        NO_NETWORK_RETRYING
    }

    public static class a {

        /* JADX INFO: renamed from: com.duokan.download.common.DownloadBlock$a$a, reason: collision with other inner class name */
        public static class C0234a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final String f3533a = "block_state";

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final String f3534b = "downloaded_length";
        }
    }

    public DownloadBlock(long j, String str, SQLiteDatabase sQLiteDatabase, com.duokan.download.common.a aVar, rt1 rt1Var) {
        this.d = -1L;
        this.f = BlockState.UNFINISHED;
        this.g = 0L;
        this.m = sQLiteDatabase;
        this.f3531a = j;
        this.n = rt1Var;
        Cursor cursorQuery = sQLiteDatabase.query("blocks", null, "block_id=?", new String[]{"" + j}, null, null, null);
        cursorQuery.moveToNext();
        this.f3532b = cursorQuery.getInt(cursorQuery.getColumnIndex(DownloadDatabaseHelper.a.C0235a.c));
        this.c = cursorQuery.getLong(cursorQuery.getColumnIndex(DownloadDatabaseHelper.a.C0235a.d));
        this.d = cursorQuery.getLong(cursorQuery.getColumnIndex(DownloadDatabaseHelper.a.C0235a.e));
        this.e = cursorQuery.getLong(cursorQuery.getColumnIndex("task_id"));
        this.i = str;
        this.l = aVar;
        try {
            JSONObject jSONObject = new JSONObject(cursorQuery.getString(cursorQuery.getColumnIndex("runtime_info")));
            if (jSONObject.length() > 0) {
                this.f = BlockState.valueOf(jSONObject.getString(a.C0234a.f3533a));
                this.g = jSONObject.getLong(a.C0234a.f3534b);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            cursorQuery.close();
            throw th;
        }
        cursorQuery.close();
    }

    public void a() {
        b();
    }

    public abstract void b();

    public void c(kt0 kt0Var) {
        String str = p;
        Log.i(str, String.format("[%d]-[%d]-[%d]: ENTER_DOWNLOAD", Long.valueOf(this.f3531a), Integer.valueOf(this.f3532b), Long.valueOf(Thread.currentThread().getId())));
        d(kt0Var);
        Log.i(str, String.format("[%d]-[%d]-[%d]: LEAVE_DOWNLOAD", Long.valueOf(this.f3531a), Integer.valueOf(this.f3532b), Long.valueOf(Thread.currentThread().getId())));
    }

    public abstract void d(kt0 kt0Var);

    public int e() {
        return this.f3532b;
    }

    public long f() {
        return this.d;
    }

    public BlockState g() {
        return this.f;
    }

    public long h() {
        return this.h / Math.max((System.nanoTime() - this.k) / 1000000000, 1L);
    }

    public long i() {
        return this.g;
    }

    public FileChannel j() {
        return this.j;
    }

    public int k() {
        return 3;
    }

    public void l(BlockState blockState) {
        com.duokan.download.common.a aVar = this.l;
        if (aVar != null) {
            aVar.c(this, blockState);
        }
    }

    public void m(long j, long j2) {
        com.duokan.download.common.a aVar = this.l;
        if (aVar != null) {
            aVar.b(this, j, j2);
        }
    }

    public void n(kt0 kt0Var, boolean z) {
        com.duokan.download.common.a aVar = this.l;
        if (aVar != null) {
            aVar.n(this, kt0Var, z);
        }
    }

    public void o(long j) {
        this.d = j;
        this.m.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DownloadDatabaseHelper.a.C0235a.e, Long.valueOf(this.d));
            this.m.update("blocks", contentValues, "block_id=?", new String[]{"" + this.f3531a});
            this.m.setTransactionSuccessful();
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.m.endTransaction();
            throw th;
        }
        this.m.endTransaction();
    }

    public void p(BlockState blockState) {
        this.f = blockState;
        Log.i(p, String.format("[%d]-[%d]-[%d]: " + this.f, Long.valueOf(this.f3531a), Integer.valueOf(this.f3532b), Long.valueOf(Thread.currentThread().getId())));
        s();
        l(this.f);
    }

    public void q(DownloadTask.DownloadingStage downloadingStage) {
        this.o = downloadingStage;
    }

    public void r(FileChannel fileChannel) {
        this.j = fileChannel;
    }

    public void s() {
        this.m.beginTransaction();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(a.C0234a.f3533a, this.f);
            jSONObject.put(a.C0234a.f3534b, this.g);
            ContentValues contentValues = new ContentValues();
            contentValues.put("runtime_info", jSONObject.toString());
            this.m.update("blocks", contentValues, "block_id=?", new String[]{"" + this.f3531a});
            this.m.setTransactionSuccessful();
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.m.endTransaction();
            throw th;
        }
        this.m.endTransaction();
    }
}
