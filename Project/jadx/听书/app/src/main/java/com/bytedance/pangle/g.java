package com.bytedance.pangle;

import android.os.Build;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.pangle.flipped.FlippedV2Impl;
import com.bytedance.pangle.log.IZeusReporter;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static void z() {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_FLIPPED, TtmlNode.START);
        g().invokeHiddenApiRestrictions();
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_FLIPPED, "finish");
    }

    private static com.bytedance.pangle.flipped.dl g() {
        if (dl()) {
            return new FlippedV2Impl();
        }
        if (a()) {
            return new com.bytedance.pangle.flipped.g();
        }
        return new com.bytedance.pangle.flipped.z();
    }

    private static boolean dl() {
        if (Build.VERSION.SDK_INT < 30) {
            return Build.VERSION.SDK_INT == 29 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    private static boolean a() {
        if (Build.VERSION.SDK_INT < 28) {
            return Build.VERSION.SDK_INT == 27 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }
}
