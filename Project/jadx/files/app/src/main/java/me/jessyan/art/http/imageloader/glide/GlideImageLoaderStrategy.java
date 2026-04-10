package me.jessyan.art.http.imageloader.glide;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.j;
import com.bumptech.glide.load.i;
import com.bumptech.glide.request.h;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.art.R$drawable;
import me.jessyan.art.entity.GlideBean;
import me.jessyan.art.f.g;
import me.jessyan.art.http.imageloader.glide.transform.BlurTransformation;
import me.jessyan.art.http.imageloader.glide.transform.RoundedCornersTransformation;

/* JADX INFO: loaded from: classes3.dex */
public class GlideImageLoaderStrategy implements me.jessyan.art.c.e.a<ImageConfigImpl>, GlideAppliesOptions {
    @Override // me.jessyan.art.http.imageloader.glide.GlideAppliesOptions
    public void applyGlideOptions(@NonNull Context context, @NonNull com.bumptech.glide.d dVar) {
        y0.a.a.b("applyGlideOptions", new Object[0]);
    }

    public void clear(@Nullable final Context context, @Nullable ImageConfigImpl imageConfigImpl) {
        g.a(context, "Context is required");
        g.a(imageConfigImpl, "ImageConfigImpl is required");
        if (imageConfigImpl.getImageView() != null) {
            GlideArt.get(context).h().a(context).clear(imageConfigImpl.getImageView());
        }
        if (imageConfigImpl.getImageViews() != null && imageConfigImpl.getImageViews().length > 0) {
            for (ImageView imageView : imageConfigImpl.getImageViews()) {
                GlideArt.get(context).h().a(context).clear(imageView);
            }
        }
        if (imageConfigImpl.isClearDiskCache()) {
            Completable.fromAction(new Action() { // from class: me.jessyan.art.http.imageloader.glide.GlideImageLoaderStrategy.1
                @Override // io.reactivex.functions.Action
                public void run() throws Exception {
                    com.bumptech.glide.c.a(context).a();
                }
            }).subscribeOn(Schedulers.io()).subscribe();
        }
        if (imageConfigImpl.isClearMemory()) {
            Completable.fromAction(new Action() { // from class: me.jessyan.art.http.imageloader.glide.GlideImageLoaderStrategy.2
                @Override // io.reactivex.functions.Action
                public void run() throws Exception {
                    com.bumptech.glide.c.a(context).b();
                }
            }).subscribeOn(AndroidSchedulers.mainThread()).subscribe();
        }
    }

    @Override // me.jessyan.art.c.e.a
    public void loadImage(@Nullable Context context, @Nullable ImageConfigImpl imageConfigImpl) {
        GlideRequest<Drawable> glideRequestMo56load;
        g.a(context, "Context is required");
        g.a(imageConfigImpl, "ImageConfigImpl is required");
        ImageView imageView = imageConfigImpl.getImageView();
        g.a(imageView, "ImageView is required");
        if ((context instanceof Activity) && ((Activity) context).isDestroyed()) {
            return;
        }
        GlideRequests glideRequestsWith = GlideArt.with(context);
        String url = imageConfigImpl.getUrl();
        if (!TextUtils.isEmpty(url)) {
            GlideBean glideBean = imageConfigImpl.getGlideBean();
            glideRequestMo56load = glideBean != null ? glideRequestsWith.mo57load((Object) new BeanGlideUrl(url, glideBean)) : glideRequestsWith.mo57load((Object) new CommonGlideUrl(url));
        } else if (imageConfigImpl.getUri() != null) {
            glideRequestMo56load = glideRequestsWith.mo54load(imageConfigImpl.getUri());
        } else if (imageConfigImpl.getBytes() != null) {
            glideRequestMo56load = glideRequestsWith.mo60load(imageConfigImpl.getBytes());
        } else if (imageConfigImpl.getDrawable() != null) {
            glideRequestMo56load = glideRequestsWith.mo53load(imageConfigImpl.getDrawable());
        } else {
            int resId = imageConfigImpl.getResId();
            if (resId == 0) {
                resId = R$drawable.icon_pic_def;
            }
            glideRequestMo56load = glideRequestsWith.mo56load(Integer.valueOf(resId));
        }
        h requestOptions = imageConfigImpl.getRequestOptions();
        if (requestOptions != null) {
            glideRequestMo56load.apply((com.bumptech.glide.request.a<?>) requestOptions);
        }
        int cacheStrategy = imageConfigImpl.getCacheStrategy();
        if (cacheStrategy == 0) {
            glideRequestMo56load.diskCacheStrategy(com.bumptech.glide.load.engine.h.a);
        } else if (cacheStrategy == 1) {
            glideRequestMo56load.diskCacheStrategy(com.bumptech.glide.load.engine.h.b);
        } else if (cacheStrategy == 2) {
            glideRequestMo56load.diskCacheStrategy(com.bumptech.glide.load.engine.h.f13535d);
        } else if (cacheStrategy == 3) {
            glideRequestMo56load.diskCacheStrategy(com.bumptech.glide.load.engine.h.f13534c);
        } else if (cacheStrategy != 4) {
            glideRequestMo56load.diskCacheStrategy(com.bumptech.glide.load.engine.h.a);
        } else {
            glideRequestMo56load.diskCacheStrategy(com.bumptech.glide.load.engine.h.f13536e);
        }
        if (imageConfigImpl.isCrossFade()) {
            glideRequestMo56load.transition((j<?, ? super Drawable>) com.bumptech.glide.load.k.e.d.c());
        }
        if (imageConfigImpl.isCenterCrop()) {
            glideRequestMo56load.centerCrop();
        }
        if (imageConfigImpl.isCircle()) {
            glideRequestMo56load.circleCrop();
        }
        if (imageConfigImpl.isImageRadius()) {
            glideRequestMo56load.transform((i<Bitmap>) new RoundedCornersTransformation(imageConfigImpl.getImageRadius(), 0));
        }
        if (imageConfigImpl.isBlurImage()) {
            glideRequestMo56load.transform((i<Bitmap>) new BlurTransformation(imageConfigImpl.getBlurValue()));
        }
        if (imageConfigImpl.getTransformation() != null) {
            glideRequestMo56load.transform((i<Bitmap>) imageConfigImpl.getTransformation());
        }
        if (imageConfigImpl.getPlaceholder() != 0) {
            glideRequestMo56load.placeholder(imageConfigImpl.getPlaceholder());
        } else if (imageConfigImpl.getPlaceholderDrawable() != null) {
            glideRequestMo56load.placeholder(imageConfigImpl.getPlaceholderDrawable());
        } else if (imageConfigImpl.isNeedPlaceholder()) {
            glideRequestMo56load.placeholder(R$drawable.icon_pic_def);
        }
        if (imageConfigImpl.getErrorPic() != 0) {
            glideRequestMo56load.error(imageConfigImpl.getErrorPic());
        } else {
            glideRequestMo56load.error(R$drawable.icon_pic_def);
        }
        if (imageConfigImpl.getFallback() != 0) {
            glideRequestMo56load.fallback(imageConfigImpl.getFallback());
        } else {
            glideRequestMo56load.fallback(R$drawable.icon_pic_def);
        }
        if (imageConfigImpl.getListener() != null) {
            glideRequestMo56load.listener(imageConfigImpl.getListener());
        }
        glideRequestMo56load.into(imageView);
    }
}
