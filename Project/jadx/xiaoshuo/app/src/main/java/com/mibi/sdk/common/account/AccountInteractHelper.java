package com.mibi.sdk.common.account;

import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes13.dex */
public final class AccountInteractHelper {
    public static final CopyOnWriteArraySet<String> sUserInteractionSet = new CopyOnWriteArraySet<>();
    public static final Object sInteractionWaitingLock = new Object();
    public static boolean mInteractionResult = false;

    private AccountInteractHelper() {
    }

    public static void notifyInteractionResult(boolean z) {
        Object obj = sInteractionWaitingLock;
        synchronized (obj) {
            mInteractionResult = z;
            obj.notifyAll();
        }
    }

    public static void registerUserInteraction(String str) {
        sUserInteractionSet.add(str);
    }

    public static void unregisterUserInteraction(String str) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = sUserInteractionSet;
        copyOnWriteArraySet.remove(str);
        if (copyOnWriteArraySet.isEmpty()) {
            mInteractionResult = false;
        }
    }
}
