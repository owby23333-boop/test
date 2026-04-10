package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import com.anythink.core.common.k.h;
import com.anythink.core.common.k.u;
import com.anythink.core.common.res.b;
import com.anythink.core.common.ui.component.RoundImageView;

/* JADX INFO: loaded from: classes2.dex */
public class EndCardView extends BaseEndCardView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f6183e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f6184f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f6185g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ImageView f6186h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private RoundImageView f6187i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ImageView f6188j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f6189k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final View.OnClickListener f6190l;

    /* JADX INFO: renamed from: com.anythink.basead.ui.EndCardView$2, reason: invalid class name */
    final class AnonymousClass2 implements b.a {
        final /* synthetic */ i a;

        AnonymousClass2(i iVar) {
            this.a = iVar;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
            if (EndCardView.this.f6183e != null) {
                EndCardView.this.f6183e.b();
            }
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, final Bitmap bitmap) {
            if (TextUtils.equals(str, this.a.u())) {
                EndCardView.this.f6186h.setImageBitmap(bitmap);
                EndCardView.this.post(new Runnable() { // from class: com.anythink.basead.ui.EndCardView.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        int[] iArrA = u.a(EndCardView.this.getWidth(), EndCardView.this.getHeight(), bitmap.getWidth() / bitmap.getHeight());
                        ViewGroup.LayoutParams layoutParams = EndCardView.this.f6186h.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = iArrA[0];
                            layoutParams.height = iArrA[1];
                            EndCardView.this.f6186h.setLayoutParams(layoutParams);
                        }
                        if (EndCardView.this.f6183e != null) {
                            EndCardView.this.f6183e.b();
                        }
                    }
                });
                EndCardView.this.f6187i.setImageBitmap(com.anythink.core.common.k.b.a(EndCardView.this.getContext(), bitmap));
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.EndCardView$3, reason: invalid class name */
    final class AnonymousClass3 implements b.a {
        final /* synthetic */ String a;
        final /* synthetic */ int b;

        AnonymousClass3(String str, int i2) {
            this.a = str;
            this.b = i2;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(str, this.a)) {
                int i2 = this.b;
                ViewGroup.LayoutParams layoutParams = EndCardView.this.f6188j.getLayoutParams();
                layoutParams.width = (int) (i2 * ((bitmap.getWidth() * 1.0f) / bitmap.getHeight()));
                layoutParams.height = i2;
                EndCardView.this.f6188j.setLayoutParams(layoutParams);
                EndCardView.this.f6188j.setScaleType(ImageView.ScaleType.FIT_XY);
                EndCardView.this.f6188j.setImageBitmap(bitmap);
            }
        }
    }

    public interface a {
        void a();

        void b();
    }

    public EndCardView(Context context, i iVar, j jVar) {
        super(context, iVar, jVar);
        this.f6190l = new View.OnClickListener() { // from class: com.anythink.basead.ui.EndCardView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k kVar = EndCardView.this.f6134d;
                if (kVar != null) {
                    if (kVar.x() == 0) {
                        if (EndCardView.this.f6183e != null) {
                            EndCardView.this.f6183e.a();
                        }
                    } else {
                        if (EndCardView.this.f6189k == null || !EndCardView.this.f6189k.isShown() || view != EndCardView.this.f6189k || EndCardView.this.f6183e == null) {
                            return;
                        }
                        EndCardView.this.f6183e.a();
                    }
                }
            }
        };
    }

    @Override // com.anythink.basead.ui.BaseEndCardView
    protected final void a() {
    }

    public View getLearnMoreButton() {
        return this.f6189k;
    }

    public void init(boolean z2, boolean z3, a aVar) {
        setId(h.a(getContext(), "myoffer_end_card_id", "id"));
        this.f6183e = aVar;
        this.f6187i = new RoundImageView(getContext());
        this.f6187i.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f6186h = new RoundImageView(getContext());
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.f6184f, this.f6185g);
        layoutParams2.addRule(13);
        addView(this.f6187i, layoutParams);
        addView(this.f6186h, layoutParams2);
        if (z2) {
            i iVar = this.b;
            this.f6188j = new RoundImageView(getContext());
            int iA = h.a(getContext(), 12.0f);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, iA);
            layoutParams3.addRule(11);
            layoutParams3.addRule(12);
            addView(this.f6188j, layoutParams3);
            String strV = iVar.v();
            if (!TextUtils.isEmpty(strV)) {
                ViewGroup.LayoutParams layoutParams4 = this.f6188j.getLayoutParams();
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, strV), layoutParams4.width, layoutParams4.height, new AnonymousClass3(strV, iA));
            }
        }
        if (z3) {
            this.f6189k = new ScanningAnimTextView(getContext());
            this.f6189k.setText(h.a(getContext(), "myoffer_cta_learn_more", com.anythink.expressad.foundation.h.i.f10649g));
            this.f6189k.setTextColor(Color.parseColor("#ffffffff"));
            this.f6189k.setTextSize(14.0f);
            this.f6189k.setGravity(17);
            this.f6189k.setBackgroundResource(h.a(getContext(), "myoffer_splash_bg_rectangle_btn_cta_asseblem", com.anythink.expressad.foundation.h.i.f10645c));
            this.f6189k.setOnClickListener(this.f6190l);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, h.a(getContext(), 48.0f));
            layoutParams5.addRule(12);
            layoutParams5.bottomMargin = h.a(getContext(), 96.0f);
            layoutParams5.leftMargin = h.a(getContext(), 24.0f);
            layoutParams5.rightMargin = h.a(getContext(), 24.0f);
            addView(this.f6189k, layoutParams5);
        }
        setOnClickListener(this.f6190l);
    }

    public void load() {
        i iVar = this.b;
        try {
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, iVar.u()), this.f6184f, this.f6185g, new AnonymousClass2(iVar));
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setSize(int i2, int i3) {
        this.f6184f = i2;
        this.f6185g = i3;
    }

    private void a(i iVar) {
        try {
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, iVar.u()), this.f6184f, this.f6185g, new AnonymousClass2(iVar));
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
        }
    }

    private void b(i iVar) {
        this.f6188j = new RoundImageView(getContext());
        int iA = h.a(getContext(), 12.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, iA);
        layoutParams.addRule(11);
        layoutParams.addRule(12);
        addView(this.f6188j, layoutParams);
        String strV = iVar.v();
        if (TextUtils.isEmpty(strV)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.f6188j.getLayoutParams();
        com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, strV), layoutParams2.width, layoutParams2.height, new AnonymousClass3(strV, iA));
    }

    private void b() {
        this.f6189k = new ScanningAnimTextView(getContext());
        this.f6189k.setText(h.a(getContext(), "myoffer_cta_learn_more", com.anythink.expressad.foundation.h.i.f10649g));
        this.f6189k.setTextColor(Color.parseColor("#ffffffff"));
        this.f6189k.setTextSize(14.0f);
        this.f6189k.setGravity(17);
        this.f6189k.setBackgroundResource(h.a(getContext(), "myoffer_splash_bg_rectangle_btn_cta_asseblem", com.anythink.expressad.foundation.h.i.f10645c));
        this.f6189k.setOnClickListener(this.f6190l);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, h.a(getContext(), 48.0f));
        layoutParams.addRule(12);
        layoutParams.bottomMargin = h.a(getContext(), 96.0f);
        layoutParams.leftMargin = h.a(getContext(), 24.0f);
        layoutParams.rightMargin = h.a(getContext(), 24.0f);
        addView(this.f6189k, layoutParams);
    }
}
