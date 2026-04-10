package com.bytedance.sdk.openadsdk.core.ugeno;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.dl.v;
import com.bytedance.adsdk.ugeno.z;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.m.io;
import com.bytedance.sdk.component.m.ls;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.yz;
import com.bytedance.sdk.openadsdk.core.un.fv;
import com.bytedance.sdk.openadsdk.core.zw;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a implements com.bytedance.adsdk.ugeno.z {

    public interface z {
        void z(Drawable drawable);
    }

    @Override // com.bytedance.adsdk.ugeno.z
    public void z(v vVar, String str, ImageView imageView, z.InterfaceC0053z interfaceC0053z) {
        if (imageView instanceof GifView) {
            final GifView gifView = (GifView) imageView;
            gifView.setAdjustViewBounds(true);
            gifView.setBackgroundColor(0);
            com.bytedance.sdk.openadsdk.gz.g.z(str).type(3).config(Bitmap.Config.RGB_565).to(new io() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.a.1
                @Override // com.bytedance.sdk.component.m.io
                public void onFailed(int i, String str2, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.m.io
                public void onSuccess(ls lsVar) {
                    try {
                        Object result = lsVar.getResult();
                        if (result instanceof byte[]) {
                            if (lsVar.isGif()) {
                                gifView.z((byte[]) result, false);
                                gifView.setRepeatConfig(true);
                                gifView.g();
                                return;
                            } else {
                                gifView.setImageDrawable(fv.z((byte[]) result, 0));
                                return;
                            }
                        }
                        if (result instanceof Bitmap) {
                            gifView.setImageBitmap((Bitmap) result);
                        }
                    } catch (Throwable th) {
                        onFailed(1002, "", th);
                    }
                }
            });
            return;
        }
        com.bytedance.sdk.component.m.v vVarZ = com.bytedance.sdk.openadsdk.gz.g.z(str);
        z(vVar, vVarZ, str);
        vVarZ.to(imageView);
    }

    @Override // com.bytedance.adsdk.ugeno.z
    public void z(v vVar, String str, final ImageView imageView, int i, int i2, z.InterfaceC0053z interfaceC0053z) {
        com.bytedance.sdk.component.m.v vVarType = com.bytedance.sdk.openadsdk.gz.g.z(str).type(3);
        z(vVar, vVarType, str);
        vVarType.to(new io() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.a.2
            @Override // com.bytedance.sdk.component.m.io
            public void onFailed(int i3, String str2, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.m.io
            public void onSuccess(final ls lsVar) {
                if (imageView.isAttachedToWindow()) {
                    a.this.z(lsVar, imageView);
                } else {
                    imageView.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.z(lsVar, imageView);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(ls lsVar, ImageView imageView) {
        Object result = lsVar.getResult();
        if (result instanceof byte[]) {
            if (!lsVar.isGif()) {
                byte[] bArr = (byte[]) result;
                if (!g(bArr)) {
                    if (z(bArr)) {
                        com.bytedance.sdk.component.adexpress.a.m.z(imageView, bArr, imageView.getWidth(), imageView.getHeight());
                        return;
                    }
                    int iZ = yz.z(imageView.getWidth(), imageView.getHeight());
                    Bitmap bitmapZ = new com.bytedance.sdk.component.m.dl.g.z(imageView.getWidth(), imageView.getHeight(), imageView.getScaleType(), Bitmap.Config.RGB_565, imageView.getWidth() / iZ, imageView.getHeight() / iZ).z(bArr);
                    if (bitmapZ != null) {
                        imageView.setImageBitmap(bitmapZ);
                        return;
                    }
                    return;
                }
            }
            if (Build.VERSION.SDK_INT <= 30) {
                z((byte[]) result, imageView);
                return;
            } else {
                com.bytedance.sdk.component.adexpress.a.m.z(imageView, (byte[]) result, imageView.getWidth(), imageView.getHeight());
                return;
            }
        }
        if (result instanceof Bitmap) {
            imageView.setImageBitmap((Bitmap) result);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.z
    public void z(v vVar, String str, z.InterfaceC0053z interfaceC0053z) {
        g(vVar, str, interfaceC0053z);
    }

    private void z(v vVar, com.bytedance.sdk.component.m.v vVar2, String str) {
        Map<String, Object> mapG;
        if (vVar == null || (mapG = vVar.g()) == null) {
            return;
        }
        Object obj = mapG.get("image_info");
        if (obj instanceof Map) {
            vVar2.key((String) ((Map) obj).get(str));
        }
        String str2 = (String) mapG.get("cache_dir");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        vVar2.cacheDir(str2);
    }

    public void g(v vVar, String str, final z.InterfaceC0053z interfaceC0053z) {
        com.bytedance.sdk.component.m.v vVarType = com.bytedance.sdk.openadsdk.gz.g.z(str).type(1);
        z(vVar, vVarType, str);
        vVarType.to(new io() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.a.3
            @Override // com.bytedance.sdk.component.m.io
            public void onSuccess(ls lsVar) {
                if (lsVar == null) {
                    interfaceC0053z.z(null);
                    return;
                }
                z.InterfaceC0053z interfaceC0053z2 = interfaceC0053z;
                if (interfaceC0053z2 != null) {
                    if (lsVar.getResult() instanceof Bitmap) {
                        interfaceC0053z.z((Bitmap) lsVar.getResult());
                        return;
                    } else {
                        if (lsVar.getResult() instanceof byte[]) {
                            try {
                                interfaceC0053z.z(BitmapFactory.decodeByteArray((byte[]) lsVar.getResult(), 0, ((byte[]) lsVar.getResult()).length));
                                return;
                            } catch (Throwable unused) {
                                return;
                            }
                        }
                        return;
                    }
                }
                interfaceC0053z2.z(null);
            }

            @Override // com.bytedance.sdk.component.m.io
            public void onFailed(int i, String str2, Throwable th) {
                z.InterfaceC0053z interfaceC0053z2 = interfaceC0053z;
                if (interfaceC0053z2 != null) {
                    interfaceC0053z2.z(null);
                }
            }
        });
    }

    private void z(byte[] bArr, final ImageView imageView) {
        try {
            wp.a("ImageLoaderProvider", "load animation image");
            z(bArr, new z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.a.4
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.a.z
                public void z(final Drawable drawable) {
                    com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.a.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Build.VERSION.SDK_INT >= 28) {
                                Drawable drawable2 = drawable;
                                if (drawable2 instanceof AnimatedImageDrawable) {
                                    ((AnimatedImageDrawable) drawable2).start();
                                }
                            }
                            imageView.setImageDrawable(drawable);
                        }
                    });
                }
            });
        } catch (Exception e) {
            wp.z(e);
        }
    }

    private void z(final byte[] bArr, final z zVar) {
        com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("csj_animation_drawable") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.a.5
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawableDl = a.this.dl(bArr);
                z zVar2 = zVar;
                if (zVar2 != null) {
                    zVar2.z(drawableDl);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable dl(byte[] bArr) {
        FileOutputStream fileOutputStream;
        File fileG;
        try {
            boolean zDl = com.bytedance.sdk.openadsdk.core.multipro.g.dl();
            fileG = com.bytedance.sdk.component.utils.m.g(zw.getContext(), zDl, zDl ? "UGEN_GIF_AD_CACHE/" : "/UGEN_GIF_CACHE/", "TT_UGEN_GIF_FILE");
            fileOutputStream = new FileOutputStream(fileG);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(bArr, 0, bArr.length);
            if (Build.VERSION.SDK_INT >= 28) {
                Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(fileG));
                try {
                    fileOutputStream.close();
                } catch (Throwable unused) {
                }
                return drawableDecodeDrawable;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(zw.getContext().getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
            try {
                fileOutputStream.close();
            } catch (Throwable unused2) {
            }
            return bitmapDrawable;
        } catch (Throwable th2) {
            th = th2;
            try {
                wp.dl("ImageLoaderProvider", "GifView  getSourceByFile fail : ", th);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused3) {
                    }
                }
                return null;
            } catch (Throwable th3) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused4) {
                    }
                }
                throw th3;
            }
        }
    }

    public boolean z(byte[] bArr) {
        return com.bytedance.sdk.component.adexpress.a.m.z(bArr, 0);
    }

    public boolean g(byte[] bArr) {
        return TextUtils.equals("png", com.bytedance.sdk.component.utils.fo.z(Arrays.copyOfRange(bArr, 0, com.bytedance.sdk.component.utils.fo.z()))) && com.bytedance.sdk.component.adexpress.a.m.z(bArr);
    }
}
