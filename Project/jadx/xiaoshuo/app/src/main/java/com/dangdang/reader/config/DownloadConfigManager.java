package com.dangdang.reader.config;

import android.content.Context;
import android.content.SharedPreferences;
import com.duokan.utils.mmkv.a;

/* JADX INFO: loaded from: classes10.dex */
public class DownloadConfigManager {
    public static final String DANG_DOWNLOAD_PREF = "dang_download_config";
    public static final String KEY_DOWNLOAD_USE_MOBILE = "download_use_mobile";
    private Context context;
    private SharedPreferences pref;

    public DownloadConfigManager(Context context) {
        this.pref = a.e().f(DANG_DOWNLOAD_PREF, context.getApplicationContext());
    }

    private SharedPreferences.Editor getEditor() {
        return this.pref.edit();
    }

    public boolean getCanDownloadUseMobile() {
        return this.pref.getBoolean(KEY_DOWNLOAD_USE_MOBILE, false);
    }

    public void saveCanDownloadUseMobile(boolean z) {
        SharedPreferences.Editor editor = getEditor();
        editor.putBoolean(KEY_DOWNLOAD_USE_MOBILE, z);
        editor.commit();
    }
}
