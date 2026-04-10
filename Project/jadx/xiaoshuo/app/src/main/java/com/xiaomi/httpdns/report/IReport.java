package com.xiaomi.httpdns.report;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public interface IReport {
    void a(Context context);

    void recordEvent(String str, Map<String, Object> map);
}
