package com.bytedance.adsdk.lottie.z.g;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class wp extends e<com.bytedance.adsdk.lottie.m.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.m.a f202a;

    public wp(List<com.bytedance.adsdk.lottie.m.z<com.bytedance.adsdk.lottie.m.a>> list) {
        super(list);
        this.f202a = new com.bytedance.adsdk.lottie.m.a();
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
    @Override // com.bytedance.adsdk.lottie.z.g.z
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.m.a z(com.bytedance.adsdk.lottie.m.z<com.bytedance.adsdk.lottie.m.a> zVar, float f) {
        com.bytedance.adsdk.lottie.m.a aVar;
        if (zVar.z == null || zVar.g == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.bytedance.adsdk.lottie.m.a aVar2 = zVar.z;
        com.bytedance.adsdk.lottie.m.a aVar3 = zVar.g;
        if (this.dl != null && (aVar = (com.bytedance.adsdk.lottie.m.a) this.dl.z(zVar.m, zVar.e.floatValue(), aVar2, aVar3, f, a(), gz())) != null) {
            return aVar;
        }
        this.f202a.z(com.bytedance.adsdk.lottie.gc.gz.z(aVar2.z(), aVar3.z(), f), com.bytedance.adsdk.lottie.gc.gz.z(aVar2.g(), aVar3.g(), f));
        return this.f202a;
    }
}
