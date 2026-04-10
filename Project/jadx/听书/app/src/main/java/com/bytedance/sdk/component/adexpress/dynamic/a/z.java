package com.bytedance.sdk.component.adexpress.dynamic.a;

import android.text.TextUtils;
import com.funny.audio.core.utils.FileUtils;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static String z(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/static/images/");
        if (str.indexOf(FileUtils.FILE_EXTENSION_SEPARATOR) > 0) {
            return sb.append(str).toString();
        }
        return sb.append(str).append(".png").toString();
    }
}
