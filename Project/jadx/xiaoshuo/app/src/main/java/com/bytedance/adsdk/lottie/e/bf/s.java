package com.bytedance.adsdk.lottie.e.bf;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class s extends p<com.bytedance.adsdk.lottie.d.bf> {
    public s(List<com.bytedance.adsdk.lottie.p.e<com.bytedance.adsdk.lottie.d.bf>> list) {
        super(list);
    }

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
    @Override // com.bytedance.adsdk.lottie.e.bf.e
    /* JADX INFO: renamed from: bf, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.d.bf e(com.bytedance.adsdk.lottie.p.e<com.bytedance.adsdk.lottie.d.bf> eVar, float f) {
        com.bytedance.adsdk.lottie.d.bf bfVar;
        com.bytedance.adsdk.lottie.p.d<A> dVar = this.d;
        if (dVar == 0) {
            return (f != 1.0f || (bfVar = eVar.bf) == null) ? eVar.e : bfVar;
        }
        float f2 = eVar.vn;
        Float f3 = eVar.p;
        float fFloatValue = f3 == null ? Float.MAX_VALUE : f3.floatValue();
        com.bytedance.adsdk.lottie.d.bf bfVar2 = eVar.e;
        com.bytedance.adsdk.lottie.d.bf bfVar3 = eVar.bf;
        return (com.bytedance.adsdk.lottie.d.bf) dVar.e(f2, fFloatValue, bfVar2, bfVar3 == null ? bfVar2 : bfVar3, f, ga(), v());
    }

    public void bf(final com.bytedance.adsdk.lottie.p.d<String> dVar) {
        final com.bytedance.adsdk.lottie.p.bf bfVar = new com.bytedance.adsdk.lottie.p.bf();
        final com.bytedance.adsdk.lottie.d.bf bfVar2 = new com.bytedance.adsdk.lottie.d.bf();
        super.e(new com.bytedance.adsdk.lottie.p.d<com.bytedance.adsdk.lottie.d.bf>() { // from class: com.bytedance.adsdk.lottie.e.bf.s.1
            @Override // com.bytedance.adsdk.lottie.p.d
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public com.bytedance.adsdk.lottie.d.bf bf(com.bytedance.adsdk.lottie.p.bf<com.bytedance.adsdk.lottie.d.bf> bfVar3) {
                bfVar.e(bfVar3.e(), bfVar3.bf(), bfVar3.d().e, bfVar3.tg().e, bfVar3.ga(), bfVar3.vn(), bfVar3.p());
                String str = (String) dVar.bf(bfVar);
                com.bytedance.adsdk.lottie.d.bf bfVarTg = bfVar3.vn() == 1.0f ? bfVar3.tg() : bfVar3.d();
                bfVar2.e(str, bfVarTg.bf, bfVarTg.d, bfVarTg.tg, bfVarTg.ga, bfVarTg.vn, bfVarTg.p, bfVarTg.v, bfVarTg.zk, bfVarTg.m, bfVarTg.wu, bfVarTg.xu, bfVarTg.bh);
                return bfVar2;
            }
        });
    }
}
