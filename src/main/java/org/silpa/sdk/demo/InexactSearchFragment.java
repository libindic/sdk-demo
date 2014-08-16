package org.silpa.sdk.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

import org.silpa.inexactsearch.InexactSearchEditText;

import java.util.Map;

/**
 * Created by sujith on 23/7/14.
 */
public class InexactSearchFragment extends SherlockFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.inexact_search_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        final InexactSearchEditText edtInexactSearch1 = (InexactSearchEditText) view.findViewById(R.id.edtInexactSearch1);
        //final InexactSearchEditText edtInexactSearch2 = (InexactSearchEditText) view.findViewById(R.id.edtInexactSearch2);
        final TextView tvInexactSearchCompare = (TextView) view.findViewById(R.id.tvInexactSearchCompare);
        final Button btInexactSearchCompare = (Button) view.findViewById(R.id.btInexactSearchCompare);
        btInexactSearchCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double compareValue = edtInexactSearch1.getCompareValue();
                double bigramAverage = edtInexactSearch1.getBigramAverage();

                String res = "";
                res += "Compare value : " + compareValue + "\n";
                res += "Bi-gram Average : " + bigramAverage + "\n";
                tvInexactSearchCompare.setText(res);
            }
        });


        final InexactSearchEditText edtInexactSearch3 = (InexactSearchEditText) view.findViewById(R.id.edtInexactSearch3);
        //final InexactSearchEditText edtInexactSearch4 = (InexactSearchEditText) view.findViewById(R.id.edtInexactSearch4);
        final TextView tvInexactSearchSearch = (TextView) view.findViewById(R.id.tvInexactSearchSearch);
        final Button btInexactSearchSearch = (Button) view.findViewById(R.id.btInexactSearchSearch);
        btInexactSearchSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Double> searchResults = edtInexactSearch3.getSearchResults();

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
}

