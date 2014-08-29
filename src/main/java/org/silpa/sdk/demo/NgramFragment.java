package org.silpa.sdk.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

import org.silpa.ngram.Ngram;
import org.silpa.render.IndicEditText;

/**
 * Created by sujith on 23/7/14.
 */
public class NgramFragment extends SherlockFragment {

    private Ngram ngram;

    private IndicEditText edtNgram;
    private EditText edtNValue;
    private TextView tvLetterNgram, tvSyllableNgram, tvWordNgram;
    private Button btGetNgram;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.ngram_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        ngram = new Ngram();

        edtNgram = (IndicEditText) view.findViewById(R.id.edtNgram);
        edtNValue = (EditText) view.findViewById(R.id.edtNValue);
        tvLetterNgram = (TextView) view.findViewById(R.id.tvLetterNgram);
        tvSyllableNgram = (TextView) view.findViewById(R.id.tvSyllableNgram);
        tvWordNgram = (TextView) view.findViewById(R.id.tvWordNgram);
        btGetNgram = (Button) view.findViewById(R.id.btGetNgram);

        btGetNgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = edtNgram.getText().toString();

                if (text == null || text.length() == 0) {
                    showWarning("Warning : Empty fields");
                }

                int nValue;
                try {
                    nValue = Integer.parseInt(edtNValue.getText().toString().trim());
                } catch (Exception e) {
                    showWarning("Error : Integer value expected.");
                    nValue = Ngram.DEFAULT_NGRAMS_WINDOW_SIZE;
                }
                System.out.println(ngram.letterNgram(text, nValue).toString());
                tvLetterNgram.setText(ngram.letterNgram(text, nValue).toString());

                tvSyllableNgram.setText(ngram.syllableNgram(text, nValue).toString());

                tvWordNgram.setText(ngram.wordNgram(text, nValue).toString());
            }
        });
    }

    private void showWarning(String errorMessage) {
        Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_SHORT).show();
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
        if (edtNgram != null && edtNValue != null) {
            edtNgram.setText(R.string.ngram_sample_1);
            edtNValue.setText(R.string.ngram_sample_2);

            if (btGetNgram != null && tvLetterNgram != null
                    && tvSyllableNgram != null && tvWordNgram != null) {
                btGetNgram.performClick();
            }
        }
    }

    private void clearFields() {
        if (edtNgram != null && edtNValue != null && tvLetterNgram != null
                && tvSyllableNgram != null && tvWordNgram != null) {
            edtNgram.setText("");
            edtNValue.setText("");
            tvLetterNgram.setText("");
            tvSyllableNgram.setText("");
            tvWordNgram.setText("");
        }
    }
}

