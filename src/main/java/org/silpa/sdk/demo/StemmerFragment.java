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

import org.silpa.render.IndicEditText;
import org.silpa.stemmer.Stemmer;
import org.silpa.stemmer.StemmerEditText;

import java.util.Map;

/**
 * Created by sujith on 10/6/14.
 */
public class StemmerFragment extends SherlockFragment {

    private Stemmer stemmer;

    private IndicEditText edtStemmer;
    private Button btGetStemmedWords;
    private TextView tvStemmedWords;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.stemmer_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        stemmer = new Stemmer(getActivity());

        edtStemmer = (IndicEditText)
                view.findViewById(R.id.edtStemmer);
        btGetStemmedWords = (Button) view.findViewById(R.id.btGetStemmedWords);
        tvStemmedWords = (TextView) view.findViewById(R.id.tvStemmedWords);

        btGetStemmedWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edtStemmer.getText().toString();
                Map<String, String> stemmedWords = stemmer.getStemWordsAsMap(text);
                String result = "";
                for (Map.Entry<String, String> entry : stemmedWords.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    result = result + key + "  :  " + value + "\n";
                }
                tvStemmedWords.setText(result);
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
        if (edtStemmer != null) {
            edtStemmer.setText(R.string.stemmer_sample_1);

            if (btGetStemmedWords != null && tvStemmedWords != null) {
                btGetStemmedWords.performClick();
            }
        }
    }

    private void clearFields() {
        if (edtStemmer != null && tvStemmedWords != null) {
            edtStemmer.setText("");
            tvStemmedWords.setText("");
        }
    }
}
