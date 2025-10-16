package org.serratec.atividade.individual.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.serratec.atividade.individual.exception.EnumValidationException;

public enum GeneroMusical {
    ROCK,POP,SAMBA,FUNK,SERTANEJO;

    @JsonCreator
    public static GeneroMusical Verifica(String value) throws EnumValidationException {

        for (GeneroMusical generoMusical: values()) {
            if (value.equals(generoMusical.name())) {
                return generoMusical;
            }
        }
        throw  new EnumValidationException("Genero musical válidos: ROCK,POP,SAMBA,FUNK,SERTANEJO");
    }
}
