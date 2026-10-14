import org.example.ContoBancario;
import org.example.ImportoNonValidoException;
import org.example.SaldoInsufficienteException;

import static java.lang.IO.println;

void main() {
    ContoBancario conto = new ContoBancario(500.0);


    println("--- Scenario 1: prelievo eccessivo ---");
    try {
        conto.preleva(800.0);
        println("Prelievo riuscito");
    } catch (SaldoInsufficienteException e) {
        println("Errore: " + e.getMessage());
        println("Ti mancano " + e.getDeficit() + " euro");
    } finally {
        println("Operazione terminata. Saldo attuale: " + conto.getSaldo());
    }


    println("\n Scenario 2: prelievo negativo ");
    try {
        conto.preleva(-50.0);
    } catch (ImportoNonValidoException e) {
        println("Errore: " + e.getMessage());
    } catch (SaldoInsufficienteException e) {
        // Va gestita comunque perché preleva() la dichiara con throws
        println("Errore: " + e.getMessage());
    }


    println("\n Scenario 3: prelievo valido");
    try {
        conto.preleva(200.0);
        println("Prelievo completato con successo. Nuovo saldo: " + conto.getSaldo());
    } catch (SaldoInsufficienteException e) {
        println("Errore: " + e.getMessage());
    }
}