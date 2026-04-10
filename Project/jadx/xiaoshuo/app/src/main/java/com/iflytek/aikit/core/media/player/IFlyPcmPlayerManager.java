package com.iflytek.aikit.core.media.player;

import com.iflytek.aikit.media.PcmPlayerHelper;

/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class IFlyPcmPlayerManager extends PcmPlayerHelper {

    public static class Holder {
        private static IFlyPcmPlayerManager instance = new IFlyPcmPlayerManager();

        private Holder() {
        }
    }

    public static IFlyPcmPlayerManager getInst() {
        return Holder.instance;
    }

    private IFlyPcmPlayerManager() {
    }
}
