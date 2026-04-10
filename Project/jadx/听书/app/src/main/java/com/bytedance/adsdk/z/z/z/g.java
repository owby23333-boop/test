package com.bytedance.adsdk.z.z.z;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.bytedance.adsdk.z.z.z.fo;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g extends fo<com.bytedance.adsdk.z.z.g.z, com.bytedance.adsdk.z.z.g.g> {
    private com.bytedance.adsdk.z.z.g.g e;
    private final Paint fo;
    private int gz;
    private final z uy;

    private static class z {
        ByteBuffer dl;
        Rect g;
        byte z;

        private z() {
            this.g = new Rect();
        }
    }

    public g(com.bytedance.adsdk.z.z.dl.g gVar, fo.z zVar) {
        super(gVar, zVar);
        Paint paint = new Paint();
        this.fo = paint;
        this.uy = new z();
        paint.setAntiAlias(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.adsdk.z.z.z.fo
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.z.z.g.g a() {
        if (this.e == null) {
            this.e = new com.bytedance.adsdk.z.z.g.g();
        }
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.adsdk.z.z.z.fo
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.z.z.g.z dl(com.bytedance.adsdk.z.z.g.m mVar) {
        return new com.bytedance.adsdk.z.z.g.z(mVar);
    }

    @Override // com.bytedance.adsdk.z.z.z.fo
    protected int g() {
        return this.gz;
    }

    @Override // com.bytedance.adsdk.z.z.z.fo
    protected void dl() {
        this.uy.dl = null;
        this.e = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.adsdk.z.z.z.fo
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Rect g(com.bytedance.adsdk.z.z.g.z zVar) throws IOException {
        List<gc> listZ = a.z(zVar);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[0];
        Iterator<gc> it = listZ.iterator();
        dl dlVar = null;
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            gc next = it.next();
            if (next instanceof com.bytedance.adsdk.z.z.z.z) {
                this.gz = ((com.bytedance.adsdk.z.z.z.z) next).dl;
                z2 = true;
            } else if (next instanceof m) {
                dlVar = new dl(zVar, (m) next);
                dlVar.gc = arrayList;
                dlVar.dl = bArr;
                this.z.add(dlVar);
            } else if (next instanceof e) {
                if (dlVar != null) {
                    dlVar.f280a.add(next);
                }
            } else if (next instanceof uy) {
                if (!z2) {
                    i iVar = new i(zVar);
                    iVar.gz = i;
                    iVar.fo = i2;
                    this.z.add(iVar);
                    this.gz = 1;
                    break;
                }
                if (dlVar != null) {
                    dlVar.f280a.add(next);
                }
            } else if (next instanceof wp) {
                wp wpVar = (wp) next;
                i = wpVar.g;
                i2 = wpVar.dl;
                bArr = wpVar.gz;
            } else if (!(next instanceof kb)) {
                arrayList.add(next);
            }
        }
        int i3 = i * i2;
        this.gc = ByteBuffer.allocate(((i3 / (this.dl * this.dl)) + 1) * 4);
        this.uy.dl = ByteBuffer.allocate(((i3 / (this.dl * this.dl)) + 1) * 4);
        return new Rect(0, 0, i, i2);
    }

    @Override // com.bytedance.adsdk.z.z.z.fo
    protected void z(gz<com.bytedance.adsdk.z.z.g.z, com.bytedance.adsdk.z.z.g.g> gzVar) {
        if (gzVar == null || this.m == null) {
            return;
        }
        try {
            Bitmap bitmapZ = z(this.m.width() / this.dl, this.m.height() / this.dl);
            Canvas canvas = this.f281a.get(bitmapZ);
            if (canvas == null) {
                canvas = new Canvas(bitmapZ);
                this.f281a.put(bitmapZ, canvas);
            }
            Canvas canvas2 = canvas;
            if (gzVar instanceof dl) {
                this.gc.rewind();
                bitmapZ.copyPixelsFromBuffer(this.gc);
                if (this.g == 0) {
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                } else {
                    canvas2.save();
                    canvas2.clipRect(this.uy.g);
                    byte b = this.uy.z;
                    if (b == 1) {
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    } else if (b == 2) {
                        this.uy.dl.rewind();
                        bitmapZ.copyPixelsFromBuffer(this.uy.dl);
                    }
                    canvas2.restore();
                }
                if (((dl) gzVar).g == 2 && this.uy.z != 2) {
                    this.uy.dl.rewind();
                    bitmapZ.copyPixelsToBuffer(this.uy.dl);
                }
                this.uy.z = ((dl) gzVar).g;
                canvas2.save();
                if (((dl) gzVar).z == 0) {
                    canvas2.clipRect(gzVar.uy / this.dl, gzVar.kb / this.dl, (gzVar.uy + gzVar.gz) / this.dl, (gzVar.kb + gzVar.fo) / this.dl);
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                }
                this.uy.g.set(gzVar.uy / this.dl, gzVar.kb / this.dl, (gzVar.uy + gzVar.gz) / this.dl, (gzVar.kb + gzVar.fo) / this.dl);
                canvas2.restore();
            }
            Bitmap bitmapZ2 = z(gzVar.gz, gzVar.fo);
            z(gzVar.z(canvas2, this.fo, this.dl, bitmapZ2, a()));
            z(bitmapZ2);
            this.gc.rewind();
            bitmapZ.copyPixelsToBuffer(this.gc);
            z(bitmapZ);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }
}
