package com.arialyy.aria.core.processor;

import com.arialyy.aria.core.inf.IEventHandler;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IHttpFileNameAdapter extends IEventHandler {
    String handleFileName(Map<String, List<String>> map, String str);
}
