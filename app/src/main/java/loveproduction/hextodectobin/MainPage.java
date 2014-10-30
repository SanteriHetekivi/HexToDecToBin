package loveproduction.hextodectobin;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;


public class MainPage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        mainpage();
    }

    private void mainpage() {
        final String EMPTY = "";
        setContentView(R.layout.activity_main_page);
        final EditText bin = (EditText) findViewById(R.id.editBin);
        final EditText dec = (EditText) findViewById(R.id.editDec);
        final EditText hex = (EditText) findViewById(R.id.editHex);
        bin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (bin.isFocused()) {
                    String VALUE = bin.getText().toString();
                    if (VALUE != null && !VALUE.isEmpty() && VALUE.matches("[01]+")) {
                        BigInteger Dec = new BigInteger(VALUE, 2);
                        String Hex = Dec.toString(16).toUpperCase();
                        String DEC = Dec.toString();
                        dec.setText(DEC, TextView.BufferType.EDITABLE);
                        hex.setText(Hex, TextView.BufferType.EDITABLE);
                    } else {
                        dec.setText(EMPTY, TextView.BufferType.EDITABLE);
                        hex.setText(EMPTY, TextView.BufferType.EDITABLE);
                    }
                }
            }
        });
        dec.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (dec.isFocused()) {
                    String VALUE = dec.getText().toString();
                    if (VALUE != null && !VALUE.isEmpty() && VALUE.matches("[0-9]+")) {
                        BigInteger Dec = new BigInteger(VALUE);
                        String Bin = Dec.toString(2);
                        String Hex = Dec.toString(16).toUpperCase();
                        bin.setText(Bin, TextView.BufferType.EDITABLE);
                        hex.setText(Hex, TextView.BufferType.EDITABLE);
                    } else {
                        bin.setText(EMPTY, TextView.BufferType.EDITABLE);
                        hex.setText(EMPTY, TextView.BufferType.EDITABLE);
                    }
                }
            }
        });
        hex.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (hex.isFocused()) {
                    String VALUE = hex.getText().toString();
                    if (VALUE != null && !VALUE.isEmpty() && VALUE.matches("^[a-fA-F0-9]+$")) {
                        BigInteger Dec = new BigInteger(VALUE, 16);
                        String Bin = Dec.toString(2);
                        String DEC = Dec.toString();
                        dec.setText(DEC, TextView.BufferType.EDITABLE);
                        bin.setText(Bin, TextView.BufferType.EDITABLE);
                    } else {
                        dec.setText(EMPTY, TextView.BufferType.EDITABLE);
                        bin.setText(EMPTY, TextView.BufferType.EDITABLE);
                    }
                }
            }
        });
    }
}

