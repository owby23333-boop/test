package com.jeremyliao.liveeventbus.ipc.core;

import android.os.Bundle;
import com.jeremyliao.liveeventbus.ipc.consts.IpcConst;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class SerializableProcessor implements Processor {
    @Override // com.jeremyliao.liveeventbus.ipc.core.Processor
    public Object createFromBundle(Bundle bundle) {
        return bundle.getSerializable(IpcConst.KEY_VALUE);
    }

    @Override // com.jeremyliao.liveeventbus.ipc.core.Processor
    public boolean writeToBundle(Bundle bundle, Object obj) {
        if (!(obj instanceof Serializable)) {
            return false;
        }
        bundle.putSerializable(IpcConst.KEY_VALUE, (Serializable) obj);
        return true;
    }
}
