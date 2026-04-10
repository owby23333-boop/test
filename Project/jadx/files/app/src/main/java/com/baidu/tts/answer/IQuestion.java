package com.baidu.tts.answer;

/* JADX INFO: loaded from: classes2.dex */
public interface IQuestion<T> {
    T answer();

    IResult<T> createResult(Object... objArr);

    String getTag();
}
