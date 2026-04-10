package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.DexLoader;

/* JADX INFO: loaded from: classes3.dex */
public class TbsMediaFactory {
    private Context a;
    private u b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DexLoader f18916c = null;

    public TbsMediaFactory(Context context) {
        this.a = null;
        this.a = context.getApplicationContext();
        a();
    }

    private void a() {
        if (this.a == null) {
            return;
        }
        if (this.b == null) {
            g.a(true).a(this.a, false, false);
            this.b = g.a(true).a();
            u uVar = this.b;
            if (uVar != null) {
                this.f18916c = uVar.c();
            }
        }
        if (this.b == null || this.f18916c == null) {
            throw new RuntimeException("tbs core dex(s) load failure !!!");
        }
    }

    public TbsMediaPlayer createPlayer() {
        DexLoader dexLoader;
        if (this.b == null || (dexLoader = this.f18916c) == null) {
            throw new RuntimeException("tbs core dex(s) did not loaded !!!");
        }
        return new TbsMediaPlayer(new p(dexLoader, this.a));
    }
}
