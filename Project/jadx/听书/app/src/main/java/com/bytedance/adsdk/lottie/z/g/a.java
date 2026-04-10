package com.bytedance.adsdk.lottie.z.g;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a extends e<Float> {
    public a(List<com.bytedance.adsdk.lottie.m.z<Float>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.lottie.z.g.z
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Float z(com.bytedance.adsdk.lottie.m.z<Float> zVar, float f) {
        return Float.valueOf(dl(zVar, f));
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
    float dl(com.bytedance.adsdk.lottie.m.z<Float> zVar, float f) {
        Float f2;
        if (zVar.z == null || zVar.g == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.dl != null && (f2 = (Float) this.dl.z(zVar.m, zVar.e.floatValue(), zVar.z, zVar.g, f, a(), gz())) != null) {
            return f2.floatValue();
        }
        return com.bytedance.adsdk.lottie.gc.gz.z(zVar.m(), zVar.e(), f);
    }

    public float fo() {
        return dl(dl(), gc());
    }
}
