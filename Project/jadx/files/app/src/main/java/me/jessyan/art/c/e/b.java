package me.jessyan.art.c.e;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.g;
import com.bumptech.glide.request.h;
import me.jessyan.art.entity.GlideBean;

/* JADX INFO: compiled from: ImageConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    protected byte[] bytes;
    protected Drawable drawable;
    protected int errorPic;
    protected int form;
    protected GlideBean glideBean;
    protected ImageView imageView;

    @Nullable
    protected g<Drawable> listener;
    protected int placeholder;
    protected Drawable placeholderDrawable;
    protected h requestOptions;
    protected int resId;
    protected String signature;
    protected Uri uri;
    protected String url;

    public byte[] getBytes() {
        return this.bytes;
    }

    public Drawable getDrawable() {
        return this.drawable;
    }

    public int getErrorPic() {
        return this.errorPic;
    }

    public int getForm() {
        return this.form;
    }

    public GlideBean getGlideBean() {
        return this.glideBean;
    }

    public ImageView getImageView() {
        return this.imageView;
    }

    @Nullable
    public g<Drawable> getListener() {
        return this.listener;
    }

    public int getPlaceholder() {
        return this.placeholder;
    }

    public Drawable getPlaceholderDrawable() {
        return this.placeholderDrawable;
    }

    public h getRequestOptions() {
        return this.requestOptions;
    }

    public int getResId() {
        return this.resId;
    }

    public String getSignature() {
        return this.signature;
    }

    public Uri getUri() {
        return this.uri;
    }

    public String getUrl() {
        return this.url;
    }

    public void setBytes(byte[] bArr) {
        this.bytes = bArr;
    }

    public void setForm(int i2) {
        this.form = i2;
    }

    public void setGlideBean(GlideBean glideBean) {
        this.glideBean = glideBean;
    }

    public void setListener(@Nullable g<Drawable> gVar) {
        this.listener = gVar;
    }

    public void setRequestOptions(h hVar) {
        this.requestOptions = hVar;
    }

    public void setResId(int i2) {
        this.resId = i2;
    }

    public void setSignature(String str) {
        this.signature = str;
    }
}
