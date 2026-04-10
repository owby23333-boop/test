package com.baidu.tts.download;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class CheckResult {
    private boolean mHasDownload = false;
    private Map<String, Integer> mFileStates = new HashMap();

    public boolean isDownloadSuccess() {
        Iterator<Integer> it = this.mFileStates.values().iterator();
        while (it.hasNext()) {
            if (it.next().intValue() != 7) {
                return false;
            }
        }
        return true;
    }

    public boolean isHasDownload() {
        return this.mHasDownload;
    }

    public void put(String str, int i2) {
        this.mFileStates.put(str, Integer.valueOf(i2));
    }

    public void setHasDownload(boolean z2) {
        this.mHasDownload = z2;
    }
}
