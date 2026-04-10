package com.yuewen;

import android.content.Context;
import com.tencent.mmkv.MMKV;
import com.tencent.mmkv.MMKVLogLevel;

/* JADX INFO: loaded from: classes15.dex */
public class jq1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile jq1 f13042b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MMKV f13043a;

    public jq1(Context context) {
        MMKV.initialize(context.getApplicationContext());
        MMKV.setLogLevel(MMKVLogLevel.LevelNone);
        this.f13043a = MMKV.mmkvWithID("tts_ipc_buffer", 2);
    }

    public static jq1 a(Context context) {
        if (f13042b == null) {
            synchronized (jq1.class) {
                if (f13042b == null) {
                    f13042b = new jq1(context);
                }
            }
        }
        return f13042b;
    }

    public String b(String str, String str2) {
        String string = this.f13043a.getString(str, str2);
        this.f13043a.removeValueForKey(str);
        return string;
    }

    public void c(String str, String str2) {
        this.f13043a.putString(str, str2);
    }
}
