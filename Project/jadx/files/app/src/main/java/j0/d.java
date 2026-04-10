package j0;

/* JADX INFO: compiled from: ValueData.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    public int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f20919c = System.currentTimeMillis() + 86400000;
    public String a = null;

    public d(String str, int i2) {
        this.b = i2;
    }

    public String toString() {
        StringBuilder sbA = y.b.a("ValueData{value='");
        sbA.append(this.a);
        sbA.append('\'');
        sbA.append(", code=");
        sbA.append(this.b);
        sbA.append(", expired=");
        sbA.append(this.f20919c);
        sbA.append('}');
        return sbA.toString();
    }
}
