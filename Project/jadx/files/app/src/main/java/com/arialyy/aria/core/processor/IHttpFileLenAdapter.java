package com.arialyy.aria.core.processor;

import com.arialyy.aria.core.inf.IEventHandler;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IHttpFileLenAdapter extends IEventHandler {
    long handleFileLen(Map<String, List<String>> map);
}
