package com.amgcyo.cuttadon.view.otherview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.api.entity.other.MkLtypeListBean;
import com.fatcatfat.io.R;
import com.google.android.material.tabs.TabLayout;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AllClassifyTopView extends LinearLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private TabLayout f4903s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TabLayout f4904t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TabLayout f4905u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f4906v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f4907w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f4908x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    b f4909y;

    class a implements TabLayout.d {
        final /* synthetic */ TabLayout a;

        a(TabLayout tabLayout) {
            this.a = tabLayout;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(TabLayout.g gVar) {
            Object objE = gVar.e();
            if (objE instanceof MkLtypeListBean) {
                MkLtypeListBean mkLtypeListBean = (MkLtypeListBean) objE;
                mkLtypeListBean.setSelect_type(this.a.getId());
                b bVar = AllClassifyTopView.this.f4909y;
                if (bVar != null) {
                    bVar.a(mkLtypeListBean, gVar.c());
                }
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(TabLayout.g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(TabLayout.g gVar) {
        }
    }

    public interface b {
        void a(MkLtypeListBean mkLtypeListBean, int i2);
    }

    public AllClassifyTopView(Context context) {
        super(context);
        this.f4906v = 0;
        this.f4907w = 0;
        this.f4908x = 0;
        a(context);
    }

    private void a(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.mk_view_topview, (ViewGroup) null);
        this.f4903s = (TabLayout) viewInflate.findViewById(R.id.tabLayout_type);
        this.f4904t = (TabLayout) viewInflate.findViewById(R.id.tabLayout_status);
        this.f4905u = (TabLayout) viewInflate.findViewById(R.id.tabLayout_score);
        removeAllViews();
        addView(viewInflate);
    }

    public void setTabSelectedListener(b bVar) {
        this.f4909y = bVar;
    }

    public AllClassifyTopView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4906v = 0;
        this.f4907w = 0;
        this.f4908x = 0;
        a(context);
    }

    public void a(List<MkLtypeListBean> list, List<MkLtypeListBean> list2, List<MkLtypeListBean> list3) {
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
            a(this.f4903s, list, this.f4906v);
        } else {
            this.f4903s.setVisibility(8);
        }
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(list2)) {
            a(this.f4904t, list2, this.f4907w);
        } else {
            this.f4904t.setVisibility(8);
        }
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(list3)) {
            a(this.f4905u, list3, this.f4908x);
        } else {
            this.f4905u.setVisibility(8);
        }
    }

    public void a(int i2, int i3, int i4) {
        TabLayout.g gVarA = this.f4903s.a(i2);
        if (gVarA != null) {
            gVarA.i();
        }
        TabLayout.g gVarA2 = this.f4904t.a(i3);
        if (gVarA2 != null) {
            gVarA2.i();
        }
        TabLayout.g gVarA3 = this.f4905u.a(i4);
        if (gVarA3 != null) {
            gVarA3.i();
        }
    }

    private void a(TabLayout tabLayout, List<MkLtypeListBean> list, int i2) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            tabLayout.a(tabLayout.c());
            TabLayout.g gVarA = tabLayout.a(i3);
            MkLtypeListBean mkLtypeListBean = list.get(i3);
            if (gVarA != null) {
                gVarA.a(R.layout.tab_layout);
                View viewA = gVarA.a();
                gVarA.a(mkLtypeListBean);
                if (viewA != null) {
                    ((TextView) viewA.findViewById(R.id.tv_txt)).setText(mkLtypeListBean.getStype_name());
                }
            }
        }
        TabLayout.g gVarA2 = tabLayout.a(i2);
        if (gVarA2 != null) {
            gVarA2.i();
        }
        tabLayout.a((TabLayout.d) new a(tabLayout));
    }
}
