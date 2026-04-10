package com.taobao.accs.net;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import java.util.Calendar;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class a extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PendingIntent f18197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AlarmManager f18198d;

    public a(Context context) {
        super(context);
        try {
            this.f18198d = (AlarmManager) this.a.getSystemService(NotificationCompat.CATEGORY_ALARM);
        } catch (Throwable th) {
            ALog.e("AlarmHeartBeatMgr", "AlarmHeartBeatMgr", th, new Object[0]);
        }
    }

    @Override // com.taobao.accs.net.f
    protected void a(int i2) {
        if (this.f18198d == null) {
            this.f18198d = (AlarmManager) this.a.getSystemService(NotificationCompat.CATEGORY_ALARM);
        }
        if (this.f18198d == null) {
            ALog.e("AlarmHeartBeatMgr", "setInner null", new Object[0]);
            return;
        }
        if (this.f18197c == null) {
            Intent intent = new Intent();
            intent.setPackage(this.a.getPackageName());
            intent.addFlags(32);
            intent.setAction(Constants.ACTION_COMMAND);
            intent.putExtra("command", 201);
            this.f18197c = PendingIntent.getBroadcast(this.a, 0, intent, Build.VERSION.SDK_INT >= 23 ? DownloadExpSwitchCode.BACK_BUGFIX_SIGBUS : 0);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(13, i2);
        this.f18198d.set(0, calendar.getTimeInMillis(), this.f18197c);
    }
}
