package com.sntech.x2.topon.reload;

import androidx.annotation.Keep;
import y.b;

/* JADX INFO: loaded from: classes3.dex */
public class ReloadStore {

    public static class ReloadStat {

        @Keep
        public String reloadId;

        @Keep
        public long reloadTime;

        @Keep
        public int reloadTimes;

        @Keep
        public boolean reported;

        public String toString() {
            StringBuilder sbA = b.a("ReloadStat{reloadId='");
            sbA.append(this.reloadId);
            sbA.append('\'');
            sbA.append(", reloadTime=");
            sbA.append(this.reloadTime);
            sbA.append(", reloadTimes=");
            sbA.append(this.reloadTimes);
            sbA.append('}');
            return sbA.toString();
        }
    }
}
