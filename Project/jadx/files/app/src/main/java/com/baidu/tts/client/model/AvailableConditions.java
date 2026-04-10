package com.baidu.tts.client.model;

import com.baidu.tts.tools.StringTool;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class AvailableConditions {
    private Set<String> mGenders;
    private Set<String> mSpeakers;

    public void appendGender(String str) {
        if (StringTool.isEmpty(str)) {
            return;
        }
        if (this.mGenders == null) {
            this.mGenders = new HashSet();
        }
        this.mGenders.add(str);
    }

    public void appendSpeaker(String str) {
        if (StringTool.isEmpty(str)) {
            return;
        }
        if (this.mSpeakers == null) {
            this.mSpeakers = new HashSet();
        }
        this.mSpeakers.add(str);
    }

    public Set<String> getGenders() {
        return this.mGenders;
    }

    public Set<String> getSpeakers() {
        return this.mSpeakers;
    }

    public void setGenders(Set<String> set) {
        this.mGenders = set;
    }

    public void setSpeakers(Set<String> set) {
        this.mSpeakers = set;
    }
}
