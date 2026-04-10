package com.arialyy.aria.orm;

/* JADX INFO: loaded from: classes.dex */
public enum ActionPolicy {
    NO_ACTION("NO ACTION"),
    RESTRICT("RESTRICT"),
    SET_NULL("SET NULL"),
    SET_DEFAULT("SET ERROR"),
    CASCADE("CASCADE");

    String function;

    ActionPolicy(String str) {
        this.function = str;
    }
}
