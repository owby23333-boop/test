package com.bytedance.sdk.component.adexpress.dynamic.tg;

import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/static/images/");
        if (str.indexOf(Consts.DOT) > 0) {
            sb.append(str);
            return sb.toString();
        }
        sb.append(str);
        sb.append(".png");
        return sb.toString();
    }
}
