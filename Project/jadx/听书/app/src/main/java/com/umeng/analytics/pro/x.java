package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;

/* JADX INFO: compiled from: SessionIdGenerateServiceImpl.java */
/* JADX INFO: loaded from: classes4.dex */
class x implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f2256a = AnalyticsConfig.kContinueSessionMillis;

    x() {
    }

    @Override // com.umeng.analytics.pro.w
    public void a(long j) {
        this.f2256a = j;
    }

    @Override // com.umeng.analytics.pro.w
    public long a() {
        return this.f2256a;
    }

    @Override // com.umeng.analytics.pro.w
    public String a(Context context) {
        String appkey = UMUtils.getAppkey(context);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (appkey == null) {
            throw new RuntimeException("Appkey is null or empty, Please check!");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(jCurrentTimeMillis).append(appkey).append("02:00:00:00:00:00");
        return UMUtils.MD5(sb.toString());
    }

    @Override // com.umeng.analytics.pro.w
    public boolean a(long j, long j2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return (j == 0 || jCurrentTimeMillis - j >= this.f2256a) && j2 > 0 && jCurrentTimeMillis - j2 > this.f2256a;
    }

    @Override // com.umeng.analytics.pro.w
    public void a(Context context, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(context).edit();
            editorEdit.putString("session_id", str);
            editorEdit.putLong(u.b, 0L);
            editorEdit.putLong(u.e, jCurrentTimeMillis);
            editorEdit.putLong(u.f, 0L);
            editorEdit.commit();
        } catch (Exception unused) {
        }
    }
}
