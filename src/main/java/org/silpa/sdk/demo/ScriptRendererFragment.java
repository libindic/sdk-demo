package org.silpa.sdk.demo;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

import org.silpa.render.IndicEditText;
import org.silpa.render.ScriptRenderer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sujith on 24/6/14.
 */
public class ScriptRendererFragment extends SherlockFragment {

    private ScriptRenderer scriptRenderer;

    private IndicEditText edtIndicText;
    private EditText edtWidth, edtHeight, edtFontSize;
    private Spinner spRenderColor;
    private Button btGetImage;
    private ImageView ivRenderedImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.script_renderer_fragment, container, false);
        initView(view);
        return view;
    }

    private static List<String> listColor = new ArrayList<String>();

    static {
        listColor.add("Black");
        listColor.add("Blue");
        listColor.add("Red");
        listColor.add("Yellow");
        listColor.add("Green");
    }

    private static Map<String, Integer> colorMap = new HashMap<String, Integer>();

    static {
        colorMap.put("Black", Color.BLACK);
        colorMap.put("Blue", Color.BLUE);
        colorMap.put("Red", Color.RED);
        colorMap.put("Yellow", Color.YELLOW);
        colorMap.put("Green", Color.GREEN);
    }

    private void initView(View view) {

        scriptRenderer = new ScriptRenderer(getActivity());

        edtIndicText = (IndicEditText) view.findViewById(R.id.edtRenderInput);
        edtWidth = (EditText) view.findViewById(R.id.edtRenderWidth);
        edtHeight = (EditText) view.findViewById(R.id.edtRenderHeight);
        edtFontSize = (EditText) view.findViewById(R.id.edtRenderFontSize);
        spRenderColor = (Spinner) view.findViewById(R.id.spRenderColor);
        btGetImage = (Button) view.findViewById(R.id.btGetRenderImage);
        ivRenderedImage = (ImageView) view.findViewById(R.id.ivRenderedImage);

        ArrayAdapter<String> dataAdapterFontMap = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, listColor);
        dataAdapterFontMap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spRenderColor.setAdapter(dataAdapterFontMap);

        btGetImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edtIndicText.getText().toString();
                int width = getValue(edtWidth, DEFAULT_WIDTH);
                int height = getValue(edtHeight, DEFAULT_HEIGHT);
                int fontSize = getValue(edtFontSize, DEFAULT_FONT_SIZE);

                Bitmap bitmap = scriptRenderer.getRenderedBitmap(text, fontSize,
                        colorMap.get(listColor.get(spRenderColor.getSelectedItemPosition())), height, width);
                try {
                    ivRenderedImage.setImageBitmap(bitmap);
                } catch (Exception e) {

                }
            }
        });
    }

    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 125;
    private static final int DEFAULT_FONT_SIZE = 50;

    private int getValue(EditText edt, int defaultValue) {
        try {
            String num = edt.getText().toString().trim();
            if (num == null || num.length() == 0) {
                showWarning("Warning : Empty fields");
            }
            int val = Integer.parseInt(num);
            return val;
        } catch (NumberFormatException nfe) {
            showWarning("Warning : Integer values expected");
            return defaultValue;
        }
    }

    private void showWarning(String warningText) {
        Toast.makeText(getActivity(), warningText, Toast.LENGTH_SHORT).show();
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
        if (edtIndicText != null && edtWidth != null && edtHeight != null && edtFontSize != null) {
            edtIndicText.setText(R.string.script_render_sample_1);
            edtWidth.setText(String.valueOf(DEFAULT_WIDTH));
            edtHeight.setText(String.valueOf(DEFAULT_HEIGHT));
            edtFontSize.setText(String.valueOf(DEFAULT_FONT_SIZE));

            if (btGetImage != null && ivRenderedImage != null) {
                btGetImage.performClick();
            }
        }
    }

    private void clearFields() {
        if (edtIndicText != null && edtWidth != null && edtHeight != null &&
                edtFontSize != null && ivRenderedImage != null) {
            edtIndicText.setText("");
            edtWidth.setText("");
            edtHeight.setText("");
            edtFontSize.setText("");
            ivRenderedImage.setImageBitmap(null);
        }
    }
}
