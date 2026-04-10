package com.yuewen;

import android.content.res.Configuration;
import android.view.LayoutInflater;

/* JADX INFO: loaded from: classes12.dex */
public interface xv1 {
    void applyOverrideConfiguration(Configuration configuration);

    LayoutInflater getLayoutInflater();

    Configuration getOverrideConfiguration();

    <T extends w01> T queryFeature(Class<T> cls);

    <T extends w01> T queryLocalFeature(Class<T> cls);

    boolean registerGlobalFeature(w01 w01Var);

    boolean registerLocalFeature(w01 w01Var);

    void setLayoutInflater(LayoutInflater layoutInflater);

    boolean unregisterGlobalFeature(w01 w01Var);

    boolean unregisterLocalFeature(w01 w01Var);
}
