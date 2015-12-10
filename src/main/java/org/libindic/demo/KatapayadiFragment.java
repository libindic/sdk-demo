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
import android.widget.TextView;
import android.widget.Toast;

import org.libindic.katapayadi.Katapayadi;
import org.libindic.render.IndicEditText;

/**
 * Created by sujith on 10/6/14.
 */
public class KatapayadiFragment extends Fragment {

    private Katapayadi katapayadi;

    private IndicEditText edtKatapayadi;
    private Button btGetKatapayadiNumber;
    private TextView tvKatapayadiOutput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.katapaydi_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        katapayadi = new Katapayadi();

        edtKatapayadi = (IndicEditText) view.findViewById(R.id.edtKatapayadi);
        btGetKatapayadiNumber = (Button) view.findViewById(R.id.btGetKatapayadiNumber);
        tvKatapayadiOutput = (TextView) view.findViewById(R.id.tvKatapayadiOutput);

        btGetKatapayadiNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = edtKatapayadi.getText().toString();

                if (text == null || text.length() == 0) {
                    showWarning();
                }

                String num = katapayadi.getKatapayadiNumber(text);
                tvKatapayadiOutput.setText(num);
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
        if (edtKatapayadi != null) {
            edtKatapayadi.setText(R.string.katapayadi_sample_1);

            if (btGetKatapayadiNumber != null && tvKatapayadiOutput != null) {
                btGetKatapayadiNumber.performClick();
            }
        }
    }

    private void clearFields() {
        if (edtKatapayadi != null && tvKatapayadiOutput != null) {
            edtKatapayadi.setText("");
            tvKatapayadiOutput.setText("");
        }
    }
}
