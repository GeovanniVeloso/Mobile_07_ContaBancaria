package com.example.mobile_07_contabancaria.model;

public class ContaEspecial extends ContaBancaria {

    private final float limite = 150;
    public ContaEspecial() {
        super();
    }

    @Override
    public void sacar(float valor) throws ArithmeticException {
        if(valor > (getSaldo() + limite)){
            throw new ArithmeticException("Saldo insuficiente");
        }else{
            setSaldo(getSaldo()-limite);
        }
    }

    public float getLimite() {
        return limite;
    }
}
