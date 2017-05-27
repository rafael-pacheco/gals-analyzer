package br.furb.controller;

public class AnalyzeEntry implements Constants {

    private String output = "";

    public String getOutput() {
        return output;
    }

    public void setOutput(final String output) {
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
            final String input = inputContent + " ";
            String token = "";

            final int endIndexSpace = input.indexOf(" ", e.getPosition());
            final int endIndexBreak = input.indexOf("\n", e.getPosition());

            if (endIndexSpace > endIndexBreak) {
                token = (input.substring(e.getPosition(), endIndexBreak));
            } else {
                token = (input.substring(e.getPosition(), endIndexSpace));
            }

            final String[] lines = input.split("\n");
            int countLines = 0;
            for (int i = 0; i <= lines.length; i++) {
                if (lines[i].contains(token)) {
                    countLines = i;
                    break;
                }
            }

            this.setOutput("erro na linha " + (countLines + 1) + " - " + e.getMessage() + " : " + token);
        }
    }

    public void clearContent() {
        this.setOutput("");
    }

}
