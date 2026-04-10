package anet.channel.monitor;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class f {
    protected long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f363c = 40.0d;
    boolean a = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f364d = true;

    public int a() {
        return 0;
    }

    public boolean a(double d2) {
        return d2 < 40.0d;
    }

    protected final boolean b() {
        if (!this.f364d) {
            return false;
        }
        if (System.currentTimeMillis() - this.b <= a() * 1000) {
            return true;
        }
        this.f364d = false;
        return false;
    }
}
