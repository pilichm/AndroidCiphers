package pl.pilichm.androidciphers;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import pl.pilichm.ciphers.substitution.CaesarCipher;

public class SubstitutionCipherActivity extends AppCompatActivity {
    private SubstitutionCipherEnum cipherType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_substitution_cipher);

        if (getIntent().hasExtra(Constants.EXTRA_CIPHER_TYPE)){
            if (Objects.equals(getIntent().getStringExtra(Constants.EXTRA_CIPHER_TYPE), SubstitutionCipherEnum.CAESAR.name())){
                cipherType = SubstitutionCipherEnum.CAESAR;
            }
        }

        Button btnRun = findViewById(R.id.btnRun);
        RadioButton rbEncode = findViewById(R.id.rbEncode);
        RadioButton rbDecode = findViewById(R.id.rbDecode);
        EditText etKeyInput = findViewById(R.id.etKeyInput);
        EditText etInputTxt = findViewById(R.id.etInputTxt);
        TextView tvConvertedText = findViewById(R.id.tvConvertedText);

        rbEncode.setOnCheckedChangeListener((compoundButton, b) -> {
            rbDecode.setChecked(!rbEncode.isChecked());
            if (rbEncode.isChecked()){
                etInputTxt.setText("Text to encode");
            } else {
                etInputTxt.setText("Text to decode");
            }
        });

        rbDecode.setOnCheckedChangeListener((compoundButton, b) -> {
            rbEncode.setChecked(!rbDecode.isChecked());
        });

        btnRun.setOnClickListener(view -> {
            String textToProcess = etInputTxt.getText().toString();
            String key = etKeyInput.getText().toString();
            String result = "";

            if (cipherType==SubstitutionCipherEnum.CAESAR){
                CaesarCipher cc = new CaesarCipher();

                try {
                    cc.setOffset(Integer.parseInt(key));
                } catch (Exception e){
                    Toast.makeText(this, "Invalid key, should be number!", Toast.LENGTH_LONG).show();
                }

                if (rbEncode.isChecked()){
                    result = cc.encode(textToProcess);
                } else {
                    result = cc.decode(textToProcess);
                }

                tvConvertedText.setText(result);
            }
        });
    }



}