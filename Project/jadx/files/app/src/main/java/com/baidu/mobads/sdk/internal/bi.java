package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.internal.bf;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
class bi implements Runnable {
    final /* synthetic */ IOAdEvent a;
    final /* synthetic */ bf.a b;

    bi(bf.a aVar, IOAdEvent iOAdEvent) {
        this.b = aVar;
        this.a = iOAdEvent;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Runnable
    public void run() {
        HashMap map;
        IOAdEvent iOAdEvent = this.a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.a.getType();
        if (w.J.equals(type)) {
            bf.this.a(this.a);
            return;
        }
        if (w.M.equals(type)) {
            bf.this.f12901n = this.a.getMessage();
            bf.this.q();
            return;
        }
        if (w.N.equals(type)) {
            bf.this.e(this.a);
            return;
        }
        if (w.O.equals(type)) {
            bf.this.f(this.a);
            return;
        }
        if (w.W.equals(type)) {
            bf.this.g(this.a);
            return;
        }
        String str = "";
        boolean zEquals = false;
        int iIntValue = 0;
        int iIntValue2 = 0;
        zEquals = false;
        if (w.f13193r.equals(type)) {
            HashMap map2 = (HashMap) this.a.getData();
            if (map2 != null) {
                str = (String) map2.get("error_message");
                Object obj = map2.get("error_code");
                Object obj2 = obj;
                if (obj == null) {
                    obj2 = 0;
                }
                iIntValue = ((Integer) obj2).intValue();
            }
            bf.this.b(str, iIntValue);
            return;
        }
        if (w.L.equals(type)) {
            HashMap map3 = (HashMap) this.a.getData();
            if (map3 != null) {
                str = (String) map3.get("error_message");
                Object obj3 = map3.get("error_code");
                Object obj4 = obj3;
                if (obj3 == null) {
                    obj4 = 0;
                }
                iIntValue2 = ((Integer) obj4).intValue();
            }
            bf.this.a(iIntValue2, str);
            return;
        }
        if (w.H.equals(type)) {
            bf.this.h(this.a);
            return;
        }
        if (w.X.equals(type)) {
            bf.this.d();
            return;
        }
        if (w.Y.equals(type)) {
            bf.this.d(this.a);
            return;
        }
        if (w.aa.equals(type)) {
            bf.this.s();
            return;
        }
        if (w.ab.equals(type)) {
            IOAdEvent iOAdEvent2 = this.a;
            if (iOAdEvent2 != null && (map = (HashMap) iOAdEvent2.getData()) != null) {
                zEquals = "1".equals((String) map.get("serverVerify"));
            }
            bf.this.b(zEquals);
            return;
        }
        if (w.ac.equals(type)) {
            bf.this.b_();
            return;
        }
        if (w.ad.equals(type)) {
            bf.this.c_();
            return;
        }
        if (w.K.equals(type)) {
            bf.this.b(this.a);
            return;
        }
        if (w.ae.equals(type)) {
            bf.this.a(this.a.getMessage(), 1 == this.a.getCode());
            return;
        }
        if (w.af.equals(type)) {
            bf.this.e(this.a.getMessage());
            return;
        }
        if (w.ag.equals(type)) {
            bf.this.d(this.a.getMessage());
            return;
        }
        if (w.D.equals(type)) {
            bf.this.f(this.a.getMessage());
            return;
        }
        if (w.Z.equals(type)) {
            bf.this.t();
            return;
        }
        if (w.ah.equals(type)) {
            bf.this.b(this.a.getMessage(), 1 == this.a.getCode());
            return;
        }
        if (w.aj.equals(type)) {
            bf.this.c(this.a);
            return;
        }
        if (w.ai.equals(type)) {
            bf.this.u();
            return;
        }
        if (w.al.equals(type)) {
            bf.this.i(this.a);
        } else if (w.am.equals(type)) {
            bf.this.j(this.a);
        } else if (w.ak.equals(type)) {
            bf.this.k(this.a);
        }
    }
}
