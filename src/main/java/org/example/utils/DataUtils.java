package org.example.utils;

import java.time.MonthDay;
import java.time.Year;

public interface DataUtils {

    static boolean verificarSeEstaEntreDatas(MonthDay dataParaVerificar, MonthDay dataInicio, MonthDay dataFim) {
        return !(dataParaVerificar.isBefore(dataInicio) || dataParaVerificar.isAfter(dataFim));
    }

    static boolean verificarSeEstaEntreAnos(Year anoParaVerificar, Year anoInicio, Year anoFim) {
        return !(anoParaVerificar.isBefore(anoInicio) || anoParaVerificar.isAfter(anoFim));
    }
}
