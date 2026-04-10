package com.yuewen;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.util.Log;
import androidx.palette.graphics.Palette;
import com.duokan.reader.common.bitmap.HashBag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class k40 {
    public static final double i = 0.01d;
    public static final double j = 0.3d;
    public static final int k = 120;
    public static final int l = 120;
    public static final String m = "k40";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bitmap f13367b;
    public HashBag<Integer> c;
    public int d;
    public boolean h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f13366a = 0.15f;
    public Integer e = null;
    public Integer f = null;
    public Integer g = null;

    public static class a implements Comparable<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f13369b;

        public a(int i, int i2) {
            this.f13368a = i;
            this.f13369b = i2;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            if (c() < aVar.c()) {
                return -1;
            }
            return c() == aVar.c() ? 0 : 1;
        }

        public int b() {
            return this.f13368a;
        }

        public int c() {
            return this.f13369b;
        }

        public boolean d() {
            double dRed = ((double) Color.red(this.f13368a)) / 255.0d;
            double dGreen = ((double) Color.green(this.f13368a)) / 255.0d;
            double dBlue = ((double) Color.blue(this.f13368a)) / 255.0d;
            if (dRed <= 0.91d || dGreen <= 0.91d || dBlue <= 0.91d) {
                return dRed < 0.09d && dGreen < 0.09d && dBlue < 0.09d;
            }
            return true;
        }
    }

    public k40(Bitmap bitmap, boolean z) {
        this.h = true;
        this.f13367b = Bitmap.createScaledBitmap(bitmap, 120, 120, false);
        this.h = z;
        b();
    }

    public static int a(int i2, float f) {
        float[] fArr = new float[3];
        Color.colorToHSV(i2, fArr);
        fArr[2] = fArr[2] * f;
        return Color.HSVToColor(fArr);
    }

    public static int c(Bitmap bitmap, float f) {
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, 120, 120, false);
        int height = bitmapCreateScaledBitmap.getHeight();
        int i2 = (int) (((double) height) * 0.01d);
        HashBag<Integer> hashBag = new HashBag();
        int[] iArr = new int[height];
        bitmapCreateScaledBitmap.getPixels(iArr, 0, 1, 0, 0, 1, height);
        for (int i3 = 0; i3 < height; i3++) {
            hashBag.add(Integer.valueOf(iArr[i3]));
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : hashBag) {
            int count = hashBag.getCount(num);
            if (count >= i2) {
                arrayList.add(new a(num.intValue(), count));
            }
        }
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            return f(-16777216, f);
        }
        a aVar = (a) it.next();
        if (!aVar.d()) {
            return f(aVar.b(), f);
        }
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a aVar2 = (a) it.next();
            if (((double) aVar2.c()) / ((double) aVar.c()) <= 0.3d) {
                break;
            }
            if (!aVar2.d()) {
                aVar = aVar2;
                break;
            }
        }
        return f(aVar.b(), f);
    }

    public static u54<Integer, Boolean> d(Bitmap bitmap) {
        Palette paletteGenerate = Palette.from(bitmap).generate();
        return new u54<>(Integer.valueOf(paletteGenerate != null ? paletteGenerate.getDarkMutedSwatch() != null ? paletteGenerate.getDarkMutedSwatch().getRgb() : c(bitmap, 0.3f) : 0), Boolean.FALSE);
    }

    public static u54<Integer, Boolean> e(Bitmap bitmap) {
        Palette paletteGenerate = Palette.from(bitmap).generate();
        int iC = 0;
        boolean z = true;
        if (paletteGenerate != null) {
            if (paletteGenerate.getLightVibrantSwatch() != null) {
                iC = paletteGenerate.getLightVibrantSwatch().getRgb();
            } else if (paletteGenerate.getDarkMutedSwatch() != null) {
                z = false;
                iC = paletteGenerate.getDarkMutedSwatch().getRgb();
            } else {
                iC = c(bitmap, 0.3f);
            }
        }
        return new u54<>(Integer.valueOf(iC), Boolean.valueOf(z));
    }

    public static int f(int i2, float f) {
        float f2 = 1.0f - f;
        return Color.rgb((int) Math.floor(Color.red(i2) * f2), (int) Math.floor(Color.green(i2) * f2), (int) Math.floor(Color.blue(i2) * f2));
    }

    public static int j(float f, int i2) {
        return (Math.min(255, Math.max(0, (int) (f * 255.0f))) << 24) + (i2 & 16777215);
    }

    public static boolean l(int i2) {
        return (((((double) Color.red(i2)) / 255.0d) * 0.2126d) + ((((double) Color.green(i2)) / 255.0d) * 0.7152d)) + ((((double) Color.blue(i2)) / 255.0d) * 0.0722d) < 0.5d;
    }

    public static boolean n(int i2) {
        return (((((double) Color.red(i2)) / 255.0d) * 0.2126d) + ((((double) Color.green(i2)) / 255.0d) * 0.7152d)) + ((((double) Color.blue(i2)) / 255.0d) * 0.0722d) < 0.5d;
    }

    public static Bitmap o(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postScale(0.125f, 0.125f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public final void b() {
        this.d = h();
        if (this.h) {
            i(this.c);
            boolean zN = n(this.d);
            if (this.e == null) {
                Log.d(m, "Unable to detect primary color in image");
                if (zN) {
                    this.e = -1;
                } else {
                    this.e = -16777216;
                }
            }
            if (this.f == null) {
                Log.d(m, "Unable to detect secondary in image");
                if (zN) {
                    this.f = -1;
                } else {
                    this.f = -16777216;
                }
            }
            if (this.g == null) {
                Log.d(m, "Unable to detect detail color in image");
                if (zN) {
                    this.g = -1;
                } else {
                    this.g = -16777216;
                }
            }
        }
    }

    public final int g(int i2, float f) {
        float[] fArr = new float[3];
        Color.colorToHSV(i2, fArr);
        return fArr[1] < f ? Color.HSVToColor(new float[]{fArr[0], f, fArr[2]}) : i2;
    }

    public final int h() {
        int height = this.f13367b.getHeight();
        int width = this.f13367b.getWidth();
        this.c = new HashBag<>();
        HashBag<Integer> hashBag = new HashBag();
        for (int i2 = 0; i2 < width; i2++) {
            for (int i3 = 0; i3 < height; i3++) {
                if (i2 == 0) {
                    hashBag.add(Integer.valueOf(this.f13367b.getPixel(i2, i3)));
                }
                this.c.add(Integer.valueOf(this.f13367b.getPixel(i2, i3)));
            }
        }
        ArrayList arrayList = new ArrayList();
        int i4 = (int) (((double) height) * 0.01d);
        for (Integer num : hashBag) {
            int count = hashBag.getCount(num);
            if (count >= i4) {
                arrayList.add(new a(num.intValue(), count));
            }
        }
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            return -16777216;
        }
        a aVar = (a) it.next();
        if (!aVar.d()) {
            return aVar.b();
        }
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a aVar2 = (a) it.next();
            if (((double) aVar2.c()) / ((double) aVar.c()) <= 0.3d) {
                break;
            }
            if (!aVar2.d()) {
                aVar = aVar2;
                break;
            }
        }
        return aVar.b();
    }

    public final void i(HashBag<Integer> hashBag) {
        Iterator<Integer> it = hashBag.iterator();
        ArrayList arrayList = new ArrayList();
        boolean z = !n(this.d);
        while (it.hasNext()) {
            int iG = g(it.next().intValue(), 0.15f);
            if (n(iG) == z) {
                arrayList.add(new a(iG, hashBag.getCount(Integer.valueOf(iG))));
            }
        }
        Collections.sort(arrayList);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            int iB = ((a) it2.next()).b();
            Integer num = this.e;
            if (num != null) {
                Integer num2 = this.f;
                if (num2 == null) {
                    if (m(num.intValue(), iB) && k(iB, this.d)) {
                        this.f = Integer.valueOf(iB);
                    }
                } else if (this.g == null && m(num2.intValue(), iB) && m(this.e.intValue(), iB) && k(iB, this.d)) {
                    this.g = Integer.valueOf(iB);
                    return;
                }
            } else if (k(iB, this.d)) {
                this.e = Integer.valueOf(iB);
            }
        }
    }

    public final boolean k(int i2, int i3) {
        double dRed = ((((double) Color.red(i2)) / 255.0d) * 0.2126d) + ((((double) Color.green(i2)) / 255.0d) * 0.7152d) + ((((double) Color.blue(i2)) / 255.0d) * 0.0722d);
        double dRed2 = ((((double) Color.red(i3)) / 255.0d) * 0.2126d) + ((((double) Color.green(i3)) / 255.0d) * 0.7152d) + ((((double) Color.blue(i3)) / 255.0d) * 0.0722d);
        return ((dRed > dRed2 ? 1 : (dRed == dRed2 ? 0 : -1)) > 0 ? (dRed + 0.05d) / (dRed2 + 0.05d) : (dRed2 + 0.05d) / (dRed + 0.05d)) > 1.6d;
    }

    public final boolean m(int i2, int i3) {
        double dRed = ((double) Color.red(i2)) / 255.0d;
        double dGreen = ((double) Color.green(i2)) / 255.0d;
        double dBlue = ((double) Color.blue(i2)) / 255.0d;
        double dAlpha = ((double) Color.alpha(i2)) / 255.0d;
        double dRed2 = ((double) Color.red(i3)) / 255.0d;
        double dGreen2 = ((double) Color.green(i3)) / 255.0d;
        double dBlue2 = ((double) Color.blue(i3)) / 255.0d;
        double dAlpha2 = ((double) Color.alpha(i3)) / 255.0d;
        if (Math.abs(dRed - dRed2) > 0.25d || Math.abs(dGreen - dGreen2) > 0.25d || Math.abs(dBlue - dBlue2) > 0.25d || Math.abs(dAlpha - dAlpha2) > 0.25d) {
            return Math.abs(dRed - dGreen) >= 0.03d || Math.abs(dRed - dBlue) >= 0.03d || Math.abs(dRed2 - dGreen2) >= 0.03d || Math.abs(dRed2 - dBlue2) >= 0.03d;
        }
        return false;
    }
}
