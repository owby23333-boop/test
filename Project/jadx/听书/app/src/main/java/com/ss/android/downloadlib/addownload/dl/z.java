package com.ss.android.downloadlib.addownload.dl;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.downloadlib.e.i;
import com.ss.android.downloadlib.e.kb;
import com.ss.android.socialbase.downloader.a.fv;
import com.ss.android.socialbase.downloader.a.js;
import com.ss.android.socialbase.downloader.downloader.e;

/* JADX INFO: loaded from: classes4.dex */
public class z implements js {
    private int z;

    public void z(int i) {
        this.z = i;
    }

    @Override // com.ss.android.socialbase.downloader.a.js
    public boolean z(long j, long j2, fv fvVar) throws Throwable {
        long j3;
        com.ss.android.socialbase.downloader.i.z zVarZ = com.ss.android.socialbase.downloader.i.z.z(this.z);
        if (!z(zVarZ)) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        a.z().dl();
        long jG = i.g(0L);
        z();
        long jG2 = i.g(0L);
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (jG2 < j2) {
            long jG3 = g(zVarZ);
            if (jG3 > 0) {
                jG2 = i.g(0L);
            }
            j3 = jG3;
        } else {
            j3 = 0;
        }
        kb.g("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j2 + ", byteAvailableAfter = " + jG2 + ", cleaned = " + (jG2 - jG), null);
        long j4 = jG2;
        z(jG, jG2, j2, jCurrentTimeMillis2, j3);
        if (j4 < j2) {
            return false;
        }
        if (fvVar == null) {
            return true;
        }
        fvVar.z();
        return true;
    }

    private boolean z(com.ss.android.socialbase.downloader.i.z zVar) {
        if (zVar.z("clear_space_use_disk_handler", 0) != 1) {
            return false;
        }
        return System.currentTimeMillis() - a.z().g() >= zVar.z("clear_space_min_time_interval", TTAdConstant.AD_MAX_EVENT_TIME);
    }

    private void z() throws Throwable {
        wp.ls();
        dl.z();
        dl.g();
    }

    private long g(com.ss.android.socialbase.downloader.i.z zVar) {
        long jZ = zVar.z("clear_space_sleep_time", 0L);
        if (jZ <= 0) {
            return 0L;
        }
        if (jZ > 5000) {
            jZ = 5000;
        }
        kb.g("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = ".concat(String.valueOf(jZ)), null);
        try {
            Thread.sleep(jZ);
        } catch (InterruptedException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        kb.g("AppDownloadDiskSpaceHandler", "waiting end!", null);
        return jZ;
    }

    private void z(long j, long j2, long j3, long j4, long j5) {
        com.ss.android.socialbase.downloader.e.dl dlVarGz = e.g(wp.getContext()).gz(this.z);
        if (dlVarGz == null) {
            return;
        }
        try {
            com.ss.android.downloadlib.z.z().z(dlVarGz, j, j2, j3, j4, j5, j2 > j3);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }
}
