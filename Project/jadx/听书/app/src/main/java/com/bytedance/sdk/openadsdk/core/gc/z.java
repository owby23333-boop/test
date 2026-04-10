package com.bytedance.sdk.openadsdk.core.gc;

import com.bytedance.sdk.openadsdk.core.iq.j;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.ls.dl.g.v;
import com.bytedance.sdk.openadsdk.tb.z.g.z.m;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z<T, V> {
    com.bytedance.sdk.openadsdk.core.gc.gc.a z = new com.bytedance.sdk.openadsdk.core.gc.gc.a(z());

    protected abstract int z();

    protected abstract void z(T t, int i, String str);

    protected abstract void z(T t, V v);

    protected z() {
    }

    protected j z(boolean z, boolean z2, long j) {
        j jVar = new j();
        jVar.gz = j;
        if (z) {
            jVar.z = 2;
        }
        if (z2) {
            jVar.m = 2;
        }
        return jVar;
    }

    public void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final T t, long j) {
        com.bytedance.sdk.openadsdk.core.gc.gc.a aVar = this.z;
        if (aVar != null) {
            aVar.z(gVar, z(false, false, j), -1, new com.bytedance.sdk.openadsdk.core.gc.gc.gc<V>() { // from class: com.bytedance.sdk.openadsdk.core.gc.z.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.bytedance.sdk.openadsdk.core.gc.gc.gc
                public void z(V v) {
                    gVar.a();
                    z.this.z(t, v);
                }

                @Override // com.bytedance.sdk.openadsdk.core.gc.gc.gc
                public void g(V v) {
                    gVar.a();
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // com.bytedance.sdk.openadsdk.core.gc.gc.gc
                public void z(int i, String str) {
                    gVar.a();
                    z.this.z(t, i, str);
                }
            });
        }
    }

    public void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final m mVar, long j) {
        com.bytedance.sdk.openadsdk.core.gc.gc.a aVar = this.z;
        if (aVar != null) {
            aVar.z(gVar, z(false, true, j), -1, new com.bytedance.sdk.openadsdk.core.gc.gc.gc<List<v>>() { // from class: com.bytedance.sdk.openadsdk.core.gc.z.2
                @Override // com.bytedance.sdk.openadsdk.core.gc.gc.gc
                public void z(List<v> list) {
                    gVar.a();
                    m mVar2 = mVar;
                    if (mVar2 != null) {
                        mVar2.z(list);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.gc.gc.gc
                public void g(List<v> list) {
                    gVar.a();
                }

                @Override // com.bytedance.sdk.openadsdk.core.gc.gc.gc
                public void z(int i, String str) {
                    gVar.a();
                    m mVar2 = mVar;
                    if (mVar2 != null) {
                        mVar2.z(i, str);
                    }
                }
            });
        }
    }

    public static z z(int i) {
        if (i == 1) {
            return com.bytedance.sdk.openadsdk.core.component.z.z.g();
        }
        if (i == 9) {
            return com.bytedance.sdk.openadsdk.core.component.g.z.g();
        }
        if (i == 5) {
            return com.bytedance.sdk.openadsdk.core.component.dl.z.g();
        }
        if (i != 6) {
            return null;
        }
        return com.bytedance.sdk.openadsdk.core.component.a.z.g();
    }

    public void z(na naVar) {
        com.bytedance.sdk.openadsdk.core.gc.gc.a aVar = this.z;
        if (aVar != null) {
            aVar.z().z(naVar);
        }
    }

    public static void z(int i, na naVar) {
        z zVarZ = z(i);
        if (zVarZ != null) {
            zVarZ.z(naVar);
        }
    }
}
