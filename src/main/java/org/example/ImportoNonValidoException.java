package org.example;

public class ImportoNonValidoException extends RuntimeException {
    public ImportoNonValidoException(double importo) {
        super("Importo non valido: " + importo + " (deve essere maggiore di zero)");
    }
}
