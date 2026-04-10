package com.lxj.xpopup.impl;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.lxj.easyadapter.EasyAdapter;
import com.lxj.easyadapter.MultiItemTypeAdapter;
import com.lxj.easyadapter.ViewHolder;
import com.lxj.xpopup.R$color;
import com.lxj.xpopup.R$id;
import com.lxj.xpopup.R$layout;
import com.lxj.xpopup.c.f;
import com.lxj.xpopup.core.AttachPopupView;
import com.lxj.xpopup.widget.VerticalRecyclerView;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AttachListPopupView extends AttachPopupView {

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    RecyclerView f17461a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    protected int f17462b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    protected int f17463c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    protected int f17464d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    String[] f17465e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    int[] f17466f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private f f17467g0;

    class a extends EasyAdapter<String> {
        a(List list, int i2) {
            super(list, i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.lxj.easyadapter.EasyAdapter
        public void a(@NonNull ViewHolder viewHolder, @NonNull String str, int i2) {
            viewHolder.a(R$id.tv_text, str);
            ImageView imageView = (ImageView) viewHolder.b(R$id.iv_image);
            int[] iArr = AttachListPopupView.this.f17466f0;
            if (iArr == null || iArr.length <= i2) {
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
            } else if (imageView != null) {
                imageView.setVisibility(0);
                imageView.setBackgroundResource(AttachListPopupView.this.f17466f0[i2]);
            }
            AttachListPopupView attachListPopupView = AttachListPopupView.this;
            if (attachListPopupView.f17463c0 == 0) {
                if (attachListPopupView.f17361s.G) {
                    ((TextView) viewHolder.a(R$id.tv_text)).setTextColor(AttachListPopupView.this.getResources().getColor(R$color._xpopup_white_color));
                } else {
                    ((TextView) viewHolder.a(R$id.tv_text)).setTextColor(AttachListPopupView.this.getResources().getColor(R$color._xpopup_dark_color));
                }
                ((LinearLayout) viewHolder.a(R$id._ll_temp)).setGravity(AttachListPopupView.this.f17464d0);
            }
        }
    }

    class b extends MultiItemTypeAdapter.c {
        final /* synthetic */ EasyAdapter a;

        b(EasyAdapter easyAdapter) {
            this.a = easyAdapter;
        }

        @Override // com.lxj.easyadapter.MultiItemTypeAdapter.b
        public void b(View view, RecyclerView.ViewHolder viewHolder, int i2) {
            if (AttachListPopupView.this.f17467g0 != null) {
                AttachListPopupView.this.f17467g0.a(i2, (String) this.a.getData().get(i2));
            }
            if (AttachListPopupView.this.f17361s.f17409d.booleanValue()) {
                AttachListPopupView.this.g();
            }
        }
    }

    public AttachListPopupView(@NonNull Context context, int i2, int i3) {
        super(context);
        this.f17464d0 = 17;
        this.f17462b0 = i2;
        this.f17463c0 = i3;
        w();
    }

    protected void B() {
        if (this.f17462b0 == 0) {
            if (this.f17361s.G) {
                b();
            } else {
                c();
            }
            this.P.setBackground(com.lxj.xpopup.util.b.a(getResources().getColor(this.f17361s.G ? R$color._xpopup_dark_color : R$color._xpopup_light_color), this.f17361s.f17421p));
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void b() {
        super.b();
        ((VerticalRecyclerView) this.f17461a0).setupDivider(true);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void c() {
        super.c();
        ((VerticalRecyclerView) this.f17461a0).setupDivider(false);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        int i2 = this.f17462b0;
        return i2 == 0 ? R$layout._xpopup_attach_impl_list : i2;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void r() {
        super.r();
        this.f17461a0 = (RecyclerView) findViewById(R$id.recyclerView);
        if (this.f17462b0 != 0) {
            this.f17461a0.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        List listAsList = Arrays.asList(this.f17465e0);
        int i2 = this.f17463c0;
        if (i2 == 0) {
            i2 = R$layout._xpopup_adapter_text;
        }
        a aVar = new a(listAsList, i2);
        aVar.a(new b(aVar));
        this.f17461a0.setAdapter(aVar);
        B();
    }

    public AttachListPopupView a(String[] strArr, int[] iArr) {
        this.f17465e0 = strArr;
        this.f17466f0 = iArr;
        return this;
    }

    public AttachListPopupView b(int i2) {
        this.f17464d0 = i2;
        return this;
    }

    public AttachListPopupView a(f fVar) {
        this.f17467g0 = fVar;
        return this;
    }
}
