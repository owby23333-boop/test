package com.bytedance.adsdk.lottie.z.z;

import android.graphics.PointF;
import com.bytedance.adsdk.lottie.z.g.z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class p implements z.InterfaceC0041z, js {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.adsdk.lottie.model.g.v f212a;
    private final com.bytedance.adsdk.lottie.z.g.z<Float, Float> dl;
    private final String g;
    private final com.bytedance.adsdk.lottie.gz z;

    @Override // com.bytedance.adsdk.lottie.z.z.dl
    public void z(List<dl> list, List<dl> list2) {
    }

    public p(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar, com.bytedance.adsdk.lottie.model.g.i iVar) {
        this.z = gzVar;
        this.g = iVar.z();
        com.bytedance.adsdk.lottie.z.g.z<Float, Float> zVarZ = iVar.g().z();
        this.dl = zVarZ;
        dlVar.z(zVarZ);
        zVarZ.z(this);
    }

    @Override // com.bytedance.adsdk.lottie.z.g.z.InterfaceC0041z
    public void z() {
        this.z.invalidateSelf();
    }

    public com.bytedance.adsdk.lottie.z.g.z<Float, Float> g() {
        return this.dl;
    }

    @Override // com.bytedance.adsdk.lottie.z.z.js
    public com.bytedance.adsdk.lottie.model.g.v z(com.bytedance.adsdk.lottie.model.g.v vVar) {
        List<com.bytedance.adsdk.lottie.model.z> list;
        boolean z;
        List<com.bytedance.adsdk.lottie.model.z> listDl = vVar.dl();
        if (listDl.size() <= 2) {
            return vVar;
        }
        float fFloatValue = this.dl.e().floatValue();
        if (fFloatValue == 0.0f) {
            return vVar;
        }
        com.bytedance.adsdk.lottie.model.g.v vVarG = g(vVar);
        vVarG.z(vVar.z().x, vVar.z().y);
        List<com.bytedance.adsdk.lottie.model.z> listDl2 = vVarG.dl();
        boolean zG = vVar.g();
        int i = 0;
        int i2 = 0;
        while (i < listDl.size()) {
            com.bytedance.adsdk.lottie.model.z zVar = listDl.get(i);
            com.bytedance.adsdk.lottie.model.z zVar2 = listDl.get(z(i - 1, listDl.size()));
            com.bytedance.adsdk.lottie.model.z zVar3 = listDl.get(z(i - 2, listDl.size()));
            PointF pointFDl = (i != 0 || zG) ? zVar2.dl() : vVar.z();
            PointF pointFG = (i != 0 || zG) ? zVar2.g() : pointFDl;
            PointF pointFZ = zVar.z();
            PointF pointFDl2 = zVar3.dl();
            PointF pointFDl3 = zVar.dl();
            boolean z2 = !vVar.g() && i == 0 && i == listDl.size() + (-1);
            if (pointFG.equals(pointFDl) && pointFZ.equals(pointFDl) && !z2) {
                float f = pointFDl.x - pointFDl2.x;
                float f2 = pointFDl.y - pointFDl2.y;
                float f3 = pointFDl3.x - pointFDl.x;
                float f4 = pointFDl3.y - pointFDl.y;
                list = listDl;
                z = zG;
                float fHypot = (float) Math.hypot(f, f2);
                float fHypot2 = (float) Math.hypot(f3, f4);
                float fMin = Math.min(fFloatValue / fHypot, 0.5f);
                float fMin2 = Math.min(fFloatValue / fHypot2, 0.5f);
                float f5 = pointFDl.x + ((pointFDl2.x - pointFDl.x) * fMin);
                float f6 = pointFDl.y + ((pointFDl2.y - pointFDl.y) * fMin);
                float f7 = pointFDl.x + ((pointFDl3.x - pointFDl.x) * fMin2);
                float f8 = pointFDl.y + ((pointFDl3.y - pointFDl.y) * fMin2);
                float f9 = f5 - ((f5 - pointFDl.x) * 0.5519f);
                float f10 = f6 - ((f6 - pointFDl.y) * 0.5519f);
                float f11 = f7 - ((f7 - pointFDl.x) * 0.5519f);
                float f12 = f8 - ((f8 - pointFDl.y) * 0.5519f);
                com.bytedance.adsdk.lottie.model.z zVar4 = listDl2.get(z(i2 - 1, listDl2.size()));
                com.bytedance.adsdk.lottie.model.z zVar5 = listDl2.get(i2);
                zVar4.g(f5, f6);
                zVar4.dl(f5, f6);
                if (i == 0) {
                    vVarG.z(f5, f6);
                }
                zVar5.z(f9, f10);
                i2++;
                com.bytedance.adsdk.lottie.model.z zVar6 = listDl2.get(i2);
                zVar5.g(f11, f12);
                zVar5.dl(f7, f8);
                zVar6.z(f7, f8);
            } else {
                list = listDl;
                z = zG;
                com.bytedance.adsdk.lottie.model.z zVar7 = listDl2.get(z(i2 - 1, listDl2.size()));
                com.bytedance.adsdk.lottie.model.z zVar8 = listDl2.get(i2);
                zVar7.g(zVar2.g().x, zVar2.g().y);
                zVar7.dl(zVar2.dl().x, zVar2.dl().y);
                zVar8.z(zVar.z().x, zVar.z().y);
            }
            i2++;
            i++;
            listDl = list;
            zG = z;
        }
        return vVarG;
    }

    private com.bytedance.adsdk.lottie.model.g.v g(com.bytedance.adsdk.lottie.model.g.v vVar) {
        List<com.bytedance.adsdk.lottie.model.z> listDl = vVar.dl();
        boolean zG = vVar.g();
        int size = listDl.size() - 1;
        int i = 0;
        while (size >= 0) {
            com.bytedance.adsdk.lottie.model.z zVar = listDl.get(size);
            com.bytedance.adsdk.lottie.model.z zVar2 = listDl.get(z(size - 1, listDl.size()));
            PointF pointFDl = (size != 0 || zG) ? zVar2.dl() : vVar.z();
            i = (((size != 0 || zG) ? zVar2.g() : pointFDl).equals(pointFDl) && zVar.z().equals(pointFDl) && !(!vVar.g() && size == 0 && size == listDl.size() - 1)) ? i + 2 : i + 1;
            size--;
        }
        com.bytedance.adsdk.lottie.model.g.v vVar2 = this.f212a;
        if (vVar2 == null || vVar2.dl().size() != i) {
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(new com.bytedance.adsdk.lottie.model.z());
            }
            this.f212a = new com.bytedance.adsdk.lottie.model.g.v(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.f212a.z(zG);
        return this.f212a;
    }

    private static int z(int i, int i2) {
        return i - (g(i, i2) * i2);
    }

    private static int g(int i, int i2) {
        int i3 = i / i2;
        return ((i ^ i2) >= 0 || i2 * i3 == i) ? i3 : i3 - 1;
    }
}
