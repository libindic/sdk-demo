package org.silpa.sdk.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

import org.silpa.inexactsearch.InexactSearch;
import org.silpa.render.IndicEditText;

import java.util.Map;

/**
 * Created by sujith on 23/7/14.
 */
public class InexactSearchFragment extends SherlockFragment {

    private InexactSearch inexactSearch;

    private IndicEditText edtInexactSearch1, edtInexactSearch2;
    private TextView tvInexactSearchCompare, tvInexactSearchSearch;
    private Button btInexactSearchCompare, btInexactSearchSearch;
    private IndicEditText edtInexactSearch3, edtInexactSearch4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.inexact_search_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        inexactSearch = new InexactSearch();

        edtInexactSearch1 = (IndicEditText) view.findViewById(R.id.edtInexactSearch1);
        edtInexactSearch2 = (IndicEditText) view.findViewById(R.id.edtInexactSearch2);
        tvInexactSearchCompare = (TextView) view.findViewById(R.id.tvInexactSearchCompare);
        btInexactSearchCompare = (Button) view.findViewById(R.id.btInexactSearchCompare);
        btInexactSearchCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text1 = edtInexactSearch1.getText().toString();
                String text2 = edtInexactSearch2.getText().toString();
                if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
                    showWarning();
                }

                double compareValue = inexactSearch.compare(text1, text2);
                double bigramAverage = inexactSearch.bigramAverage(text1, text2);

                String res = "";
                res += "Compare value : " + compareValue + "\n";
                res += "Bi-gram Average : " + bigramAverage + "\n";
                tvInexactSearchCompare.setText(res);
            }
        });

        edtInexactSearch3 = (IndicEditText) view.findViewById(R.id.edtInexactSearch3);
        edtInexactSearch4 = (IndicEditText) view.findViewById(R.id.edtInexactSearch4);
        tvInexactSearchSearch = (TextView) view.findViewById(R.id.tvInexactSearchSearch);
        btInexactSearchSearch = (Button) view.findViewById(R.id.btInexactSearchSearch);
        btInexactSearchSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text1 = edtInexactSearch3.getText().toString();
                String text2 = edtInexactSearch4.getText().toString();
                Map<String, Double> searchResults = inexactSearch.search(text1, text2);

                if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
                    showWarning();
                }

                String res = "";
                for (Map.Entry<String, Double> entry : searchResults.entrySet()) {
                    String key = entry.getKey();
                    double val = entry.getValue();
                    res += key + "  :  " + val + "\n";
                }

                tvInexactSearchSearch.setText(res);
            }
        });
    }

    private void showWarning() {
        Toast.makeText(getActivity(), "Warning : Empty fields.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_fill_sample_data, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_fill_sample_fields:
                fillSampleData();
                return true;

            case R.id.menu_clear_fields:
                clearFields();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void fillSampleData() {
        if (edtInexactSearch1 != null && edtInexactSearch2 != null) {
            edtInexactSearch1.setText(R.string.inexact_search_compare_sample_1);
            edtInexactSearch2.setText(R.string.inexact_search_compare_sample_2);

            if (btInexactSearchCompare != null && tvInexactSearchCompare != null) {
                btInexactSearchCompare.performClick();
            }
        }

        if (edtInexactSearch3 != null && edtInexactSearch4 != null) {
            edtInexactSearch3.setText(R.string.inexact_search_search_sample_1);
            edtInexactSearch4.setText(R.string.inexact_search_search_sample_2);

            if (btInexactSearchSearch != null && tvInexactSearchSearch != null) {
                btInexactSearchSearch.performClick();
            }
        }
    }

    private void clearFields() {
        if (edtInexactSearch1 != null && edtInexactSearch2 != null
                && edtInexactSearch3 != null && edtInexactSearch4 != null
                && tvInexactSearchCompare != null && tvInexactSearchSearch != null) {
            edtInexactSearch1.setText("");
            edtInexactSearch2.setText("");
            edtInexactSearch3.setText("");
            edtInexactSearch4.setText("");
            tvInexactSearchCompare.setText("");
            tvInexactSearchSearch.setText("");
        }
    }
}

