package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public boolean a = false;
    public boolean b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, Integer> f817c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, String> f818d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f819e = 10;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f820f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f821g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f822h = 10;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f823i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f824j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f825k = 900;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f826l = 120;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f827m = null;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" localEnable: ");
        sb.append(this.a);
        sb.append(" probeEnable: ");
        sb.append(this.b);
        sb.append(" hostFilter: ");
        Map<String, Integer> map = this.f817c;
        sb.append(map != null ? map.size() : 0);
        sb.append(" hostMap: ");
        Map<String, String> map2 = this.f818d;
        sb.append(map2 != null ? map2.size() : 0);
        sb.append(" reqTo: ");
        sb.append(this.f819e);
        sb.append("#");
        sb.append(this.f820f);
        sb.append("#");
        sb.append(this.f821g);
        sb.append(" reqErr: ");
        sb.append(this.f822h);
        sb.append("#");
        sb.append(this.f823i);
        sb.append("#");
        sb.append(this.f824j);
        sb.append(" updateInterval: ");
        sb.append(this.f825k);
        sb.append(" updateRandom: ");
        sb.append(this.f826l);
        sb.append(" httpBlack: ");
        sb.append(this.f827m);
        return sb.toString();
    }
}
