package com.example.mobile_07_contabancaria.model;

public class ContaPoupanca extends ContaBancaria {

    private final int diaDeRendimento = 22;

    public ContaPoupanca() {
        super();
    }

    public void calcularNovoSaldo(int taxa){
        setSaldo(getSaldo()*(1+(taxa/100)));
    }

    public int getDiaDeRendimento() {
        return diaDeRendimento;
    }
}
