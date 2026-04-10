package com.bytedance.adsdk.ugeno.yoga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class YogaNodeJNIBase extends uy implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f258a;
    private float[] arr;
    private List<YogaNodeJNIBase> dl;
    private boolean e;
    private YogaNodeJNIBase g;
    private g gc;
    private Object m;
    private int mLayoutDirection;
    protected long z;

    private YogaNodeJNIBase(long j) {
        this.arr = null;
        this.mLayoutDirection = 0;
        this.e = true;
        if (j == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
        this.z = j;
    }

    YogaNodeJNIBase() {
        this(YogaNative.jni_YGNodeNewJNI());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public int z() {
        List<YogaNodeJNIBase> list = this.dl;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    /* JADX INFO: renamed from: dl, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase z(int i) {
        List<YogaNodeJNIBase> list = this.dl;
        if (list == null) {
            throw new IllegalStateException("YogaNode does not have children");
        }
        return list.get(i);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void z(uy uyVar, int i) {
        if (uyVar instanceof YogaNodeJNIBase) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) uyVar;
            if (yogaNodeJNIBase.g != null) {
                throw new IllegalStateException("Child already has a parent, it must be removed first.");
            }
            if (this.dl == null) {
                this.dl = new ArrayList(4);
            }
            this.dl.add(i, yogaNodeJNIBase);
            yogaNodeJNIBase.g = this;
            YogaNative.jni_YGNodeInsertChildJNI(this.z, yogaNodeJNIBase.z, i);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase g(int i) {
        List<YogaNodeJNIBase> list = this.dl;
        if (list == null) {
            throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
        }
        YogaNodeJNIBase yogaNodeJNIBaseRemove = list.remove(i);
        yogaNodeJNIBaseRemove.g = null;
        YogaNative.jni_YGNodeRemoveChildJNI(this.z, yogaNodeJNIBaseRemove.z);
        return yogaNodeJNIBaseRemove;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    /* JADX INFO: renamed from: kb, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase g() {
        return this.g;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public int z(uy uyVar) {
        List<YogaNodeJNIBase> list = this.dl;
        if (list == null) {
            return -1;
        }
        return list.indexOf(uyVar);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void z(float f, float f2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        for (int i = 0; i < arrayList.size(); i++) {
            List<YogaNodeJNIBase> list = ((YogaNodeJNIBase) arrayList.get(i)).dl;
            if (list != null) {
                Iterator<YogaNodeJNIBase> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            }
        }
        YogaNodeJNIBase[] yogaNodeJNIBaseArr = (YogaNodeJNIBase[]) arrayList.toArray(new YogaNodeJNIBase[arrayList.size()]);
        long[] jArr = new long[yogaNodeJNIBaseArr.length];
        for (int i2 = 0; i2 < yogaNodeJNIBaseArr.length; i2++) {
            jArr[i2] = yogaNodeJNIBaseArr[i2].z;
        }
        YogaNative.jni_YGNodeCalculateLayoutJNI(this.z, f, f2, jArr, yogaNodeJNIBaseArr);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void z(dl dlVar) {
        YogaNative.jni_YGNodeStyleSetDirectionJNI(this.z, dlVar.z());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void z(gc gcVar) {
        YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(this.z, gcVar.z());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void z(m mVar) {
        YogaNative.jni_YGNodeStyleSetJustifyContentJNI(this.z, mVar.z());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void z(z zVar) {
        YogaNative.jni_YGNodeStyleSetAlignItemsJNI(this.z, zVar.z());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void g(z zVar) {
        YogaNative.jni_YGNodeStyleSetAlignSelfJNI(this.z, zVar.z());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void dl(z zVar) {
        YogaNative.jni_YGNodeStyleSetAlignContentJNI(this.z, zVar.z());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void z(i iVar) {
        YogaNative.jni_YGNodeStyleSetPositionTypeJNI(this.z, iVar.z());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void z(v vVar) {
        YogaNative.jni_YGNodeStyleSetFlexWrapJNI(this.z, vVar.z());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void z(float f) {
        YogaNative.jni_YGNodeStyleSetFlexGrowJNI(this.z, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void g(float f) {
        YogaNative.jni_YGNodeStyleSetFlexShrinkJNI(this.z, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void dl(float f) {
        YogaNative.jni_YGNodeStyleSetFlexBasisJNI(this.z, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void dl() {
        YogaNative.jni_YGNodeStyleSetFlexBasisAutoJNI(this.z);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void z(a aVar, float f) {
        YogaNative.jni_YGNodeStyleSetMarginJNI(this.z, aVar.z(), f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void g(a aVar, float f) {
        YogaNative.jni_YGNodeStyleSetPaddingJNI(this.z, aVar.z(), f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void dl(a aVar, float f) {
        YogaNative.jni_YGNodeStyleSetPositionJNI(this.z, aVar.z(), f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void a(float f) {
        YogaNative.jni_YGNodeStyleSetWidthJNI(this.z, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void gc(float f) {
        YogaNative.jni_YGNodeStyleSetWidthPercentJNI(this.z, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void a() {
        YogaNative.jni_YGNodeStyleSetWidthAutoJNI(this.z);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void m(float f) {
        YogaNative.jni_YGNodeStyleSetHeightJNI(this.z, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void e(float f) {
        YogaNative.jni_YGNodeStyleSetHeightPercentJNI(this.z, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void gc() {
        YogaNative.jni_YGNodeStyleSetHeightAutoJNI(this.z);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void gz(float f) {
        YogaNative.jni_YGNodeStyleSetMinWidthJNI(this.z, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void fo(float f) {
        YogaNative.jni_YGNodeStyleSetMinHeightJNI(this.z, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void uy(float f) {
        YogaNative.jni_YGNodeStyleSetMaxWidthJNI(this.z, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void kb(float f) {
        YogaNative.jni_YGNodeStyleSetMaxHeightJNI(this.z, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void wp(float f) {
        YogaNative.jni_YGNodeStyleSetAspectRatioJNI(this.z, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void z(e eVar) {
        this.f258a = eVar;
        YogaNative.jni_YGNodeSetHasMeasureFuncJNI(this.z, eVar != null);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void z(boolean z) {
        YogaNative.jni_YGNodeSetAlwaysFormsContainingBlockJNI(this.z, z);
    }

    public final long measure(float f, int i, float f2, int i2) {
        if (!wp()) {
            throw new RuntimeException("Measure function isn't defined!");
        }
        return this.f258a.z(this, f, gz.z(i), f2, gz.z(i2));
    }

    public final float baseline(float f, float f2) {
        return this.gc.z(this, f, f2);
    }

    public boolean wp() {
        return this.f258a != null;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public void z(Object obj) {
        this.m = obj;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public Object uy() {
        return this.m;
    }

    private final long replaceChild(YogaNodeJNIBase yogaNodeJNIBase, int i) {
        List<YogaNodeJNIBase> list = this.dl;
        if (list == null) {
            throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
        }
        list.remove(i);
        this.dl.add(i, yogaNodeJNIBase);
        yogaNodeJNIBase.g = this;
        return yogaNodeJNIBase.z;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public float m() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[3];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public float e() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[4];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public float gz() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[1];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.uy
    public float fo() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[2];
        }
        return 0.0f;
    }
}
