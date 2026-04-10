package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.component.widget.recycler.fo;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends com.bytedance.sdk.component.widget.recycler.gc {
    public boolean fv;
    private z io;
    private boolean iq;
    private final fo js;
    private int q;
    private int tb;
    private final RecyclerView.kb uf;
    private int zw;

    public interface z {
        void z();

        void z(boolean z, int i);

        void z(boolean z, int i, boolean z2);
    }

    public dl(Context context, int i, boolean z2) {
        super(context, i, z2);
        this.iq = false;
        this.fv = true;
        this.uf = new RecyclerView.kb() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.dl.1
            @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.kb
            public void z(View view) {
                if (dl.this.io == null || dl.this.js() != 1) {
                    return;
                }
                dl.this.io.z();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.kb
            public void g(View view) {
                if (dl.this.io != null) {
                    dl.this.io.z(dl.this.tb >= 0, dl.this.a(view));
                }
            }
        };
        this.js = new fo();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public void dl(RecyclerView recyclerView) {
        super.dl(recyclerView);
        this.js.z(recyclerView);
        recyclerView.z(this.uf);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.gc, com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public void z(RecyclerView recyclerView, RecyclerView.ls lsVar) {
        super.z(recyclerView, lsVar);
        try {
            gc gcVar = (gc) recyclerView.dl(this.zw);
            if (gcVar != null) {
                gcVar.h();
            }
        } catch (Exception e) {
            wp.dl("cubic detached exception:" + e.getMessage());
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public void kb(int i) {
        boolean z2;
        z zVar;
        this.q = i;
        if (i == 0) {
            View viewZ = this.js.z(this);
            if (viewZ != null) {
                int iA = a(viewZ);
                z2 = this.zw == iA;
                this.zw = iA;
            } else {
                z2 = true;
            }
            if (this.iq) {
                this.iq = false;
                if (!z2 && (zVar = this.io) != null) {
                    boolean z3 = this.tb >= 0;
                    int i2 = this.zw;
                    zVar.z(z3, i2, i2 == h() - 1);
                }
            }
        }
        if (i == 2) {
            this.iq = true;
        }
    }

    public void g(boolean z2) {
        this.fv = z2;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.gc, com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public int g(int i, RecyclerView.ls lsVar, RecyclerView.tb tbVar) {
        this.tb = i;
        return super.g(i, lsVar, tbVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.gc, com.bytedance.sdk.component.widget.recycler.RecyclerView.fo
    public int z(int i, RecyclerView.ls lsVar, RecyclerView.tb tbVar) {
        this.tb = i;
        return super.z(i, lsVar, tbVar);
    }

    public void z(z zVar) {
        this.io = zVar;
    }
}
