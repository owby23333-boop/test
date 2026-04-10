package com.lxj.xpopup.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
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
import com.lxj.xpopup.core.CenterPopupView;
import com.lxj.xpopup.widget.CheckView;
import com.lxj.xpopup.widget.VerticalRecyclerView;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CenterListPopupView extends CenterPopupView {
    RecyclerView R;
    TextView S;
    CharSequence T;
    String[] U;
    int[] V;
    private f W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    int f17474a0;

    class a extends EasyAdapter<String> {
        a(List list, int i2) {
            super(list, i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.lxj.easyadapter.EasyAdapter
        public void a(@NonNull ViewHolder viewHolder, @NonNull String str, int i2) {
            viewHolder.a(R$id.tv_text, str);
            ImageView imageView = (ImageView) viewHolder.b(R$id.iv_image);
            int[] iArr = CenterListPopupView.this.V;
            if (iArr == null || iArr.length <= i2) {
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
            } else if (imageView != null) {
                imageView.setVisibility(0);
                imageView.setBackgroundResource(CenterListPopupView.this.V[i2]);
            }
            if (CenterListPopupView.this.f17474a0 != -1) {
                if (viewHolder.b(R$id.check_view) != null) {
                    viewHolder.a(R$id.check_view).setVisibility(i2 != CenterListPopupView.this.f17474a0 ? 8 : 0);
                    ((CheckView) viewHolder.a(R$id.check_view)).setColor(com.lxj.xpopup.a.c());
                }
                TextView textView = (TextView) viewHolder.a(R$id.tv_text);
                CenterListPopupView centerListPopupView = CenterListPopupView.this;
                textView.setTextColor(i2 == centerListPopupView.f17474a0 ? com.lxj.xpopup.a.c() : centerListPopupView.getResources().getColor(R$color._xpopup_title_color));
            } else {
                if (viewHolder.b(R$id.check_view) != null) {
                    viewHolder.a(R$id.check_view).setVisibility(8);
                }
                ((TextView) viewHolder.a(R$id.tv_text)).setGravity(17);
            }
            if (((CenterPopupView) CenterListPopupView.this).P == 0) {
                if (CenterListPopupView.this.f17361s.G) {
                    ((TextView) viewHolder.a(R$id.tv_text)).setTextColor(CenterListPopupView.this.getResources().getColor(R$color._xpopup_white_color));
                } else {
                    ((TextView) viewHolder.a(R$id.tv_text)).setTextColor(CenterListPopupView.this.getResources().getColor(R$color._xpopup_dark_color));
                }
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
            if (CenterListPopupView.this.W != null && i2 >= 0 && i2 < this.a.getData().size()) {
                CenterListPopupView.this.W.a(i2, (String) this.a.getData().get(i2));
            }
            CenterListPopupView centerListPopupView = CenterListPopupView.this;
            if (centerListPopupView.f17474a0 != -1) {
                centerListPopupView.f17474a0 = i2;
                this.a.notifyDataSetChanged();
            }
            if (CenterListPopupView.this.f17361s.f17409d.booleanValue()) {
                CenterListPopupView.this.g();
            }
        }
    }

    public CenterListPopupView(@NonNull Context context, int i2, int i3) {
        super(context);
        this.f17474a0 = -1;
        this.O = i2;
        this.P = i3;
        w();
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected void c() {
        super.c();
        ((VerticalRecyclerView) this.R).setupDivider(false);
        this.S.setTextColor(getResources().getColor(R$color._xpopup_dark_color));
        findViewById(R$id.xpopup_divider).setBackgroundColor(getResources().getColor(R$color._xpopup_list_divider));
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        int i2 = this.O;
        return i2 == 0 ? R$layout._xpopup_center_impl_list : i2;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getMaxWidth() {
        int i2 = this.f17361s.f17417l;
        return i2 == 0 ? (int) (super.getMaxWidth() * 0.8f) : i2;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void r() {
        super.r();
        this.R = (RecyclerView) findViewById(R$id.recyclerView);
        if (this.O != 0) {
            this.R.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        this.S = (TextView) findViewById(R$id.tv_title);
        if (this.S != null) {
            if (TextUtils.isEmpty(this.T)) {
                this.S.setVisibility(8);
                if (findViewById(R$id.xpopup_divider) != null) {
                    findViewById(R$id.xpopup_divider).setVisibility(8);
                }
            } else {
                this.S.setText(this.T);
            }
        }
        List listAsList = Arrays.asList(this.U);
        int i2 = this.P;
        if (i2 == 0) {
            i2 = R$layout._xpopup_adapter_text_match;
        }
        a aVar = new a(listAsList, i2);
        aVar.a(new b(aVar));
        this.R.setAdapter(aVar);
        x();
    }

    public CenterListPopupView a(CharSequence charSequence, String[] strArr, int[] iArr) {
        this.T = charSequence;
        this.U = strArr;
        this.V = iArr;
        return this;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected void b() {
        super.b();
        ((VerticalRecyclerView) this.R).setupDivider(true);
        this.S.setTextColor(getResources().getColor(R$color._xpopup_white_color));
        findViewById(R$id.xpopup_divider).setBackgroundColor(getResources().getColor(R$color._xpopup_list_dark_divider));
    }

    public CenterListPopupView a(f fVar) {
        this.W = fVar;
        return this;
    }

    public CenterListPopupView b(int i2) {
        this.f17474a0 = i2;
        return this;
    }
}
