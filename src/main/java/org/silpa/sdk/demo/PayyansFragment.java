package org.silpa.sdk.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

import org.silpa.payyans.Payyans;
import org.silpa.render.IndicEditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sujith on 10/6/14.
 */
public class PayyansFragment extends SherlockFragment {

    private Payyans payyans;

    private IndicEditText edtPayyans;
    private Spinner spDirection;
    private Spinner spFontMap;
    private Button btConvert;
    private TextView tvPayyans;

    private static final int DEFAULT_FONT_MAP = Payyans.FONT_MAP_AMBILI;
    private static final int DEFAULT_DIRECTION = Payyans.ASCII_TO_UNICODE;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.payyans_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        payyans = new Payyans(getActivity());

        edtPayyans = (IndicEditText) view.findViewById(R.id.edtPayyans);
        spDirection = (Spinner) view.findViewById(R.id.spinnerDirection);
        spFontMap = (Spinner) view.findViewById(R.id.spinnerFontMap);
        btConvert = (Button) view.findViewById(R.id.btConvert);
        tvPayyans = (TextView) view.findViewById(R.id.tvPayyans);

        final List<String> listDirection = new ArrayList<String>();
        listDirection.add("ASCII To Unicode");
        listDirection.add("Unicode To ASCII");
        ArrayAdapter<String> dataAdapterDirection = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, listDirection);
        dataAdapterDirection.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDirection.setAdapter(dataAdapterDirection);

        final List<String> listFontMap = new ArrayList<String>();
        listFontMap.add("ambili");
        listFontMap.add("charaka");
        listFontMap.add("haritha");
        listFontMap.add("indulekha");
        listFontMap.add("karthika");
        listFontMap.add("manorama");
        listFontMap.add("matweb");
        listFontMap.add("nandini");
        listFontMap.add("panchari");
        listFontMap.add("revathi");
        listFontMap.add("template");
        listFontMap.add("uma");
        listFontMap.add("valluvar");
        ArrayAdapter<String> dataAdapterFontMap = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, listFontMap);
        dataAdapterFontMap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spFontMap.setAdapter(dataAdapterFontMap);

        btConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edtPayyans.getText().toString();

                payyans.setFontMap(spFontMap.getSelectedItemPosition());
                payyans.setDirection(spDirection.getSelectedItemPosition());

                String convertedText = payyans.getConvertText(text);

                tvPayyans.setText(payyans.getConvertText(edtPayyans.getText().toString()));
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
        if (edtPayyans != null && spFontMap != null && spDirection != null) {
            edtPayyans.setText(R.string.payyans_sample_1);
            spFontMap.setSelection(DEFAULT_FONT_MAP);
            spDirection.setSelection(DEFAULT_DIRECTION);

            if (btConvert != null && tvPayyans != null) {
                btConvert.performClick();
            }
        }
    }

    private void clearFields() {
        if (edtPayyans != null && tvPayyans != null) {
            edtPayyans.setText("");
            tvPayyans.setText("");
        }
    }
}
