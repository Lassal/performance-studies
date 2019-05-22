package org.lassal.performance.perfdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CNPJService {

    Logger logger = LoggerFactory.getLogger(CNPJService.class);

    private int[] baseConvMod11 = new int[]{5,4,3,2,9,8,7,6,5,4,3,2};

    /**
     * A partir de uma raiz de número de CNPJ 00.000.000/0000
     * calcula o digito verificador utilizando o módulo 11.
     *
     * O CNPJ é composto da seguinte forma
     * Exemplo: 00.987.654/0001-99
     *
     * Número principal = 00.987.654
     * Filial = 0001
     * Digito Verificador = 99
     *
     * @param raizCNPJ Número principal mais número da filial do CNPJ com ou sem formatação
     * @return número do CNPJ informado mais o digito verificador
     */
    public String calculaDigitoVerificador(String raizCNPJ) throws Exception{

        String cnpjIn = raizCNPJ.trim().replace(".","").replace("/","");

        if(cnpjIn.length() != 12){
            throw new Exception("Número de CNPJ inválido. Informe todos os números incluindo zeros.");
        }

        // calcula primeiro digito
        String cnpj = this.addDigitoVerificador(cnpjIn);
        cnpj = this.addDigitoVerificador(cnpj);

        return raizCNPJ + "-" + cnpj.substring(12,14);
    }

    /**
     * Calculo o digito verificador para um CNPJ base
     * @param cleanCNPJ
     * @return
     */
    private String addDigitoVerificador(String cleanCNPJ){
        int mod11Peso = 2;
        int total = 0;

        for(int i=cleanCNPJ.length()-1; i >= 0; i--){
            total += Integer.parseInt(String.valueOf(cleanCNPJ.charAt(i))) * mod11Peso;

            ++mod11Peso;
            mod11Peso = mod11Peso > 9 ? 2 : mod11Peso;
        }

        int digit = total % 11;
        digit = digit > 1 ? 11 - digit : 0;

        return cleanCNPJ+digit;

    }

    public void calculateVerificationDigitNTimes(int numberOfExecutions) throws Exception {
        String[] raizCnpjSet = new String[5];
        raizCnpjSet[0] = "14.572.457.0001";
        raizCnpjSet[1] = "34.756.552/0001";
        raizCnpjSet[2] = "53.008.363/0001";
        raizCnpjSet[3] = "53.047.545/0001";
        raizCnpjSet[4] = "58.763.276/0001";

        int cnpjIndex = 0;

        for(int i =0; i < numberOfExecutions; i++){
            cnpjIndex = i % raizCnpjSet.length;

            this.calculaDigitoVerificador(raizCnpjSet[cnpjIndex]);
        }


    }
}
