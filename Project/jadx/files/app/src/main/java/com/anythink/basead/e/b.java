package com.anythink.basead.e;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static final String a = "b";
    private Map<String, InterfaceC0141b> b;

    private static class a {
        private static final b a = new b(0);

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.e.b$b, reason: collision with other inner class name */
    public interface InterfaceC0141b extends Serializable {
        void a();

        void a(int i2);

        void a(com.anythink.basead.c.e eVar);

        void a(boolean z2);

        void b();

        void c();

        void d();

        void e();
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public static b a() {
        return a.a;
    }

    public final void b(String str) {
        this.b.remove(str);
    }

    private b() {
        this.b = new HashMap(2);
    }

    public final void a(String str, InterfaceC0141b interfaceC0141b) {
        this.b.put(str, interfaceC0141b);
    }

    public final InterfaceC0141b a(String str) {
        return this.b.get(str);
    }
}
