package com.kwad.components.core.n.kwai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    @NonNull
    public final b Kj;

    @NonNull
    public final com.kwad.components.core.n.b Oo;

    @Nullable
    public List<String> Op;
    public boolean Oq;
    public boolean Or;

    @Nullable
    public d Os;

    /* JADX INFO: renamed from: com.kwad.components.core.n.kwai.a$a, reason: collision with other inner class name */
    public static class C0403a {
        public b Kj;
        public com.kwad.components.core.n.b Oo;
        public boolean Oq;
        public boolean Or;

        public final C0403a a(@NonNull com.kwad.components.core.n.b bVar) {
            this.Oo = bVar;
            return this;
        }

        public final C0403a aD(boolean z2) {
            this.Oq = true;
            return this;
        }

        public final C0403a aE(boolean z2) {
            this.Or = z2;
            return this;
        }

        public final C0403a e(b bVar) {
            this.Kj = bVar;
            return this;
        }

        public final a pz() {
            if (com.kwad.components.ad.d.a.bI.booleanValue() && (this.Kj == null || this.Oo == null)) {
                throw new IllegalStateException("AdRequestParams build Illegal");
            }
            return new a(this, (byte) 0);
        }
    }

    private a(C0403a c0403a) {
        this.Kj = c0403a.Kj;
        this.Oo = c0403a.Oo;
        this.Oq = c0403a.Oq;
        this.Or = c0403a.Or;
    }

    /* synthetic */ a(C0403a c0403a, byte b) {
        this(c0403a);
    }

    public static void a(@NonNull a aVar, int i2, String str, boolean z2) {
        aVar.Oo.a(i2, str, z2);
    }

    public static void a(@NonNull a aVar, AdResultData adResultData, boolean z2) {
        boolean zIsAdResultDataEmpty = adResultData.isAdResultDataEmpty();
        com.kwad.components.core.n.b bVar = aVar.Oo;
        if (!zIsAdResultDataEmpty) {
            bVar.a(adResultData, z2);
        } else {
            f fVar = f.afS;
            bVar.a(fVar.errorCode, fVar.msg, z2);
        }
    }

    public final int getAdNum() {
        SceneImpl sceneImpl = this.Kj.Ot;
        if (sceneImpl != null) {
            return sceneImpl.getAdNum();
        }
        return 1;
    }

    public final int getAdStyle() {
        SceneImpl sceneImpl = this.Kj.Ot;
        if (sceneImpl != null) {
            return sceneImpl.adStyle;
        }
        return 0;
    }

    public final long getPosId() {
        SceneImpl sceneImpl = this.Kj.Ot;
        if (sceneImpl != null) {
            return sceneImpl.getPosId();
        }
        return -1L;
    }
}
