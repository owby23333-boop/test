package com.bytedance.sdk.component.z;

import com.bytedance.sdk.component.z.a;
import com.bytedance.sdk.component.z.iq;
import com.bytedance.sdk.component.z.js;
import com.bytedance.sdk.component.z.q;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
class e implements iq.z {
    private final i e;
    private final boolean fo;
    private final tb g;
    private final boolean gz;
    private final com.bytedance.sdk.component.z.z uy;
    private final gz z;
    private final Map<String, g> dl = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, a.g> f856a = new HashMap();
    private final List<ls> gc = new ArrayList();
    private final Set<a> m = new HashSet();

    e(uy uyVar, com.bytedance.sdk.component.z.z zVar, q qVar) {
        this.uy = zVar;
        this.z = uyVar.f866a;
        tb tbVar = new tb(qVar, uyVar.wp, uyVar.i);
        this.g = tbVar;
        tbVar.z(this);
        tbVar.z(uyVar.ls);
        this.e = uyVar.fo;
        this.gz = uyVar.gz;
        this.fo = uyVar.pf;
    }

    z z(ls lsVar, m mVar) throws Exception {
        g gVar = this.dl.get(lsVar.f859a);
        if (gVar != null) {
            try {
                zw zwVarG = g(mVar.g, gVar);
                mVar.f861a = zwVarG;
                if (zwVarG == null) {
                    fo.z("Permission denied, call: ".concat(String.valueOf(lsVar)));
                    throw new fv(-1);
                }
                if (gVar instanceof gc) {
                    fo.z("Processing stateless call: ".concat(String.valueOf(lsVar)));
                    return z(lsVar, (gc) gVar, mVar);
                }
                if (gVar instanceof dl) {
                    fo.z("Processing raw call: ".concat(String.valueOf(lsVar)));
                    return z(lsVar, (dl) gVar, zwVarG);
                }
            } catch (q.z e) {
                fo.z("No remote permission config fetched, call pending: ".concat(String.valueOf(lsVar)), e);
                this.gc.add(lsVar);
                return new z(false, io.z());
            }
        }
        a.g gVar2 = this.f856a.get(lsVar.f859a);
        if (gVar2 != null) {
            a aVarZ = gVar2.z();
            aVarZ.z(lsVar.f859a);
            zw zwVarG2 = g(mVar.g, aVarZ);
            mVar.f861a = zwVarG2;
            if (zwVarG2 == null) {
                fo.z("Permission denied, call: ".concat(String.valueOf(lsVar)));
                aVarZ.gc();
                throw new fv(-1);
            }
            fo.z("Processing stateful call: ".concat(String.valueOf(lsVar)));
            return z(lsVar, aVarZ, mVar);
        }
        fo.g("Received call: " + lsVar + ", but not registered.");
        return null;
    }

    void z(String str, gc<?, ?> gcVar) {
        gcVar.z(str);
        this.dl.put(str, gcVar);
        fo.z("JsBridge stateless method registered: ".concat(String.valueOf(str)));
    }

    void z(String str, a.g gVar) {
        this.f856a.put(str, gVar);
        fo.z("JsBridge stateful method registered: ".concat(String.valueOf(str)));
    }

    void z() {
        Iterator<a> it = this.m.iterator();
        while (it.hasNext()) {
            it.next().m();
        }
        this.m.clear();
        this.dl.clear();
        this.f856a.clear();
        this.g.g(this);
    }

    private z z(ls lsVar, gc gcVar, m mVar) throws Exception {
        return new z(true, io.z(this.z.z(gcVar.z(z(lsVar.gc, (g) gcVar), mVar))));
    }

    private z z(final ls lsVar, final a aVar, m mVar) throws Exception {
        this.m.add(aVar);
        aVar.z(z(lsVar.gc, aVar), mVar, new a.z() { // from class: com.bytedance.sdk.component.z.e.1
            @Override // com.bytedance.sdk.component.z.a.z
            public void z(Object obj) {
                if (e.this.uy == null) {
                    return;
                }
                e.this.uy.g(io.z(e.this.z.z(obj)), lsVar);
                e.this.m.remove(aVar);
            }

            @Override // com.bytedance.sdk.component.z.a.z
            public void z(Throwable th) {
                if (e.this.uy == null) {
                    return;
                }
                e.this.uy.g(io.z(th), lsVar);
                e.this.m.remove(aVar);
            }
        });
        return new z(false, io.z());
    }

    private z z(final ls lsVar, dl dlVar, zw zwVar) throws Exception {
        new js(lsVar.f859a, zwVar, new js.z() { // from class: com.bytedance.sdk.component.z.e.2
        });
        return new z(false, io.z());
    }

    private Object z(String str, g gVar) throws JSONException {
        return this.z.z(str, z(gVar)[0]);
    }

    private zw g(String str, g gVar) {
        if (this.fo) {
            return zw.PRIVATE;
        }
        return this.g.z(this.gz, str, gVar);
    }

    private static Type[] z(Object obj) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        if (genericSuperclass == null) {
            throw new IllegalStateException("Method is not parameterized?!");
        }
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments();
    }

    static final class z {
        String g;
        boolean z;

        private z(boolean z, String str) {
            this.z = z;
            this.g = str;
        }
    }
}
