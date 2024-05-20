package com.example.mobile_07_contabancaria;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mobile_07_contabancaria.model.ContaBancaria;
import com.example.mobile_07_contabancaria.model.ContaEspecial;
import com.example.mobile_07_contabancaria.model.ContaPoupanca;

public class MainActivity extends AppCompatActivity {

    private TextView tvRes;
    private TextView ET01;
    private TextView ET02;
    private RadioButton RBP;
    private RadioButton RBE;
    private RadioButton RBSacar;
    private RadioButton RBDepositar;
    private RadioButton RBRender;
    private Button BTExec;

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

        tvRes = findViewById(R.id.tvRes);
        ET01 = findViewById(R.id.et01);
        ET02 = findViewById(R.id.et02);
        RBP = findViewById(R.id.RBP);
        RBE = findViewById(R.id.RBE);
        RBDepositar = findViewById(R.id.RBDepositar);
        RBSacar = findViewById(R.id.RBSacar);
        RBRender = findViewById(R.id.RBRender);
        BTExec = findViewById(R.id.BTExec);
        BTExec.setOnClickListener(op -> exec());
    }

    private void exec() {
        if(RBE.isChecked()){
            ContaBancaria conta = new ContaEspecial();
        }else{
            ContaPoupanca conta = new ContaPoupanca();
        }
        conta.setNum_conta(001);
        conta.setCliente(ET01.getText().toString());
        conta.setSaldo(1500f);

        if(RBDepositar.isChecked()){
            float valor = Float.parseFloat(ET02.getText().toString());
            conta.depositar(valor);
        }else if (RBSacar.isChecked()){
            float valor = Float.parseFloat(ET02.getText().toString());
           conta.sacar(valor);
        }else {

        }
    }

}