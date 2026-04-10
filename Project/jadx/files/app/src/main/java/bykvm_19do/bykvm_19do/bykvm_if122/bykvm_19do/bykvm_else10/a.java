package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final Map<String, InterfaceC0042a> a = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.a$a, reason: collision with other inner class name */
    public interface InterfaceC0042a {
        void a();

        void a(String str);
    }

    public static void a(String str) {
        InterfaceC0042a interfaceC0042aB;
        if (TextUtils.isEmpty(str) || (interfaceC0042aB = b(str)) == null) {
            return;
        }
        interfaceC0042aB.a();
    }

    public static void a(String str, String str2) {
        InterfaceC0042a interfaceC0042aB;
        if (TextUtils.isEmpty(str) || (interfaceC0042aB = b(str)) == null) {
            return;
        }
        interfaceC0042aB.a(str2);
    }

    private static InterfaceC0042a b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return a.remove(str);
    }
}
