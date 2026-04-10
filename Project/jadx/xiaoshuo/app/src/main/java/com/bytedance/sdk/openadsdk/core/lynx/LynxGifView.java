package com.bytedance.sdk.openadsdk.core.lynx;

import android.graphics.Canvas;
import android.graphics.Path;
import com.bytedance.sdk.openadsdk.core.widget.GifView;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.utils.LynxBackground;

/* JADX INFO: loaded from: classes10.dex */
public class LynxGifView extends GifView {
    e e;

    @Override // com.bytedance.sdk.openadsdk.core.widget.GifView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int iSave;
        e eVar = this.e;
        if (eVar != null) {
            LynxBackground lynxBackground = eVar.getLynxBackground();
            BackgroundDrawable drawable2 = lynxBackground != null ? lynxBackground.getDrawable() : null;
            if (drawable2 instanceof BackgroundDrawable) {
                Path innerClipPathForBorderRadius = drawable2.getInnerClipPathForBorderRadius();
                if (innerClipPathForBorderRadius != null) {
                    iSave = canvas.save();
                    canvas.clipPath(innerClipPathForBorderRadius);
                } else {
                    iSave = 0;
                }
                super.onDraw(canvas);
                if (innerClipPathForBorderRadius != null) {
                    canvas.restoreToCount(iSave);
                    return;
                }
                return;
            }
        }
        super.onDraw(canvas);
    }
}
