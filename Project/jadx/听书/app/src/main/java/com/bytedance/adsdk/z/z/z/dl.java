package com.bytedance.adsdk.z.z.z;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends gz<com.bytedance.adsdk.z.z.g.z, com.bytedance.adsdk.z.z.g.g> {
    static final /* synthetic */ boolean m = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<gc> f280a;
    byte[] dl;
    public final byte g;
    List<gc> gc;
    public final byte z;
    private static final byte[] pf = {-119, 80, 78, 71, 13, 10, Ascii.SUB, 10};
    private static final byte[] ls = {0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};
    private static final ThreadLocal<CRC32> p = new ThreadLocal<>();

    private CRC32 z() {
        ThreadLocal<CRC32> threadLocal = p;
        CRC32 crc32 = threadLocal.get();
        if (crc32 != null) {
            return crc32;
        }
        CRC32 crc322 = new CRC32();
        threadLocal.set(crc322);
        return crc322;
    }

    public dl(com.bytedance.adsdk.z.z.g.z zVar, m mVar) {
        super(zVar);
        this.f280a = new ArrayList();
        this.gc = new ArrayList();
        this.z = mVar.v;
        this.g = mVar.i;
        this.wp = (mVar.kb * 1000) / (mVar.wp == 0 ? (short) 100 : mVar.wp);
        if (this.wp < 10) {
            this.wp = 100;
        }
        this.gz = mVar.dl;
        this.fo = mVar.gz;
        this.uy = mVar.fo;
        this.kb = mVar.uy;
    }

    private int z(com.bytedance.adsdk.z.z.g.g gVar) throws IOException {
        int i;
        Iterator<gc> it = this.gc.iterator();
        int i2 = 33;
        while (it.hasNext()) {
            i2 += it.next().f283a + 12;
        }
        for (gc gcVar : this.f280a) {
            if (gcVar instanceof uy) {
                i = gcVar.f283a + 12;
            } else if (gcVar instanceof e) {
                i = gcVar.f283a + 8;
            }
            i2 += i;
        }
        int length = i2 + ls.length;
        gVar.dl(length);
        gVar.z(pf);
        gVar.g(13);
        int iZ = gVar.z();
        gVar.z(wp.z);
        gVar.g(this.gz);
        gVar.g(this.fo);
        gVar.z(this.dl);
        CRC32 crc32Z = z();
        crc32Z.reset();
        crc32Z.update(gVar.g(), iZ, 17);
        gVar.g((int) crc32Z.getValue());
        for (gc gcVar2 : this.gc) {
            if (!(gcVar2 instanceof kb)) {
                ((com.bytedance.adsdk.z.z.g.z) this.e).d_();
                ((com.bytedance.adsdk.z.z.g.z) this.e).z(gcVar2.e);
                ((com.bytedance.adsdk.z.z.g.z) this.e).z(gVar.g(), gVar.z(), gcVar2.f283a + 12);
                gVar.a(gcVar2.f283a + 12);
            }
        }
        for (gc gcVar3 : this.f280a) {
            if (gcVar3 instanceof uy) {
                ((com.bytedance.adsdk.z.z.g.z) this.e).d_();
                ((com.bytedance.adsdk.z.z.g.z) this.e).z(gcVar3.e);
                ((com.bytedance.adsdk.z.z.g.z) this.e).z(gVar.g(), gVar.z(), gcVar3.f283a + 12);
                gVar.a(gcVar3.f283a + 12);
            } else if (gcVar3 instanceof e) {
                gVar.g(gcVar3.f283a - 4);
                int iZ2 = gVar.z();
                gVar.z(uy.z);
                ((com.bytedance.adsdk.z.z.g.z) this.e).d_();
                ((com.bytedance.adsdk.z.z.g.z) this.e).z(gcVar3.e + 4 + 4 + 4);
                ((com.bytedance.adsdk.z.z.g.z) this.e).z(gVar.g(), gVar.z(), gcVar3.f283a - 4);
                gVar.a(gcVar3.f283a - 4);
                crc32Z.reset();
                crc32Z.update(gVar.g(), iZ2, gcVar3.f283a);
                gVar.g((int) crc32Z.getValue());
            }
        }
        gVar.z(ls);
        return length;
    }

    @Override // com.bytedance.adsdk.z.z.z.gz
    public Bitmap z(Canvas canvas, Paint paint, int i, Bitmap bitmap, com.bytedance.adsdk.z.z.g.g gVar) {
        Bitmap bitmapDecodeByteArray;
        try {
            int iZ = z(gVar);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = i;
            options.inMutable = true;
            options.inBitmap = bitmap;
            byte[] bArrG = gVar.g();
            try {
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrG, 0, iZ, options);
            } catch (IllegalArgumentException unused) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = i;
                options2.inMutable = true;
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrG, 0, iZ, options2);
            }
            if (!m && bitmapDecodeByteArray == null) {
                throw new AssertionError();
            }
            this.i.left = 0;
            this.i.top = 0;
            this.i.right = bitmapDecodeByteArray.getWidth();
            this.i.bottom = bitmapDecodeByteArray.getHeight();
            float f = i;
            this.v.left = (int) (this.uy / f);
            this.v.top = (int) (this.kb / f);
            this.v.right = (int) ((this.uy / f) + bitmapDecodeByteArray.getWidth());
            this.v.bottom = (int) ((this.kb / f) + bitmapDecodeByteArray.getHeight());
            canvas.drawBitmap(bitmapDecodeByteArray, this.i, this.v, paint);
            return bitmapDecodeByteArray;
        } catch (IOException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return null;
        }
    }
}
