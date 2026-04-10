package com.bytedance.sdk.component.fo.dl;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    public boolean z = false;
    public boolean g = true;
    public Map<String, Integer> dl = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, String> f706a = null;
    public int gc = 10;
    public int m = 1;
    public int e = 1;
    public int gz = 10;
    public int fo = 1;
    public int uy = 1;
    public int kb = 900;
    public int wp = 120;
    public String i = null;
    public int v = 0;
    public long pf = 0;

    public String toString() {
        StringBuilder sb = new StringBuilder(" localEnable: ");
        sb.append(this.z);
        sb.append(" probeEnable: ").append(this.g);
        StringBuilder sbAppend = sb.append(" hostFilter: ");
        Map<String, Integer> map = this.dl;
        sbAppend.append(map != null ? map.size() : 0);
        StringBuilder sbAppend2 = sb.append(" hostMap: ");
        Map<String, String> map2 = this.f706a;
        sbAppend2.append(map2 != null ? map2.size() : 0);
        sb.append(" reqTo: ").append(this.gc).append("#").append(this.m).append("#").append(this.e);
        sb.append(" reqErr: ").append(this.gz).append("#").append(this.fo).append("#").append(this.uy);
        sb.append(" updateInterval: ").append(this.kb);
        sb.append(" updateRandom: ").append(this.wp);
        sb.append(" httpBlack: ").append(this.i);
        return sb.toString();
    }
}
