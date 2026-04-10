package com.xiaomi.micloudsdk;

import java.io.File;

/* JADX INFO: loaded from: classes8.dex */
public class CloudConfig {
    public static final String URL_GALLERY_BASE;
    public static final String URL_RICH_MEDIA_BASE;
    public static final boolean USE_PREVIEW;

    static {
        boolean zExists = new File("/data/system/account_preview").exists();
        USE_PREVIEW = zExists;
        URL_GALLERY_BASE = zExists ? "http://micloud.preview.n.xiaomi.net" : "http://galleryapi.micloud.xiaomi.net";
        URL_RICH_MEDIA_BASE = zExists ? "http://api.micloud.preview.n.xiaomi.net" : "http://fileapi.micloud.xiaomi.net";
    }
}
