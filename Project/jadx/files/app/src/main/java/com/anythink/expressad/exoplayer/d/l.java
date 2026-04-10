package com.anythink.expressad.exoplayer.d;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.d.j;
import com.anythink.expressad.exoplayer.k.af;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(23)
public final class l implements j<k> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f8826g = "cenc";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final UUID f8827h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MediaDrm f8828i;

    @SuppressLint({"WrongConstant"})
    private l(UUID uuid) {
        com.anythink.expressad.exoplayer.k.a.a(uuid);
        com.anythink.expressad.exoplayer.k.a.a(!com.anythink.expressad.exoplayer.b.bi.equals(uuid), "Use C.CLEARKEY_UUID instead");
        if (af.a < 27 && com.anythink.expressad.exoplayer.b.bj.equals(uuid)) {
            uuid = com.anythink.expressad.exoplayer.b.bi;
        }
        this.f8827h = uuid;
        this.f8828i = new MediaDrm(uuid);
        if (com.anythink.expressad.exoplayer.b.bk.equals(uuid) && "ASUS_Z00AD".equals(af.f9816d)) {
            this.f8828i.setPropertyString("securityLevel", "L3");
        }
    }

    public static l a(UUID uuid) throws o {
        try {
            return new l(uuid);
        } catch (Exception e2) {
            throw new o(e2);
        }
    }

    private static boolean d() {
        return "ASUS_Z00AD".equals(af.f9816d);
    }

    private k e(byte[] bArr) {
        return new k(new MediaCrypto(this.f8827h, bArr), af.a < 21 && com.anythink.expressad.exoplayer.b.bk.equals(this.f8827h) && "L3".equals(a("securityLevel")));
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final j.h b() {
        MediaDrm.ProvisionRequest provisionRequest = this.f8828i.getProvisionRequest();
        return new j.c(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final Map<String, String> c(byte[] bArr) {
        return this.f8828i.queryKeyStatus(bArr);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final void c() {
        this.f8828i.release();
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final /* synthetic */ i d(byte[] bArr) {
        return new k(new MediaCrypto(this.f8827h, bArr), af.a < 21 && com.anythink.expressad.exoplayer.b.bk.equals(this.f8827h) && "L3".equals(a("securityLevel")));
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final void a(final j.f<? super k> fVar) {
        this.f8828i.setOnEventListener(new MediaDrm.OnEventListener() { // from class: com.anythink.expressad.exoplayer.d.l.1
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(@NonNull MediaDrm mediaDrm, @Nullable byte[] bArr, int i2, int i3, byte[] bArr2) {
                fVar.a(bArr, i2);
            }
        });
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final void b(byte[] bArr) throws DeniedByServerException {
        this.f8828i.provideProvisionResponse(bArr);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final void a(final j.g<? super k> gVar) {
        if (af.a >= 23) {
            this.f8828i.setOnKeyStatusChangeListener(gVar == null ? null : new MediaDrm.OnKeyStatusChangeListener() { // from class: com.anythink.expressad.exoplayer.d.l.2
                @Override // android.media.MediaDrm.OnKeyStatusChangeListener
                public final void onKeyStatusChange(@NonNull MediaDrm mediaDrm, @NonNull byte[] bArr, @NonNull List<MediaDrm.KeyStatus> list, boolean z2) {
                    ArrayList arrayList = new ArrayList();
                    for (MediaDrm.KeyStatus keyStatus : list) {
                        arrayList.add(new j.b(keyStatus.getStatusCode(), keyStatus.getKeyId()));
                    }
                }
            }, (Handler) null);
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final void b(byte[] bArr, byte[] bArr2) {
        this.f8828i.restoreKeys(bArr, bArr2);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final byte[] b(String str) {
        return this.f8828i.getPropertyByteArray(str);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final byte[] a() {
        return this.f8828i.openSession();
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final void a(byte[] bArr) {
        this.f8828i.closeSession(bArr);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final j.d a(byte[] bArr, byte[] bArr2, String str, int i2, HashMap<String, String> map) throws NotProvisionedException {
        byte[] bArrA;
        byte[] bArr3 = (((af.a >= 21 || !com.anythink.expressad.exoplayer.b.bk.equals(this.f8827h)) && !(com.anythink.expressad.exoplayer.b.bl.equals(this.f8827h) && "Amazon".equals(af.f9815c) && ("AFTB".equals(af.f9816d) || "AFTS".equals(af.f9816d) || "AFTM".equals(af.f9816d)))) || (bArrA = com.anythink.expressad.exoplayer.e.a.h.a(bArr2, this.f8827h)) == null) ? bArr2 : bArrA;
        if (af.a < 26 && com.anythink.expressad.exoplayer.b.bj.equals(this.f8827h) && (com.anythink.expressad.exoplayer.k.o.f9860e.equals(str) || com.anythink.expressad.exoplayer.k.o.f9872q.equals(str))) {
            str = "cenc";
        }
        MediaDrm.KeyRequest keyRequest = this.f8828i.getKeyRequest(bArr, bArr3, str, i2, map);
        byte[] data = keyRequest.getData();
        if (com.anythink.expressad.exoplayer.b.bj.equals(this.f8827h) && af.a < 27) {
            data = af.c(af.a(data).replace('+', '-').replace('/', '_'));
        }
        return new j.a(data, keyRequest.getDefaultUrl());
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final byte[] a(byte[] bArr, byte[] bArr2) {
        if (com.anythink.expressad.exoplayer.b.bj.equals(this.f8827h)) {
            bArr2 = a.a(bArr2);
        }
        return this.f8828i.provideKeyResponse(bArr, bArr2);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final String a(String str) {
        return this.f8828i.getPropertyString(str);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final void a(String str, String str2) {
        this.f8828i.setPropertyString(str, str2);
    }

    @Override // com.anythink.expressad.exoplayer.d.j
    public final void a(String str, byte[] bArr) {
        this.f8828i.setPropertyByteArray(str, bArr);
    }
}
