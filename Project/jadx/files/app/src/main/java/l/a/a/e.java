package l.a.a;

import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: Spring.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static int f21016o;
    private f a;
    private boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f21017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f21018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f21019e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final b f21020f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private double f21021g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private double f21022h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f21023i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private double f21024j = 0.005d;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private double f21025k = 0.005d;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private CopyOnWriteArraySet<h> f21026l = new CopyOnWriteArraySet<>();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private double f21027m = PangleAdapterUtils.CPM_DEFLAUT_VALUE;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final l.a.a.b f21028n;

    /* JADX INFO: compiled from: Spring.java */
    private static class b {
        double a;
        double b;

        private b() {
        }
    }

    e(l.a.a.b bVar) {
        this.f21018d = new b();
        this.f21019e = new b();
        this.f21020f = new b();
        if (bVar == null) {
            throw new IllegalArgumentException("Spring cannot be created outside of a BaseSpringSystem");
        }
        this.f21028n = bVar;
        StringBuilder sb = new StringBuilder();
        sb.append("spring:");
        int i2 = f21016o;
        f21016o = i2 + 1;
        sb.append(i2);
        this.f21017c = sb.toString();
        a(f.f21029c);
    }

    public e a(f fVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("springConfig is required");
        }
        this.a = fVar;
        return this;
    }

    public e b(double d2) {
        a(d2, true);
        return this;
    }

    public String c() {
        return this.f21017c;
    }

    public e d(double d2) {
        b bVar = this.f21018d;
        if (d2 == bVar.b) {
            return this;
        }
        bVar.b = d2;
        this.f21028n.a(c());
        return this;
    }

    public boolean e() {
        return this.a.b > PangleAdapterUtils.CPM_DEFLAUT_VALUE && ((this.f21021g < this.f21022h && a() > this.f21022h) || (this.f21021g > this.f21022h && a() < this.f21022h));
    }

    public e f() {
        b bVar = this.f21018d;
        double d2 = bVar.a;
        this.f21022h = d2;
        this.f21020f.a = d2;
        bVar.b = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        return this;
    }

    public boolean g() {
        return (d() && h()) ? false : true;
    }

    public boolean h() {
        return this.f21023i;
    }

    private void e(double d2) {
        b bVar = this.f21018d;
        double d3 = bVar.a * d2;
        b bVar2 = this.f21019e;
        double d4 = 1.0d - d2;
        bVar.a = d3 + (bVar2.a * d4);
        bVar.b = (bVar.b * d2) + (bVar2.b * d4);
    }

    public double b() {
        return this.f21022h;
    }

    public e c(double d2) {
        if (this.f21022h == d2 && d()) {
            return this;
        }
        this.f21021g = a();
        this.f21022h = d2;
        this.f21028n.a(c());
        Iterator<h> it = this.f21026l.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
        return this;
    }

    public e a(double d2, boolean z2) {
        this.f21021g = d2;
        this.f21018d.a = d2;
        this.f21028n.a(c());
        Iterator<h> it = this.f21026l.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        if (z2) {
            f();
        }
        return this;
    }

    public boolean d() {
        return Math.abs(this.f21018d.b) <= this.f21024j && (a(this.f21018d) <= this.f21025k || this.a.b == PangleAdapterUtils.CPM_DEFLAUT_VALUE);
    }

    public double a() {
        return this.f21018d.a;
    }

    private double a(b bVar) {
        return Math.abs(this.f21022h - bVar.a);
    }

    void a(double d2) {
        double d3;
        boolean z2;
        boolean zD = d();
        if (zD && this.f21023i) {
            return;
        }
        this.f21027m += d2 <= 0.064d ? d2 : 0.064d;
        f fVar = this.a;
        double d4 = fVar.b;
        double d5 = fVar.a;
        b bVar = this.f21018d;
        double d6 = bVar.a;
        double d7 = bVar.b;
        b bVar2 = this.f21020f;
        double d8 = bVar2.a;
        double d9 = bVar2.b;
        boolean z3 = zD;
        while (true) {
            d3 = this.f21027m;
            if (d3 < 0.001d) {
                break;
            }
            this.f21027m = d3 - 0.001d;
            if (this.f21027m < 0.001d) {
                b bVar3 = this.f21019e;
                bVar3.a = d6;
                bVar3.b = d7;
            }
            double d10 = this.f21022h;
            double d11 = ((d10 - d8) * d4) - (d5 * d7);
            double d12 = d7 + (d11 * 0.001d * 0.5d);
            double d13 = ((d10 - (((d7 * 0.001d) * 0.5d) + d6)) * d4) - (d5 * d12);
            double d14 = d7 + (d13 * 0.001d * 0.5d);
            double d15 = ((d10 - (d6 + ((d12 * 0.001d) * 0.5d))) * d4) - (d5 * d14);
            double d16 = d6 + (d14 * 0.001d);
            double d17 = d7 + (d15 * 0.001d);
            d6 += (d7 + ((d12 + d14) * 2.0d) + d17) * 0.16666666666666666d * 0.001d;
            d7 += (d11 + ((d13 + d15) * 2.0d) + (((d10 - d16) * d4) - (d5 * d17))) * 0.16666666666666666d * 0.001d;
            d8 = d16;
            d9 = d17;
        }
        b bVar4 = this.f21020f;
        bVar4.a = d8;
        bVar4.b = d9;
        b bVar5 = this.f21018d;
        bVar5.a = d6;
        bVar5.b = d7;
        if (d3 > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            e(d3 / 0.001d);
        }
        boolean z4 = true;
        if (d() || (this.b && e())) {
            if (d4 > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                double d18 = this.f21022h;
                this.f21021g = d18;
                this.f21018d.a = d18;
            } else {
                this.f21022h = this.f21018d.a;
                this.f21021g = this.f21022h;
            }
            d(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
            z3 = true;
        }
        if (this.f21023i) {
            this.f21023i = false;
            z2 = true;
        } else {
            z2 = false;
        }
        if (z3) {
            this.f21023i = true;
        } else {
            z4 = false;
        }
        for (h hVar : this.f21026l) {
            if (z2) {
                hVar.c(this);
            }
            hVar.a(this);
            if (z4) {
                hVar.d(this);
            }
        }
    }

    public e a(h hVar) {
        if (hVar != null) {
            this.f21026l.add(hVar);
            return this;
        }
        throw new IllegalArgumentException("newListener is required");
    }
}
