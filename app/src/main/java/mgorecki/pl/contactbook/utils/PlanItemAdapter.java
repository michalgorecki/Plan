package mgorecki.pl.contactbook.utils;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import mgorecki.pl.contactbook.R;
import mgorecki.pl.contactbook.db.AppDatabase;
import mgorecki.pl.contactbook.domain.PlanItem;
import mgorecki.pl.contactbook.domain.User;

/**
 * Created by emigore on 2017-07-06.
 */

public class PlanItemAdapter extends ArrayAdapter<PlanItem>{


    public PlanItemAdapter(@NonNull Context context, List<PlanItem> planItemList) {
        super(context, 0,planItemList);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final PlanItem planItem = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.plan_list_item,parent,false);
        }

        TextView dateField = (TextView) convertView.findViewById(R.id.dateTextView);
        TextView nameField = (TextView) convertView.findViewById(R.id.nameTextView);
        TextView headingField = (TextView) convertView.findViewById(R.id.headingTextView);
        TextView teacherField = (TextView) convertView.findViewById(R.id.teacherTextView);

        Date date = planItem.getDate();
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateString = formatter.format(date);

        dateField.setText(dateString);
        nameField.setText(planItem.getName());
        headingField.setText(planItem.getHeading());
        teacherField.setText(planItem.getTeacher());
        return convertView;
    }

}
