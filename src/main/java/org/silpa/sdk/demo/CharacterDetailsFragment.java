package org.silpa.sdk.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

import org.silpa.characterdetails.CharacterDetailsEditText;
import org.silpa.characterdetails.CharacterDetailsObject;

/**
 * Created by sujith on 10/6/14.
 */
public class CharacterDetailsFragment extends SherlockFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.character_details_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        final CharacterDetailsEditText edtCharacterDetails = (CharacterDetailsEditText)
                view.findViewById(R.id.edtCharDetails);
        final Button btGetDetails = (Button) view.findViewById(R.id.btGetCharDetails);
        final TextView tvCharDetails = (TextView) view.findViewById(R.id.tvCharDetails);

        btGetDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharacterDetailsObject[] arr = edtCharacterDetails.getCharacterDetailsAsArray();
                String result = "";
                for (CharacterDetailsObject obj : arr) {
                    result = result + obj.toString();
                    result = result + "\n\n";
                }
                tvCharDetails.setText(result);
            }
        });

    }
}
