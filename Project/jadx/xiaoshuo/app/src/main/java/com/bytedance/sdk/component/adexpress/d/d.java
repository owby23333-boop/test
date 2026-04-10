package com.bytedance.sdk.component.adexpress.d;

import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class d {

    public enum e {
        HTML("text/html"),
        CSS("text/css"),
        JS("application/x-javascript"),
        IMAGE("image/*");

        private String ga;

        e(String str) {
            this.ga = str;
        }

        public String getType() {
            return this.ga;
        }
    }

    public static e e(String str) {
        e eVar;
        e eVar2 = e.IMAGE;
        if (TextUtils.isEmpty(str)) {
            return eVar2;
        }
        try {
            String path = Uri.parse(str).getPath();
            if (path == null) {
                return eVar2;
            }
            if (path.endsWith(".css")) {
                eVar = e.CSS;
            } else if (path.endsWith(".js")) {
                eVar = e.JS;
            } else {
                if (path.endsWith(".jpg") || path.endsWith(".gif") || path.endsWith(".png") || path.endsWith(".jpeg") || path.endsWith(".webp") || path.endsWith(".bmp") || path.endsWith(".ico") || !path.endsWith(".html")) {
                    return eVar2;
                }
                eVar = e.HTML;
            }
            return eVar;
        } catch (Throwable unused) {
            return eVar2;
        }
    }
}
