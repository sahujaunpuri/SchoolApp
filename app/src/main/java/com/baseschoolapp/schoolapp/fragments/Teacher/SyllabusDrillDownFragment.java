package com.baseschoolapp.schoolapp.fragments.Teacher;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.Adapters.Teacher.SyllabusDrillDownAdapter;
import com.baseschoolapp.schoolapp.Adapters.Teacher.SyllabusDrillDownAdapter;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;
import com.baseschoolapp.schoolapp.fragments.Student.BaseFragment;
import com.baseschoolapp.schoolapp.models.Teacher.SyllabusDrillDownDataModel;
import com.baseschoolapp.schoolapp.models.Teacher.SyllabusDrillDownDataModel;

import java.util.ArrayList;

import butterknife.ButterKnife;


public class SyllabusDrillDownFragment extends BaseFragment {

    ArrayList<SyllabusDrillDownDataModel> dataModels;
    private static SyllabusDrillDownAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        String subject = "";
        int colorCode = R.color.white;

        Bundle bundle = this.getArguments();

        if (bundle != null) {
            subject = this.getArguments().getString("SUBJECT");
            colorCode = this.getArguments().getInt("COLOR");
        }

        View view = inflater.inflate(R.layout.syllabus_drill_down, container, false);

        Button subjectName = (Button) view.findViewById(R.id.syllabusSubjectName);
        subjectName.setText(subject);

        GradientDrawable background = (GradientDrawable) subjectName.getBackground();
        int color = ContextCompat.getColor(getContext(), colorCode);
        background.setColor(color);


        ButterKnife.bind(this, view);

        ((StudentDashBoard) getActivity()).updateToolbarTitle("5th Class - A");

        initialiseSyllabusDrillDown(view);

        return view;
    }


    public void initialiseSyllabusDrillDown(View view) {

        ListView listView = (ListView) view.findViewById(R.id.syllabus_drill_down_list);

        dataModels = new ArrayList<>();

        dataModels.add(new SyllabusDrillDownDataModel("1.", "Chapter 1", "this is sample desc so that we can see how many lines it can span", "Completed", R.color.green));
        dataModels.add(new SyllabusDrillDownDataModel("2.", "Chapter 2", "this is sample desc so that we can see how many lines it can span", "Completed", R.color.green));
        dataModels.add(new SyllabusDrillDownDataModel("3.", "Chapter 3", "this is sample desc so that we can see how many lines it can span", "Completed", R.color.yellow));
        dataModels.add(new SyllabusDrillDownDataModel("4.", "Chapter 4", "this is sample desc so that we can see how many lines it can span", "In Process", R.color.yellow));
        dataModels.add(new SyllabusDrillDownDataModel("5.", "Chapter 5", "this is sample desc so that we can see how many lines it can span", "In Process", R.color.red));
        dataModels.add(new SyllabusDrillDownDataModel("6.", "Chapter 6", "this is sample desc so that we can see how many lines it can span", "In Process", R.color.red));
        dataModels.add(new SyllabusDrillDownDataModel("7.", "Chapter 7", "this is sample desc so that we can see how many lines it can span", "In Process", R.color.green));
        dataModels.add(new SyllabusDrillDownDataModel("8.", "Chapter 8", "this is sample desc so that we can see how many lines it can span", "In Process", R.color.green));

        adapter = new SyllabusDrillDownAdapter(dataModels, this.getContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                SyllabusDrillDownDataModel dataModel = dataModels.get(position);

//                Snackbar.make(view, dataModel.getUnitTestName() + "\n" + dataModel.getUnitTestStartDate(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
            }
        });
    }


}
