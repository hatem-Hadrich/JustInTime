package com.glid.justintime.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.glid.justintime.R;
import com.glid.justintime.wrapper.ModelItemWrapper;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by imen on 03/05/15.
 * c'est l'adapter de la gride utiliser pour choisir le type  des expenses
 */
public class CarburantGridAdapter extends BaseAdapter {
    Context context;
    private List<ModelItemWrapper> mModelList;


    public CarburantGridAdapter(List<ModelItemWrapper> mList, Context context) {

        mModelList = mList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return mModelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.carburant_model_item, null);

        CircleImageView image = (CircleImageView) view.findViewById(R.id.type_pic);
        TextView title = (TextView) view.findViewById(R.id.type_title);
        image.setImageResource(mModelList.get(i).getImage());
        title.setText(mModelList.get(i).getTitle());
        return view;
    }
}
