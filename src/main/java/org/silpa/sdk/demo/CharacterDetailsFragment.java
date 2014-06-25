package org.silpa.sdk.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;

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

//        final CharacterDetailsEditText edtCharacterDetails = (CharacterDetailsEditText)
//                view.findViewById(R.id.edtCharDetails);
//        final CharacterDetailsTextView tvCharacterDetails = (CharacterDetailsTextView)
//                view.findViewById(R.id.tvCharDetails);
//
//        CharacterDetailsObject[] arr1 = edtCharacterDetails.getCharacterDetailsAsArray();
//        Map<Character, CharacterDetailsObject> map1 = edtCharacterDetails.getCharacterDetailsAsMap();
//
//        CharacterDetailsObject[] arr2 = tvCharacterDetails.getCharacterDetailsAsArray();
//        Map<Character, CharacterDetailsObject> map2 = tvCharacterDetails.getCharacterDetailsAsMap();

    }
}
