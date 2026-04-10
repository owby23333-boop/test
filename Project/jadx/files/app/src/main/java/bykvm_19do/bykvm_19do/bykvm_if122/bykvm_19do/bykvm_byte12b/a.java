package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private String a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f1398c;

    public a(String str, String str2, long j2) {
        this.a = str2;
        this.b = str;
        this.f1398c = j2;
    }

    public long a() {
        return this.f1398c;
    }

    public String toString() {
        return "AdnLoadFailShowBean{slotId='" + this.a + "', adnName='" + this.b + "', effectiveTime=" + this.f1398c + '}';
    }
}
