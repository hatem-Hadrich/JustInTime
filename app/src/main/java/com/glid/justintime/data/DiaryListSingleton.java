package com.glid.justintime.data;

import com.glid.justintime.wrapper.DiaryItemWrapper;

import java.util.ArrayList;

/**
 * Created by imen on 18/06/2015.
 * c'est la structure de donnees utilisee pour gerer les objets contact avant la mise a jour finale dans la base de donnees.
 */
public class DiaryListSingleton {
    private static DiaryListSingleton mInstance;
    private ArrayList<DiaryItemWrapper> mList;


    private DiaryListSingleton() {
        mList = new ArrayList<DiaryItemWrapper>();
    }

    public static synchronized DiaryListSingleton getInstance() {
        if (mInstance == null)
            mInstance = new DiaryListSingleton();
        return mInstance;
    }

    public void addContact(int position, DiaryItemWrapper contact) {
        mList.add(position, contact);
    }

    public void getContactList(ArrayList<DiaryItemWrapper> list) {
        if (list != null) {
            list.clear();
            for (DiaryItemWrapper wrapper : mList) {
                list.add(wrapper);
            }
        }
    }

    public void removeContact(int position) {
        mList.remove(position);
    }

    public DiaryItemWrapper getItem(int position) {
        return mList.get(position);
    }

    public void clearList() {
        mList.clear();
    }

    public int getPositionContactItem(long id) {
        int i = 0;
        int res = -1;
        boolean exist = false;
        while ((i < mList.size()) && (!exist)) {
            Long a = new Long(mList.get(i).getId());
            Long b = new Long(id);

            if (a.equals(b)) {
                exist = true;
                res = i;

            }
            i++;
        }
        return res;
    }

    public void editExpenseWithoutGettingPosition(int position, DiaryItemWrapper contact) {
        mList.set(position, contact);

    }

    public int getSizeList() {
        return mList.size();
    }
}

