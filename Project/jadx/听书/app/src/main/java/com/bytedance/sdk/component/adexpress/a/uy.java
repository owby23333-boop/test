package com.bytedance.sdk.component.adexpress.a;

import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class uy {
    public static z z(String str) {
        z zVar = z.IMAGE;
        if (!TextUtils.isEmpty(str)) {
            try {
                String path = Uri.parse(str).getPath();
                if (path != null) {
                    if (path.endsWith(".css")) {
                        zVar = z.CSS;
                    } else if (path.endsWith(".js")) {
                        zVar = z.JS;
                    } else if (path.endsWith(".jpg") || path.endsWith(".gif") || path.endsWith(".png") || path.endsWith(".jpeg") || path.endsWith(".webp") || path.endsWith(".bmp") || path.endsWith(".ico")) {
                        zVar = z.IMAGE;
                    } else if (path.endsWith(".html")) {
                        zVar = z.HTML;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return zVar;
    }

    public static boolean g(String str) {
        Uri uri;
        if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null) {
            return false;
        }
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return path.endsWith(".gif");
    }

    public enum z {
        HTML("text/html"),
        CSS("text/css"),
        JS("application/x-javascript"),
        IMAGE("image/*");

        private String gc;

        z(String str) {
            this.gc = str;
        }

        public String getType() {
            return this.gc;
        }
    }
}
