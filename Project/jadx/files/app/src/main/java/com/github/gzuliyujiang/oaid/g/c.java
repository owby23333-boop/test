package com.github.gzuliyujiang.oaid.g;

import android.app.KeyguardManager;
import android.content.Context;
import com.github.gzuliyujiang.oaid.OAIDException;
import java.util.Objects;

/* JADX INFO: compiled from: CooseaImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements com.github.gzuliyujiang.oaid.d {
    private final Context a;
    private final KeyguardManager b;

    public c(Context context) {
        this.a = context;
        this.b = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.github.gzuliyujiang.oaid.d
    public boolean a() {
        KeyguardManager keyguardManager;
        if (this.a == null || (keyguardManager = this.b) == null) {
            return false;
        }
        try {
            return ((Boolean) Objects.requireNonNull(keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.b, new Object[0]))).booleanValue();
        } catch (Exception e2) {
            com.github.gzuliyujiang.oaid.e.a(e2);
            return false;
        }
    }

    @Override // com.github.gzuliyujiang.oaid.d
    public void a(com.github.gzuliyujiang.oaid.c cVar) {
        if (this.a == null || cVar == null) {
            return;
        }
        KeyguardManager keyguardManager = this.b;
        if (keyguardManager == null) {
            cVar.a(new OAIDException("KeyguardManager not found"));
            return;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.b, new Object[0]);
            if (objInvoke != null) {
                String string = objInvoke.toString();
                com.github.gzuliyujiang.oaid.e.a("OAID obtain success: " + string);
                cVar.a(string);
                return;
            }
            throw new OAIDException("OAID obtain failed");
        } catch (Exception e2) {
            com.github.gzuliyujiang.oaid.e.a(e2);
        }
    }
}
