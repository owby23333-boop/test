package com.lxj.xpopup.util;

import android.R;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.FloatRange;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.lxj.xpopup.R$string;
import com.lxj.xpopup.c.i;
import com.lxj.xpopup.core.AttachPopupView;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.core.BubbleAttachPopupView;
import com.lxj.xpopup.core.PositionPopupView;
import com.lxj.xpopup.impl.FullScreenPopupView;
import com.ss.android.downloadlib.constants.EventConstants;
import com.umeng.analytics.pro.cb;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: XPopupUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static int a;
    private static int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f17580c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char[] f17581d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: compiled from: XPopupUtils.java */
    static class a implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ ViewGroup f17582s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ int f17583t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final /* synthetic */ int f17584u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        final /* synthetic */ int f17585v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        final /* synthetic */ int f17586w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ Runnable f17587x;

        /* JADX INFO: renamed from: com.lxj.xpopup.util.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: XPopupUtils.java */
        class RunnableC0497a implements Runnable {
            RunnableC0497a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Runnable runnable = a.this.f17587x;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }

        a(ViewGroup viewGroup, int i2, int i3, int i4, int i5, Runnable runnable) {
            this.f17582s = viewGroup;
            this.f17583t = i2;
            this.f17584u = i3;
            this.f17585v = i4;
            this.f17586w = i5;
            this.f17587x = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup.LayoutParams layoutParams = this.f17582s.getLayoutParams();
            View childAt = this.f17582s.getChildAt(0);
            ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
            int measuredWidth = this.f17582s.getMeasuredWidth();
            int i2 = this.f17583t;
            if (i2 > 0) {
                layoutParams.width = Math.min(measuredWidth, i2);
                int i3 = this.f17584u;
                if (i3 > 0) {
                    layoutParams.width = Math.min(i3, this.f17583t);
                    layoutParams2.width = Math.min(this.f17584u, this.f17583t);
                }
            } else {
                int i4 = this.f17584u;
                if (i4 > 0) {
                    layoutParams.width = i4;
                    layoutParams2.width = i4;
                }
            }
            int measuredHeight = this.f17582s.getMeasuredHeight();
            int i5 = this.f17585v;
            if (i5 > 0) {
                layoutParams.height = Math.min(measuredHeight, i5);
                int i6 = this.f17586w;
                if (i6 > 0) {
                    layoutParams.height = Math.min(i6, this.f17585v);
                    layoutParams2.height = Math.min(this.f17586w, this.f17585v);
                }
            } else {
                int i7 = this.f17586w;
                if (i7 > 0) {
                    layoutParams.height = i7;
                    layoutParams2.height = i7;
                }
            }
            childAt.setLayoutParams(layoutParams2);
            this.f17582s.setLayoutParams(layoutParams);
            this.f17582s.post(new RunnableC0497a());
        }
    }

    /* JADX INFO: renamed from: com.lxj.xpopup.util.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: XPopupUtils.java */
    static class RunnableC0498b implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ BasePopupView f17589s;

        RunnableC0498b(BasePopupView basePopupView) {
            this.f17589s = basePopupView;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.c(b.b, this.f17589s);
        }
    }

    /* JADX INFO: compiled from: XPopupUtils.java */
    static class c implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ i f17590s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ Context f17591t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final /* synthetic */ Object f17592u;

        c(i iVar, Context context, Object obj) {
            this.f17590s = iVar;
            this.f17591t = context;
            this.f17592u = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            File fileA = this.f17590s.a(this.f17591t, this.f17592u);
            if (fileA == null) {
                Context context = this.f17591t;
                b.b(context, context.getString(R$string.xpopup_image_not_exist));
                return;
            }
            try {
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), this.f17591t.getPackageName());
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, System.currentTimeMillis() + "." + b.a(fileA));
                if (Build.VERSION.SDK_INT < 29) {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    file2.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    try {
                        b.b(fileOutputStream, new FileInputStream(fileA));
                        fileOutputStream.close();
                        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                        intent.setData(Uri.parse("file://" + file2.getAbsolutePath()));
                        this.f17591t.sendBroadcast(intent);
                    } finally {
                    }
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("_display_name", file2.getName());
                    contentValues.put(EventConstants.ExtraJson.MIME_TYPE, "image/*");
                    Uri uri = Environment.getExternalStorageState().equals("mounted") ? MediaStore.Images.Media.EXTERNAL_CONTENT_URI : MediaStore.Images.Media.INTERNAL_CONTENT_URI;
                    contentValues.put("relative_path", Environment.DIRECTORY_DCIM + "/" + this.f17591t.getPackageName());
                    contentValues.put("is_pending", (Integer) 1);
                    Uri uriInsert = this.f17591t.getContentResolver().insert(uri, contentValues);
                    if (uriInsert == null) {
                        b.b(this.f17591t, this.f17591t.getString(R$string.xpopup_saved_fail));
                        return;
                    }
                    ContentResolver contentResolver = this.f17591t.getContentResolver();
                    OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert);
                    try {
                        b.b(outputStreamOpenOutputStream, new FileInputStream(fileA));
                        if (outputStreamOpenOutputStream != null) {
                            outputStreamOpenOutputStream.close();
                        }
                        contentValues.clear();
                        contentValues.put("is_pending", (Integer) 0);
                        contentResolver.update(uriInsert, contentValues, null, null);
                    } finally {
                    }
                }
                b.b(this.f17591t, this.f17591t.getString(R$string.xpopup_saved_to_gallery));
            } catch (Exception e2) {
                e2.printStackTrace();
                Context context2 = this.f17591t;
                b.b(context2, context2.getString(R$string.xpopup_saved_fail));
            }
        }
    }

    /* JADX INFO: compiled from: XPopupUtils.java */
    static class d implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Context f17593s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ String f17594t;

        d(Context context, String str) {
            this.f17593s = context;
            this.f17594t = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.f17593s;
            if (context != null) {
                Toast.makeText(context, this.f17594t, 0).show();
            }
        }
    }

    public static void a(EditText editText, int i2) {
    }

    public static int b(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point.y;
    }

    public static int c(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    public static boolean d(Context context) {
        return TextUtils.getLayoutDirectionFromLocale(Build.VERSION.SDK_INT >= 24 ? context.getResources().getConfiguration().getLocales().get(0) : context.getResources().getConfiguration().locale) == 1;
    }

    public static int c() {
        Resources system = Resources.getSystem();
        return system.getDimensionPixelSize(system.getIdentifier("status_bar_height", "dimen", DispatchConstants.ANDROID));
    }

    public static int a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.y;
    }

    public static int b() {
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("navigation_bar_height", "dimen", DispatchConstants.ANDROID);
        if (identifier != 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(int r8, com.lxj.xpopup.core.BasePopupView r9) {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lxj.xpopup.util.b.c(int, com.lxj.xpopup.core.BasePopupView):void");
    }

    public static void b(int i2, BasePopupView basePopupView) {
        b = i2;
        basePopupView.post(new RunnableC0498b(basePopupView));
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void a(View view, int i2, int i3) {
        if (i2 > 0 || i3 > 0) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (i2 > 0) {
                layoutParams.width = i2;
            }
            if (i3 > 0) {
                layoutParams.height = i3;
            }
            view.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str) {
        new Handler(Looper.getMainLooper()).post(new d(context, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(OutputStream outputStream, InputStream inputStream) throws Throwable {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(outputStream);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i2 = inputStream.read(bArr, 0, 8192);
                        if (i2 == -1) {
                            break;
                        }
                        bufferedOutputStream2.write(bArr, 0, i2);
                    }
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    return true;
                } catch (IOException e4) {
                    e = e4;
                    bufferedOutputStream = bufferedOutputStream2;
                    e.printStackTrace();
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    try {
                        inputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                    if (bufferedOutputStream == null) {
                        throw th;
                    }
                    try {
                        bufferedOutputStream.close();
                        throw th;
                    } catch (IOException e8) {
                        e8.printStackTrace();
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e9) {
            e = e9;
        }
    }

    public static void a(ViewGroup viewGroup, int i2, int i3, int i4, int i5, Runnable runnable) {
        viewGroup.post(new a(viewGroup, i2, i4, i3, i5, runnable));
    }

    public static BitmapDrawable a(Resources resources, int i2, int i3) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, 20, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setColor(i3);
        canvas.drawRect(0.0f, 0.0f, bitmapCreateBitmap.getWidth(), 4.0f, paint);
        paint.setColor(0);
        canvas.drawRect(0.0f, 4.0f, bitmapCreateBitmap.getWidth(), 20.0f, paint);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, bitmapCreateBitmap);
        bitmapDrawable.setGravity(80);
        return bitmapDrawable;
    }

    public static StateListDrawable a(Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_focused}, drawable2);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public static boolean a(float f2, float f3, Rect rect) {
        return f2 >= ((float) rect.left) && f2 <= ((float) rect.right) && f3 >= ((float) rect.top) && f3 <= ((float) rect.bottom);
    }

    public static int a(Window window) {
        View decorView = window.getDecorView();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int iAbs = Math.abs(decorView.getBottom() - rect.bottom);
        if (iAbs <= b()) {
            a = iAbs;
            return 0;
        }
        return iAbs - a;
    }

    public static boolean b(View view) {
        try {
            Method declaredMethod = Class.forName("android.view.View").getDeclaredMethod("getListenerInfo", new Class[0]);
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            Object objInvoke = declaredMethod.invoke(view, new Object[0]);
            Field declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnKeyListener");
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            return declaredField.get(objInvoke) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static Bitmap c(View view) {
        Bitmap bitmapCreateBitmap;
        if (view == null) {
            return null;
        }
        boolean zIsDrawingCacheEnabled = view.isDrawingCacheEnabled();
        boolean zWillNotCacheDrawing = view.willNotCacheDrawing();
        view.setDrawingCacheEnabled(true);
        view.setWillNotCacheDrawing(false);
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null) {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.buildDrawingCache();
            Bitmap drawingCache2 = view.getDrawingCache();
            if (drawingCache2 != null) {
                bitmapCreateBitmap = Bitmap.createBitmap(drawingCache2);
            } else {
                bitmapCreateBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                view.draw(new Canvas(bitmapCreateBitmap));
            }
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap(drawingCache);
        }
        view.destroyDrawingCache();
        view.setWillNotCacheDrawing(zWillNotCacheDrawing);
        view.setDrawingCacheEnabled(zIsDrawingCacheEnabled);
        return bitmapCreateBitmap;
    }

    public static void a(BasePopupView basePopupView) {
        if ((basePopupView instanceof PositionPopupView) || (basePopupView instanceof AttachPopupView) || (basePopupView instanceof BubbleAttachPopupView)) {
            return;
        }
        if ((basePopupView instanceof FullScreenPopupView) && basePopupView.getPopupContentView().hasTransientState()) {
            return;
        }
        basePopupView.getPopupContentView().animate().translationY(0.0f).setDuration(100L).start();
    }

    public static void a(ArrayList<EditText> arrayList, ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof EditText) && childAt.getVisibility() == 0) {
                arrayList.add((EditText) childAt);
            } else if (childAt instanceof ViewGroup) {
                a(arrayList, (ViewGroup) childAt);
            }
        }
    }

    public static void a(Context context, i iVar, Object obj) {
        Executors.newSingleThreadExecutor().execute(new c(iVar, context, obj));
    }

    public static Bitmap a(Context context, Bitmap bitmap, @FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, fromInclusive = false, to = 25.0d) float f2, boolean z2) throws Throwable {
        RenderScript renderScriptCreate;
        if (!z2) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        try {
            renderScriptCreate = RenderScript.create(context);
        } catch (Throwable th) {
            th = th;
            renderScriptCreate = null;
        }
        try {
            renderScriptCreate.setMessageHandler(new RenderScript.RSMessageHandler());
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            Allocation allocationCreateTyped = Allocation.createTyped(renderScriptCreate, allocationCreateFromBitmap.getType());
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.setRadius(f2);
            scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
            allocationCreateTyped.copyTo(bitmap);
            if (renderScriptCreate != null) {
                renderScriptCreate.destroy();
            }
            return bitmap;
        } catch (Throwable th2) {
            th = th2;
            if (renderScriptCreate != null) {
                renderScriptCreate.destroy();
            }
            throw th;
        }
    }

    public static Activity a(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public static Drawable a(int i2, float f2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius(f2);
        return gradientDrawable;
    }

    public static Drawable a(int i2, float f2, float f3, float f4, float f5) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadii(new float[]{f2, f2, f3, f3, f4, f4, f5, f5});
        return gradientDrawable;
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a5, code lost:
    
        if (r4.contains("00000200") != false) goto L61;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x00d4 -> B:99:0x00d7). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.io.File r4) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lxj.xpopup.util.b.a(java.io.File):java.lang.String");
    }

    public static String a(byte[] bArr, boolean z2) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = z2 ? f17580c : f17581d;
        int length = bArr.length;
        if (length <= 0) {
            return "";
        }
        char[] cArr2 = new char[length << 1];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i2 + 1;
            cArr2[i2] = cArr[(bArr[i3] >> 4) & 15];
            i2 = i4 + 1;
            cArr2[i4] = cArr[bArr[i3] & cb.f19604m];
        }
        return new String(cArr2);
    }
}
