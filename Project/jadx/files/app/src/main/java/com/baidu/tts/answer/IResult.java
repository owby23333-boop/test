package com.baidu.tts.answer;

/* JADX INFO: loaded from: classes2.dex */
public interface IResult<T> {
    T getResult();

    String getTag();

    void setResult(T t2);

    void setTag(String str);
}
