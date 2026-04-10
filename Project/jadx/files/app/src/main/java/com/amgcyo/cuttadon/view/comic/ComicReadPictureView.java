package com.amgcyo.cuttadon.view.comic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.bumptech.glide.load.DecodeFormat;
import com.fatcatfat.io.R;
import com.github.chrisbanes.photoview.PhotoView;
import me.jessyan.art.entity.GlideBean;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: loaded from: classes.dex */
public class ComicReadPictureView extends PhotoView {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Paint f4453u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f4454v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f4455w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f4456x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f4457y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private com.bumptech.glide.request.h f4458z;

    public ComicReadPictureView(Context context) {
        super(context);
        this.f4457y = true;
        a();
    }

    private void a() {
        setBackgroundColor(o.b(R.color.colorWhite2));
        this.f4453u = new Paint(1);
        this.f4455w = o.b(R.color.text_66);
        this.f4454v = n.a(50.0f);
        this.f4456x = "";
        b();
    }

    private void b() {
        this.f4458z = new com.bumptech.glide.request.h().format(DecodeFormat.PREFER_RGB_565).skipMemoryCache(true).diskCacheStrategy(com.bumptech.glide.load.engine.h.f13534c);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f4457y) {
            a(canvas);
        }
    }

    public void setText(String str) {
        this.f4457y = true;
        this.f4456x = str;
        invalidate();
    }

    public void setTextColor(int i2) {
        this.f4455w = i2;
        invalidate();
    }

    public void setTextVisibility(boolean z2) {
        this.f4457y = z2;
        invalidate();
    }

    public ComicReadPictureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4457y = true;
        a();
    }

    public ComicReadPictureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4457y = true;
        a();
    }

    private void a(Canvas canvas) {
        if (this.f4453u == null) {
            a();
        }
        this.f4453u.setColor(this.f4455w);
        this.f4453u.setTextSize(this.f4454v);
        float width = (getWidth() / 2.0f) - (this.f4453u.measureText(this.f4456x) / 2.0f);
        Paint.FontMetrics fontMetrics = this.f4453u.getFontMetrics();
        canvas.drawText(this.f4456x, width, (getHeight() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.f4453u);
    }

    public void a(Context context, int i2, String str, me.jessyan.art.c.e.c cVar, GlideBean glideBean, com.bumptech.glide.request.g<Drawable> gVar) {
        if (context == null || TextUtils.isEmpty(str) || gVar == null) {
            return;
        }
        setTag(R.id.imageid, Integer.valueOf(i2));
        if (this.f4458z == null) {
            b();
        }
        if (getTag(R.id.imageid) == null || i2 != ((Integer) getTag(R.id.imageid)).intValue()) {
            return;
        }
        cVar.a(context, ImageConfigImpl.builder().placeholder(-1).errorPic(-1).glideBean(glideBean).signature(glideBean.getSignature()).url(str).requestOptions(this.f4458z).listener(gVar).imageView(this).build());
    }
}
