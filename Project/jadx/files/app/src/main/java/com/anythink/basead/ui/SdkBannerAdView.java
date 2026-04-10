package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import com.anythink.core.common.k.h;
import com.anythink.core.common.k.l;
import com.anythink.core.common.k.u;
import com.anythink.core.common.res.b;
import com.anythink.core.common.res.image.RecycleImageView;
import com.anythink.core.common.ui.component.RoundImageView;
import com.anythink.expressad.foundation.h.i;

/* JADX INFO: loaded from: classes2.dex */
public class SdkBannerAdView extends BaseBannerAdView {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f6298x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int f6299y = 2;
    private final View.OnClickListener A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    boolean f6300u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    String f6301v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f6302w;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final View.OnClickListener f6303z;

    /* JADX INFO: renamed from: com.anythink.basead.ui.SdkBannerAdView$10, reason: invalid class name */
    final class AnonymousClass10 implements b.a {
        final /* synthetic */ ImageView a;

        AnonymousClass10(ImageView imageView) {
            this.a = imageView;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(SdkBannerAdView.this.f6115d.v(), str)) {
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.SdkBannerAdView$11, reason: invalid class name */
    final class AnonymousClass11 implements View.OnClickListener {
        AnonymousClass11() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.SdkBannerAdView$12, reason: invalid class name */
    final class AnonymousClass12 implements View.OnClickListener {
        AnonymousClass12() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            l.b(n.a().g(), SdkBannerAdView.this.f6115d.H());
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.SdkBannerAdView$13, reason: invalid class name */
    final class AnonymousClass13 implements View.OnClickListener {
        AnonymousClass13() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            l.b(n.a().g(), SdkBannerAdView.this.f6115d.I());
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.SdkBannerAdView$14, reason: invalid class name */
    final class AnonymousClass14 implements View.OnClickListener {
        AnonymousClass14() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.SdkBannerAdView$15, reason: invalid class name */
    final class AnonymousClass15 implements b.a {
        final /* synthetic */ RoundImageView a;

        AnonymousClass15(RoundImageView roundImageView) {
            this.a = roundImageView;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(SdkBannerAdView.this.f6115d.t(), str)) {
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.SdkBannerAdView$2, reason: invalid class name */
    final class AnonymousClass2 implements b.a {
        final /* synthetic */ ImageView a;

        AnonymousClass2(ImageView imageView) {
            this.a = imageView;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(SdkBannerAdView.this.f6115d.v(), str)) {
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.SdkBannerAdView$3, reason: invalid class name */
    final class AnonymousClass3 implements b.a {
        final /* synthetic */ RoundImageView a;

        AnonymousClass3(RoundImageView roundImageView) {
            this.a = roundImageView;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(SdkBannerAdView.this.f6115d.u(), str)) {
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.SdkBannerAdView$4, reason: invalid class name */
    final class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.SdkBannerAdView$5, reason: invalid class name */
    final class AnonymousClass5 implements View.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            l.b(n.a().g(), SdkBannerAdView.this.f6115d.H());
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.SdkBannerAdView$6, reason: invalid class name */
    final class AnonymousClass6 implements View.OnClickListener {
        AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            l.b(n.a().g(), SdkBannerAdView.this.f6115d.I());
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.SdkBannerAdView$7, reason: invalid class name */
    final class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.SdkBannerAdView$9, reason: invalid class name */
    final class AnonymousClass9 implements b.a {
        final /* synthetic */ String a;
        final /* synthetic */ RecycleImageView b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ RecycleImageView f6304c;

        AnonymousClass9(String str, RecycleImageView recycleImageView, RecycleImageView recycleImageView2) {
            this.a = str;
            this.b = recycleImageView;
            this.f6304c = recycleImageView2;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, final Bitmap bitmap) {
            if (TextUtils.equals(this.a, str)) {
                this.b.setImageBitmap(bitmap);
                SdkBannerAdView.this.post(new Runnable() { // from class: com.anythink.basead.ui.SdkBannerAdView.9.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        int[] iArrA = u.a(SdkBannerAdView.this.getWidth(), SdkBannerAdView.this.getHeight(), bitmap.getWidth() / bitmap.getHeight());
                        ViewGroup.LayoutParams layoutParams = AnonymousClass9.this.b.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = iArrA[0];
                            layoutParams.height = iArrA[1];
                            AnonymousClass9.this.b.setLayoutParams(layoutParams);
                        }
                    }
                });
                this.f6304c.setImageBitmap(com.anythink.core.common.k.b.a(SdkBannerAdView.this.getContext(), bitmap));
            }
        }
    }

    public SdkBannerAdView(Context context) {
        super(context);
        this.f6302w = 2;
        this.f6303z = new View.OnClickListener() { // from class: com.anythink.basead.ui.SdkBannerAdView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (2 != SdkBannerAdView.this.f6302w) {
                    SdkBannerAdView.super.b(1);
                    return;
                }
                k kVar = SdkBannerAdView.this.f6114c.f7312m;
                if (kVar == null || kVar.x() != 0) {
                    return;
                }
                SdkBannerAdView.super.b(1);
            }
        };
        this.A = new View.OnClickListener() { // from class: com.anythink.basead.ui.SdkBannerAdView.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SdkBannerAdView.super.b(1);
            }
        };
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x058c  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0648  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x06fc  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0773  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x07a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void o() {
        /*
            Method dump skipped, instruction units count: 2076
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.ui.SdkBannerAdView.o():void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0389  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void p() {
        /*
            Method dump skipped, instruction units count: 1348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.ui.SdkBannerAdView.p():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int a(java.lang.String r5) {
        /*
            r4 = this;
            com.anythink.core.common.e.i r0 = r4.f6115d
            boolean r1 = r0 instanceof com.anythink.core.common.e.aa
            r2 = 1
            r3 = 2
            if (r1 == 0) goto L14
            com.anythink.core.common.e.aa r0 = (com.anythink.core.common.e.aa) r0
            int r5 = r0.Y()
            if (r5 == r2) goto L12
            r0 = 3
            goto L25
        L12:
            r3 = 1
            goto L25
        L14:
            boolean r0 = r0 instanceof com.anythink.core.common.e.s
            if (r0 == 0) goto L25
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L25
            boolean r5 = com.anythink.basead.a.b.c.c(r5)
            if (r5 == 0) goto L25
            goto L12
        L25:
            r4.f6302w = r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.ui.SdkBannerAdView.a(java.lang.String):int");
    }

    private void b(String str) {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(h.a(getContext(), "myoffer_banner_root", "id"));
        this.f6132t = (CloseImageView) findViewById(h.a(getContext(), "myoffer_banner_close", "id"));
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(h.a(getContext(), "myoffer_banner_container", "id"));
        TextView textView = (TextView) findViewById(h.a(getContext(), "myoffer_banner_publisher_name", "id"));
        TextView textView2 = (TextView) findViewById(h.a(getContext(), "myoffer_banner_privacy_agreement", "id"));
        TextView textView3 = (TextView) findViewById(h.a(getContext(), "myoffer_banner_permission_manage", "id"));
        TextView textView4 = (TextView) findViewById(h.a(getContext(), "myoffer_banner_version_name", "id"));
        if (this.f6114c.f7312m.s() == 0) {
            this.f6132t.setVisibility(0);
            if (TextUtils.equals(k.f7315d, this.f6301v)) {
                ViewGroup.LayoutParams layoutParams = this.f6132t.getLayoutParams();
                layoutParams.width = h.a(getContext(), 23.0f);
                layoutParams.height = h.a(getContext(), 23.0f);
                this.f6132t.setLayoutParams(layoutParams);
            }
            a(this.f6132t, this.f6114c.f7312m.h());
        } else {
            this.f6132t.setVisibility(8);
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        relativeLayout.setLayoutParams(layoutParams2);
        RecycleImageView recycleImageView = new RecycleImageView(getContext());
        recycleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(recycleImageView, 0, new RelativeLayout.LayoutParams(-1, -1));
        RecycleImageView recycleImageView2 = new RecycleImageView(getContext());
        recycleImageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, str), new AnonymousClass9(str, recycleImageView2, recycleImageView));
        this.f6129r.add(recycleImageView2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.addRule(13);
        addView(recycleImageView2, 1, layoutParams3);
        if (!TextUtils.isEmpty(this.f6115d.v())) {
            ImageView imageView = (ImageView) findViewById(h.a(getContext(), "myoffer_banner_self_ad_logo", "id"));
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.f6115d.v()), new AnonymousClass10(imageView));
            this.f6129r.add(imageView);
        }
        if (this.f6115d.K()) {
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(0);
            }
            if (textView != null) {
                textView.setVisibility(0);
                textView.setText(this.f6115d.F());
                textView.setOnClickListener(new AnonymousClass11());
            }
            if (textView2 != null) {
                textView2.setVisibility(0);
                textView2.setOnClickListener(new AnonymousClass12());
            }
            if (textView3 != null) {
                textView3.setVisibility(0);
                textView3.setOnClickListener(new AnonymousClass13());
            }
            if (textView4 != null) {
                textView4.setVisibility(0);
                textView4.setText(getContext().getResources().getString(h.a(getContext(), "myoffer_panel_version", i.f10649g), this.f6115d.G()));
                textView4.setOnClickListener(new AnonymousClass14());
            }
        }
    }

    @Override // com.anythink.basead.ui.BaseBannerAdView
    protected final void c() {
        int size = this.f6129r.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.f6129r.get(i2);
            if (view != null) {
                view.setOnClickListener(this.A);
            }
        }
        setOnClickListener(this.f6303z);
        super.c();
    }

    public SdkBannerAdView(Context context, j jVar, com.anythink.core.common.e.i iVar, com.anythink.basead.e.a aVar) {
        super(context, jVar, iVar, aVar);
        this.f6302w = 2;
        this.f6303z = new View.OnClickListener() { // from class: com.anythink.basead.ui.SdkBannerAdView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (2 != SdkBannerAdView.this.f6302w) {
                    SdkBannerAdView.super.b(1);
                    return;
                }
                k kVar = SdkBannerAdView.this.f6114c.f7312m;
                if (kVar == null || kVar.x() != 0) {
                    return;
                }
                SdkBannerAdView.super.b(1);
            }
        };
        this.A = new View.OnClickListener() { // from class: com.anythink.basead.ui.SdkBannerAdView.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SdkBannerAdView.super.b(1);
            }
        };
        b();
        c();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x058c  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0648  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x06fc  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0773  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x07a6  */
    @Override // com.anythink.basead.ui.BaseAdView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void a() {
        /*
            Method dump skipped, instruction units count: 2076
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.ui.SdkBannerAdView.a():void");
    }
}
