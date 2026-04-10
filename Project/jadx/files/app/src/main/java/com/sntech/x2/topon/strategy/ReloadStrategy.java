package com.sntech.x2.topon.strategy;

import androidx.annotation.Keep;
import y.b;

/* JADX INFO: loaded from: classes3.dex */
public class ReloadStrategy {

    @Keep
    public long interval;

    @Keep
    public Boolean reloadFlag;

    @Keep
    public String reloadID;

    @Keep
    public int reloadTimes;

    public String toString() {
        StringBuilder sbA = b.a("ReloadStrategy{reloadID='");
        sbA.append(this.reloadID);
        sbA.append('\'');
        sbA.append(", reloadFlag=");
        sbA.append(this.reloadFlag);
        sbA.append(", reloadTimes=");
        sbA.append(this.reloadTimes);
        sbA.append(", interval=");
        sbA.append(this.interval);
        sbA.append('}');
        return sbA.toString();
    }
}
