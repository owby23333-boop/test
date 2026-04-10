package com.yuewen;

/* JADX INFO: loaded from: classes10.dex */
public class vu1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f19285a;

    public interface a {
        void a();
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final vu1 f19286a = new vu1();
    }

    public static vu1 a() {
        return b.f19286a;
    }

    public void b() {
        a aVar = this.f19285a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void c(a aVar) {
        this.f19285a = aVar;
    }

    public vu1() {
        this.f19285a = null;
    }
}
