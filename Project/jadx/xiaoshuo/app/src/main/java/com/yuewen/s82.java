package com.yuewen;

import android.os.Debug;
import java.io.IOException;

/* JADX INFO: loaded from: classes17.dex */
public class s82 implements wc1 {
    @Override // com.yuewen.wc1
    public boolean a(String str) {
        try {
            Debug.dumpHprofData(str);
            return true;
        } catch (IOException e) {
            qt1.b("NormalHeapDumper", "An exception occurs", e);
            return false;
        }
    }
}
