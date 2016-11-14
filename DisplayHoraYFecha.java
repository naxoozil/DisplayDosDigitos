
/**
 * Write a description of class DisplayHoraYFecha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DisplayHoraYFecha
{
    private NumberDisplay minutos;
    private NumberDisplay hora;
    private NumberDisplay dia;
    private NumberDisplay mes;
    private NumberDisplay anno;
    private String displayString;
    /**
     * Constructor for objects of class DisplayHoraYFecha
     */
    public DisplayHoraYFecha()
    {
        minutos = new NumberDisplay(60, 0);
        hora = new NumberDisplay(24, 0);
        dia = new NumberDisplay(30, 1);
        mes = new NumberDisplay(12, 1);
        anno = new NumberDisplay(100, 1);
        updateDisplay();
    }

    public void avanzarMomento()
    {
        minutos.increment();
        if(minutos.getValue() == 0) {  // it just rolled over!
            hora.increment();
            if(hora.getValue() == 0){
                dia.increment();
                if(mes.getValue() == 0){
                     mes.increment();
                     if(anno.getValue()  == 0){
                         anno.increment();
                     }
                }
            }
        }
        updateDisplay();
    }
    
    public void setMomento(int minutos1, int hora1, int dia1, int mes1, int anno1)
    {
        boolean legal = true;
        if (minutos1 < 0 && minutos1 > 59){
            legal = false;
        }
        if (hora1 < 0 && hora1 > 23){
            legal = false;
        }
        if (dia1 < 1 && dia1 > 30){
            legal = false;
        }
        if (mes1 < 1 && mes1 > 12){
            legal = false;
        }
        if (anno1 < 0 && anno1 > 99){
            legal = false;
        }
        if (legal == true){
            minutos.setValue(minutos1);
            hora.setValue(hora1);
            dia.setValue(dia1);
            mes.setValue(mes1);
            anno.setValue(anno1);
        }
    }
    
     public String getmomento()
    {
        return displayString;
    }
    
    private void updateDisplay()
    {
        displayString = hora.getDisplayValue() + ":" + minutos.getDisplayValue() 
                        + " " + dia.getDisplayValue() + "/" + mes.getDisplayValue() 
                        + "/" + "20" + anno.getDisplayValue();
    }
    
    
}
