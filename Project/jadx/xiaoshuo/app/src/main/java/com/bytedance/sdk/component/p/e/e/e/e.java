package com.bytedance.sdk.component.p.e.e.e;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bytedance.sdk.component.p.e.e.e.bf;

/* JADX INFO: loaded from: classes.dex */
public class e extends bf {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile e e;

    private e(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.component.p.e.e.e.bf
    public /* bridge */ /* synthetic */ bf.C0104bf e() {
        return super.e();
    }

    public static e e(Context context) {
        if (e == null) {
            synchronized (e.class) {
                if (e == null) {
                    e = new e(context);
                }
            }
        }
        return e;
    }
}
