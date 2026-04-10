package com.bytedance.adsdk.lottie.e.bf;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class wu extends p<PointF> {
    private final PointF tg;

    public wu(List<com.bytedance.adsdk.lottie.p.e<PointF>> list) {
        super(list);
        this.tg = new PointF();
    }

    @Override // com.bytedance.adsdk.lottie.e.bf.e
    /* JADX INFO: renamed from: bf, reason: merged with bridge method [inline-methods] */
    public PointF e(com.bytedance.adsdk.lottie.p.e<PointF> eVar, float f) {
        return e(eVar, f, f, f);
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
    public PointF e(com.bytedance.adsdk.lottie.p.e<PointF> eVar, float f, float f2, float f3) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = eVar.e;
        if (pointF3 == null || (pointF = eVar.bf) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF4 = pointF3;
        PointF pointF5 = pointF;
        com.bytedance.adsdk.lottie.p.d<A> dVar = this.d;
        if (dVar != 0 && (pointF2 = (PointF) dVar.e(eVar.vn, eVar.p.floatValue(), pointF4, pointF5, f, tg(), v())) != null) {
            return pointF2;
        }
        PointF pointF6 = this.tg;
        float f4 = pointF4.x;
        float f5 = f4 + (f2 * (pointF5.x - f4));
        float f6 = pointF4.y;
        pointF6.set(f5, f6 + (f3 * (pointF5.y - f6)));
        return this.tg;
    }
}
