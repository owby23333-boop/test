package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class g implements t {
    private int a;

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t
    public a0 a(t.a aVar) throws IOException {
        a0 a0VarA;
        y yVarB = aVar.b();
        if (h.a().a(this.a).a() != null) {
            h.a().a(this.a).a().e();
        }
        String string = yVarB.g().toString();
        String strA = h.a().a(this.a).a(string);
        if (!string.equals(strA)) {
            yVarB = yVarB.f().b(strA).a();
        }
        try {
            a0VarA = aVar.a(yVarB);
        } catch (Exception e2) {
            h.a().a(this.a).a(yVarB, e2);
            a0VarA = null;
        }
        h.a().a(this.a).a(yVarB, a0VarA);
        return a0VarA == null ? aVar.a(yVarB) : a0VarA;
    }

    public void a(int i2) {
        this.a = i2;
    }
}
