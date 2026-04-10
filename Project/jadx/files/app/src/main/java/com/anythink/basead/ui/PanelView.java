package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.anythink.basead.ui.BaseShakeView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import com.anythink.core.common.k.h;
import com.anythink.core.common.k.l;
import com.anythink.core.common.k.u;
import com.anythink.core.common.res.b;
import com.anythink.core.common.ui.component.RoundImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PanelView extends RelativeLayout {
    public static final int TYPE_FULL_SCREEN_BANNER = 0;
    public static final int TYPE_FULL_SCREEN_EMPTY_INFO = 8;
    public static final int TYPE_FULL_SCREEN_ENDCARD_HORIZONTAL_LANDSCAPE = 6;
    public static final int TYPE_FULL_SCREEN_ENDCARD_HORIZONTAL_PORTRAIT = 1;
    public static final int TYPE_FULL_SCREEN_ENDCARD_VERTICAL_LANDSCAPE = 2;
    public static final int TYPE_FULL_SCREEN_ENDCARD_VERTICAL_PORTRAIT = 5;
    public static final int TYPE_HALF_SCREEN_EMPTY_INFO = 7;
    public static final int TYPE_HALF_SCREEN_HORIZONTAL = 4;
    public static final int TYPE_HALF_SCREEN_VERTICAL = 3;
    private View a;
    private ImageView b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ImageView f6243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f6244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f6245e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Button f6246f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private BaseShakeView f6247g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private a f6248h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f6249i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private k f6250j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private j f6251k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private i f6252l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f6253m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ViewGroup f6254n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private TextView f6255o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TextView f6256p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TextView f6257q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private TextView f6258r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f6259s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f6260t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f6261u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private List<View> f6262v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final View.OnClickListener f6263w;

    /* JADX INFO: renamed from: com.anythink.basead.ui.PanelView$1, reason: invalid class name */
    final class AnonymousClass1 implements b.a {
        final /* synthetic */ String a;

        AnonymousClass1(String str) {
            this.a = str;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(str, this.a)) {
                PanelView.this.b.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.PanelView$2, reason: invalid class name */
    final class AnonymousClass2 implements b.a {
        final /* synthetic */ String a;
        final /* synthetic */ ViewGroup.LayoutParams b;

        AnonymousClass2(String str, ViewGroup.LayoutParams layoutParams) {
            this.a = str;
            this.b = layoutParams;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
            PanelView.this.f6243c.setVisibility(8);
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(str, this.a)) {
                PanelView.this.f6243c.setImageBitmap(bitmap);
                ViewGroup.LayoutParams layoutParams = this.b;
                int i2 = layoutParams.height;
                layoutParams.width = (int) (i2 * ((bitmap.getWidth() * 1.0f) / bitmap.getHeight()));
                layoutParams.height = i2;
                PanelView.this.f6243c.setLayoutParams(this.b);
                PanelView.this.f6243c.setScaleType(ImageView.ScaleType.FIT_XY);
                PanelView.this.f6243c.setImageBitmap(bitmap);
                PanelView.this.f6243c.setVisibility(0);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.PanelView$7, reason: invalid class name */
    final class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PanelView.this.f6263w.onClick(PanelView.this.f6246f);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.PanelView$8, reason: invalid class name */
    final class AnonymousClass8 implements BaseShakeView.a {
        AnonymousClass8() {
        }

        @Override // com.anythink.basead.ui.BaseShakeView.a
        public final boolean a() {
            return PanelView.this.f6248h.b();
        }
    }

    public interface a {
        void a();

        boolean b();
    }

    public PanelView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6253m = 0;
        this.f6259s = false;
        this.f6260t = false;
        this.f6261u = false;
        this.f6263w = new View.OnClickListener() { // from class: com.anythink.basead.ui.PanelView.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (PanelView.this.f6250j != null) {
                    if (PanelView.this.f6250j.x() != 1) {
                        if (PanelView.this.f6248h != null) {
                            PanelView.this.f6248h.a();
                        }
                    } else {
                        if (view != PanelView.this.f6246f || PanelView.this.f6248h == null) {
                            return;
                        }
                        PanelView.this.f6248h.a();
                    }
                }
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.f6253m != 0) {
            super.dispatchDraw(canvas);
            return;
        }
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        super.dispatchDraw(canvas);
        u.a(canvas, getWidth(), getHeight(), h.a(getContext(), 7.0f));
        canvas.restoreToCount(iSaveLayer);
    }

    public View getCTAButton() {
        return this.f6246f;
    }

    public List<View> getClickViews() {
        return this.f6262v;
    }

    public View getShakeView() {
        return this.f6247g;
    }

    public void init(i iVar, j jVar, int i2, boolean z2, a aVar) {
        this.f6248h = aVar;
        this.f6249i = i2;
        this.f6252l = iVar;
        this.f6251k = jVar;
        this.f6250j = jVar.f7312m;
        this.f6261u = z2;
        this.f6259s = iVar.K();
        this.f6260t = this.f6250j.o() == 1;
        this.f6262v = new ArrayList();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setLayoutType(int i2) {
        this.f6253m = i2;
        switch (i2) {
            case 1:
                if (!TextUtils.isEmpty(this.f6252l.t())) {
                    this.a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_endcard_horizontal_portrait", "layout"), (ViewGroup) this, true);
                } else {
                    this.a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_endcard_portrait_without_icon", "layout"), (ViewGroup) this, true);
                }
                break;
            case 2:
            case 6:
                if (!TextUtils.isEmpty(this.f6252l.t())) {
                    this.a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_endcard_landscape", "layout"), (ViewGroup) this, true);
                } else {
                    this.a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_endcard_landscape_without_icon", "layout"), (ViewGroup) this, true);
                }
                break;
            case 3:
                if (this.f6249i != 1) {
                    if (!TextUtils.isEmpty(this.f6252l.t())) {
                        this.a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_vertical", "layout"), (ViewGroup) this, true);
                    } else {
                        this.a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_vertical_without_icon", "layout"), (ViewGroup) this, true);
                    }
                } else if (!TextUtils.isEmpty(this.f6252l.t())) {
                    this.a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_horizontal", "layout"), (ViewGroup) this, true);
                } else {
                    this.a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_horizontal_without_icon", "layout"), (ViewGroup) this, true);
                }
                break;
            case 4:
                if (!TextUtils.isEmpty(this.f6252l.t())) {
                    this.a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_horizontal", "layout"), (ViewGroup) this, true);
                } else {
                    this.a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_horizontal_without_icon", "layout"), (ViewGroup) this, true);
                }
                break;
            case 5:
                if (!TextUtils.isEmpty(this.f6252l.t())) {
                    this.a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_endcard_vertical_portrait", "layout"), (ViewGroup) this, true);
                } else {
                    this.a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_endcard_portrait_without_icon", "layout"), (ViewGroup) this, true);
                }
                break;
            case 7:
                this.a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_empty_info", "layout"), (ViewGroup) this, true);
                break;
            case 8:
                this.a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_full_screen_empty_info", "layout"), (ViewGroup) this, true);
                break;
            default:
                if (!TextUtils.isEmpty(this.f6252l.t())) {
                    this.a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_bottom_banner", "layout"), (ViewGroup) this, true);
                } else {
                    this.a = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_panel_view_bottom_banner_without_icon", "layout"), (ViewGroup) this, true);
                }
                break;
        }
        d();
        i iVar = this.f6252l;
        if (this.b != null) {
            String strT = iVar.t();
            if (!TextUtils.isEmpty(strT)) {
                ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, strT), layoutParams.width, layoutParams.height, new AnonymousClass1(strT));
            }
            if (TextUtils.isEmpty(iVar.t())) {
                this.b.setVisibility(8);
            }
        }
        if (this.f6243c != null) {
            String strV = iVar.v();
            if (TextUtils.isEmpty(strV)) {
                this.f6243c.setVisibility(8);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.f6243c.getLayoutParams();
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, strV), layoutParams2.width, layoutParams2.height, new AnonymousClass2(strV, layoutParams2));
            }
        }
        if (this.f6245e != null) {
            if (TextUtils.isEmpty(iVar.s())) {
                this.f6245e.setVisibility(8);
            } else {
                this.f6245e.setText(iVar.s());
            }
        }
        if (this.f6244d != null) {
            if (TextUtils.isEmpty(iVar.r())) {
                this.f6244d.setVisibility(8);
            } else {
                this.f6244d.setText(iVar.r());
            }
        }
        if (TextUtils.isEmpty(iVar.w())) {
            this.f6246f.setText(com.anythink.basead.a.e.a(getContext(), this.f6252l));
        } else {
            this.f6246f.setText(iVar.w());
        }
        b(iVar);
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setOnClickListener(this.f6263w);
            this.f6262v.add(this.b);
        }
        TextView textView = this.f6244d;
        if (textView != null) {
            textView.setOnClickListener(this.f6263w);
            this.f6262v.add(this.f6244d);
        }
        TextView textView2 = this.f6245e;
        if (textView2 != null) {
            textView2.setOnClickListener(this.f6263w);
            this.f6262v.add(this.f6245e);
        }
        this.f6246f.setOnClickListener(this.f6263w);
        this.f6262v.add(this.f6246f);
        ImageView imageView2 = this.f6243c;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this.f6263w);
            this.f6262v.add(this.f6243c);
        }
        BaseShakeView baseShakeView = this.f6247g;
        if (baseShakeView != null && this.f6261u) {
            baseShakeView.setOnClickListener(new AnonymousClass7());
            this.f6247g.setOnShakeListener(new AnonymousClass8(), this.f6250j);
        }
        View viewFindViewById = this.a.findViewById(h.a(getContext(), "myoffer_panel_view_blank", "id"));
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(this.f6263w);
            this.f6262v.add(viewFindViewById);
        } else {
            this.a.setOnClickListener(this.f6263w);
            this.f6262v.add(this.a);
        }
        ImageView imageView3 = this.b;
        if (imageView3 instanceof RoundImageView) {
            ((RoundImageView) imageView3).setNeedRadiu(true);
            int i3 = this.f6253m;
            if (i3 == 2 || i3 == 6) {
                ((RoundImageView) this.b).setRadiusInDip(8);
            } else {
                ((RoundImageView) this.b).setRadiusInDip(12);
            }
            this.b.invalidate();
        }
    }

    private boolean a() {
        return this.f6259s && !this.f6260t;
    }

    private void b() {
        d();
        i iVar = this.f6252l;
        if (this.b != null) {
            String strT = iVar.t();
            if (!TextUtils.isEmpty(strT)) {
                ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, strT), layoutParams.width, layoutParams.height, new AnonymousClass1(strT));
            }
            if (TextUtils.isEmpty(iVar.t())) {
                this.b.setVisibility(8);
            }
        }
        if (this.f6243c != null) {
            String strV = iVar.v();
            if (TextUtils.isEmpty(strV)) {
                this.f6243c.setVisibility(8);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.f6243c.getLayoutParams();
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, strV), layoutParams2.width, layoutParams2.height, new AnonymousClass2(strV, layoutParams2));
            }
        }
        if (this.f6245e != null) {
            if (TextUtils.isEmpty(iVar.s())) {
                this.f6245e.setVisibility(8);
            } else {
                this.f6245e.setText(iVar.s());
            }
        }
        if (this.f6244d != null) {
            if (TextUtils.isEmpty(iVar.r())) {
                this.f6244d.setVisibility(8);
            } else {
                this.f6244d.setText(iVar.r());
            }
        }
        if (TextUtils.isEmpty(iVar.w())) {
            this.f6246f.setText(com.anythink.basead.a.e.a(getContext(), this.f6252l));
        } else {
            this.f6246f.setText(iVar.w());
        }
        b(iVar);
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setOnClickListener(this.f6263w);
            this.f6262v.add(this.b);
        }
        TextView textView = this.f6244d;
        if (textView != null) {
            textView.setOnClickListener(this.f6263w);
            this.f6262v.add(this.f6244d);
        }
        TextView textView2 = this.f6245e;
        if (textView2 != null) {
            textView2.setOnClickListener(this.f6263w);
            this.f6262v.add(this.f6245e);
        }
        this.f6246f.setOnClickListener(this.f6263w);
        this.f6262v.add(this.f6246f);
        ImageView imageView2 = this.f6243c;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this.f6263w);
            this.f6262v.add(this.f6243c);
        }
        BaseShakeView baseShakeView = this.f6247g;
        if (baseShakeView != null && this.f6261u) {
            baseShakeView.setOnClickListener(new AnonymousClass7());
            this.f6247g.setOnShakeListener(new AnonymousClass8(), this.f6250j);
        }
        View viewFindViewById = this.a.findViewById(h.a(getContext(), "myoffer_panel_view_blank", "id"));
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(this.f6263w);
            this.f6262v.add(viewFindViewById);
        } else {
            this.a.setOnClickListener(this.f6263w);
            this.f6262v.add(this.a);
        }
        ImageView imageView3 = this.b;
        if (imageView3 instanceof RoundImageView) {
            ((RoundImageView) imageView3).setNeedRadiu(true);
            int i2 = this.f6253m;
            if (i2 == 2 || i2 == 6) {
                ((RoundImageView) this.b).setRadiusInDip(8);
            } else {
                ((RoundImageView) this.b).setRadiusInDip(12);
            }
            this.b.invalidate();
        }
    }

    private void c() {
        ImageView imageView = this.b;
        if (imageView instanceof RoundImageView) {
            ((RoundImageView) imageView).setNeedRadiu(true);
            int i2 = this.f6253m;
            if (i2 == 2 || i2 == 6) {
                ((RoundImageView) this.b).setRadiusInDip(8);
            } else {
                ((RoundImageView) this.b).setRadiusInDip(12);
            }
            this.b.invalidate();
        }
    }

    private void d() {
        this.f6262v.clear();
        this.b = (ImageView) this.a.findViewById(h.a(getContext(), "myoffer_iv_banner_icon", "id"));
        this.f6244d = (TextView) this.a.findViewById(h.a(getContext(), "myoffer_tv_banner_title", "id"));
        this.f6245e = (TextView) this.a.findViewById(h.a(getContext(), "myoffer_tv_banner_desc", "id"));
        this.f6246f = (Button) this.a.findViewById(h.a(getContext(), "myoffer_btn_banner_cta", "id"));
        this.f6243c = (ImageView) this.a.findViewById(h.a(getContext(), "myoffer_ad_logo", "id"));
        this.f6254n = (ViewGroup) this.a.findViewById(h.a(getContext(), "myoffer_four_element_container", "id"));
        this.f6255o = (TextView) this.a.findViewById(h.a(getContext(), "myoffer_version_name", "id"));
        this.f6256p = (TextView) this.a.findViewById(h.a(getContext(), "myoffer_publisher_name", "id"));
        this.f6257q = (TextView) this.a.findViewById(h.a(getContext(), "myoffer_permission_manage", "id"));
        this.f6258r = (TextView) this.a.findViewById(h.a(getContext(), "myoffer_privacy_agreement", "id"));
        try {
            this.f6247g = (BaseShakeView) this.a.findViewById(h.a(getContext(), "myoffer_shake_hint_text", "id"));
        } catch (Throwable unused) {
        }
        e();
    }

    private void e() {
        BaseShakeView baseShakeView;
        if (!this.f6261u || (baseShakeView = this.f6247g) == null || this.f6253m == 8) {
            return;
        }
        baseShakeView.setVisibility(0);
    }

    private void f() {
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setOnClickListener(this.f6263w);
            this.f6262v.add(this.b);
        }
        TextView textView = this.f6244d;
        if (textView != null) {
            textView.setOnClickListener(this.f6263w);
            this.f6262v.add(this.f6244d);
        }
        TextView textView2 = this.f6245e;
        if (textView2 != null) {
            textView2.setOnClickListener(this.f6263w);
            this.f6262v.add(this.f6245e);
        }
        this.f6246f.setOnClickListener(this.f6263w);
        this.f6262v.add(this.f6246f);
        ImageView imageView2 = this.f6243c;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this.f6263w);
            this.f6262v.add(this.f6243c);
        }
        BaseShakeView baseShakeView = this.f6247g;
        if (baseShakeView != null && this.f6261u) {
            baseShakeView.setOnClickListener(new AnonymousClass7());
            this.f6247g.setOnShakeListener(new AnonymousClass8(), this.f6250j);
        }
        View viewFindViewById = this.a.findViewById(h.a(getContext(), "myoffer_panel_view_blank", "id"));
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(this.f6263w);
            this.f6262v.add(viewFindViewById);
        } else {
            this.a.setOnClickListener(this.f6263w);
            this.f6262v.add(this.a);
        }
    }

    private void a(i iVar) {
        if (this.b != null) {
            String strT = iVar.t();
            if (!TextUtils.isEmpty(strT)) {
                ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, strT), layoutParams.width, layoutParams.height, new AnonymousClass1(strT));
            }
            if (TextUtils.isEmpty(iVar.t())) {
                this.b.setVisibility(8);
            }
        }
        if (this.f6243c != null) {
            String strV = iVar.v();
            if (!TextUtils.isEmpty(strV)) {
                ViewGroup.LayoutParams layoutParams2 = this.f6243c.getLayoutParams();
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, strV), layoutParams2.width, layoutParams2.height, new AnonymousClass2(strV, layoutParams2));
            } else {
                this.f6243c.setVisibility(8);
            }
        }
        if (this.f6245e != null) {
            if (!TextUtils.isEmpty(iVar.s())) {
                this.f6245e.setText(iVar.s());
            } else {
                this.f6245e.setVisibility(8);
            }
        }
        if (this.f6244d != null) {
            if (!TextUtils.isEmpty(iVar.r())) {
                this.f6244d.setText(iVar.r());
            } else {
                this.f6244d.setVisibility(8);
            }
        }
        if (!TextUtils.isEmpty(iVar.w())) {
            this.f6246f.setText(iVar.w());
        } else {
            this.f6246f.setText(com.anythink.basead.a.e.a(getContext(), this.f6252l));
        }
        b(iVar);
    }

    private void b(final i iVar) {
        if (a()) {
            this.f6255o.setText(getContext().getResources().getString(h.a(getContext(), "myoffer_panel_version", com.anythink.expressad.foundation.h.i.f10649g), iVar.G()));
            this.f6256p.setText(iVar.F());
            this.f6258r.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.PanelView.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l.b(n.a().g(), iVar.H());
                }
            });
            this.f6257q.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.PanelView.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l.b(n.a().g(), iVar.I());
                }
            });
            this.f6255o.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.PanelView.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                }
            });
            this.f6256p.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.PanelView.6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                }
            });
            ViewGroup viewGroup = this.f6254n;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
            TextView textView = this.f6255o;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.f6256p;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            TextView textView3 = this.f6258r;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            TextView textView4 = this.f6257q;
            if (textView4 != null) {
                textView4.setVisibility(0);
                return;
            }
            return;
        }
        ViewGroup viewGroup2 = this.f6254n;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        }
        TextView textView5 = this.f6255o;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        TextView textView6 = this.f6256p;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        TextView textView7 = this.f6258r;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        TextView textView8 = this.f6257q;
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        try {
            View viewFindViewById = findViewById(h.a(getContext(), "myoffer_four_element_container_bg", "id"));
            if (viewFindViewById != null) {
                viewFindViewById.setBackgroundDrawable(null);
            }
        } catch (Throwable unused) {
        }
    }
}
