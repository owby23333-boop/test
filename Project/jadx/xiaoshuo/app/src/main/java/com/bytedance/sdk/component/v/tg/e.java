package com.bytedance.sdk.component.v.tg;

import android.util.Log;
import com.bytedance.sdk.component.utils.wu;
import com.bytedance.sdk.component.v.tg.bf;

/* JADX INFO: loaded from: classes.dex */
public class e implements bf.InterfaceC0107bf {
    @Override // com.bytedance.sdk.component.v.tg.bf.InterfaceC0107bf
    public void bf(String str, String str2) {
        Log.d(wu.tg(str), str2);
    }

    @Override // com.bytedance.sdk.component.v.tg.bf.InterfaceC0107bf
    public void e(String str, String str2) {
        Log.e(wu.tg(str), str2);
    }
}
