package com.kwad.components.ad.reward.presenter.c;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.d.h;
import com.kwad.components.ad.reward.d.l;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.presenter.c.a.c;
import com.kwad.components.ad.reward.presenter.c.a.d;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.a.i;
import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class a extends com.kwad.components.ad.reward.presenter.a implements f, h, com.kwad.components.core.webview.a.d.b {
    public a() {
        cj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        return getPriority() - fVar.getPriority();
    }

    private void cc() {
        this.qS.b(this);
        com.kwad.components.ad.reward.b.fz().a(this);
    }

    private void ew() {
        List<Presenter> listBr = Br();
        if (listBr == null) {
            return;
        }
        for (Object obj : listBr) {
            if (obj instanceof c) {
                ((c) obj).iW();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void a(PlayableSource playableSource, @Nullable l lVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (j.b(this.qS)) {
            com.kwad.components.core.webview.a.c.a.rE().a(this);
        } else {
            cc();
        }
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bM() {
        ew();
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void ca() {
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void cb() {
        ew();
    }

    protected void cj() {
        a(new d());
        a(new com.kwad.components.ad.reward.presenter.c.a.a());
        a(new com.kwad.components.ad.reward.presenter.c.a.b());
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final int getPriority() {
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rE().b(this);
        this.qS.c(this);
        com.kwad.components.ad.reward.b.fz().b(this);
    }

    @Override // com.kwad.components.core.webview.a.d.b
    public final void u(String str) {
        if (i.b("ksad-video-top-bar", this.qS.mAdTemplate).equals(str)) {
            cc();
        }
    }
}
