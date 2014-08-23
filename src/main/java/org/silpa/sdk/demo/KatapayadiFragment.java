package org.silpa.sdk.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

import org.silpa.katapayadi.Katapayadi;
import org.silpa.render.IndicEditText;

/**
 * Created by sujith on 10/6/14.
 */
public class KatapayadiFragment extends SherlockFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.katapaydi_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        final Katapayadi katapayadi = new Katapayadi();

        final IndicEditText edtKatapayadi = (IndicEditText) view.findViewById(R.id.edtKatapayadi);
        final Button btGetKatapayadiNumber = (Button) view.findViewById(R.id.btGetKatapayadiNumber);
        final TextView tvKatapayadiOutput = (TextView) view.findViewById(R.id.tvKatapayadiOutput);

        btGetKatapayadiNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = katapayadi.getKatapayadiNumber(edtKatapayadi.getText().toString());
                tvKatapayadiOutput.setText(num);
            }
        });

    }
}
