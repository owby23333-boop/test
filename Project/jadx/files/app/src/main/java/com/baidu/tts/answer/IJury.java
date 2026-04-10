package com.baidu.tts.answer;

import com.baidu.tts.composite.IComposite;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes2.dex */
public interface IJury extends IComposite<IQuestion<?>> {
    void check();

    void check(String str);

    IQuestion<?> getQuestion(String str);

    Hashtable<String, IQuestion<?>> getQuestions();

    IResult<?> getResult(String str);

    Hashtable<String, IResult<?>> getResults();
}
