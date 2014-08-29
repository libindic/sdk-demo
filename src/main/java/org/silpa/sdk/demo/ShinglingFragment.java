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

import org.silpa.render.IndicEditText;
import org.silpa.shingling.Shingling;

/**
 * Created by sujith on 25/7/14.
 */
public class ShinglingFragment extends SherlockFragment {

    private Shingling shingling;

    private IndicEditText edtShingling;
    private EditText edtWValue;
    private TextView tvShingles;
    private Button btGetShingles;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.shingling_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        shingling = new Shingling();

        edtShingling = (IndicEditText) view.findViewById(R.id.edtShingling);
        edtWValue = (EditText) view.findViewById(R.id.edtWValue);

        tvShingles = (TextView) view.findViewById(R.id.tvShingles);
        btGetShingles = (Button) view.findViewById(R.id.btGetShingles);

        btGetShingles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = edtShingling.getText().toString();

                if (text == null || text.length() == 0) {
                    showWarning("Warning : Empty fields");
                }

                int wValue;
                try {
                    wValue = Integer.parseInt(edtWValue.getText().toString().trim());
                } catch (Exception e) {
                    showWarning("Error : Integer value expected.");
                    wValue = 4;
                }

                tvShingles.setText(shingling.wshingling(text, wValue).toString());
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
        if (edtShingling != null && edtWValue != null) {
            edtShingling.setText(R.string.shingling_sample_1);
            edtWValue.setText(R.string.shingling_sample_2);

            if (btGetShingles != null && tvShingles != null) {
                btGetShingles.performClick();
            }
        }
    }

    private void clearFields() {
        if (edtShingling != null && edtWValue != null && tvShingles != null) {
            edtWValue.setText("");
            edtShingling.setText("");
            tvShingles.setText("");
        }
    }
}

