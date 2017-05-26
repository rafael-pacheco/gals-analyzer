package br.furb.controller;

import java.util.Iterator;

public class AnalyzeEntry implements Constants {

    private String output = "";

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public void validateInput(final String inputContent) {
        int countCnpj = 0;
        int countNome = 0;
        int countTelefone = 0;
        int countData = 0;
        int countAtividade = 0;
        int countEmail = 0;
        int contLinha = 0;

        Lexico lexico = new Lexico();
        lexico.setInput(inputContent);
        Token token = null;

        try {
            while ((token = lexico.nextToken()) != null) {
                if (token.getId() == t_CNPJ) {
                    countCnpj++;
                }
                if (token.getId() == t_Nome) {
                    countNome++;
                }
                if (token.getId() == t_Telefone) {
                    countTelefone++;
                }
                if (token.getId() == t_Data) {
                    countData++;
                }
                if (token.getId() == t_Atividade) {
                    countAtividade++;
                }
                if (token.getId() == t_Email) {
                    countEmail++;
                }

                final StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("dados analisados\n");
                stringBuilder.append(String.format("CNPJs:\t%d\n", countCnpj));
                stringBuilder.append(String.format("nomes:\t%d\n", countNome));
                stringBuilder.append(String.format("telefones:\t%d\n", countTelefone));
                stringBuilder.append(String.format("datas:\t%d\n", countData));
                stringBuilder.append(String.format("códigos de atividades:\t%d\n", countAtividade));
                stringBuilder.append(String.format("emails:\t%d", countEmail));
                this.setOutput(stringBuilder.toString());
            }
        } catch (LexicalError e) {
            String texto = inputContent + "";
            int fimIndex = texto.indexOf(" ", e.getPosition());
            String palavra = (texto.substring(e.getPosition(), fimIndex));
            String[] linha = texto.split("\n");
            for (int i = 0; i <= linha.length; i++) {
                if (linha[i].contains(palavra)) {
                    contLinha = i;
                    break;
                }
            }
            String outputError = ("erro na linha " + (contLinha + 1) + " - " + e.getMessage() + " : " + palavra);
            this.setOutput(outputError);
        }
    }

    public void clearContent() {
        this.setOutput("");
    }

}
