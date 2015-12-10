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

import org.libindic.characterdetails.CharacterDetails;
import org.libindic.characterdetails.CharacterDetailsObject;
import org.libindic.render.IndicEditText;

/**
 * Created by sujith on 10/6/14.
 */
public class CharacterDetailsFragment extends Fragment {

    private CharacterDetails characterDetails;

    private IndicEditText edtCharacterDetails;
    private Button btGetDetails;
    private TextView tvCharDetails;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.character_details_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        characterDetails = new CharacterDetails(getActivity());

        edtCharacterDetails = (IndicEditText) view.findViewById(R.id.edtCharDetails);
        btGetDetails = (Button) view.findViewById(R.id.btGetCharDetails);
        tvCharDetails = (TextView) view.findViewById(R.id.tvCharDetails);

        btGetDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = edtCharacterDetails.getText().toString();

                if (text == null || text.length() == 0) {
                    showWarning();
                }

                CharacterDetailsObject[] arr = characterDetails.getCharacterDetailsAsArray(text);
                String result = "";
                for (CharacterDetailsObject obj : arr) {
                    result = result + obj.toString();
                    result = result + "\n\n";
                }
                tvCharDetails.setText(result);
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
        if (edtCharacterDetails != null) {
            edtCharacterDetails.setText(R.string.character_details_sample_1);

            if (btGetDetails != null && tvCharDetails != null) {
                btGetDetails.performClick();
            }
        }
    }

    private void clearFields() {
        if (edtCharacterDetails != null && tvCharDetails != null) {
            edtCharacterDetails.setText("");
            tvCharDetails.setText("");
        }
    }
}
