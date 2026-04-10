package com.bytedance.sdk.component.v.d;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public boolean e = false;
    public boolean bf = true;
    public Map<String, Integer> d = null;
    public Map<String, String> tg = null;
    public int ga = 10;
    public int vn = 1;
    public int p = 1;
    public int v = 10;
    public int zk = 1;
    public int m = 1;
    public int wu = 900;
    public int xu = 120;
    public String bh = null;
    public int t = 0;
    public long s = 0;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" localEnable: ");
        sb.append(this.e);
        sb.append(" probeEnable: ");
        sb.append(this.bf);
        sb.append(" hostFilter: ");
        Map<String, Integer> map = this.d;
        sb.append(map != null ? map.size() : 0);
        sb.append(" hostMap: ");
        Map<String, String> map2 = this.tg;
        sb.append(map2 != null ? map2.size() : 0);
        sb.append(" reqTo: ");
        sb.append(this.ga);
        sb.append("#");
        sb.append(this.vn);
        sb.append("#");
        sb.append(this.p);
        sb.append(" reqErr: ");
        sb.append(this.v);
        sb.append("#");
        sb.append(this.zk);
        sb.append("#");
        sb.append(this.m);
        sb.append(" updateInterval: ");
        sb.append(this.wu);
        sb.append(" updateRandom: ");
        sb.append(this.xu);
        sb.append(" httpBlack: ");
        sb.append(this.bh);
        return sb.toString();
    }
}
