package com.kwad.sdk.api.model;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements IKsAdLabel {
    public int aaB;
    public int aaC;
    public String aaD;
    public String aaE;
    public String aaF;
    public String aaG;
    public String aaH;
    public long aaI;

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final String getChannel() {
        return this.aaH;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final long getCpmBidFloor() {
        return this.aaI;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final String getHistoryTitle() {
        return this.aaG;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final String getPostTitle() {
        return this.aaF;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final String getPrevTitle() {
        return this.aaE;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final int getThirdAge() {
        return this.aaB;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final int getThirdGender() {
        return this.aaC;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final String getThirdInterest() {
        return this.aaD;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setChannel(String str) {
        this.aaH = str;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setCpmBidFloor(long j2) {
        this.aaI = j2;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setHistoryTitle(String str) {
        this.aaG = str;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setPostTitle(String str) {
        this.aaF = str;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setPrevTitle(String str) {
        this.aaE = str;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setThirdAge(int i2) {
        this.aaB = i2;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setThirdGender(int i2) {
        this.aaC = i2;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setThirdInterest(String str) {
        this.aaD = str;
    }
}
