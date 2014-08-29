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

import org.silpa.guesslanguage.GuessLanguage;
import org.silpa.guesslanguage.LanguageInfo;
import org.silpa.render.IndicEditText;

/**
 * Created by sujith on 11/8/14.
 */
public class GuessLanguageFragment extends SherlockFragment {

    private GuessLanguage gl;

    private IndicEditText edtGuessLanguage;
    private Button btGetLanguage;
    private TextView tvLanguageInfoResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.guess_language_fragment, container, false);
        initView(view);

        return view;
    }

    private void initView(View view) {

        gl = new GuessLanguage(getActivity());

        edtGuessLanguage = (IndicEditText) view.findViewById(R.id.edtGuessLanguage);
        btGetLanguage = (Button) view.findViewById(R.id.btGetLanguage);
        tvLanguageInfoResult = (TextView) view.findViewById(R.id.tvLanguageInfoResult);

        btGetLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edtGuessLanguage.getText().toString();

                if (text == null || text.length() == 0) {
                    showWarning();
                }

                LanguageInfo li = gl.guessLanguageInfo(text);
                tvLanguageInfoResult.setText(li.toString());
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
        if (edtGuessLanguage != null) {
            edtGuessLanguage.setText(R.string.guess_language_sample_1);

            if (btGetLanguage != null && tvLanguageInfoResult != null) {
                btGetLanguage.performClick();
            }
        }
    }

    private void clearFields() {
        if (edtGuessLanguage != null && tvLanguageInfoResult != null) {
            edtGuessLanguage.setText("");
            tvLanguageInfoResult.setText("");
        }
    }
}
