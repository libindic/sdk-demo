package org.libindic.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.libindic.textsimilarity.TextSimilarity;

/**
 * Created by sujith on 13/8/14.
 */
public class TextSimilarityFragment extends Fragment {

    private TextSimilarity textSimilarity = new TextSimilarity();

    private EditText edt1, edt2;
    private Button btCompare;
    private TextView tvCompareResults;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.text_similarity_fragment, container, false);
        initView(view);

        return view;
    }

    private void initView(View view) {

        textSimilarity = new TextSimilarity();

        edt1 = (EditText) view.findViewById(R.id.edtTextSimilarity1);
        edt2 = (EditText) view.findViewById(R.id.edtTextSimilarity2);
        btCompare = (Button) view.findViewById(R.id.btTextSimilarityCompare);
        tvCompareResults = (TextView) view.findViewById(R.id.tvTextSimilarityResult);

        btCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = edt1.getText().toString();
                String text2 = edt2.getText().toString();

                if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
                    showWarning();
                }

                double result = textSimilarity.compare(text1, text2);
                tvCompareResults.setText(String.valueOf(result));
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
        if (edt1 != null && edt2 != null) {
            edt1.setText(R.string.text_similarity_sample_1);
            edt2.setText(R.string.text_similarity_sample_2);

            if (btCompare != null && tvCompareResults != null) {
                btCompare.performClick();
            }
        }
    }

    private void clearFields() {
        if (edt1 != null && edt2 != null
                && tvCompareResults != null) {
            edt1.setText("");
            edt2.setText("");
            tvCompareResults.setText("");
        }
    }
}
