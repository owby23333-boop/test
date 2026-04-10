package com.yuewen;

import android.text.TextUtils;
import com.duokan.adbridge.bean.CommonAdInfo;
import com.duokan.advertisement.i;

/* JADX INFO: loaded from: classes12.dex */
public class x00 implements t {
    @Override // com.yuewen.t
    public int a(w6 w6Var) {
        if (w6Var instanceof CommonAdInfo) {
            return b((CommonAdInfo) w6Var);
        }
        return 0;
    }

    public final int b(CommonAdInfo commonAdInfo) {
        try {
            int i = commonAdInfo.n;
            if (i == 4) {
                return TextUtils.isEmpty(commonAdInfo.z) ? i.n.e : i.n.f;
            }
            if (i == 20) {
                return commonAdInfo.t() ? i.n.d : i.n.c;
            }
            if (i == 6) {
                return TextUtils.isEmpty(commonAdInfo.z) ? i.n.j : i.n.k;
            }
            if (i == 7) {
                return TextUtils.isEmpty(commonAdInfo.z) ? i.n.g : i.n.h;
            }
            if (i == 60 || i == 61) {
                return TextUtils.isEmpty(commonAdInfo.z) ? i.n.m : i.n.n;
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.yuewen.t
    public String getName() {
        return "styleA";
    }
}
