package com.bytedance.adsdk.lottie.z.g;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class uy extends e<PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PointF f200a;
    private fo e;
    private final float[] gc;
    private final PathMeasure m;

    public uy(List<? extends com.bytedance.adsdk.lottie.m.z<PointF>> list) {
        super(list);
        this.f200a = new PointF();
        this.gc = new float[2];
        this.m = new PathMeasure();
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
    @Override // com.bytedance.adsdk.lottie.z.g.z
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public PointF z(com.bytedance.adsdk.lottie.m.z<PointF> zVar, float f) {
        PointF pointF;
        fo foVar = (fo) zVar;
        Path pathG = foVar.g();
        if (pathG == null) {
            return zVar.z;
        }
        if (this.dl != null && (pointF = (PointF) this.dl.z(foVar.m, foVar.e.floatValue(), foVar.z, foVar.g, a(), f, gz())) != null) {
            return pointF;
        }
        if (this.e != foVar) {
            this.m.setPath(pathG, false);
            this.e = foVar;
        }
        PathMeasure pathMeasure = this.m;
        pathMeasure.getPosTan(f * pathMeasure.getLength(), this.gc, null);
        PointF pointF2 = this.f200a;
        float[] fArr = this.gc;
        pointF2.set(fArr[0], fArr[1]);
        return this.f200a;
    }
}
