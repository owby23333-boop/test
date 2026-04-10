package xyz.doikki.videoplayer.render;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public class TextureRenderViewFactory extends RenderViewFactory {
    public static TextureRenderViewFactory create() {
        return new TextureRenderViewFactory();
    }

    @Override // xyz.doikki.videoplayer.render.RenderViewFactory
    public IRenderView createRenderView(Context context) {
        return new TextureRenderView(context);
    }
}
