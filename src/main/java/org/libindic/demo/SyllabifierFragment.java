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
import android.widget.Toast;

import org.libindic.render.IndicEditText;
import org.libindic.render.IndicTextView;
import org.libindic.syllabifier.Syllabifier;

/**
 * Created by sujith on 10/6/14.
 */
public class SyllabifierFragment extends Fragment {

    private Syllabifier syllabifier;

    private IndicEditText edtSyllabifier;
    private Button btSyllabify;
    private IndicTextView tvSyllabifiedText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.syllabifier_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        syllabifier = new Syllabifier();

        edtSyllabifier = (IndicEditText)
                view.findViewById(R.id.edtSyllabifier);
        btSyllabify = (Button) view.findViewById(R.id.btSyllabify);
        tvSyllabifiedText = (IndicTextView)
                view.findViewById(R.id.tvSyllabifiedText);

        btSyllabify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = edtSyllabifier.getText().toString();

                if (text == null || text.length() == 0) {
                    showWarning();
                }

                tvSyllabifiedText.setText(syllabifier.syllabify(text));
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
        if (edtSyllabifier != null) {
            edtSyllabifier.setText(R.string.syllabifier_sample_1);

            if (btSyllabify != null && tvSyllabifiedText != null) {
                btSyllabify.performClick();
            }
        }
    }

    private void clearFields() {
        if (edtSyllabifier != null && tvSyllabifiedText != null) {
            edtSyllabifier.setText("");
            tvSyllabifiedText.setText("");
        }
    }
}
