package br.com.calculadora.logicquiz;

/**
 * Created by andre on 12/08/16.
 */
public class Pergunta {
    private int id;
    private String pergunta;
    private String alterA;
    private String alterB;
    private String alterC;
    private String alterD;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getAlterA() {
        return alterA;
    }

    public void setAlterA(String alterA) {
        this.alterA = alterA;
    }

    public String getAlterB() {
        return alterB;
    }

    public void setAlterB(String alterB) {
        this.alterB = alterB;
    }

    public String getAlterC() {
        return alterC;
    }

    public void setAlterC(String alterC) {
        this.alterC = alterC;
    }

    public String getAlterD() {
        return alterD;
    }

    public void setAlterD(String alterD) {
        this.alterD = alterD;
    }
}
