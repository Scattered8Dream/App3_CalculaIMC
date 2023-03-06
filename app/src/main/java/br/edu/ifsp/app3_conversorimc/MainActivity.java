package br.edu.ifsp.app3_conversorimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText pesoEditText;
    private EditText alturaEditText;
    private TextView outputTextView;
    private Button btnCalcula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TIRANDO A ACTION BAR

        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        pesoEditText = findViewById(R.id.edttextpeso);
        alturaEditText = findViewById(R.id.edttextaltura);
        outputTextView = findViewById(R.id.outputtextview);
        btnCalcula = findViewById(R.id.btncalcular);

        btnCalcula.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view ==btnCalcula){
            process();
        }
    }

    private void process (){
        double peso = getDouble(pesoEditText);
        double altura = getDouble(alturaEditText);
        double imc;

        if(peso != 0 && altura !=0){
            imc = peso/(altura * altura);
            outputTextView.setText(String.format("%s %.2f", "IMC", imc));
        }
    }

    private double getDouble(EditText text){
        double value;
        try{
            value = Double.parseDouble(text.getText().toString());
        }catch (NumberFormatException nfe){
            Toast.makeText(this, "Valor inválido", Toast.LENGTH_SHORT).show();
            value = 0;
        }
        return value;
    }

}