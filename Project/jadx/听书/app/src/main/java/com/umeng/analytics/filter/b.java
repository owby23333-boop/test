package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* JADX INFO: compiled from: EventWhiteList.java */
/* JADX INFO: loaded from: classes4.dex */
public class b extends EventList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f2158a;
    private Object b;

    public b(String str, String str2) {
        super(str, str2);
        this.b = new Object();
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean zA;
        if (TextUtils.isEmpty(this.mEventList)) {
            return true;
        }
        synchronized (this.b) {
            if (this.f2158a == null) {
                this.f2158a = new d(true, this.mEventList);
            }
            zA = this.f2158a.a(str);
        }
        return zA;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z) {
        AnalyticsConfig.CLEAR_EKV_WL = z;
    }

    @Override // com.umeng.analytics.filter.EventList
    protected void eventListChange() {
        if (TextUtils.isEmpty(this.mEventList)) {
            return;
        }
        synchronized (this.b) {
            this.f2158a = null;
            this.f2158a = new d(true, this.mEventList);
        }
    }
}
