package jp.ac.titech.itpro.sdl.resasapi.model;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by takahiro on 2017/11/17.
 */

public class Prefectures {
    private static final String TAG = Prefectures.class.getSimpleName();

    @Expose
    private String message;

    @Expose
    private List<Prefecture> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Prefecture> getResult() {
        return result;
    }

    public void setResult(List<Prefecture> result) {
        this.result = result;
    }
}
