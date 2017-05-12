package br.furb.controller;

public class AnalyzeEntry implements Constants{

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
        
        Lexico lexico = new Lexico();
        lexico.setInput(inputContent);
        try {
            Token token = null;
            while ((token = lexico.nextToken()) != null) {
                if(token.getId() == t_CNPJ) {
                    countCnpj++;
                }
                if(token.getId() == t_NOME) {
                    countNome++;
                }
                if(token.getId() == t_TELEFONE) {
                    countTelefone++;
                }
                if(token.getId() == t_DATA) {
                    countData++;
                }
                if(token.getId() == t_ATIVIDADE) {
                    countAtividade++;
                }
                if(token.getId() == t_EMAIL) {
                    countEmail++;
                }
                
                System.out.println(token.getLexeme());
            }
        } catch (LexicalError e) {
            String outputError = (e.getMessage() + "e;, em " + e.getPosition());
            this.setOutput(outputError);
        }
    }

    public void clearContent() {
        this.setOutput("");
    }

}
