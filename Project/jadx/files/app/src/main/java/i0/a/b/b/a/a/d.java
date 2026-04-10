package i0.a.b.b.a.a;

/* JADX INFO: loaded from: classes3.dex */
class d {
    public String a;
    public int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f20846c = System.currentTimeMillis() + 86400000;

    public d(String str, int i2) {
        this.a = str;
        this.b = i2;
    }

    public String toString() {
        return "ValueData{value='" + this.a + "', code=" + this.b + ", expired=" + this.f20846c + '}';
    }
}
