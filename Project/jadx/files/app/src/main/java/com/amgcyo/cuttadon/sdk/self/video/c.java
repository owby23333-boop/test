package com.amgcyo.cuttadon.sdk.self.video;

import android.content.Context;
import xyz.doikki.videoplayer.render.IRenderView;
import xyz.doikki.videoplayer.render.RenderViewFactory;
import xyz.doikki.videoplayer.render.TextureRenderView;

/* JADX INFO: compiled from: TikTokRenderViewFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends RenderViewFactory {
    public static c create() {
        return new c();
    }

    @Override // xyz.doikki.videoplayer.render.RenderViewFactory
    public IRenderView createRenderView(Context context) {
        return new b(new TextureRenderView(context));
    }
}
