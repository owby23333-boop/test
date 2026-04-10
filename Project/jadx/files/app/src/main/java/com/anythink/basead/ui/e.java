package com.anythink.basead.ui;

import android.view.View;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e implements View.OnClickListener {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final /* synthetic */ PlayerView f6325s;

    public /* synthetic */ e(PlayerView playerView) {
        this.f6325s = playerView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f6325s.a(view);
    }
}
