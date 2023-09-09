package pl.pilichm.androidciphers;

public enum CipherListModel {
    SUBSTITUTION(R.layout.substitution_ciphers_layout),
    TRANSPOSITION(R.layout.transposition_ciphers_layout),
    SQUARE(R.layout.square_ciphers_layout)
    ;
    private int layoutId;

    CipherListModel(int layoutId) {
        this.layoutId = layoutId;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }
}
