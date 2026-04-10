package com.bytedance.sdk.component.widget.recycler;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends RecyclerView.fo implements RecyclerView.js.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f833a;
    boolean dl;
    final z e;
    private dl fv;
    gz g;
    int gc;
    private final g io;
    private boolean iq;
    private boolean js;
    a m;
    private boolean q;
    private boolean tb;
    private int uf;
    int z;
    private boolean zw;

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public boolean z() {
        return true;
    }

    public gc(Context context) {
        this(context, 1, false);
    }

    public gc(Context context, int i, boolean z2) {
        this.z = 1;
        this.tb = false;
        this.dl = false;
        this.q = false;
        this.iq = true;
        this.f833a = -1;
        this.gc = Integer.MIN_VALUE;
        this.m = null;
        this.e = new z();
        this.io = new g();
        this.uf = 2;
        z(i);
        z(z2);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public RecyclerView.uy g() {
        return new RecyclerView.uy(-2, -2);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public void z(RecyclerView recyclerView, RecyclerView.ls lsVar) {
        super.z(recyclerView, lsVar);
        if (this.zw) {
            dl(lsVar);
            lsVar.z();
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public boolean dl() {
        return this.z == 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public boolean a() {
        return this.z == 1;
    }

    public void z(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:".concat(String.valueOf(i)));
        }
        z((String) null);
        if (i != this.z || this.g == null) {
            gz gzVarZ = gz.z(this, i);
            this.g = gzVarZ;
            this.e.z = gzVarZ;
            this.z = i;
            i();
        }
    }

    private void un() {
        if (this.z != 1 && gc()) {
            this.dl = !this.tb;
        } else {
            this.dl = this.tb;
        }
    }

    public void z(boolean z2) {
        z((String) null);
        if (z2 != this.tb) {
            this.tb = z2;
            i();
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public View g(int i) {
        int iJs = js();
        if (iJs == 0) {
            return null;
        }
        int iA = i - a(gz(0));
        if (iA >= 0 && iA < iJs) {
            View viewGz = gz(iA);
            if (a(viewGz) == i) {
                return viewGz;
            }
        }
        return super.g(i);
    }

    protected int z(RecyclerView.tb tbVar) {
        if (tbVar.dl()) {
            return this.g.m();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public void z(RecyclerView recyclerView, RecyclerView.tb tbVar, int i) {
        m mVar = new m(recyclerView.getContext());
        mVar.dl(i);
        z(mVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.js.g
    public PointF dl(int i) {
        if (js() == 0) {
            return null;
        }
        int i2 = (i < a(gz(0))) != this.dl ? -1 : 1;
        return this.z == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public void z(RecyclerView.ls lsVar, RecyclerView.tb tbVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int iZ;
        int i6;
        View viewG;
        int iZ2;
        int iA;
        if ((this.m != null || this.f833a != -1) && tbVar.a() == 0) {
            dl(lsVar);
            return;
        }
        a aVar = this.m;
        if (aVar != null && aVar.z()) {
            this.f833a = this.m.z;
        }
        m();
        this.fv.z = false;
        un();
        View viewL = l();
        if (this.e.gc && this.f833a == -1 && this.m == null) {
            if (viewL != null && (this.g.z(viewL) >= this.g.a() || this.g.g(viewL) <= this.g.dl())) {
                this.e.z(viewL, a(viewL));
            }
        } else {
            this.e.z();
            this.e.f836a = this.dl ^ this.q;
            z(lsVar, tbVar, this.e);
            this.e.gc = true;
        }
        int iZ3 = z(tbVar);
        if (this.fv.uy >= 0) {
            i = iZ3;
            iZ3 = 0;
        } else {
            i = 0;
        }
        int iDl = iZ3 + this.g.dl();
        int iE = i + this.g.e();
        if (tbVar.z() && (i6 = this.f833a) != -1 && this.gc != Integer.MIN_VALUE && (viewG = g(i6)) != null) {
            if (this.dl) {
                iA = this.g.a() - this.g.g(viewG);
                iZ2 = this.gc;
            } else {
                iZ2 = this.g.z(viewG) - this.g.dl();
                iA = this.gc;
            }
            int i7 = iA - iZ2;
            if (i7 > 0) {
                iDl += i7;
            } else {
                iE -= i7;
            }
        }
        z(lsVar);
        this.fv.wp = gz();
        this.fv.fo = tbVar.z();
        if (this.e.f836a) {
            g(this.e);
            this.fv.gz = iDl;
            z(lsVar, this.fv, tbVar, false);
            i3 = this.fv.g;
            int i8 = this.fv.f834a;
            if (this.fv.dl > 0) {
                iE += this.fv.dl;
            }
            z(this.e);
            this.fv.gz = iE;
            this.fv.f834a += this.fv.gc;
            z(lsVar, this.fv, tbVar, false);
            i2 = this.fv.g;
            if (this.fv.dl > 0) {
                int i9 = this.fv.dl;
                e(i8, i3);
                this.fv.gz = i9;
                z(lsVar, this.fv, tbVar, false);
                i3 = this.fv.g;
            }
        } else {
            z(this.e);
            this.fv.gz = iE;
            z(lsVar, this.fv, tbVar, false);
            i2 = this.fv.g;
            int i10 = this.fv.f834a;
            if (this.fv.dl > 0) {
                iDl += this.fv.dl;
            }
            g(this.e);
            this.fv.gz = iDl;
            this.fv.f834a += this.fv.gc;
            z(lsVar, this.fv, tbVar, false);
            i3 = this.fv.g;
            if (this.fv.dl > 0) {
                int i11 = this.fv.dl;
                m(i10, i2);
                this.fv.gz = i11;
                z(lsVar, this.fv, tbVar, false);
                i2 = this.fv.g;
            }
        }
        if (js() > 0) {
            if (this.dl ^ this.q) {
                int iZ4 = z(i2, lsVar, tbVar, true);
                i4 = i3 + iZ4;
                i5 = i2 + iZ4;
                iZ = g(i4, lsVar, tbVar, false);
            } else {
                int iG = g(i3, lsVar, tbVar, true);
                i4 = i3 + iG;
                i5 = i2 + iG;
                iZ = z(i5, lsVar, tbVar, false);
            }
            i3 = i4 + iZ;
            i2 = i5 + iZ;
        }
        g(lsVar, tbVar, i3, i2);
        if (!tbVar.z()) {
            this.g.z();
        } else {
            this.e.z();
        }
        this.js = this.q;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public void g(RecyclerView.tb tbVar) {
        super.g(tbVar);
        this.m = null;
        this.f833a = -1;
        this.gc = Integer.MIN_VALUE;
        this.e.z();
    }

    private void g(RecyclerView.ls lsVar, RecyclerView.tb tbVar, int i, int i2) {
        if (!tbVar.g() || js() == 0 || tbVar.z() || !wp()) {
            return;
        }
        List<RecyclerView.zw> listDl = lsVar.dl();
        int size = listDl.size();
        int iA = a(gz(0));
        int iGc = 0;
        int iGc2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView.zw zwVar = listDl.get(i3);
            if (!zwVar.p()) {
                if (((zwVar.a() < iA) != this.dl ? (byte) -1 : (byte) 1) == -1) {
                    iGc += this.g.gc(zwVar.z);
                } else {
                    iGc2 += this.g.gc(zwVar.z);
                }
            }
        }
        this.fv.kb = listDl;
        if (iGc > 0) {
            e(a(ti()), i);
            this.fv.gz = iGc;
            this.fv.dl = 0;
            this.fv.z();
            z(lsVar, this.fv, tbVar, false);
        }
        if (iGc2 > 0) {
            m(a(eo()), i2);
            this.fv.gz = iGc2;
            this.fv.dl = 0;
            this.fv.z();
            z(lsVar, this.fv, tbVar, false);
        }
        this.fv.kb = null;
    }

    private void z(RecyclerView.ls lsVar, RecyclerView.tb tbVar, z zVar) {
        if (z(tbVar, zVar) || g(lsVar, tbVar, zVar)) {
            return;
        }
        zVar.g();
        zVar.g = this.q ? tbVar.a() - 1 : 0;
    }

    private boolean g(RecyclerView.ls lsVar, RecyclerView.tb tbVar, z zVar) {
        if (js() == 0) {
            return false;
        }
        View viewL = l();
        if (viewL != null && zVar.z(viewL, tbVar)) {
            zVar.z(viewL, a(viewL));
            return true;
        }
        if (this.js != this.q) {
            return false;
        }
        View viewG = zVar.f836a ? g(lsVar, tbVar) : dl(lsVar, tbVar);
        if (viewG == null) {
            return false;
        }
        zVar.g(viewG, a(viewG));
        if (!tbVar.z() && wp()) {
            if (this.g.z(viewG) >= this.g.a() || this.g.g(viewG) < this.g.dl()) {
                zVar.dl = zVar.f836a ? this.g.a() : this.g.dl();
            }
        }
        return true;
    }

    private boolean z(RecyclerView.tb tbVar, z zVar) {
        int i;
        if (!tbVar.z() && (i = this.f833a) != -1) {
            if (i >= 0 && i < tbVar.a()) {
                zVar.g = this.f833a;
                a aVar = this.m;
                if (aVar != null && aVar.z()) {
                    zVar.f836a = this.m.dl;
                    if (zVar.f836a) {
                        zVar.dl = this.g.a() - this.m.g;
                    } else {
                        zVar.dl = this.g.dl() + this.m.g;
                    }
                    return true;
                }
                if (this.gc == Integer.MIN_VALUE) {
                    View viewG = g(this.f833a);
                    if (viewG != null) {
                        if (this.g.gc(viewG) > this.g.m()) {
                            zVar.g();
                            return true;
                        }
                        if (this.g.z(viewG) - this.g.dl() < 0) {
                            zVar.dl = this.g.dl();
                            zVar.f836a = false;
                            return true;
                        }
                        if (this.g.a() - this.g.g(viewG) < 0) {
                            zVar.dl = this.g.a();
                            zVar.f836a = true;
                            return true;
                        }
                        zVar.dl = zVar.f836a ? this.g.g(viewG) + this.g.g() : this.g.z(viewG);
                    } else {
                        if (js() > 0) {
                            zVar.f836a = (this.f833a < a(gz(0))) == this.dl;
                        }
                        zVar.g();
                    }
                    return true;
                }
                zVar.f836a = this.dl;
                if (this.dl) {
                    zVar.dl = this.g.a() - this.gc;
                } else {
                    zVar.dl = this.g.dl() + this.gc;
                }
                return true;
            }
            this.f833a = -1;
            this.gc = Integer.MIN_VALUE;
        }
        return false;
    }

    private int z(int i, RecyclerView.ls lsVar, RecyclerView.tb tbVar, boolean z2) {
        int iA;
        int iA2 = this.g.a() - i;
        if (iA2 <= 0) {
            return 0;
        }
        int i2 = -dl(-iA2, lsVar, tbVar);
        int i3 = i + i2;
        if (!z2 || (iA = this.g.a() - i3) <= 0) {
            return i2;
        }
        this.g.z(iA);
        return iA + i2;
    }

    private int g(int i, RecyclerView.ls lsVar, RecyclerView.tb tbVar, boolean z2) {
        int iDl;
        int iDl2 = i - this.g.dl();
        if (iDl2 <= 0) {
            return 0;
        }
        int i2 = -dl(iDl2, lsVar, tbVar);
        int i3 = i + i2;
        if (!z2 || (iDl = i3 - this.g.dl()) <= 0) {
            return i2;
        }
        this.g.z(-iDl);
        return i2 - iDl;
    }

    private void z(z zVar) {
        m(zVar.g, zVar.dl);
    }

    private void m(int i, int i2) {
        this.fv.dl = this.g.a() - i2;
        this.fv.gc = this.dl ? -1 : 1;
        this.fv.f834a = i;
        this.fv.m = 1;
        this.fv.g = i2;
        this.fv.e = Integer.MIN_VALUE;
    }

    private void g(z zVar) {
        e(zVar.g, zVar.dl);
    }

    private void e(int i, int i2) {
        this.fv.dl = i2 - this.g.dl();
        this.fv.f834a = i;
        this.fv.gc = this.dl ? 1 : -1;
        this.fv.m = -1;
        this.fv.g = i2;
        this.fv.e = Integer.MIN_VALUE;
    }

    protected boolean gc() {
        return p() == 1;
    }

    void m() {
        if (this.fv == null) {
            this.fv = e();
        }
    }

    dl e() {
        return new dl();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public void a(int i) {
        this.f833a = i;
        this.gc = Integer.MIN_VALUE;
        a aVar = this.m;
        if (aVar != null) {
            aVar.g();
        }
        i();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public int z(int i, RecyclerView.ls lsVar, RecyclerView.tb tbVar) {
        if (this.z == 1) {
            return 0;
        }
        return dl(i, lsVar, tbVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public int g(int i, RecyclerView.ls lsVar, RecyclerView.tb tbVar) {
        if (this.z == 0) {
            return 0;
        }
        return dl(i, lsVar, tbVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public int dl(RecyclerView.tb tbVar) {
        return fo(tbVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public int a(RecyclerView.tb tbVar) {
        return fo(tbVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public int gc(RecyclerView.tb tbVar) {
        return uy(tbVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public int m(RecyclerView.tb tbVar) {
        return uy(tbVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public int e(RecyclerView.tb tbVar) {
        return kb(tbVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public int gz(RecyclerView.tb tbVar) {
        return kb(tbVar);
    }

    private int fo(RecyclerView.tb tbVar) {
        if (js() == 0) {
            return 0;
        }
        m();
        return uy.z(tbVar, this.g, z(!this.iq, true), g(!this.iq, true), this, this.iq, this.dl);
    }

    private int uy(RecyclerView.tb tbVar) {
        if (js() == 0) {
            return 0;
        }
        m();
        return uy.z(tbVar, this.g, z(!this.iq, true), g(!this.iq, true), this, this.iq);
    }

    private int kb(RecyclerView.tb tbVar) {
        if (js() == 0) {
            return 0;
        }
        m();
        return uy.g(tbVar, this.g, z(!this.iq, true), g(!this.iq, true), this, this.iq);
    }

    private void z(int i, int i2, boolean z2, RecyclerView.tb tbVar) {
        int iDl;
        this.fv.wp = gz();
        this.fv.gz = z(tbVar);
        this.fv.m = i;
        if (i == 1) {
            this.fv.gz += this.g.e();
            View viewEo = eo();
            this.fv.gc = this.dl ? -1 : 1;
            this.fv.f834a = a(viewEo) + this.fv.gc;
            this.fv.g = this.g.g(viewEo);
            iDl = this.g.g(viewEo) - this.g.a();
        } else {
            View viewTi = ti();
            this.fv.gz += this.g.dl();
            this.fv.gc = this.dl ? 1 : -1;
            this.fv.f834a = a(viewTi) + this.fv.gc;
            this.fv.g = this.g.z(viewTi);
            iDl = (-this.g.z(viewTi)) + this.g.dl();
        }
        this.fv.dl = i2;
        if (z2) {
            this.fv.dl -= iDl;
        }
        this.fv.e = iDl;
    }

    boolean gz() {
        return this.g.gz() == 0 && this.g.gc() == 0;
    }

    void z(RecyclerView.tb tbVar, dl dlVar, RecyclerView.fo.z zVar) {
        int i = dlVar.f834a;
        if (i < 0 || i >= tbVar.a()) {
            return;
        }
        zVar.g(i, Math.max(0, dlVar.e));
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public void z(int i, RecyclerView.fo.z zVar) {
        boolean z2;
        int i2;
        a aVar = this.m;
        if (aVar != null && aVar.z()) {
            z2 = this.m.dl;
            i2 = this.m.z;
        } else {
            un();
            z2 = this.dl;
            i2 = this.f833a;
            if (i2 == -1) {
                i2 = z2 ? i - 1 : 0;
            }
        }
        int i3 = z2 ? -1 : 1;
        for (int i4 = 0; i4 < this.uf && i2 >= 0 && i2 < i; i4++) {
            zVar.g(i2, 0);
            i2 += i3;
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public void z(int i, int i2, RecyclerView.tb tbVar, RecyclerView.fo.z zVar) {
        if (this.z != 0) {
            i = i2;
        }
        if (js() == 0 || i == 0) {
            return;
        }
        m();
        z(i > 0 ? 1 : -1, Math.abs(i), true, tbVar);
        z(tbVar, this.fv, zVar);
    }

    int dl(int i, RecyclerView.ls lsVar, RecyclerView.tb tbVar) {
        if (js() == 0 || i == 0) {
            return 0;
        }
        this.fv.z = true;
        m();
        int i2 = i > 0 ? 1 : -1;
        int iAbs = Math.abs(i);
        z(i2, iAbs, true, tbVar);
        int iZ = this.fv.e + z(lsVar, this.fv, tbVar, false);
        if (iZ < 0) {
            return 0;
        }
        if (iAbs > iZ) {
            i = i2 * iZ;
        }
        this.g.z(-i);
        this.fv.uy = i;
        return i;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public void z(String str) {
        if (this.m == null) {
            super.z(str);
        }
    }

    private void z(RecyclerView.ls lsVar, int i, int i2) {
        if (i != i2) {
            if (i2 <= i) {
                while (i > i2) {
                    z(i, lsVar);
                    i--;
                }
            } else {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    z(i3, lsVar);
                }
            }
        }
    }

    private void z(RecyclerView.ls lsVar, int i) {
        if (i >= 0) {
            int iJs = js();
            if (!this.dl) {
                for (int i2 = 0; i2 < iJs; i2++) {
                    View viewGz = gz(i2);
                    if (this.g.g(viewGz) > i || this.g.dl(viewGz) > i) {
                        z(lsVar, 0, i2);
                        return;
                    }
                }
                return;
            }
            int i3 = iJs - 1;
            for (int i4 = i3; i4 >= 0; i4--) {
                View viewGz2 = gz(i4);
                if (this.g.g(viewGz2) > i || this.g.dl(viewGz2) > i) {
                    z(lsVar, i3, i4);
                    return;
                }
            }
        }
    }

    private void g(RecyclerView.ls lsVar, int i) {
        int iJs = js();
        if (i >= 0) {
            int iGc = this.g.gc() - i;
            if (this.dl) {
                for (int i2 = 0; i2 < iJs; i2++) {
                    View viewGz = gz(i2);
                    if (this.g.z(viewGz) < iGc || this.g.a(viewGz) < iGc) {
                        z(lsVar, 0, i2);
                        return;
                    }
                }
                return;
            }
            int i3 = iJs - 1;
            for (int i4 = i3; i4 >= 0; i4--) {
                View viewGz2 = gz(i4);
                if (this.g.z(viewGz2) < iGc || this.g.a(viewGz2) < iGc) {
                    z(lsVar, i3, i4);
                    return;
                }
            }
        }
    }

    private void z(RecyclerView.ls lsVar, dl dlVar) {
        if (!dlVar.z || dlVar.wp) {
            return;
        }
        if (dlVar.m == -1) {
            g(lsVar, dlVar.e);
        } else {
            z(lsVar, dlVar.e);
        }
    }

    int z(RecyclerView.ls lsVar, dl dlVar, RecyclerView.tb tbVar, boolean z2) {
        int i = dlVar.dl;
        if (dlVar.e != Integer.MIN_VALUE) {
            if (dlVar.dl < 0) {
                dlVar.e += dlVar.dl;
            }
            z(lsVar, dlVar);
        }
        int i2 = dlVar.dl + dlVar.gz;
        g gVar = this.io;
        while (true) {
            if ((!dlVar.wp && i2 <= 0) || !dlVar.z(tbVar)) {
                break;
            }
            gVar.z();
            z(lsVar, tbVar, dlVar, gVar);
            if (!gVar.g) {
                dlVar.g += gVar.z * dlVar.m;
                if (!gVar.dl || this.fv.kb != null || !tbVar.z()) {
                    dlVar.dl -= gVar.z;
                    i2 -= gVar.z;
                }
                if (dlVar.e != Integer.MIN_VALUE) {
                    dlVar.e += gVar.z;
                    if (dlVar.dl < 0) {
                        dlVar.e += dlVar.dl;
                    }
                    z(lsVar, dlVar);
                }
                if (z2 && gVar.f835a) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - dlVar.dl;
    }

    void z(RecyclerView.ls lsVar, RecyclerView.tb tbVar, dl dlVar, g gVar) {
        int i;
        int i2;
        int i3;
        int iIo;
        int iM;
        View viewZ = dlVar.z(lsVar);
        if (viewZ == null) {
            gVar.g = true;
            return;
        }
        RecyclerView.uy uyVar = (RecyclerView.uy) viewZ.getLayoutParams();
        if (dlVar.kb == null) {
            if (this.dl == (dlVar.m == -1)) {
                g(viewZ);
            } else {
                g(viewZ, 0);
            }
        } else {
            if (this.dl == (dlVar.m == -1)) {
                z(viewZ);
            } else {
                z(viewZ, 0);
            }
        }
        z(viewZ, 0, 0);
        gVar.z = this.g.gc(viewZ);
        if (this.z == 1) {
            if (gc()) {
                iM = iq() - sy();
                iIo = iM - this.g.m(viewZ);
            } else {
                iIo = io();
                iM = this.g.m(viewZ) + iIo;
            }
            if (dlVar.m == -1) {
                int i4 = dlVar.g;
                i2 = dlVar.g - gVar.z;
                i = iM;
                i3 = i4;
            } else {
                int i5 = dlVar.g;
                i3 = dlVar.g + gVar.z;
                i = iM;
                i2 = i5;
            }
        } else {
            int iUf = uf();
            int iM2 = this.g.m(viewZ) + iUf;
            if (dlVar.m == -1) {
                i2 = iUf;
                i = dlVar.g;
                i3 = iM2;
                iIo = dlVar.g - gVar.z;
            } else {
                int i6 = dlVar.g;
                i = dlVar.g + gVar.z;
                i2 = iUf;
                i3 = iM2;
                iIo = i6;
            }
        }
        z(viewZ, iIo, i2, i, i3);
        if (uyVar.g() || uyVar.dl()) {
            gVar.dl = true;
        }
        gVar.f835a = viewZ.hasFocusable();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    boolean fo() {
        return (q() == 1073741824 || tb() == 1073741824 || !mc()) ? false : true;
    }

    int gc(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.z == 1) ? 1 : Integer.MIN_VALUE : this.z == 0 ? 1 : Integer.MIN_VALUE : this.z == 1 ? -1 : Integer.MIN_VALUE : this.z == 0 ? -1 : Integer.MIN_VALUE : (this.z != 1 && gc()) ? -1 : 1 : (this.z != 1 && gc()) ? 1 : -1;
    }

    private View ti() {
        return gz(this.dl ? js() - 1 : 0);
    }

    private View eo() {
        return gz(this.dl ? 0 : js() - 1);
    }

    private View z(boolean z2, boolean z3) {
        int iJs;
        int iJs2;
        if (this.dl) {
            iJs = js() - 1;
            iJs2 = -1;
        } else {
            iJs = 0;
            iJs2 = js();
        }
        return z(iJs, iJs2, z2, z3);
    }

    private View g(boolean z2, boolean z3) {
        int iJs;
        int iJs2;
        if (this.dl) {
            iJs = 0;
            iJs2 = js();
        } else {
            iJs = js() - 1;
            iJs2 = -1;
        }
        return z(iJs, iJs2, z2, z3);
    }

    private View g(RecyclerView.ls lsVar, RecyclerView.tb tbVar) {
        return this.dl ? a(lsVar, tbVar) : gc(lsVar, tbVar);
    }

    private View dl(RecyclerView.ls lsVar, RecyclerView.tb tbVar) {
        return this.dl ? gc(lsVar, tbVar) : a(lsVar, tbVar);
    }

    private View a(RecyclerView.ls lsVar, RecyclerView.tb tbVar) {
        return z(lsVar, tbVar, 0, js(), tbVar.a());
    }

    private View gc(RecyclerView.ls lsVar, RecyclerView.tb tbVar) {
        return z(lsVar, tbVar, js() - 1, -1, tbVar.a());
    }

    View z(RecyclerView.ls lsVar, RecyclerView.tb tbVar, int i, int i2, int i3) {
        m();
        int iDl = this.g.dl();
        int iA = this.g.a();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View viewGz = gz(i);
            int iA2 = a(viewGz);
            if (iA2 >= 0 && iA2 < i3) {
                if (((RecyclerView.uy) viewGz.getLayoutParams()).g()) {
                    if (view2 == null) {
                        view2 = viewGz;
                    }
                } else {
                    if (this.g.z(viewGz) < iA && this.g.g(viewGz) >= iDl) {
                        return viewGz;
                    }
                    if (view == null) {
                        view = viewGz;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    private View m(RecyclerView.ls lsVar, RecyclerView.tb tbVar) {
        return this.dl ? gz(lsVar, tbVar) : fo(lsVar, tbVar);
    }

    private View e(RecyclerView.ls lsVar, RecyclerView.tb tbVar) {
        return this.dl ? fo(lsVar, tbVar) : gz(lsVar, tbVar);
    }

    private View gz(RecyclerView.ls lsVar, RecyclerView.tb tbVar) {
        return z(0, js());
    }

    private View fo(RecyclerView.ls lsVar, RecyclerView.tb tbVar) {
        return z(js() - 1, -1);
    }

    public int uy() {
        View viewZ = z(0, js(), false, true);
        if (viewZ == null) {
            return -1;
        }
        return a(viewZ);
    }

    public int kb() {
        View viewZ = z(js() - 1, -1, false, true);
        if (viewZ == null) {
            return -1;
        }
        return a(viewZ);
    }

    View z(int i, int i2, boolean z2, boolean z3) {
        m();
        int i3 = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        int i4 = z2 ? 24579 : 320;
        if (!z3) {
            i3 = 0;
        }
        return (this.z == 0 ? this.uy : this.kb).z(i, i2, i4, i3);
    }

    View z(int i, int i2) {
        int i3;
        int i4;
        m();
        if ((i2 > i ? (byte) 1 : i2 < i ? (byte) -1 : (byte) 0) == 0) {
            return gz(i);
        }
        if (this.g.z(gz(i)) < this.g.dl()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        return (this.z == 0 ? this.uy : this.kb).z(i, i2, i3, i4);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public View z(View view, int i, RecyclerView.ls lsVar, RecyclerView.tb tbVar) {
        int iGc;
        View viewM;
        View viewEo;
        un();
        if (js() == 0 || (iGc = gc(i)) == Integer.MIN_VALUE) {
            return null;
        }
        m();
        m();
        z(iGc, (int) (this.g.m() * 0.33333334f), false, tbVar);
        this.fv.e = Integer.MIN_VALUE;
        this.fv.z = false;
        z(lsVar, this.fv, tbVar, true);
        if (iGc == -1) {
            viewM = e(lsVar, tbVar);
        } else {
            viewM = m(lsVar, tbVar);
        }
        if (iGc == -1) {
            viewEo = ti();
        } else {
            viewEo = eo();
        }
        if (!viewEo.hasFocusable()) {
            return viewM;
        }
        if (viewM == null) {
            return null;
        }
        return viewEo;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public boolean wp() {
        return this.m == null && this.js == this.q;
    }

    protected static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f835a;
        public boolean dl;
        public boolean g;
        public int z;

        protected g() {
        }

        void z() {
            this.z = 0;
            this.g = false;
            this.dl = false;
            this.f835a = false;
        }
    }

    static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f836a;
        int dl;
        int g;
        boolean gc;
        gz z;

        z() {
            z();
        }

        void z() {
            this.g = -1;
            this.dl = Integer.MIN_VALUE;
            this.f836a = false;
            this.gc = false;
        }

        void g() {
            this.dl = this.f836a ? this.z.a() : this.z.dl();
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.g + ", mCoordinate=" + this.dl + ", mLayoutFromEnd=" + this.f836a + ", mValid=" + this.gc + '}';
        }

        boolean z(View view, RecyclerView.tb tbVar) {
            RecyclerView.uy uyVar = (RecyclerView.uy) view.getLayoutParams();
            return !uyVar.g() && uyVar.a() >= 0 && uyVar.a() < tbVar.a();
        }

        public void z(View view, int i) {
            int iG = this.z.g();
            if (iG >= 0) {
                g(view, i);
                return;
            }
            this.g = i;
            if (this.f836a) {
                int iA = (this.z.a() - iG) - this.z.g(view);
                this.dl = this.z.a() - iA;
                if (iA > 0) {
                    int iGc = this.dl - this.z.gc(view);
                    int iDl = this.z.dl();
                    int iMin = iGc - (iDl + Math.min(this.z.z(view) - iDl, 0));
                    if (iMin < 0) {
                        this.dl += Math.min(iA, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iZ = this.z.z(view);
            int iDl2 = iZ - this.z.dl();
            this.dl = iZ;
            if (iDl2 > 0) {
                int iA2 = (this.z.a() - Math.min(0, (this.z.a() - iG) - this.z.g(view))) - (iZ + this.z.gc(view));
                if (iA2 < 0) {
                    this.dl -= Math.min(iDl2, -iA2);
                }
            }
        }

        public void g(View view, int i) {
            if (this.f836a) {
                this.dl = this.z.g(view) + this.z.g();
            } else {
                this.dl = this.z.z(view);
            }
            this.g = i;
        }
    }

    public static class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.bytedance.sdk.component.widget.recycler.gc.a.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i) {
                return new a[i];
            }
        };
        boolean dl;
        int g;
        int z;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public a() {
        }

        a(Parcel parcel) {
            this.z = parcel.readInt();
            this.g = parcel.readInt();
            this.dl = parcel.readInt() == 1;
        }

        boolean z() {
            return this.z >= 0;
        }

        void g() {
            this.z = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.z);
            parcel.writeInt(this.g);
            parcel.writeInt(this.dl ? 1 : 0);
        }
    }

    static class dl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f834a;
        int dl;
        int e;
        int g;
        int gc;
        int m;
        int uy;
        boolean wp;
        boolean z = true;
        int gz = 0;
        boolean fo = false;
        List<RecyclerView.zw> kb = null;

        dl() {
        }

        boolean z(RecyclerView.tb tbVar) {
            int i = this.f834a;
            return i >= 0 && i < tbVar.a();
        }

        View z(RecyclerView.ls lsVar) {
            if (this.kb != null) {
                return g();
            }
            View viewG = lsVar.g(this.f834a);
            this.f834a += this.gc;
            return viewG;
        }

        private View g() {
            int size = this.kb.size();
            for (int i = 0; i < size; i++) {
                View view = this.kb.get(i).z;
                RecyclerView.uy uyVar = (RecyclerView.uy) view.getLayoutParams();
                if (!uyVar.g() && this.f834a == uyVar.a()) {
                    z(view);
                    return view;
                }
            }
            return null;
        }

        public void z() {
            z((View) null);
        }

        public void z(View view) {
            View viewG = g(view);
            if (viewG == null) {
                this.f834a = -1;
            } else {
                this.f834a = ((RecyclerView.uy) viewG.getLayoutParams()).a();
            }
        }

        public View g(View view) {
            int iA;
            int size = this.kb.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.kb.get(i2).z;
                RecyclerView.uy uyVar = (RecyclerView.uy) view3.getLayoutParams();
                if (view3 != view && !uyVar.g() && (iA = (uyVar.a() - this.f834a) * this.gc) >= 0 && iA < i) {
                    view2 = view3;
                    if (iA == 0) {
                        break;
                    }
                    i = iA;
                }
            }
            return view2;
        }
    }
}
