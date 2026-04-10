package com.bykv.vk.openvk.api.proto;

/* JADX INFO: loaded from: classes2.dex */
public interface Result {
    int code();

    boolean isSuccess();

    String message();

    ValueSet values();
}
