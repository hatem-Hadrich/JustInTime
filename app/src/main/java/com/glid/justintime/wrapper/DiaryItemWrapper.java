package com.glid.justintime.wrapper;

import java.io.Serializable;

/**
 * Created by imen on 20/03/15.
 */
public class DiaryItemWrapper implements Serializable {


    private long mId;
    private String mTitle;
    private String mNumber;
    private int mIndice;

    public DiaryItemWrapper() {

    }

    public long getId() {

        return mId;
    }

    public void setId(long id) {

        this.mId = id;
    }

    public String getTitle() {

        return mTitle;
    }

    public void setTitle(String mTitle) {

        this.mTitle = mTitle;
    }

    public String getNumber() {

        return mNumber;
    }

    public void setNumber(String nbr) {
        this.mNumber = nbr;
    }

    public int getIndice() {
        return mIndice;
    }

    public void setIndice(int indice) {
        this.mIndice = indice;
    }


}
