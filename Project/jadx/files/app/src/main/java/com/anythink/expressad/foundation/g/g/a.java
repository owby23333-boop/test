package com.anythink.expressad.foundation.g.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements Runnable {
    public static long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EnumC0209a f10605c = EnumC0209a.READY;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f10606d;

    /* JADX INFO: renamed from: com.anythink.expressad.foundation.g.g.a$a, reason: collision with other inner class name */
    public enum EnumC0209a {
        READY,
        RUNNING,
        PAUSE,
        CANCEL,
        FINISH
    }

    public interface b {
        void a(EnumC0209a enumC0209a);
    }

    public a() {
        b++;
    }

    private void a(EnumC0209a enumC0209a) {
        this.f10605c = enumC0209a;
        b bVar = this.f10606d;
        if (bVar != null) {
            bVar.a(enumC0209a);
        }
    }

    private EnumC0209a d() {
        return this.f10605c;
    }

    public static long e() {
        return b;
    }

    public abstract void a();

    public abstract void b();

    public abstract void c();

    public final void f() {
        EnumC0209a enumC0209a = this.f10605c;
        EnumC0209a enumC0209a2 = EnumC0209a.CANCEL;
        if (enumC0209a != enumC0209a2) {
            a(enumC0209a2);
        }
    }

    public final void g() {
        EnumC0209a enumC0209a = this.f10605c;
        if (enumC0209a == EnumC0209a.PAUSE || enumC0209a == EnumC0209a.CANCEL || enumC0209a == EnumC0209a.FINISH) {
            return;
        }
        a(EnumC0209a.RUNNING);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f10605c == EnumC0209a.READY) {
                a(EnumC0209a.RUNNING);
                a();
                a(EnumC0209a.FINISH);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(b bVar) {
        this.f10606d = bVar;
    }
}
