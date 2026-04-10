package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class tb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f794a;
    private static Resources dl;
    private static String g;
    private static boolean gc;
    private static boolean m;
    private static Context z;

    private static String dl(Context context) {
        if (f794a == null) {
            f794a = context.getPackageName();
        }
        return f794a;
    }

    private static int z(Context context, String str, String str2) {
        int identifier = z(context).getIdentifier(str, str2, dl(context));
        if (identifier != 0) {
            return identifier;
        }
        if (!gc) {
            g(context);
            return z(context).getIdentifier(str, str2, dl(context));
        }
        return context.getResources().getIdentifier(str, str2, dl(context));
    }

    public static String z(Context context, String str) {
        return z(context).getString(g(context, str));
    }

    public static int g(Context context, String str) {
        return z(context, str, TypedValues.Custom.S_STRING);
    }

    public static void z(Context context, String str, ImageView imageView) {
        Drawable drawable = z(context).getDrawable(gc(context, str));
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public static void z(Context context, String str, View view) {
        Drawable drawable = z(context).getDrawable(gc(context, str));
        if (view != null) {
            view.setBackground(drawable);
        }
    }

    public static Drawable dl(Context context, String str) {
        try {
            return z(context).getDrawable(gc(context, str));
        } catch (Exception e) {
            wp.z(e);
            return null;
        }
    }

    public static Bitmap a(Context context, String str) {
        return BitmapFactory.decodeResource(z(context), gc(context, str));
    }

    public static int gc(Context context, String str) {
        try {
            return z(context, str, "drawable");
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int m(Context context, String str) {
        return z(context, str, "id");
    }

    public static int e(Context context, String str) {
        return z(context, str, TtmlNode.TAG_LAYOUT);
    }

    public static int gz(Context context, String str) {
        return z(context, str, TtmlNode.TAG_STYLE);
    }

    public static int fo(Context context, String str) {
        return z(context, str, "dimen");
    }

    public static int uy(Context context, String str) {
        return z(context).getColor(kb(context, str));
    }

    public static int kb(Context context, String str) {
        return z(context, str, "color");
    }

    public static int wp(Context context, String str) {
        return z(context, str, "anim");
    }

    public static Resources z(Context context) {
        Resources resources = dl;
        if (resources == null) {
            resources = null;
        }
        Context context2 = z;
        if (context2 != null) {
            resources = context2.getResources();
        }
        return resources == null ? context.getResources() : resources;
    }

    public static synchronized void g(Context context) {
        try {
            if (TextUtils.isEmpty(g)) {
                return;
            }
            Resources resources = context.getResources();
            dl = new Resources(g(resources.getAssets(), g + "/apk/base-1.apk"), resources.getDisplayMetrics(), resources.getConfiguration());
            f794a = context.getPackageName();
            gc = true;
        } catch (Throwable th) {
            wp.dl("ResourceHelp", "makePluginResources failed", th);
        }
    }

    private static AssetManager g(AssetManager assetManager, String str) {
        AssetManager assetManager2;
        try {
            if (assetManager.getClass().getName().equals("android.content.res.BaiduAssetManager")) {
                assetManager2 = (AssetManager) Class.forName("android.content.res.BaiduAssetManager").getConstructor(new Class[0]).newInstance(new Object[0]);
            } else {
                assetManager2 = (AssetManager) AssetManager.class.newInstance();
            }
            z(assetManager2, str);
            assetManager = assetManager2;
        } catch (Exception unused) {
            z(assetManager, str);
        }
        try {
            h.z(assetManager, "ensureStringBlocks", new Object[0]);
        } catch (Exception unused2) {
        }
        return assetManager;
    }

    public static boolean z(AssetManager assetManager, String str) {
        Method methodZ = h.z((Class<?>) AssetManager.class, "addAssetPath", (Class<?>[]) new Class[]{String.class});
        if (methodZ == null) {
            methodZ = h.z((Class<?>) AssetManager.class, "addAssetPath", (Class<?>[]) new Class[]{String.class});
        }
        if (methodZ != null) {
            int i = 3;
            while (true) {
                int i2 = i - 1;
                if (i < 0) {
                    break;
                }
                if (((Integer) methodZ.invoke(assetManager, str)).intValue() != 0) {
                    return true;
                }
                i = i2;
            }
        }
        return false;
    }
}
