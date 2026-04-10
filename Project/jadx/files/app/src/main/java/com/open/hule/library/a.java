package com.open.hule.library;

import android.app.DownloadManager;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.anythink.core.common.c.m;

/* JADX INFO: compiled from: DownloadObserver.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends ContentObserver {
    private final String a;
    private final Handler b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f17646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f17647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final DownloadManager f17648e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final DownloadManager.Query f17649f;

    public a(Context context, Handler handler, DownloadManager downloadManager, long j2) {
        super(handler);
        this.a = a.class.getCanonicalName();
        this.f17647d = false;
        this.b = handler;
        this.f17648e = downloadManager;
        this.f17646c = context;
        this.f17649f = new DownloadManager.Query().setFilterById(j2);
    }

    private void a() {
        Cursor cursorQuery = this.f17648e.query(this.f17649f);
        if (cursorQuery == null || !cursorQuery.moveToNext()) {
            if (!this.f17647d) {
                Toast.makeText(this.f17646c, "取消下载", 0).show();
                Message message = new Message();
                message.what = 1317;
                this.b.sendMessage(message);
            }
            this.f17647d = true;
            return;
        }
        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
        int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("reason"));
        int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex(m.a.f7067f));
        int i5 = i4 != 0 ? (cursorQuery.getInt(cursorQuery.getColumnIndex("bytes_so_far")) * 100) / i4 : 0;
        String str = String.valueOf(i5) + " status:" + i2 + " reason " + i3;
        if (i2 == 1) {
            this.b.sendEmptyMessage(1);
        } else if (i2 == 2) {
            Message message2 = new Message();
            message2.what = 2;
            message2.arg1 = i5;
            this.b.sendMessage(message2);
        } else if (i2 == 4) {
            this.b.sendEmptyMessage(4);
        } else if (i2 == 8) {
            if (!this.f17647d) {
                this.b.sendEmptyMessage(8);
            }
            this.f17647d = true;
        } else if (i2 == 16) {
            if (!this.f17647d) {
                Message message3 = new Message();
                message3.what = 16;
                message3.arg1 = i3;
                this.b.sendMessage(message3);
            }
            this.f17647d = true;
        }
        cursorQuery.close();
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z2) {
        super.onChange(z2);
        a();
    }
}
