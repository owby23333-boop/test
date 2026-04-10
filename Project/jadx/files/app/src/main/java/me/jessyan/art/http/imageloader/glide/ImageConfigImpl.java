package me.jessyan.art.http.imageloader.glide;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.resource.bitmap.f;
import com.bumptech.glide.request.g;
import com.bumptech.glide.request.h;
import me.jessyan.art.entity.GlideBean;

/* JADX INFO: loaded from: classes3.dex */
public class ImageConfigImpl extends me.jessyan.art.c.e.b {
    private int blurValue;
    private int cacheStrategy;
    private int fallback;
    private int imageRadius;
    private ImageView[] imageViews;
    private boolean isCenterCrop;
    private boolean isCircle;
    private boolean isClearDiskCache;
    private boolean isClearMemory;
    private boolean isCrossFade;
    private boolean isNeedPlaceholder;

    @Deprecated
    private f transformation;

    public static final class Builder {
        private int blurValue;
        private byte[] bytes;
        private int cacheStrategy;
        private Drawable drawable;
        private int errorPic;
        private int fallback;
        private int form;
        private GlideBean glideBean;
        private int imageRadius;
        private ImageView imageView;
        private ImageView[] imageViews;
        private boolean isCenterCrop;
        private boolean isCircle;
        private boolean isClearDiskCache;
        private boolean isClearMemory;
        private boolean isCrossFade;
        private boolean isNeedPlaceholder;

        @Nullable
        private g<Drawable> listener;
        private int placeholder;
        private Drawable placeholderDrawable;
        private h requestOptions;
        private int resId;
        private String signature;

        @Deprecated
        private f transformation;
        private Uri uri;
        private String url;

        public Builder blurValue(int i2) {
            this.blurValue = i2;
            return this;
        }

        public ImageConfigImpl build() {
            return new ImageConfigImpl(this);
        }

        public Builder bytes(byte[] bArr) {
            this.bytes = bArr;
            return this;
        }

        public Builder cacheStrategy(int i2) {
            this.cacheStrategy = i2;
            return this;
        }

        public Builder drawable(Drawable drawable) {
            this.drawable = drawable;
            return this;
        }

        public Builder errorPic(int i2) {
            this.errorPic = i2;
            return this;
        }

        public Builder fallback(int i2) {
            this.fallback = i2;
            return this;
        }

        public Builder form(int i2) {
            this.form = i2;
            return this;
        }

        public Builder glideBean(GlideBean glideBean) {
            this.glideBean = glideBean;
            return this;
        }

        public Builder imageRadius(int i2) {
            this.imageRadius = i2;
            return this;
        }

        public Builder imageView(ImageView imageView) {
            this.imageView = imageView;
            return this;
        }

        public Builder imageViews(ImageView... imageViewArr) {
            this.imageViews = imageViewArr;
            return this;
        }

        public Builder isCenterCrop(boolean z2) {
            this.isCenterCrop = z2;
            return this;
        }

        public Builder isCircle(boolean z2) {
            this.isCircle = z2;
            return this;
        }

        public Builder isClearDiskCache(boolean z2) {
            this.isClearDiskCache = z2;
            return this;
        }

        public Builder isClearMemory(boolean z2) {
            this.isClearMemory = z2;
            return this;
        }

        public Builder isCrossFade(boolean z2) {
            this.isCrossFade = z2;
            return this;
        }

        public Builder isNeedPlaceholder(boolean z2) {
            this.isNeedPlaceholder = z2;
            return this;
        }

        public Builder listener(g<Drawable> gVar) {
            this.listener = gVar;
            return this;
        }

        public Builder placeholder(int i2) {
            this.placeholder = i2;
            return this;
        }

        public Builder placeholderDrawable(Drawable drawable) {
            this.placeholderDrawable = drawable;
            return this;
        }

        public Builder requestOptions(h hVar) {
            this.requestOptions = hVar;
            return this;
        }

        public Builder resId(int i2) {
            this.resId = i2;
            return this;
        }

        public Builder signature(String str) {
            this.signature = str;
            return this;
        }

        @Deprecated
        public Builder transformation(f fVar) {
            this.transformation = fVar;
            return this;
        }

        public Builder uri(Uri uri) {
            this.uri = uri;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        private Builder() {
            this.isNeedPlaceholder = true;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getBlurValue() {
        return this.blurValue;
    }

    public int getCacheStrategy() {
        return this.cacheStrategy;
    }

    public int getFallback() {
        return this.fallback;
    }

    public int getImageRadius() {
        return this.imageRadius;
    }

    public ImageView[] getImageViews() {
        return this.imageViews;
    }

    public f getTransformation() {
        return this.transformation;
    }

    public boolean isBlurImage() {
        return this.blurValue > 0;
    }

    public boolean isCenterCrop() {
        return this.isCenterCrop;
    }

    public boolean isCircle() {
        return this.isCircle;
    }

    public boolean isClearDiskCache() {
        return this.isClearDiskCache;
    }

    public boolean isClearMemory() {
        return this.isClearMemory;
    }

    public boolean isCrossFade() {
        return this.isCrossFade;
    }

    public boolean isImageRadius() {
        return this.imageRadius > 0;
    }

    public boolean isNeedPlaceholder() {
        return this.isNeedPlaceholder;
    }

    private ImageConfigImpl(Builder builder) {
        this.url = builder.url;
        this.glideBean = builder.glideBean;
        this.requestOptions = builder.requestOptions;
        this.signature = builder.signature;
        this.uri = builder.uri;
        this.bytes = builder.bytes;
        this.form = builder.form;
        this.listener = builder.listener;
        this.resId = builder.resId;
        this.drawable = builder.drawable;
        this.imageView = builder.imageView;
        this.placeholder = builder.placeholder;
        this.placeholderDrawable = builder.placeholderDrawable;
        this.errorPic = builder.errorPic;
        this.fallback = builder.fallback;
        this.cacheStrategy = builder.cacheStrategy;
        this.imageRadius = builder.imageRadius;
        this.blurValue = builder.blurValue;
        this.transformation = builder.transformation;
        this.imageViews = builder.imageViews;
        this.isCrossFade = builder.isCrossFade;
        this.isCenterCrop = builder.isCenterCrop;
        this.isNeedPlaceholder = builder.isNeedPlaceholder;
        this.isCircle = builder.isCircle;
        this.isClearMemory = builder.isClearMemory;
        this.isClearDiskCache = builder.isClearDiskCache;
    }
}
