package com.king.zxing;

import com.google.zxing.BarcodeFormat;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: DecodeFormatManager.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l {
    public static final Set<BarcodeFormat> a;
    public static final Set<BarcodeFormat> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<BarcodeFormat> f16507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<BarcodeFormat> f16508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<BarcodeFormat> f16509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<BarcodeFormat> f16510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set<BarcodeFormat> f16511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Map<String, Set<BarcodeFormat>> f16512h;

    static {
        Pattern.compile(",");
        f16508d = EnumSet.of(BarcodeFormat.QR_CODE);
        f16509e = EnumSet.of(BarcodeFormat.DATA_MATRIX);
        f16510f = EnumSet.of(BarcodeFormat.AZTEC);
        f16511g = EnumSet.of(BarcodeFormat.PDF_417);
        a = EnumSet.of(BarcodeFormat.UPC_A, BarcodeFormat.UPC_E, BarcodeFormat.EAN_13, BarcodeFormat.EAN_8, BarcodeFormat.RSS_14, BarcodeFormat.RSS_EXPANDED);
        b = EnumSet.of(BarcodeFormat.CODE_39, BarcodeFormat.CODE_93, BarcodeFormat.CODE_128, BarcodeFormat.ITF, BarcodeFormat.CODABAR);
        f16507c = EnumSet.copyOf((Collection) a);
        f16507c.addAll(b);
        f16512h = new HashMap();
        f16512h.put("ONE_D_MODE", f16507c);
        f16512h.put("PRODUCT_MODE", a);
        f16512h.put("QR_CODE_MODE", f16508d);
        f16512h.put("DATA_MATRIX_MODE", f16509e);
        f16512h.put("AZTEC_MODE", f16510f);
        f16512h.put("PDF417_MODE", f16511g);
    }
}
