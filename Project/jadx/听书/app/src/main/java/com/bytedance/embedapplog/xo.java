package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.embedapplog.gm;
import com.bytedance.embedapplog.uy;

/* JADX INFO: loaded from: classes2.dex */
abstract class xo<SERVICE> implements gm {
    private bm<Boolean> g = new bm<Boolean>() { // from class: com.bytedance.embedapplog.xo.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.bm
        /* JADX INFO: renamed from: dl, reason: merged with bridge method [inline-methods] */
        public Boolean z(Object... objArr) {
            return Boolean.valueOf(zb.z((Context) objArr[0], xo.this.z));
        }
    };
    private final String z;

    protected abstract Intent dl(Context context);

    protected abstract uy.g<SERVICE, String> z();

    xo(String str) {
        this.z = str;
    }

    @Override // com.bytedance.embedapplog.gm
    public boolean z(Context context) {
        if (context == null) {
            return false;
        }
        return this.g.g(context).booleanValue();
    }

    @Override // com.bytedance.embedapplog.gm
    public gm.z g(Context context) {
        return z((String) new uy(context, dl(context), z()).z());
    }

    private gm.z z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        gm.z zVar = new gm.z();
        zVar.g = str;
        return zVar;
    }
}
