package com.bytedance.adsdk.lottie.z.g;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class kb extends e<PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PointF f197a;

    public kb(List<com.bytedance.adsdk.lottie.m.z<PointF>> list) {
        super(list);
        this.f197a = new PointF();
    }

    @Override // com.bytedance.adsdk.lottie.z.g.z
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public PointF z(com.bytedance.adsdk.lottie.m.z<PointF> zVar, float f) {
        return z(zVar, f, f, f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
    public PointF z(com.bytedance.adsdk.lottie.m.z<PointF> zVar, float f, float f2, float f3) {
        PointF pointF;
        if (zVar.z == null || zVar.g == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = zVar.z;
        PointF pointF3 = zVar.g;
        if (this.dl != null && (pointF = (PointF) this.dl.z(zVar.m, zVar.e.floatValue(), pointF2, pointF3, f, a(), gz())) != null) {
            return pointF;
        }
        this.f197a.set(pointF2.x + (f2 * (pointF3.x - pointF2.x)), pointF2.y + (f3 * (pointF3.y - pointF2.y)));
        return this.f197a;
    }
}
