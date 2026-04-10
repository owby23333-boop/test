package com.anythink.expressad.exoplayer.k;

import android.net.NetworkInfo;
import android.os.SystemClock;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.anythink.expressad.exoplayer.a.b;
import com.anythink.expressad.exoplayer.ae;
import com.anythink.expressad.exoplayer.h.t;
import com.anythink.expressad.exoplayer.i.e;
import com.taobao.accs.flowcontrol.FlowControl;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements com.anythink.expressad.exoplayer.a.b {
    private static final String a = "EventLogger";
    private static final int b = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final NumberFormat f9845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final com.anythink.expressad.exoplayer.i.e f9846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ae.b f9847e = new ae.b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ae.a f9848f = new ae.a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f9849g = SystemClock.elapsedRealtime();

    static {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        f9845c = numberFormat;
        numberFormat.setMinimumFractionDigits(2);
        f9845c.setMaximumFractionDigits(2);
        f9845c.setGroupingUsed(false);
    }

    private i(@Nullable com.anythink.expressad.exoplayer.i.e eVar) {
        this.f9846d = eVar;
    }

    private static String a(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "?" : "ENDED" : "READY" : "BUFFERING" : "IDLE";
    }

    private static String a(int i2, int i3) {
        return i2 < 2 ? "N/A" : i3 != 0 ? i3 != 8 ? i3 != 16 ? "?" : "YES" : "YES_NOT_SEAMLESS" : "NO";
    }

    private static String a(boolean z2) {
        return z2 ? "[X]" : "[ ]";
    }

    private static void a(String str) {
    }

    private static void a(String str, Throwable th) {
    }

    private static String b(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "?" : "YES" : "NO_EXCEEDS_CAPABILITIES" : "NO_UNSUPPORTED_DRM" : "NO_UNSUPPORTED_TYPE" : "NO";
    }

    private static String c(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? "?" : FlowControl.SERVICE_ALL : "ONE" : "OFF";
    }

    private static String d(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "?" : "INTERNAL" : "AD_INSERTION" : "SEEK_ADJUSTMENT" : "SEEK" : "PERIOD_TRANSITION";
    }

    private static String e(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? "?" : "DYNAMIC" : "RESET" : "PREPARED";
    }

    private String i(b.a aVar) {
        String str = "window=" + aVar.f8455c;
        if (aVar.f8456d != null) {
            str = str + ", period=" + aVar.f8456d.a;
            if (aVar.f8456d.a()) {
                str = (str + ", adGroup=" + aVar.f8456d.b) + ", ad=" + aVar.f8456d.f9418c;
            }
        }
        return a(aVar.a - this.f9849g) + ", " + a(aVar.f8458f) + ", " + str;
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a() {
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, boolean z2, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(z2);
        sb.append(", ");
        sb.append(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "?" : "ENDED" : "READY" : "BUFFERING" : "IDLE");
        a(aVar, CallMraidJS.b, sb.toString());
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void b() {
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void b(b.a aVar, boolean z2) {
        a(aVar, CallMraidJS.f8282e, Boolean.toString(z2));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void c() {
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void c(b.a aVar, int i2) {
        a(aVar, "repeatMode", i2 != 0 ? i2 != 1 ? i2 != 2 ? "?" : FlowControl.SERVICE_ALL : "ONE" : "OFF");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void d() {
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void d(b.a aVar, int i2) {
        a(aVar, "decoderEnabled", f(i2));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void e(b.a aVar, int i2) {
        a(aVar, "decoderDisabled", f(i2));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void f(b.a aVar, int i2) {
        a(aVar, "audioSessionId", Integer.toString(i2));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void g(b.a aVar, int i2) {
        a(aVar, "droppedFrames", Integer.toString(i2));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void h(b.a aVar) {
        a(aVar, "drmKeysRemoved");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, boolean z2) {
        a(aVar, "shuffleModeEnabled", Boolean.toString(z2));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void b(b.a aVar, int i2) {
        a(aVar, "positionDiscontinuity", i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "?" : "INTERNAL" : "AD_INSERTION" : "SEEK_ADJUSTMENT" : "SEEK" : "PERIOD_TRANSITION");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void c(b.a aVar) {
        a(aVar, "mediaPeriodCreated");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void d(b.a aVar) {
        a(aVar, "mediaPeriodReleased");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void e(b.a aVar) {
        a(aVar, "mediaPeriodReadingStarted");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void f(b.a aVar) {
        a(aVar, "drmKeysLoaded");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void g(b.a aVar) {
        a(aVar, "drmKeysRestored");
    }

    private static String f(int i2) {
        if (i2 == 0) {
            return "default";
        }
        if (i2 == 1) {
            return o.b;
        }
        if (i2 == 2) {
            return "video";
        }
        if (i2 == 3) {
            return "text";
        }
        if (i2 == 4) {
            return "metadata";
        }
        if (i2 == 5) {
            return "none";
        }
        if (i2 < 10000) {
            return "?";
        }
        return "custom (" + i2 + com.umeng.message.proguard.ad.f20406s;
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar) {
        a(aVar, "seekStarted");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void b(b.a aVar) {
        a(aVar, "seekProcessed");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, com.anythink.expressad.exoplayer.v vVar) {
        a(aVar, "playbackParameters", af.a("speed=%.2f, pitch=%.2f, skipSilence=%s", Float.valueOf(vVar.b), Float.valueOf(vVar.f10069c), Boolean.valueOf(vVar.f10070d)));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void b(b.a aVar, int i2, int i3) {
        a(aVar, "videoSizeChanged", i2 + ", " + i3);
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void b(b.a aVar, t.c cVar) {
        a(aVar, "upstreamDiscarded", com.anythink.expressad.exoplayer.m.c(cVar.f9436c));
    }

    private String b(b.a aVar, String str) {
        return str + " [" + i(aVar) + "]";
    }

    private String b(b.a aVar, String str, String str2) {
        return str + " [" + i(aVar) + ", " + str2 + "]";
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, int i2) {
        int iC = aVar.b.c();
        int iB = aVar.b.b();
        StringBuilder sb = new StringBuilder("timelineChanged [");
        sb.append(i(aVar));
        sb.append(", periodCount=");
        sb.append(iC);
        sb.append(", windowCount=");
        sb.append(iB);
        sb.append(", reason=");
        sb.append(i2 != 0 ? i2 != 1 ? i2 != 2 ? "?" : "DYNAMIC" : "RESET" : "PREPARED");
        sb.toString();
        for (int i3 = 0; i3 < Math.min(iC, 3); i3++) {
            aVar.b.a(i3, this.f9848f, false);
            String str = "  period [" + a(com.anythink.expressad.exoplayer.b.a(this.f9848f.f8470d)) + "]";
        }
        for (int i4 = 0; i4 < Math.min(iB, 3); i4++) {
            aVar.b.a(i4, this.f9847e, false);
            String str2 = "  window [" + a(com.anythink.expressad.exoplayer.b.a(this.f9847e.f8479i)) + ", " + this.f9847e.f8474d + ", " + this.f9847e.f8475e + "]";
        }
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, com.anythink.expressad.exoplayer.i.g gVar) {
        int i2;
        com.anythink.expressad.exoplayer.i.e eVar = this.f9846d;
        e.a aVarA = eVar != null ? eVar.a() : null;
        if (aVarA == null) {
            a(aVar, "tracksChanged", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        String str = "tracksChanged [" + i(aVar) + ", ";
        int iA = aVarA.a();
        int i3 = 0;
        while (i3 < iA) {
            com.anythink.expressad.exoplayer.h.af afVarB = aVarA.b(i3);
            com.anythink.expressad.exoplayer.i.f fVarA = gVar.a(i3);
            if (afVarB.b > 0) {
                String str2 = "  Renderer:" + i3 + " [";
                int i4 = 0;
                while (i4 < afVarB.b) {
                    com.anythink.expressad.exoplayer.h.ae aeVarA = afVarB.a(i4);
                    int i5 = aeVarA.a;
                    int iA2 = aVarA.a(i3, i4);
                    int i6 = iA;
                    String str3 = "    Group:" + i4 + ", adaptive_supported=" + (i5 < 2 ? "N/A" : iA2 != 0 ? iA2 != 8 ? iA2 != 16 ? "?" : "YES" : "YES_NOT_SEAMLESS" : "NO") + " [";
                    int i7 = 0;
                    while (i7 < aeVarA.a) {
                        String str4 = "      " + a((fVarA == null || fVarA.f() != aeVarA || fVarA.c(i7) == -1) ? false : true) + " Track:" + i7 + ", " + com.anythink.expressad.exoplayer.m.c(aeVarA.a(i7)) + ", supported=" + b(aVarA.a(i3, i4, i7));
                        i7++;
                        afVarB = afVarB;
                    }
                    i4++;
                    iA = i6;
                }
                i2 = iA;
                if (fVarA != null) {
                    int i8 = 0;
                    while (true) {
                        if (i8 >= fVarA.g()) {
                            break;
                        }
                        com.anythink.expressad.exoplayer.g.a aVar2 = fVarA.a(i8).f9988f;
                        if (aVar2 != null) {
                            a(aVar2, "      ");
                            break;
                        }
                        i8++;
                    }
                }
            } else {
                i2 = iA;
            }
            i3++;
            iA = i2;
        }
        com.anythink.expressad.exoplayer.h.af afVarB2 = aVarA.b();
        if (afVarB2.b > 0) {
            for (int i9 = 0; i9 < afVarB2.b; i9++) {
                String str5 = "    Group:" + i9 + " [";
                com.anythink.expressad.exoplayer.h.ae aeVarA2 = afVarB2.a(i9);
                for (int i10 = 0; i10 < aeVarA2.a; i10++) {
                    String str6 = "      " + a(false) + " Track:" + i10 + ", " + com.anythink.expressad.exoplayer.m.c(aeVarA2.a(i10)) + ", supported=" + b(0);
                }
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, com.anythink.expressad.exoplayer.g.a aVar2) {
        String str = "metadata [" + i(aVar) + ", ";
        a(aVar2, "  ");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, int i2, String str) {
        a(aVar, "decoderInitialized", f(i2) + ", " + str);
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, int i2, com.anythink.expressad.exoplayer.m mVar) {
        a(aVar, "decoderInputFormatChanged", f(i2) + ", " + com.anythink.expressad.exoplayer.m.c(mVar));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, int i2, long j2, long j3) {
        a(aVar, "audioTrackUnderrun", i2 + ", " + j2 + ", " + j3 + "]", (Throwable) null);
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, Surface surface) {
        a(aVar, "renderedFirstFrame", surface.toString());
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, IOException iOException) {
        a(aVar, "loadError", (Exception) iOException);
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, int i2, int i3) {
        a(aVar, "viewportSizeChanged", i2 + ", " + i3);
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, @Nullable NetworkInfo networkInfo) {
        a(aVar, "networkTypeChanged", networkInfo == null ? "none" : networkInfo.toString());
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, t.c cVar) {
        a(aVar, "downstreamFormatChanged", com.anythink.expressad.exoplayer.m.c(cVar.f9436c));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, Exception exc) {
        a(aVar, "drmSessionManagerError", exc);
    }

    private void a(b.a aVar, String str) {
        b(aVar, str);
    }

    private void a(b.a aVar, String str, String str2) {
        b(aVar, str, str2);
    }

    private void a(b.a aVar, String str, Throwable th) {
        a(b(aVar, str), th);
    }

    private void a(b.a aVar, String str, String str2, Throwable th) {
        a(b(aVar, str, str2), th);
    }

    private void a(b.a aVar, String str, Exception exc) {
        a(aVar, "internalError", str, exc);
    }

    private static void a(com.anythink.expressad.exoplayer.g.a aVar, String str) {
        for (int i2 = 0; i2 < aVar.a(); i2++) {
            String str2 = str + aVar.a(i2);
        }
    }

    private static String a(long j2) {
        return j2 == com.anythink.expressad.exoplayer.b.b ? "?" : f9845c.format(j2 / 1000.0f);
    }

    private static String a(com.anythink.expressad.exoplayer.i.f fVar, com.anythink.expressad.exoplayer.h.ae aeVar, int i2) {
        return a((fVar == null || fVar.f() != aeVar || fVar.c(i2) == -1) ? false : true);
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, com.anythink.expressad.exoplayer.g gVar) {
        a(b(aVar, "playerFailed"), gVar);
    }
}
