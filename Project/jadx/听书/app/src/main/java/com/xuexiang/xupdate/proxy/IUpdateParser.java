package com.xuexiang.xupdate.proxy;

import com.xuexiang.xupdate.entity.UpdateEntity;
import com.xuexiang.xupdate.listener.IUpdateParseCallback;

/* JADX INFO: loaded from: classes4.dex */
public interface IUpdateParser {
    boolean isAsyncParser();

    UpdateEntity parseJson(String str) throws Exception;

    void parseJson(String str, IUpdateParseCallback iUpdateParseCallback) throws Exception;
}
