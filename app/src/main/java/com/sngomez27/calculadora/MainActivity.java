package com.sngomez27.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.udojava.evalex.Expression;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button buttonC = findViewById(R.id.buttonC);
        Button buttonCE = findViewById(R.id.buttonCE);
        Button buttonDelet = findViewById(R.id.buttonDelet);
        Button buttonMulti = findViewById(R.id.buttonX);
        Button buttonDiv = findViewById(R.id.buttonDiv);
        Button buttonSuma = findViewById(R.id.buttonSUm);
        Button buttonPunto = findViewById(R.id.buttonPunt);
        Button buttonResta = findViewById(R.id.buttonRest);
        Button buttonResultado = findViewById(R.id.buttonResul);


        Button button9 = findViewById(R.id.button9);
        Button button8 = findViewById(R.id.button8);
        Button button7 = findViewById(R.id.button7);
        Button button6 = findViewById(R.id.button6);
        Button button5 = findViewById(R.id.button5);
        Button button4 = findViewById(R.id.button4);
        Button button3 = findViewById(R.id.button3);
        Button button2 = findViewById(R.id.button2);
        Button button1 = findViewById(R.id.button1);
        Button button0 = findViewById(R.id.button0);

        ArrayList <Button> arrayListButtons = new ArrayList<>();
        arrayListButtons.add(button0);
        arrayListButtons.add(button1);
        arrayListButtons.add(button2);
        arrayListButtons.add(button3);
        arrayListButtons.add(button4);
        arrayListButtons.add(button5);
        arrayListButtons.add(button6);
        arrayListButtons.add(button7);
        arrayListButtons.add(button8);
        arrayListButtons.add(button9);

        TextView pantalla1 = findViewById(R.id.pantallaPrinci);
        TextView pantalla2 = findViewById(R.id.pantallaSup);
        pantalla1.setText(null);

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pantalla1.setText(null);
                pantalla2.setText(null);
            }
        });
        buttonSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantallaText = pantalla1.getText().toString();
                String pantallaTextSup = pantalla2.getText().toString();
                if (!pantallaTextSup.isEmpty()){
                    if(!(pantallaTextSup.charAt(pantallaTextSup.length() - 1) == '=')) {
                      pantalla2.setText(null);
                    }
                }
                if (!pantallaText.isEmpty()){
                    char lastchar = pantallaText.charAt(pantallaText.length()-1);
                    if (lastchar != '-' && lastchar != '+'){
                        pantalla2.setText(pantallaTextSup + "" + pantallaText + "+");
                    }
                    pantalla1.setText(null);
                } else if (pantallaTextSup.isEmpty()) {
                    pantalla1.setText("+ ");
                }
            }
        });
        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantallaText = pantalla1.getText().toString();
                String pantallaTextSup = pantalla2.getText().toString();
                if (!pantallaTextSup.isEmpty()){
                    if(!(pantallaTextSup.charAt(pantallaTextSup.length() - 1) == '=')) {
                        pantalla2.setText(null);
                    }
                }
                if (!pantallaText.isEmpty()){
                    char lastChar = pantallaText.charAt(pantallaText.length()-1);
                    if (lastChar !='/' && lastChar !='*'){
                        pantalla2.setText(pantalla2.getText().toString() + "" + pantallaText + "*");
                    }
                    pantalla1.setText(null);
                }
            }
        });
        buttonResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantallaText = pantalla1.getText().toString();
                String pantallaTextSup = pantalla2.getText().toString();
                if (!pantallaTextSup.isEmpty()){
                    if(!(pantallaTextSup.charAt(pantallaTextSup.length() - 1) == '=')) {
                        pantalla2.setText(null);
                    }
                }
                if (!pantallaText.isEmpty()){
                    char lastChar = pantallaText.charAt(pantallaText.length()-1);
                    if (lastChar !='-' && lastChar !='+'){
                        pantalla2.setText(pantalla2.getText().toString() + "" + pantallaText + "-");
                    }
                    pantalla1.setText(null);
                } else if (pantallaTextSup.isEmpty()) {
                    pantalla1.setText("-");
                }
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantallaText = pantalla1.getText().toString();
                String pantallaTextSup = pantalla2.getText().toString();
                if (!pantallaTextSup.isEmpty()){
                    if(!(pantallaTextSup.charAt(pantallaTextSup.length() - 1) == '=')) {
                        pantalla2.setText(null);
                    }
                }
                if (!pantallaText.isEmpty()){
                    char lastChar = pantallaText.charAt(pantallaText.length()-1);
                    if (lastChar !='/' && lastChar !='*'){
                        pantalla2.setText(pantalla2.getText().toString() + "" + pantallaText + "*");
                    } if (pantalla2.getText().toString().charAt(pantalla2.getText().toString().length() -1) == ')')
                        pantalla2.setText(pantalla2.getText().toString()+"/");

                    pantalla1.setText(null);
                }
            }
        });
        buttonResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pantalla1.getText().toString().isEmpty()){
                    pantalla1.setText("0");
                }
                String calculo = pantalla2.getText().toString() + pantalla1.getText().toString();
                try {
                    Expression expression = new Expression(calculo);
                    double resultado = expression.eval().doubleValue();
                    pantalla1.setText(resultado+"");
                }catch (Exception e){
                    pantalla2.setText("error:");
                    pantalla1.setText("No se puede realizar el calculo");
                }
            }
        });
        buttonDelet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String delet = pantalla1.getText().toString();
                delet = delet.substring(0, delet.length() - 1);
                pantalla1.setText(delet);
            }
        });
        buttonPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textpantalla = pantalla1.getText().toString();
                if (!textpantalla.isEmpty() && textpantalla.charAt(textpantalla.length() -1) != '.'){
                    textpantalla += buttonPunto.getText().toString();
                    pantalla1.setText(textpantalla);
                }
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textpantalla = pantalla1.getText().toString();
                if(!textpantalla.isEmpty()){
                    textpantalla += buttonPunto.getText().toString();
                    pantalla1.setText(textpantalla);

                }
            }
        });
        for (Button button: arrayListButtons){
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!pantalla2.getText().toString().isEmpty()){
                        if (pantalla2.getText().toString().charAt(pantalla2.length() -1) == '='){
                            pantalla2.setText(null);
                        }
                    }
                    String textPantalla = pantalla1.getText().toString();
                    textPantalla += button.getText().toString();
                    pantalla1.setText(textPantalla);
                }
            });
        }
    }
}