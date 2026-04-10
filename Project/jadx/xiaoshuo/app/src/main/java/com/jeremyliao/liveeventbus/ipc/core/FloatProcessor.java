package com.jeremyliao.liveeventbus.ipc.core;

import android.os.Bundle;
import com.jeremyliao.liveeventbus.ipc.consts.IpcConst;

/* JADX INFO: loaded from: classes7.dex */
public class FloatProcessor implements Processor {
    @Override // com.jeremyliao.liveeventbus.ipc.core.Processor
    public Object createFromBundle(Bundle bundle) {
        return Float.valueOf(bundle.getFloat(IpcConst.KEY_VALUE));
    }

    @Override // com.jeremyliao.liveeventbus.ipc.core.Processor
    public boolean writeToBundle(Bundle bundle, Object obj) {
        if (!(obj instanceof Float)) {
            return false;
        }
        bundle.putFloat(IpcConst.KEY_VALUE, ((Float) obj).floatValue());
        return true;
    }
}
