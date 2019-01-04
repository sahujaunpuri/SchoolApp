package com.baseschoolapp.schoolapp.fragments.Teacher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baseschoolapp.schoolapp.Adapters.Student.FamilyDetailsAdapter;
import com.baseschoolapp.schoolapp.Adapters.Teacher.UnitTestDetailsAdapter;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Teacher.KeyValueDataModel;
import com.baseschoolapp.schoolapp.models.Teacher.UnitTestDataModel;
import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

import java.util.ArrayList;

public class UnitTestFragment extends Fragment {

    ArrayList<Object> dataModels;
    private static UnitTestDetailsAdapter adapter;

    public UnitTestFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_unit_test, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initialiseUnitTestDetails(view);
    }


    public void initialiseUnitTestDetails(View view) {
        ListView listView = (ListView) view.findViewById(R.id.unit_test_list);

        dataModels = new ArrayList<>();

        dataModels.add(new UnitTestDataModel(-1, "Unit Test 1", "", "", "", ROW_TYPE.HEADER, 1, false));
        dataModels.add(new UnitTestDataModel(R.drawable.ic_welcome01, "Kartheek Kumar", "01", "80/100", "A+", ROW_TYPE.DATA_ROW, 1, false));
        dataModels.add(new UnitTestDataModel(R.drawable.ic_welcome01, "Arvind Kumar", "02", "70/100", "A", ROW_TYPE.DATA_ROW, 1, false));
        dataModels.add(new UnitTestDataModel(R.drawable.ic_welcome01, "Kumar", "03", "60/100", "B+", ROW_TYPE.DATA_ROW, 1, false));
        dataModels.add(new UnitTestDataModel(R.drawable.ic_welcome01, "Rangamma", "04", "50/100", "B", ROW_TYPE.DATA_ROW, 1, false));
        dataModels.add(new UnitTestDataModel(R.drawable.ic_welcome01, "Jagapathi", "05", "100/100", "A++", ROW_TYPE.DATA_ROW, 1, false));

        dataModels.add(new UnitTestDataModel(-1, "Unit Test 2", "", "", "", ROW_TYPE.HEADER, 2, false));
        dataModels.add(new UnitTestDataModel(R.drawable.ic_welcome01, "Ram Charan", "01", "80/100", "A+", ROW_TYPE.DATA_ROW, 2, false));
        dataModels.add(new UnitTestDataModel(R.drawable.ic_welcome01, "Arvind Swamy", "02", "70/100", "A", ROW_TYPE.DATA_ROW, 2, false));
        dataModels.add(new UnitTestDataModel(R.drawable.ic_welcome01, "Rakul", "03", "60/100", "B+", ROW_TYPE.DATA_ROW, 2, false));
        dataModels.add(new UnitTestDataModel(R.drawable.ic_welcome01, "Navdeep", "04", "50/100", "B", ROW_TYPE.DATA_ROW, 2, false));
        dataModels.add(new UnitTestDataModel(R.drawable.ic_welcome01, "Tanikeli", "05", "100/100", "A++", ROW_TYPE.DATA_ROW, 2, false));

        adapter = new UnitTestDetailsAdapter(this.getContext(), dataModels);

        listView.setAdapter(adapter);

        adapter.setListener(new UnitTestDetailsAdapter.AdapterListener() {
            public void onClick(int id) {

            }

        });

    }
}