package com.sntech.ads.impl.utils;

import com.sntech.ads.api.event.SNEvent;
import com.sntech.event.SNEvent;

/* JADX INFO: loaded from: classes3.dex */
public class EventConverter {
    private EventConverter() {
    }

    public static SNEvent.AdEvent convertAdEvent(SNEvent.AdEvent adEvent) {
        return (SNEvent.AdEvent) getEnumObj(SNEvent.AdEvent.class, adEvent.toString());
    }

    public static SNEvent.AdType convertAdType(SNEvent.AdType adType) {
        return (SNEvent.AdType) getEnumObj(SNEvent.AdType.class, adType.toString());
    }

    public static SNEvent.EventSource convertEventSource(SNEvent.EventSource eventSource) {
        return (SNEvent.EventSource) getEnumObj(SNEvent.EventSource.class, eventSource.toString());
    }

    public static SNEvent.AdPlatform convertPlatform(SNEvent.AdPlatform adPlatform) {
        return (SNEvent.AdPlatform) getEnumObj(SNEvent.AdPlatform.class, adPlatform.toString());
    }

    public static SNEvent.UserEvent convertUserEvent(SNEvent.UserEvent userEvent) {
        return (SNEvent.UserEvent) getEnumObj(SNEvent.UserEvent.class, userEvent.toString());
    }

    public static SNEvent.WithdrawChannel convertWithdrawChannel(SNEvent.WithdrawChannel withdrawChannel) {
        return (SNEvent.WithdrawChannel) getEnumObj(SNEvent.WithdrawChannel.class, withdrawChannel.toString());
    }

    private static Object getEnumObj(Class cls, String str) {
        for (Object obj : cls.getEnumConstants()) {
            if (str.equals(obj.toString())) {
                return obj;
            }
        }
        return null;
    }
}
