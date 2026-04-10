package com.kwad.components.ad.reward.presenter.d;

import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.ad.reward.presenter.d.b.c;
import com.kwad.components.ad.reward.presenter.d.b.d;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class a extends com.kwad.components.ad.reward.presenter.b implements g, j {
    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, n nVar) {
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dk() {
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    public a() {
        dt();
    }

    protected void dt() {
        a(new d());
        a(new com.kwad.components.ad.reward.presenter.d.b.a());
        a(new com.kwad.components.ad.reward.presenter.d.b.b());
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        dm();
    }

    private void dm() {
        this.tm.b(this);
        com.kwad.components.ad.reward.a.gg().a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.c(this);
        com.kwad.components.ad.reward.a.gg().b(this);
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void cX() {
        fa();
    }

    private void fa() {
        List<Presenter> listNM = NM();
        if (listNM == null) {
            return;
        }
        for (Object obj : listNM) {
            if (obj instanceof c) {
                ((c) obj).jO();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dl() {
        fa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(g gVar) {
        return getPriority() - gVar.getPriority();
    }
}
