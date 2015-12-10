package org.libindic.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import org.libindic.render.IndicEditText;
import org.libindic.render.IndicTextView;
import org.libindic.transliteration.Transliterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sujith on 9/7/14.
 */
public class TransliteratorFragment extends Fragment {

    private Transliterator transliterator;
    private IndicEditText edtTransliterator;
    private Spinner spTargetLanguage;
    private Button btTransliterate;
    private IndicTextView tvTransliteratorOutput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.transliterator_fragment, container, false);
        initView(view);
        return view;
    }

    private static Map<String, String> languageNameMap = new HashMap<String, String>();

    static {
        languageNameMap.put("English", "en_US");
        languageNameMap.put("Hindi", "hi_IN");
        languageNameMap.put("Bengali", "bn_IN");
        languageNameMap.put("Punjabi", "pa_IN");
        languageNameMap.put("Gujarati", "gu_IN");
        languageNameMap.put("Oriya", "or_IN");
        languageNameMap.put("Tamil", "ta_IN");
        languageNameMap.put("Telugu", "te_IN");
        languageNameMap.put("Kannada", "kn_IN");
        languageNameMap.put("Malayalam", "ml_IN");
        languageNameMap.put("ISO15919", "ISO15919");
        languageNameMap.put("IPA", "IPA");
    }

    private static List<String> listTargetLanguage = new ArrayList<String>();

    static {
        listTargetLanguage.add("English");
        listTargetLanguage.add("Hindi");
        listTargetLanguage.add("Malayalam");
        listTargetLanguage.add("Bengali");
        listTargetLanguage.add("Tamil");
        listTargetLanguage.add("Telugu");
        listTargetLanguage.add("Gujarati");
        listTargetLanguage.add("Punjabi");
        listTargetLanguage.add("Kannada");
        listTargetLanguage.add("ISO15919");
        listTargetLanguage.add("IPA");
    }

    private void initView(View view) {

        transliterator = new Transliterator(getActivity());
        edtTransliterator = (IndicEditText) view.findViewById(R.id.edtTransliterator);
        spTargetLanguage = (Spinner) view.findViewById(R.id.spTargetLanguage);
        btTransliterate = (Button) view.findViewById(R.id.btTransliterate);
        tvTransliteratorOutput = (IndicTextView) view.findViewById(R.id.tvTransliteratorOutput);

        ArrayAdapter<String> dataAdapterFontMap = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, listTargetLanguage);
        dataAdapterFontMap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTargetLanguage.setAdapter(dataAdapterFontMap);

        btTransliterate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = edtTransliterator.getText().toString();

                if (text == null || text.length() == 0) {
                    showWarning();
                }

                String languageCode = languageNameMap.get(spTargetLanguage.getSelectedItem().toString());
                String transliteratedText = transliterator.transliterate(text, languageCode);
                tvTransliteratorOutput.setText(transliteratedText);
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
        if (edtTransliterator != null) {
            edtTransliterator.setText(R.string.transliteration_sample_1);

            if (btTransliterate != null && tvTransliteratorOutput != null) {
                btTransliterate.performClick();
            }
        }
    }

    private void clearFields() {
        if (edtTransliterator != null && tvTransliteratorOutput != null) {
            edtTransliterator.setText("");
            tvTransliteratorOutput.setText("");
        }
    }
}
