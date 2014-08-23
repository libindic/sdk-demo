package org.silpa.sdk.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.actionbarsherlock.app.SherlockFragment;

import org.silpa.render.IndicEditText;
import org.silpa.render.IndicTextView;
import org.silpa.shingling.Shingling;

/**
 * Created by sujith on 25/7/14.
 */
public class ShinglingFragment extends SherlockFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.shingling_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        final Shingling shingling = new Shingling();

        final IndicEditText edtShingling = (IndicEditText) view.findViewById(R.id.edtShingling);
        final EditText edtWValue = (EditText) view.findViewById(R.id.edtWValue);

        final IndicTextView tvShingles = (IndicTextView) view.findViewById(R.id.tvShingles);
        final Button btGetShingles = (Button) view.findViewById(R.id.btGetShingles);

        btGetShingles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int wValue;
                try {
                    wValue = Integer.parseInt(edtWValue.getText().toString().trim());
                } catch (Exception e) {
                    wValue = 4;
                }

                tvShingles.setText(shingling.wshingling
                        (edtShingling.getText().toString(), wValue).toString());

            }
        });
    }
}

