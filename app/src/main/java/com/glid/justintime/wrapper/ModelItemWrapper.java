package com.glid.justintime.wrapper;

import com.glid.justintime.R;

import java.io.Serializable;

/**
 * Created by imen on 03/05/15.
 */
public class ModelItemWrapper implements Serializable {
    //public int typeId;
    private String mTitle;
    private int mImage;
    private int mType;     //ic_diary_type_1->pas de distance ****2->existance de distance
    private int mId;

    public ModelItemWrapper() {
        mImage = R.drawable.ic_expense_type_1;
        mTitle = "";
        mType = 1;
        mId = 0;
    }

    public ModelItemWrapper(int image, String title, int type, int id) {
        mImage = image;
        mTitle = title;
        mType = type;
        mId = id;
    }


    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int mImage) {
        this.mImage = mImage;
    }

    public int getType() {
        return mType;
    }

    public void setType(int mType) {
        this.mType = mType;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }


}
