package com.funny.audio.view;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.funny.audio.R;
import com.funny.audio.api.AddressSetting;
import com.funny.audio.view.core.BlurTransformation;
import com.umeng.analytics.pro.d;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ImageUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J \u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/funny/audio/view/ImageUtils;", "", "()V", "defaultErrorPlaceholder", "", "defaultPlaceholder", "convertPath", "", "path", "loadBlurImage", "", d.R, "Landroid/content/Context;", "imageView", "Landroid/widget/ImageView;", "loadToView", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ImageUtils {
    public static final ImageUtils INSTANCE = new ImageUtils();
    private static final int defaultPlaceholder = R.mipmap.default_cover;
    private static final int defaultErrorPlaceholder = R.mipmap.default_cover;

    private ImageUtils() {
    }

    private final String convertPath(String path) {
        if (StringsKt.startsWith$default(path, "http", false, 2, (Object) null)) {
            return path;
        }
        String string = new URI(AddressSetting.INSTANCE.getCurrent().getStaticResource().getValue()).resolve(path).toString();
        Intrinsics.checkNotNullExpressionValue(string, "{\n            val baseUr…ath).toString()\n        }");
        return string;
    }

    public final void loadToView(Context context, ImageView imageView, String path) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        String str = path;
        if (str == null || str.length() == 0) {
            Glide.with(context).load(Integer.valueOf(defaultPlaceholder)).into(imageView);
        } else {
            Glide.with(context).load(convertPath(path)).placeholder(defaultPlaceholder).error(defaultErrorPlaceholder).into(imageView);
        }
    }

    public final void loadBlurImage(Context context, ImageView imageView, String path) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        String str = path;
        if (str == null || str.length() == 0) {
            Glide.with(context).load(Integer.valueOf(defaultPlaceholder)).apply((BaseRequestOptions<?>) RequestOptions.bitmapTransform(new BlurTransformation(10, 8))).into(imageView);
        } else {
            Glide.with(context).load(convertPath(path)).placeholder(defaultPlaceholder).error(defaultErrorPlaceholder).apply((BaseRequestOptions<?>) RequestOptions.bitmapTransform(new BlurTransformation(10, 8))).into(imageView);
        }
    }
}
