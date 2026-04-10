package com.iflytek.aikit.plugin.base;

/* JADX INFO: loaded from: classes7.dex */
public class AbilityInfo {

    public static class Holder {
        private static final AbilityInfo instance = new AbilityInfo();

        private Holder() {
        }
    }

    public static AbilityInfo getInst() {
        return Holder.instance;
    }

    public String getInputKey() {
        return "audio";
    }

    public boolean isSync() {
        return false;
    }

    private AbilityInfo() {
    }
}
