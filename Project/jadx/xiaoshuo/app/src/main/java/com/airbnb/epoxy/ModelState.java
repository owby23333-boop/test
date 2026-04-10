package com.airbnb.epoxy;

/* JADX INFO: loaded from: classes.dex */
class ModelState {
    int hashCode;
    long id;
    int lastMoveOp;
    EpoxyModel<?> model;
    ModelState pair;
    int position;

    public static ModelState build(EpoxyModel<?> epoxyModel, int i, boolean z) {
        ModelState modelState = new ModelState();
        modelState.lastMoveOp = 0;
        modelState.pair = null;
        modelState.id = epoxyModel.id();
        modelState.position = i;
        if (z) {
            modelState.model = epoxyModel;
        } else {
            modelState.hashCode = epoxyModel.hashCode();
        }
        return modelState;
    }

    public void pairWithSelf() {
        if (this.pair != null) {
            throw new IllegalStateException("Already paired.");
        }
        ModelState modelState = new ModelState();
        this.pair = modelState;
        modelState.lastMoveOp = 0;
        modelState.id = this.id;
        modelState.position = this.position;
        modelState.hashCode = this.hashCode;
        modelState.pair = this;
        this.pair.model = this.model;
    }

    public String toString() {
        return "ModelState{id=" + this.id + ", model=" + this.model + ", hashCode=" + this.hashCode + ", position=" + this.position + ", pair=" + this.pair + ", lastMoveOp=" + this.lastMoveOp + '}';
    }
}
