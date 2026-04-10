package com.duokan.core.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.os.Process;
import android.view.View;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.duokan.core.utils.BitmapsRecycler;
import com.yuewen.b80;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes12.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedList<BitmapsRecycler> f3031a = new LinkedList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ boolean f3032b = false;

    /* JADX INFO: renamed from: com.duokan.core.utils.a$a, reason: collision with other inner class name */
    public class C0211a implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitmapFactory.Options f3033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ byte[] f3034b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        public C0211a(BitmapFactory.Options options, byte[] bArr, int i, int i2) {
            this.f3033a = options;
            this.f3034b = bArr;
            this.c = i;
            this.d = i2;
        }

        @Override // com.duokan.core.utils.a.l
        @TargetApi(11)
        public Bitmap create() {
            BitmapFactory.Options options = this.f3033a;
            if (options != null && options.inBitmap != null) {
                return BitmapFactory.decodeByteArray(this.f3034b, this.c, this.d, options);
            }
            if (options != null) {
                options.inBitmap = null;
            }
            return BitmapFactory.decodeByteArray(this.f3034b, this.c, this.d, options);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3035a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f3035a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3035a[Bitmap.Config.ARGB_4444.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3035a[Bitmap.Config.RGB_565.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3035a[Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public class c implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f3036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f3037b;
        public final /* synthetic */ Bitmap.Config c;

        public c(int i, int i2, Bitmap.Config config) {
            this.f3036a = i;
            this.f3037b = i2;
            this.c = config;
        }

        @Override // com.duokan.core.utils.a.l
        public Bitmap create() {
            return Bitmap.createBitmap(Math.max(this.f3036a, 1), Math.max(this.f3037b, 1), this.c);
        }
    }

    public class d implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int[] f3038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f3039b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Bitmap.Config d;

        public d(int[] iArr, int i, int i2, Bitmap.Config config) {
            this.f3038a = iArr;
            this.f3039b = i;
            this.c = i2;
            this.d = config;
        }

        @Override // com.duokan.core.utils.a.l
        public Bitmap create() {
            return Bitmap.createBitmap(this.f3038a, Math.max(this.f3039b, 1), Math.max(this.c, 1), this.d);
        }
    }

    public class e implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f3040a;

        public e(Bitmap bitmap) {
            this.f3040a = bitmap;
        }

        @Override // com.duokan.core.utils.a.l
        public Bitmap create() {
            return Bitmap.createBitmap(this.f3040a);
        }
    }

    public class f implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f3041a;

        public f(Bitmap bitmap) {
            this.f3041a = bitmap;
        }

        @Override // com.duokan.core.utils.a.l
        public Bitmap create() {
            Bitmap bitmap = this.f3041a;
            return bitmap.copy(bitmap.getConfig(), true);
        }
    }

    public class g implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputStream f3042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BitmapFactory.Options f3043b;

        public g(InputStream inputStream, BitmapFactory.Options options) {
            this.f3042a = inputStream;
            this.f3043b = options;
        }

        @Override // com.duokan.core.utils.a.l
        public Bitmap create() {
            return BitmapFactory.decodeStream(this.f3042a, null, this.f3043b);
        }
    }

    public class h implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f3044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f3045b;
        public final /* synthetic */ BitmapFactory.Options c;

        public h(Context context, int i, BitmapFactory.Options options) {
            this.f3044a = context;
            this.f3045b = i;
            this.c = options;
        }

        @Override // com.duokan.core.utils.a.l
        public Bitmap create() {
            return BitmapFactory.decodeResource(this.f3044a.getResources(), this.f3045b, this.c);
        }
    }

    public class i implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f3046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f3047b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        public i(Context context, String str, int i, int i2) {
            this.f3046a = context;
            this.f3047b = str;
            this.c = i;
            this.d = i2;
        }

        @Override // com.duokan.core.utils.a.l
        public Bitmap create() {
            return a.z(this.f3046a, this.f3047b, this.c, this.d);
        }
    }

    public class j implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitmapFactory.Options f3048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FileDescriptor f3049b;
        public final /* synthetic */ Rect c;

        public j(BitmapFactory.Options options, FileDescriptor fileDescriptor, Rect rect) {
            this.f3048a = options;
            this.f3049b = fileDescriptor;
            this.c = rect;
        }

        @Override // com.duokan.core.utils.a.l
        @SuppressLint({"NewApi"})
        public Bitmap create() {
            BitmapFactory.Options options = this.f3048a;
            if (options.inBitmap != null) {
                return BitmapFactory.decodeFileDescriptor(this.f3049b, this.c, options);
            }
            options.inBitmap = null;
            return BitmapFactory.decodeFileDescriptor(this.f3049b, this.c, options);
        }
    }

    public class k implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f3050a;

        public k(String str) {
            this.f3050a = str;
        }

        @Override // com.duokan.core.utils.a.l
        public Bitmap create() {
            return BitmapFactory.decodeFile(this.f3050a);
        }
    }

    public interface l {
        Bitmap create();
    }

    public static int A(Bitmap.Config config) {
        int i2 = b.f3035a[config.ordinal()];
        if (i2 != 1) {
            return (i2 == 2 || i2 == 3) ? 2 : 4;
        }
        return 1;
    }

    public static void B(BitmapsRecycler.RecycleReason recycleReason) {
        LinkedList linkedList;
        LinkedList<BitmapsRecycler> linkedList2 = f3031a;
        synchronized (linkedList2) {
            linkedList = new LinkedList(linkedList2);
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((BitmapsRecycler) it.next()).a(recycleReason);
        }
        System.gc();
    }

    public static void C(BitmapsRecycler bitmapsRecycler) {
        LinkedList<BitmapsRecycler> linkedList = f3031a;
        synchronized (linkedList) {
            if (!linkedList.contains(bitmapsRecycler)) {
                linkedList.add(bitmapsRecycler);
            }
        }
    }

    public static Bitmap D(int i2, int i3, Bitmap.Config config) {
        return I(i2, i3, config);
    }

    public static Bitmap E(Bitmap bitmap, int i2, int i3) {
        return J(bitmap, i2, i3);
    }

    public static int F(int i2, int i3, Bitmap.Config config) {
        return i2 * i3 * A(config);
    }

    public static int G(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth() * bitmap.getHeight() * A(bitmap.getConfig());
    }

    public static Bitmap H(Bitmap bitmap, float f2, float f3) {
        return ThumbnailUtils.extractThumbnail(bitmap, (int) f2, (int) f3);
    }

    public static Bitmap I(int i2, int i3, Bitmap.Config config) {
        Bitmap bitmapCreateBitmap;
        int iMax = Math.max(1, i2);
        int iMax2 = Math.max(1, i3);
        for (int i4 = 0; i4 < 2; i4++) {
            try {
                bitmapCreateBitmap = Bitmap.createBitmap(iMax, iMax2, config);
            } catch (OutOfMemoryError unused) {
                System.gc();
                b80.e(200L);
            } catch (Throwable unused2) {
                return null;
            }
            if (bitmapCreateBitmap != null) {
                return bitmapCreateBitmap;
            }
        }
        return null;
    }

    public static Bitmap J(Bitmap bitmap, int i2, int i3) {
        Bitmap bitmapCreateScaledBitmap;
        int iMax = Math.max(1, i2);
        int iMax2 = Math.max(1, i3);
        for (int i4 = 0; i4 < 2; i4++) {
            try {
                bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, iMax, iMax2, false);
            } catch (OutOfMemoryError unused) {
                System.gc();
                b80.e(200L);
            } catch (Throwable unused2) {
                return bitmap;
            }
            if (bitmapCreateScaledBitmap != null) {
                return bitmapCreateScaledBitmap;
            }
        }
        return bitmap;
    }

    public static void K(BitmapsRecycler bitmapsRecycler) {
        LinkedList<BitmapsRecycler> linkedList = f3031a;
        synchronized (linkedList) {
            linkedList.remove(bitmapsRecycler);
        }
    }

    public static Bitmap b(Bitmap bitmap) {
        return e(null, new e(bitmap), null);
    }

    public static void c(Bitmap bitmap, Bitmap bitmap2) {
        new Canvas(bitmap2).drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight()), new Paint());
    }

    public static Bitmap d(int i2, int i3, Bitmap.Config config) {
        return e(null, new c(i2, i3, config), null);
    }

    public static Bitmap e(Context context, l lVar, BitmapFactory.Options options) {
        try {
            Bitmap bitmapCreate = lVar.create();
            if ((options != null && options.inJustDecodeBounds) || bitmapCreate != null || context == null) {
                return bitmapCreate;
            }
            if (t(context) / w(context) > 0.9f) {
                B(BitmapsRecycler.RecycleReason.OutOfMemory);
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException unused) {
                }
            }
            return lVar.create();
        } catch (OutOfMemoryError unused2) {
            B(BitmapsRecycler.RecycleReason.OutOfMemory);
            try {
                Thread.sleep(200L);
            } catch (InterruptedException unused3) {
            }
            return lVar.create();
        }
    }

    public static Bitmap f(int[] iArr, int i2, int i3, Bitmap.Config config) {
        return e(null, new d(iArr, i2, i3, config), null);
    }

    public static Bitmap g(Bitmap bitmap) {
        return e(null, new f(bitmap), null);
    }

    public static Bitmap h(Context context, byte[] bArr, int i2, int i3) {
        return i(context, bArr, i2, i3, null);
    }

    public static Bitmap i(Context context, byte[] bArr, int i2, int i3, BitmapFactory.Options options) {
        return e(context, new C0211a(options, bArr, i2, i3), options);
    }

    public static Bitmap j(Context context, String str) {
        return e(context, new k(str), null);
    }

    public static Bitmap k(Context context, String str, int i2, int i3) {
        return e(context, new i(context, str, i2, i3), null);
    }

    public static Bitmap l(Context context, String str, BitmapFactory.Options options) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (IOException unused) {
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            Bitmap bitmapM = m(context, fileInputStream.getFD(), null, options);
            try {
                fileInputStream.close();
            } catch (IOException unused2) {
            }
            return bitmapM;
        } catch (IOException unused3) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    public static Bitmap m(Context context, FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        return e(context, new j(options, fileDescriptor, rect), options);
    }

    public static Bitmap n(Context context, int i2) {
        return o(context, i2, null);
    }

    public static Bitmap o(Context context, int i2, BitmapFactory.Options options) {
        return e(context, new h(context, i2, options), options);
    }

    public static Bitmap p(Context context, InputStream inputStream) {
        return q(context, inputStream, null);
    }

    public static Bitmap q(Context context, InputStream inputStream, BitmapFactory.Options options) {
        return e(context, new g(inputStream, options), options);
    }

    public static Bitmap r(InputStream inputStream, BitmapFactory.Options options) {
        return q(null, inputStream, options);
    }

    public static Bitmap s(View view) {
        view.clearFocus();
        view.setPressed(false);
        Bitmap bitmapD = D(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmapD));
        return bitmapD;
    }

    public static long t(Context context) {
        return ((long) ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getProcessMemoryInfo(new int[]{Process.myPid()})[0].dalvikPss) * 1024;
    }

    @TargetApi(14)
    public static int u(Canvas canvas) {
        return canvas.getMaximumBitmapHeight();
    }

    @TargetApi(14)
    public static int v(Canvas canvas) {
        return canvas.getMaximumBitmapWidth();
    }

    @TargetApi(11)
    public static long w(Context context) {
        return ((long) ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getLargeMemoryClass()) * 1048576;
    }

    public static Bitmap x(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str, new HashMap());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                try {
                    mediaMetadataRetriever.release();
                    return frameAtTime;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return frameAtTime;
                }
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return null;
            }
        } finally {
            try {
                mediaMetadataRetriever.release();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static Bitmap y(Context context, InputStream inputStream, int i2) {
        if (inputStream == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        options.inJustDecodeBounds = false;
        options.inSampleSize = i2;
        return q(context, inputStream, options);
    }

    public static Bitmap z(Context context, String str, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i4 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i5 = options.outWidth;
        int i6 = options.outHeight;
        while (true) {
            if (i5 <= i2 && i6 <= i3) {
                options.inSampleSize = i4;
                options.inJustDecodeBounds = false;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                return BitmapFactory.decodeFile(str, options);
            }
            i4++;
            i5 = options.outWidth / i4;
            i6 = options.outHeight / i4;
        }
    }
}
