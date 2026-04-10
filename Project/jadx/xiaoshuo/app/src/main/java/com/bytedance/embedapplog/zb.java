package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.embedapplog.aq;
import com.bytedance.embedapplog.rk;

/* JADX INFO: loaded from: classes.dex */
abstract class zb<SERVICE> implements rk {
    private ev<Boolean> bf = new ev<Boolean>() { // from class: com.bytedance.embedapplog.zb.1
        @Override // com.bytedance.embedapplog.ev
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Boolean e(Object... objArr) {
            return Boolean.valueOf(vg.e((Context) objArr[0], zb.this.e));
        }
    };
    private final String e;

    public zb(String str) {
        this.e = str;
    }

    @Override // com.bytedance.embedapplog.rk
    public boolean bf(Context context) {
        if (context == null) {
            return false;
        }
        return this.bf.bf(context).booleanValue();
    }

    @Override // com.bytedance.embedapplog.rk
    public rk.e d(Context context) {
        return e((String) new aq(context, e(context), e()).e());
    }

    public abstract Intent e(Context context);

    public abstract aq.bf<SERVICE, String> e();

    private rk.e e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        rk.e eVar = new rk.e();
        eVar.bf = str;
        return eVar;
    }
}
