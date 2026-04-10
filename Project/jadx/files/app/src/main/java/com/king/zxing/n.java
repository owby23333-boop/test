package com.king.zxing;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: DecodeThread.java */
/* JADX INFO: loaded from: classes2.dex */
final class n extends Thread {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Context f16517s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final com.king.zxing.camera.d f16518t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Handler f16520v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private CaptureHandler f16521w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final CountDownLatch f16522x = new CountDownLatch(1);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Map<DecodeHintType, Object> f16519u = new EnumMap(DecodeHintType.class);

    n(Context context, com.king.zxing.camera.d dVar, CaptureHandler captureHandler, Collection<BarcodeFormat> collection, Map<DecodeHintType, Object> map, String str, com.google.zxing.j jVar) {
        this.f16517s = context;
        this.f16518t = dVar;
        this.f16521w = captureHandler;
        if (map != null) {
            this.f16519u.putAll(map);
        }
        if (collection == null || collection.isEmpty()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            collection = EnumSet.noneOf(BarcodeFormat.class);
            if (defaultSharedPreferences.getBoolean("preferences_decode_1D_product", true)) {
                collection.addAll(l.a);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_1D_industrial", true)) {
                collection.addAll(l.b);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_QR", true)) {
                collection.addAll(l.f16508d);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_Data_Matrix", true)) {
                collection.addAll(l.f16509e);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_Aztec", false)) {
                collection.addAll(l.f16510f);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_PDF417", false)) {
                collection.addAll(l.f16511g);
            }
        }
        this.f16519u.put(DecodeHintType.POSSIBLE_FORMATS, collection);
        if (str != null) {
            this.f16519u.put(DecodeHintType.CHARACTER_SET, str);
        }
        this.f16519u.put(DecodeHintType.NEED_RESULT_POINT_CALLBACK, jVar);
        com.king.zxing.r.b.b("Hints: " + this.f16519u);
    }

    Handler a() {
        try {
            this.f16522x.await();
        } catch (InterruptedException unused) {
        }
        return this.f16520v;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f16520v = new m(this.f16517s, this.f16518t, this.f16521w, this.f16519u);
        this.f16522x.countDown();
        Looper.loop();
    }
}
