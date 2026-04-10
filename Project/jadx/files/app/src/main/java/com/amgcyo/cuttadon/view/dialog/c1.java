package com.amgcyo.cuttadon.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.api.entity.other.NewApiAd;
import com.amgcyo.cuttadon.view.otherview.SelfAdLogoFrameLayout;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.fatcatfat.io.R;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: compiled from: InteractionAdDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class c1 extends Dialog implements View.OnClickListener {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4684s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ImageView f4685t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ImageView f4686u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private SelfAdLogoFrameLayout f4687v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private com.amgcyo.cuttadon.g.f f4688w;

    /* JADX INFO: compiled from: InteractionAdDialog.java */
    class a implements com.bumptech.glide.request.g<Drawable> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ NewApiAd f4689s;

        a(NewApiAd newApiAd) {
            this.f4689s = newApiAd;
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(@Nullable GlideException glideException, Object obj, com.bumptech.glide.request.k.j<Drawable> jVar, boolean z2) {
            c1.this.a();
            return false;
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(Drawable drawable, Object obj, com.bumptech.glide.request.k.j<Drawable> jVar, DataSource dataSource, boolean z2) {
            Context context = c1.this.f4684s;
            NewApiAd newApiAd = this.f4689s;
            com.amgcyo.cuttadon.h.h.c.a(context, "OWNADSHOW", newApiAd, newApiAd.getLocation(), this.f4689s.getOwnerType());
            c1.this.a();
            return false;
        }
    }

    public c1(@NonNull Context context) {
        super(context);
        this.f4684s = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_close) {
            dismiss();
        } else {
            if (id != R.id.selfadlogo_fl) {
                return;
            }
            com.amgcyo.cuttadon.g.f fVar = this.f4688w;
            if (fVar != null) {
                fVar.a();
            }
            dismiss();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(R.layout.dialog_show_tips, (ViewGroup) null);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.setGravity(17);
        window.setContentView(viewInflate);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        WindowManager.LayoutParams attributes = window.getAttributes();
        double dC = com.amgcyo.cuttadon.utils.otherutils.n.c(this.f4684s);
        Double.isNaN(dC);
        attributes.width = (int) (dC * 0.8d);
        attributes.height = -2;
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.DialogScaleAnim);
        this.f4687v = (SelfAdLogoFrameLayout) findViewById(R.id.selfadlogo_fl);
        this.f4685t = this.f4687v.getIv_native_image();
        this.f4686u = (ImageView) findViewById(R.id.iv_close);
        this.f4687v.setOnClickListener(this);
        this.f4686u.setOnClickListener(this);
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
    }

    public void a(NewApiAd newApiAd, me.jessyan.art.c.e.c cVar) {
        if (newApiAd == null) {
            return;
        }
        String image = newApiAd.getImage();
        newApiAd.setOwnerType("插屏");
        if (TextUtils.isEmpty(image) || this.f4685t == null) {
            return;
        }
        cVar.a(this.f4684s, ImageConfigImpl.builder().url(image).listener(new a(newApiAd)).imageRadius(8).isNeedPlaceholder(false).imageView(this.f4685t).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        ImageView imageView = this.f4686u;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        SelfAdLogoFrameLayout selfAdLogoFrameLayout = this.f4687v;
        if (selfAdLogoFrameLayout != null) {
            selfAdLogoFrameLayout.a();
        }
    }

    public void a(com.amgcyo.cuttadon.g.f fVar) {
        this.f4688w = fVar;
    }
}
