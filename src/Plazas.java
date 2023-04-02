public class Plazas {
    private int ID;
    private char tipoPlaza;
    private boolean adjudicada = false;
    private Persona persona = null;
    
    public Plazas(int iD, char tipoPlaza, boolean adjudicada, Persona persona) {
        ID = iD;
        this.tipoPlaza = tipoPlaza;
        this.adjudicada = adjudicada;
        this.persona = persona;
    }
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public char getTipoPlaza() {
        return tipoPlaza;
    }
    public void setTipoPlaza(char tipoPlaza) {
        this.tipoPlaza = tipoPlaza;
    }
    public boolean isAdjudicada() {
        return adjudicada;
    }
    public void setAdjudicada(boolean adjudicada) {
        this.adjudicada = adjudicada;
    }
    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    
    @Override
    public String toString() {
        return "ID Plaza: " + ID + "\n Tipo: " + tipoPlaza + "\n Adjudicada: " + adjudicada + "\n" + persona;
    }

    
    
}
