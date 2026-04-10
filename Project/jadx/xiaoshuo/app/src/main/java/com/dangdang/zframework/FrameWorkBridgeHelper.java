package com.dangdang.zframework;

/* JADX INFO: loaded from: classes10.dex */
public class FrameWorkBridgeHelper {
    private IFrameWorkModuleBridge mBridge;

    public static class SingletonInstance {
        private static final FrameWorkBridgeHelper INSTANCE = new FrameWorkBridgeHelper();

        private SingletonInstance() {
        }
    }

    public static FrameWorkBridgeHelper getInstance() {
        return SingletonInstance.INSTANCE;
    }

    public boolean hasPermitPrivacy() {
        return this.mBridge.hasPermitPrivacy();
    }

    public void init(IFrameWorkModuleBridge iFrameWorkModuleBridge) {
        this.mBridge = iFrameWorkModuleBridge;
    }
}
