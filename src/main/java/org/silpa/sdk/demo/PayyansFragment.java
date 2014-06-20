package org.silpa.sdk.demo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.silpa.payyans.Payyans;
import org.silpa.payyans.PayyansEditText;
import org.silpa.payyans.PayyansTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sujith on 10/6/14.
 */
public class PayyansFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.payyans_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        final PayyansEditText edtPayyan1 = (PayyansEditText) view.findViewById(R.id.edtPayyansInput1);
        final Spinner spDirection = (Spinner) view.findViewById(R.id.spinnerDirection);
        final Spinner spFontMap = (Spinner) view.findViewById(R.id.spinnerFontMap);
        final Button btConvert = (Button) view.findViewById(R.id.btConvert);
        final TextView tvOutput1 = (TextView) view.findViewById(R.id.tvPayyansOutput1);

        List<String> listDirection = new ArrayList<String>();
        listDirection.add("ASCII To Unicode");
        listDirection.add("Unicode To ASCII");
        ArrayAdapter<String> dataAdapterDirection = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, listDirection);
        dataAdapterDirection.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDirection.setAdapter(dataAdapterDirection);

        List<String> listFontMap = new ArrayList<String>();
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
                Payyans payyans = new Payyans(getActivity(), spFontMap.getSelectedItemPosition(),
                        spDirection.getSelectedItemPosition());
                tvOutput1.setText(payyans.getConvertText(edtPayyan1.getText().toString()));
            }
        });

        PayyansTextView tvPayyans = (PayyansTextView) view.findViewById(R.id.tvPayyans);
        System.out.println(tvPayyans.getConvertedText());

    }
}
