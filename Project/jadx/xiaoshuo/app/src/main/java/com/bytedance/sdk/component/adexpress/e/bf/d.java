package com.bytedance.sdk.component.adexpress.e.bf;

import android.os.Environment;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static File e() {
        return (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && com.bytedance.sdk.component.adexpress.e.e.e.e().d().getContext().getExternalCacheDir() != null) ? com.bytedance.sdk.component.adexpress.e.e.e.e().d().getContext().getExternalCacheDir() : com.bytedance.sdk.component.adexpress.e.e.e.e().d().getContext().getCacheDir();
    }
}
