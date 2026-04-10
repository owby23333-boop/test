package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: StandardGifDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements GifDecoder {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f13338u = "d";

    @ColorInt
    private int[] a;

    @ColorInt
    private final int[] b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final GifDecoder.a f13339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ByteBuffer f13340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f13341e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private short[] f13342f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private byte[] f13343g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private byte[] f13344h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private byte[] f13345i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @ColorInt
    private int[] f13346j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f13347k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private b f13348l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Bitmap f13349m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f13350n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f13351o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f13352p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f13353q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f13354r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    private Boolean f13355s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    private Bitmap.Config f13356t;

    public d(@NonNull GifDecoder.a aVar, b bVar, ByteBuffer byteBuffer, int i2) {
        this(aVar);
        a(bVar, byteBuffer, i2);
    }

    private Bitmap i() {
        Boolean bool = this.f13355s;
        Bitmap bitmapA = this.f13339c.a(this.f13354r, this.f13353q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f13356t);
        bitmapA.setHasAlpha(true);
        return bitmapA;
    }

    private int j() {
        int iK = k();
        if (iK <= 0) {
            return iK;
        }
        ByteBuffer byteBuffer = this.f13340d;
        byteBuffer.get(this.f13341e, 0, Math.min(iK, byteBuffer.remaining()));
        return iK;
    }

    private int k() {
        return this.f13340d.get() & 255;
    }

    public int a(int i2) {
        if (i2 >= 0) {
            b bVar = this.f13348l;
            if (i2 < bVar.f13325c) {
                return bVar.f13327e.get(i2).f13322i;
            }
        }
        return -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void b() {
        this.f13347k = (this.f13347k + 1) % this.f13348l.f13325c;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int c() {
        return this.f13348l.f13325c;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void clear() {
        this.f13348l = null;
        byte[] bArr = this.f13345i;
        if (bArr != null) {
            this.f13339c.a(bArr);
        }
        int[] iArr = this.f13346j;
        if (iArr != null) {
            this.f13339c.a(iArr);
        }
        Bitmap bitmap = this.f13349m;
        if (bitmap != null) {
            this.f13339c.a(bitmap);
        }
        this.f13349m = null;
        this.f13340d = null;
        this.f13355s = null;
        byte[] bArr2 = this.f13341e;
        if (bArr2 != null) {
            this.f13339c.a(bArr2);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int d() {
        int i2 = this.f13348l.f13335m;
        if (i2 == -1) {
            return 1;
        }
        if (i2 == 0) {
            return 0;
        }
        return i2 + 1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int e() {
        int i2;
        if (this.f13348l.f13325c <= 0 || (i2 = this.f13347k) < 0) {
            return 0;
        }
        return a(i2);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void f() {
        this.f13347k = -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int g() {
        return this.f13347k;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @NonNull
    public ByteBuffer getData() {
        return this.f13340d;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int h() {
        return this.f13340d.limit() + this.f13345i.length + (this.f13346j.length * 4);
    }

    private void b(a aVar) {
        a aVar2 = aVar;
        int[] iArr = this.f13346j;
        int i2 = aVar2.f13317d;
        int i3 = aVar2.b;
        int i4 = aVar2.f13316c;
        int i5 = aVar2.a;
        boolean z2 = this.f13347k == 0;
        int i6 = this.f13354r;
        byte[] bArr = this.f13345i;
        int[] iArr2 = this.a;
        int i7 = 0;
        byte b = -1;
        while (i7 < i2) {
            int i8 = (i7 + i3) * i6;
            int i9 = i8 + i5;
            int i10 = i9 + i4;
            int i11 = i8 + i6;
            if (i11 < i10) {
                i10 = i11;
            }
            int i12 = aVar2.f13316c * i7;
            for (int i13 = i9; i13 < i10; i13++) {
                byte b2 = bArr[i12];
                int i14 = b2 & 255;
                if (i14 != b) {
                    int i15 = iArr2[i14];
                    if (i15 != 0) {
                        iArr[i13] = i15;
                    } else {
                        b = b2;
                    }
                }
                i12++;
            }
            i7++;
            aVar2 = aVar;
        }
        Boolean bool = this.f13355s;
        this.f13355s = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.f13355s == null && z2 && b != -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v17, types: [short] */
    /* JADX WARN: Type inference failed for: r4v20 */
    private void c(a aVar) {
        int i2;
        int i3;
        short s2;
        d dVar = this;
        if (aVar != null) {
            dVar.f13340d.position(aVar.f13323j);
        }
        if (aVar == null) {
            b bVar = dVar.f13348l;
            i2 = bVar.f13328f;
            i3 = bVar.f13329g;
        } else {
            i2 = aVar.f13316c;
            i3 = aVar.f13317d;
        }
        int i4 = i2 * i3;
        byte[] bArr = dVar.f13345i;
        if (bArr == null || bArr.length < i4) {
            dVar.f13345i = dVar.f13339c.a(i4);
        }
        byte[] bArr2 = dVar.f13345i;
        if (dVar.f13342f == null) {
            dVar.f13342f = new short[4096];
        }
        short[] sArr = dVar.f13342f;
        if (dVar.f13343g == null) {
            dVar.f13343g = new byte[4096];
        }
        byte[] bArr3 = dVar.f13343g;
        if (dVar.f13344h == null) {
            dVar.f13344h = new byte[4097];
        }
        byte[] bArr4 = dVar.f13344h;
        int iK = k();
        int i5 = 1 << iK;
        int i6 = i5 + 1;
        int i7 = i5 + 2;
        int i8 = iK + 1;
        int i9 = (1 << i8) - 1;
        int i10 = 0;
        for (int i11 = 0; i11 < i5; i11++) {
            sArr[i11] = 0;
            bArr3[i11] = (byte) i11;
        }
        byte[] bArr5 = dVar.f13341e;
        int i12 = i8;
        int i13 = i7;
        int i14 = i9;
        int iJ = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = -1;
        int i20 = 0;
        int i21 = 0;
        while (true) {
            if (i10 >= i4) {
                break;
            }
            if (iJ == 0) {
                iJ = j();
                if (iJ <= 0) {
                    dVar.f13351o = 3;
                    break;
                }
                i17 = 0;
            }
            i16 += (bArr5[i17] & 255) << i15;
            i17++;
            iJ--;
            int i22 = i15 + 8;
            int i23 = i19;
            int i24 = i20;
            int i25 = i13;
            int i26 = i18;
            int i27 = i10;
            int i28 = i12;
            while (true) {
                if (i22 < i28) {
                    i12 = i28;
                    i20 = i24;
                    i10 = i27;
                    i18 = i26;
                    i15 = i22;
                    i13 = i25;
                    i19 = i23;
                    dVar = this;
                    break;
                }
                int i29 = i16 & i14;
                i16 >>= i28;
                i22 -= i28;
                if (i29 == i5) {
                    i28 = i8;
                    i25 = i7;
                    i14 = i9;
                    i23 = -1;
                } else {
                    if (i29 == i6) {
                        i15 = i22;
                        i12 = i28;
                        i10 = i27;
                        i18 = i26;
                        i13 = i25;
                        i20 = i24;
                        i19 = i23;
                        break;
                    }
                    if (i23 == -1) {
                        bArr2[i26] = bArr3[i29];
                        i26++;
                        i27++;
                        dVar = this;
                        i23 = i29;
                        i24 = i23;
                    } else {
                        int i30 = i25;
                        if (i29 >= i30) {
                            bArr4[i21] = (byte) i24;
                            i21++;
                            s2 = i23;
                        } else {
                            s2 = i29;
                        }
                        while (s2 >= i5) {
                            bArr4[i21] = bArr3[s2];
                            i21++;
                            s2 = sArr[s2];
                        }
                        int i31 = bArr3[s2] & 255;
                        int i32 = i8;
                        byte b = (byte) i31;
                        bArr2[i26] = b;
                        while (true) {
                            i26++;
                            i27++;
                            if (i21 <= 0) {
                                break;
                            }
                            i21--;
                            bArr2[i26] = bArr4[i21];
                        }
                        if (i30 < 4096) {
                            sArr[i30] = (short) i23;
                            bArr3[i30] = b;
                            i30++;
                            if ((i30 & i14) == 0 && i30 < 4096) {
                                i28++;
                                i14 += i30;
                            }
                        }
                        i23 = i29;
                        i22 = i22;
                        i8 = i32;
                        i24 = i31;
                        i25 = i30;
                        dVar = this;
                    }
                }
            }
        }
        Arrays.fill(bArr2, i18, i4, (byte) 0);
    }

    public d(@NonNull GifDecoder.a aVar) {
        this.b = new int[256];
        this.f13356t = Bitmap.Config.ARGB_8888;
        this.f13339c = aVar;
        this.f13348l = new b();
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Nullable
    public synchronized Bitmap a() {
        if (this.f13348l.f13325c <= 0 || this.f13347k < 0) {
            if (Log.isLoggable(f13338u, 3)) {
                String str = "Unable to decode frame, frameCount=" + this.f13348l.f13325c + ", framePointer=" + this.f13347k;
            }
            this.f13351o = 1;
        }
        if (this.f13351o != 1 && this.f13351o != 2) {
            this.f13351o = 0;
            if (this.f13341e == null) {
                this.f13341e = this.f13339c.a(255);
            }
            a aVar = this.f13348l.f13327e.get(this.f13347k);
            int i2 = this.f13347k - 1;
            a aVar2 = i2 >= 0 ? this.f13348l.f13327e.get(i2) : null;
            this.a = aVar.f13324k != null ? aVar.f13324k : this.f13348l.a;
            if (this.a == null) {
                if (Log.isLoggable(f13338u, 3)) {
                    String str2 = "No valid color table found for frame #" + this.f13347k;
                }
                this.f13351o = 1;
                return null;
            }
            if (aVar.f13319f) {
                System.arraycopy(this.a, 0, this.b, 0, this.a.length);
                this.a = this.b;
                this.a[aVar.f13321h] = 0;
                if (aVar.f13320g == 2 && this.f13347k == 0) {
                    this.f13355s = true;
                }
            }
            return a(aVar, aVar2);
        }
        if (Log.isLoggable(f13338u, 3)) {
            String str3 = "Unable to decode frame, status=" + this.f13351o;
        }
        return null;
    }

    public synchronized void a(@NonNull b bVar, @NonNull ByteBuffer byteBuffer, int i2) {
        if (i2 > 0) {
            int iHighestOneBit = Integer.highestOneBit(i2);
            this.f13351o = 0;
            this.f13348l = bVar;
            this.f13347k = -1;
            this.f13340d = byteBuffer.asReadOnlyBuffer();
            this.f13340d.position(0);
            this.f13340d.order(ByteOrder.LITTLE_ENDIAN);
            this.f13350n = false;
            Iterator<a> it = bVar.f13327e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().f13320g == 3) {
                    this.f13350n = true;
                    break;
                }
            }
            this.f13352p = iHighestOneBit;
            this.f13354r = bVar.f13328f / iHighestOneBit;
            this.f13353q = bVar.f13329g / iHighestOneBit;
            this.f13345i = this.f13339c.a(bVar.f13328f * bVar.f13329g);
            this.f13346j = this.f13339c.b(this.f13354r * this.f13353q);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void a(@NonNull Bitmap.Config config) {
        if (config != Bitmap.Config.ARGB_8888 && config != Bitmap.Config.RGB_565) {
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
        }
        this.f13356t = config;
    }

    private Bitmap a(a aVar, a aVar2) {
        int i2;
        int i3;
        Bitmap bitmap;
        int[] iArr = this.f13346j;
        int i4 = 0;
        if (aVar2 == null) {
            Bitmap bitmap2 = this.f13349m;
            if (bitmap2 != null) {
                this.f13339c.a(bitmap2);
            }
            this.f13349m = null;
            Arrays.fill(iArr, 0);
        }
        if (aVar2 != null && aVar2.f13320g == 3 && this.f13349m == null) {
            Arrays.fill(iArr, 0);
        }
        if (aVar2 != null && (i3 = aVar2.f13320g) > 0) {
            if (i3 == 2) {
                if (!aVar.f13319f) {
                    b bVar = this.f13348l;
                    int i5 = bVar.f13334l;
                    if (aVar.f13324k == null || bVar.f13332j != aVar.f13321h) {
                        i4 = i5;
                    }
                }
                int i6 = aVar2.f13317d;
                int i7 = this.f13352p;
                int i8 = i6 / i7;
                int i9 = aVar2.b / i7;
                int i10 = aVar2.f13316c / i7;
                int i11 = aVar2.a / i7;
                int i12 = this.f13354r;
                int i13 = (i9 * i12) + i11;
                int i14 = (i8 * i12) + i13;
                while (i13 < i14) {
                    int i15 = i13 + i10;
                    for (int i16 = i13; i16 < i15; i16++) {
                        iArr[i16] = i4;
                    }
                    i13 += this.f13354r;
                }
            } else if (i3 == 3 && (bitmap = this.f13349m) != null) {
                int i17 = this.f13354r;
                bitmap.getPixels(iArr, 0, i17, 0, 0, i17, this.f13353q);
            }
        }
        c(aVar);
        if (!aVar.f13318e && this.f13352p == 1) {
            b(aVar);
        } else {
            a(aVar);
        }
        if (this.f13350n && ((i2 = aVar.f13320g) == 0 || i2 == 1)) {
            if (this.f13349m == null) {
                this.f13349m = i();
            }
            Bitmap bitmap3 = this.f13349m;
            int i18 = this.f13354r;
            bitmap3.setPixels(iArr, 0, i18, 0, 0, i18, this.f13353q);
        }
        Bitmap bitmapI = i();
        int i19 = this.f13354r;
        bitmapI.setPixels(iArr, 0, i19, 0, 0, i19, this.f13353q);
        return bitmapI;
    }

    private void a(a aVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr = this.f13346j;
        int i7 = aVar.f13317d;
        int i8 = this.f13352p;
        int i9 = i7 / i8;
        int i10 = aVar.b / i8;
        int i11 = aVar.f13316c / i8;
        int i12 = aVar.a / i8;
        Boolean bool = true;
        boolean z2 = this.f13347k == 0;
        int i13 = this.f13352p;
        int i14 = this.f13354r;
        int i15 = this.f13353q;
        byte[] bArr = this.f13345i;
        int[] iArr2 = this.a;
        Boolean bool2 = this.f13355s;
        int i16 = 0;
        int i17 = 0;
        int i18 = 1;
        int i19 = 8;
        while (i16 < i9) {
            Boolean bool3 = bool;
            if (aVar.f13318e) {
                if (i17 >= i9) {
                    i2 = i9;
                    i6 = i18 + 1;
                    if (i6 == 2) {
                        i17 = 4;
                    } else if (i6 == 3) {
                        i17 = 2;
                        i19 = 4;
                    } else if (i6 == 4) {
                        i17 = 1;
                        i19 = 2;
                    }
                } else {
                    i2 = i9;
                    i6 = i18;
                }
                i3 = i17 + i19;
                i18 = i6;
            } else {
                i2 = i9;
                i3 = i17;
                i17 = i16;
            }
            int i20 = i17 + i10;
            boolean z3 = i13 == 1;
            if (i20 < i15) {
                int i21 = i20 * i14;
                int i22 = i21 + i12;
                int i23 = i22 + i11;
                int i24 = i21 + i14;
                if (i24 < i23) {
                    i23 = i24;
                }
                i4 = i10;
                int i25 = i16 * i13 * aVar.f13316c;
                if (z3) {
                    int i26 = i22;
                    while (i26 < i23) {
                        int i27 = i11;
                        int i28 = iArr2[bArr[i25] & 255];
                        if (i28 != 0) {
                            iArr[i26] = i28;
                        } else if (z2 && bool2 == null) {
                            bool2 = bool3;
                        }
                        i25 += i13;
                        i26++;
                        i11 = i27;
                    }
                } else {
                    i5 = i11;
                    int i29 = ((i23 - i22) * i13) + i25;
                    int i30 = i22;
                    while (i30 < i23) {
                        int i31 = i23;
                        int iA = a(i25, i29, aVar.f13316c);
                        if (iA != 0) {
                            iArr[i30] = iA;
                        } else if (z2 && bool2 == null) {
                            bool2 = bool3;
                        }
                        i25 += i13;
                        i30++;
                        i23 = i31;
                    }
                    i16++;
                    i17 = i3;
                    i11 = i5;
                    bool = bool3;
                    i9 = i2;
                    i10 = i4;
                }
            } else {
                i4 = i10;
            }
            i5 = i11;
            i16++;
            i17 = i3;
            i11 = i5;
            bool = bool3;
            i9 = i2;
            i10 = i4;
        }
        if (this.f13355s == null) {
            this.f13355s = Boolean.valueOf(bool2 == null ? false : bool2.booleanValue());
        }
    }

    @ColorInt
    private int a(int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = i2; i10 < this.f13352p + i2; i10++) {
            byte[] bArr = this.f13345i;
            if (i10 >= bArr.length || i10 >= i3) {
                break;
            }
            int i11 = this.a[bArr[i10] & 255];
            if (i11 != 0) {
                i5 += (i11 >> 24) & 255;
                i6 += (i11 >> 16) & 255;
                i7 += (i11 >> 8) & 255;
                i8 += i11 & 255;
                i9++;
            }
        }
        int i12 = i2 + i4;
        for (int i13 = i12; i13 < this.f13352p + i12; i13++) {
            byte[] bArr2 = this.f13345i;
            if (i13 >= bArr2.length || i13 >= i3) {
                break;
            }
            int i14 = this.a[bArr2[i13] & 255];
            if (i14 != 0) {
                i5 += (i14 >> 24) & 255;
                i6 += (i14 >> 16) & 255;
                i7 += (i14 >> 8) & 255;
                i8 += i14 & 255;
                i9++;
            }
        }
        if (i9 == 0) {
            return 0;
        }
        return ((i5 / i9) << 24) | ((i6 / i9) << 16) | ((i7 / i9) << 8) | (i8 / i9);
    }
}
