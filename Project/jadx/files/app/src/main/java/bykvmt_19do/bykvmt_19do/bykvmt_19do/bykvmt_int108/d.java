package bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: TTRitConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements Serializable {
    private String a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList<e> f2142c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2143d;

    public int a() {
        return this.f2143d;
    }

    public String b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    public List<e> d() {
        return this.f2142c;
    }

    public void a(int i2) {
        this.f2143d = i2;
    }

    public void b(int i2) {
        this.b = i2;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(ArrayList<e> arrayList) {
        this.f2142c = arrayList;
    }
}
