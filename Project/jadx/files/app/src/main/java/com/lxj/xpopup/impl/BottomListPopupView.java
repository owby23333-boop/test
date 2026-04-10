package com.lxj.xpopup.impl;

import android.graphics.Color;
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
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.widget.CheckView;
import com.lxj.xpopup.widget.VerticalRecyclerView;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BottomListPopupView extends BottomPopupView {
    RecyclerView O;
    TextView P;
    TextView Q;
    View R;
    protected int S;
    protected int T;
    CharSequence U;
    String[] V;
    int[] W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private f f17469a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    int f17470b0;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BottomListPopupView.this.g();
        }
    }

    class b extends EasyAdapter<String> {
        b(List list, int i2) {
            super(list, i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.lxj.easyadapter.EasyAdapter
        public void a(@NonNull ViewHolder viewHolder, @NonNull String str, int i2) {
            viewHolder.a(R$id.tv_text, str);
            ImageView imageView = (ImageView) viewHolder.b(R$id.iv_image);
            int[] iArr = BottomListPopupView.this.W;
            if (iArr == null || iArr.length <= i2) {
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
            } else if (imageView != null) {
                imageView.setVisibility(0);
                imageView.setBackgroundResource(BottomListPopupView.this.W[i2]);
            }
            if (BottomListPopupView.this.f17470b0 != -1) {
                if (viewHolder.b(R$id.check_view) != null) {
                    viewHolder.a(R$id.check_view).setVisibility(i2 != BottomListPopupView.this.f17470b0 ? 8 : 0);
                    ((CheckView) viewHolder.a(R$id.check_view)).setColor(com.lxj.xpopup.a.c());
                }
                TextView textView = (TextView) viewHolder.a(R$id.tv_text);
                BottomListPopupView bottomListPopupView = BottomListPopupView.this;
                textView.setTextColor(i2 == bottomListPopupView.f17470b0 ? com.lxj.xpopup.a.c() : bottomListPopupView.getResources().getColor(R$color._xpopup_title_color));
            } else {
                if (viewHolder.b(R$id.check_view) != null) {
                    viewHolder.a(R$id.check_view).setVisibility(8);
                }
                ((TextView) viewHolder.a(R$id.tv_text)).setGravity(17);
            }
            BottomListPopupView bottomListPopupView2 = BottomListPopupView.this;
            if (bottomListPopupView2.T == 0) {
                if (bottomListPopupView2.f17361s.G) {
                    ((TextView) viewHolder.a(R$id.tv_text)).setTextColor(BottomListPopupView.this.getResources().getColor(R$color._xpopup_white_color));
                } else {
                    ((TextView) viewHolder.a(R$id.tv_text)).setTextColor(BottomListPopupView.this.getResources().getColor(R$color._xpopup_dark_color));
                }
            }
        }
    }

    class c extends MultiItemTypeAdapter.c {
        final /* synthetic */ EasyAdapter a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (BottomListPopupView.this.f17361s.f17409d.booleanValue()) {
                    BottomListPopupView.this.g();
                }
            }
        }

        c(EasyAdapter easyAdapter) {
            this.a = easyAdapter;
        }

        @Override // com.lxj.easyadapter.MultiItemTypeAdapter.b
        public void b(View view, RecyclerView.ViewHolder viewHolder, int i2) {
            if (BottomListPopupView.this.f17469a0 != null) {
                BottomListPopupView.this.f17469a0.a(i2, (String) this.a.getData().get(i2));
            }
            BottomListPopupView bottomListPopupView = BottomListPopupView.this;
            if (bottomListPopupView.f17470b0 != -1) {
                bottomListPopupView.f17470b0 = i2;
                this.a.notifyDataSetChanged();
            }
            BottomListPopupView.this.postDelayed(new a(), 100L);
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void b() {
        super.b();
        ((VerticalRecyclerView) this.O).setupDivider(true);
        this.P.setTextColor(getResources().getColor(R$color._xpopup_white_color));
        TextView textView = this.Q;
        if (textView != null) {
            textView.setTextColor(getResources().getColor(R$color._xpopup_white_color));
        }
        findViewById(R$id.xpopup_divider).setBackgroundColor(getResources().getColor(R$color._xpopup_list_dark_divider));
        View view = this.R;
        if (view != null) {
            view.setBackgroundColor(Color.parseColor("#1B1B1B"));
        }
        View popupImplView = getPopupImplView();
        int color = getResources().getColor(R$color._xpopup_dark_color);
        float f2 = this.f17361s.f17421p;
        popupImplView.setBackground(com.lxj.xpopup.util.b.a(color, f2, f2, 0.0f, 0.0f));
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void c() {
        super.c();
        ((VerticalRecyclerView) this.O).setupDivider(false);
        this.P.setTextColor(getResources().getColor(R$color._xpopup_dark_color));
        TextView textView = this.Q;
        if (textView != null) {
            textView.setTextColor(getResources().getColor(R$color._xpopup_dark_color));
        }
        findViewById(R$id.xpopup_divider).setBackgroundColor(getResources().getColor(R$color._xpopup_list_divider));
        View view = this.R;
        if (view != null) {
            view.setBackgroundColor(getResources().getColor(R$color._xpopup_white_color));
        }
        View popupImplView = getPopupImplView();
        int color = getResources().getColor(R$color._xpopup_light_color);
        float f2 = this.f17361s.f17421p;
        popupImplView.setBackground(com.lxj.xpopup.util.b.a(color, f2, f2, 0.0f, 0.0f));
    }

    @Override // com.lxj.xpopup.core.BottomPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        int i2 = this.S;
        return i2 == 0 ? R$layout._xpopup_bottom_impl_list : i2;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void r() {
        super.r();
        this.O = (RecyclerView) findViewById(R$id.recyclerView);
        if (this.S != 0) {
            this.O.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        this.P = (TextView) findViewById(R$id.tv_title);
        this.Q = (TextView) findViewById(R$id.tv_cancel);
        this.R = findViewById(R$id.vv_divider);
        TextView textView = this.Q;
        if (textView != null) {
            textView.setOnClickListener(new a());
        }
        if (this.P != null) {
            if (TextUtils.isEmpty(this.U)) {
                this.P.setVisibility(8);
                if (findViewById(R$id.xpopup_divider) != null) {
                    findViewById(R$id.xpopup_divider).setVisibility(8);
                }
            } else {
                this.P.setText(this.U);
            }
        }
        List listAsList = Arrays.asList(this.V);
        int i2 = this.T;
        if (i2 == 0) {
            i2 = R$layout._xpopup_adapter_text_match;
        }
        b bVar = new b(listAsList, i2);
        bVar.a(new c(bVar));
        this.O.setAdapter(bVar);
        x();
    }

    protected void x() {
        if (this.S == 0) {
            if (this.f17361s.G) {
                b();
            } else {
                c();
            }
        }
    }
}
