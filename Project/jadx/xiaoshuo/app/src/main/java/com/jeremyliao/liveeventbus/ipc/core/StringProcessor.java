package com.jeremyliao.liveeventbus.ipc.core;

import android.os.Bundle;
import com.jeremyliao.liveeventbus.ipc.consts.IpcConst;

/* JADX INFO: loaded from: classes7.dex */
public class StringProcessor implements Processor {
    @Override // com.jeremyliao.liveeventbus.ipc.core.Processor
    public Object createFromBundle(Bundle bundle) {
        return bundle.getString(IpcConst.KEY_VALUE);
    }

    @Override // com.jeremyliao.liveeventbus.ipc.core.Processor
    public boolean writeToBundle(Bundle bundle, Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        bundle.putString(IpcConst.KEY_VALUE, (String) obj);
        return true;
    }
}
