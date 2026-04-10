package com.ss.android.socialbase.downloader.impls;

import androidx.media3.common.C;
import androidx.media3.session.MediaController;
import com.ss.android.socialbase.downloader.downloader.tb;

/* JADX INFO: loaded from: classes4.dex */
public class uy implements tb {
    @Override // com.ss.android.socialbase.downloader.downloader.tb
    public long z(int i, int i2) {
        return i == 1 ? C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS : i == 2 ? C.DEFAULT_SEEK_FORWARD_INCREMENT_MS : i == 3 ? MediaController.RELEASE_UNBIND_TIMEOUT_MS : i > 3 ? 300000L : 0L;
    }
}
