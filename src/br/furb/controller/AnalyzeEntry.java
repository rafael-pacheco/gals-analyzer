package br.furb.controller;

public class AnalyzeEntry {

    private String output = "";

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public void validateInput(final String inputContent) {
        Lexico lexico = new Lexico();
        lexico.setInput(inputContent);
        try {
            Token token = null;
            while ((token = lexico.nextToken()) != null) {
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
