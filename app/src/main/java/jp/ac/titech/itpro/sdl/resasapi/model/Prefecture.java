package jp.ac.titech.itpro.sdl.resasapi.model;

import com.google.gson.annotations.Expose;

/**
 * Created by takahiro on 2017/11/17.
 */

public class Prefecture {
    @Expose
    private Integer prefCode;

    @Expose
    private String prefName;

    public int getPrefCode() {
        return prefCode;
    }

    public void setPrefCode(Integer prefCode) {
        this.prefCode = prefCode;
    }

    public String getPrefName() {
        return prefName;
    }

    public void setPrefName(String prefName) {
        this.prefName = prefName;
    }
}
