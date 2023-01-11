package com.example.myapplication33;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText Num1, Num2, Operation;
    TextView ResultText;
    Button button;
    Toast toastError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Num1=findViewById(R.id.editText1);
        Num2=findViewById(R.id.editText3);
        Operation=findViewById(R.id.editText2);
        ResultText=findViewById(R.id.textView4);
        button=findViewById(R.id.button);
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        float num1, num2, resalt=0;
        String task = Operation.getText().toString();
        num1 = Float.parseFloat(Num1.getText().toString());
        num2 = Float.parseFloat(Num2.getText().toString());
        try {
            switch (task) {
                case "+":
                    resalt = num1 + num2;
                    break;
                case "*":
                    resalt = num1 * num2;
                    break;
                case "/":
                    resalt = num1 / num2;
                    break;
                case "-":
                    resalt = num1 - num2;
                    break;
                default:
                    break;
            }
        } catch (ArithmeticException e) {
            int duration=Toast.LENGTH_SHORT;
            if(toastError!=null){
                toastError.cancel();
            }
            toastError=Toast.makeText(this,"деление на ноль",duration);
            toastError.show();
            return;
        } catch (NullPointerException e) {
            int duration=Toast.LENGTH_SHORT;
            if(toastError!=null){
                toastError.cancel();
            }
            toastError=Toast.makeText(this,"не введено число",duration);
            toastError.show();
        } catch (NumberFormatException e) {
            int duration=Toast.LENGTH_SHORT;
            if(toastError!=null){
                toastError.cancel();
            }
            toastError=Toast.makeText(this,"не верный формат числа",duration);
            toastError.show();
        }
        ResultText.setText(num1+" "+task+" "+num2+"="+resalt);

    }
}