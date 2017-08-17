package mgorecki.pl.plan.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import mgorecki.pl.plan.R;
import mgorecki.pl.plan.domain.PlanItem;

/**
 * Created by emigore on 2017-07-06.
 */

public class PlanItemAdapter extends ArrayAdapter<PlanItem>{
    public static final String TAG = "PlanItemAdapter";

    public PlanItemAdapter(@NonNull Context context, List<PlanItem> planItemList) {
        super(context, 0,planItemList);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Log.d(TAG,"ENTER: getView()");
        final PlanItem planItem = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.plan_list_item,parent,false);
        }

        TextView time = (TextView) convertView.findViewById(R.id.timeTextView);
        TextView nameField = (TextView) convertView.findViewById(R.id.nameTextView);
        TextView teacherField = (TextView) convertView.findViewById(R.id.teacherTextView);
        TextView weekdayField = (TextView) convertView.findViewById(R.id.weekdayTextView);

        Log.d(TAG,"Got item on position "+position+": "+planItem.getName()+" "+planItem.getWeekday()+" "+planItem.getTime());
        nameField.setText(planItem.getName());
        time.setText(planItem.getTime());
        weekdayField.setText(planItem.getWeekday());
        teacherField.setText(planItem.getTeacher());
        Log.d(TAG,"RETURN: getView()");
        return convertView;
    }

}
