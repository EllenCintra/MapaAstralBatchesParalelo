package org.example.utils;

import java.time.MonthDay;
import java.time.Year;

import static org.example.utils.DataUtils.verificarSeEstaEntreAnos;
import static org.example.utils.DataUtils.verificarSeEstaEntreDatas;

public interface MapaAstral {

        static String verificarSigno(MonthDay aniversario) {
        MonthDay leaoComecaEm = MonthDay.of(7,22);
        MonthDay leaoTerminaEm = MonthDay.of(8,23);

        MonthDay sagitarioComecaEm = MonthDay.of(11,21);
        MonthDay sagitarioTerminaEm = MonthDay.of(12,22);

        MonthDay aquarioComecaEm = MonthDay.of(01,21);
        MonthDay aquarioTerminaEm = MonthDay.of(02,19);

        MonthDay cancerComecaEm = MonthDay.of(06,22);
        MonthDay cancerTerminaEm = MonthDay.of(07,22);

        MonthDay escorpiaoComecaEm = MonthDay.of(10,23);
        MonthDay escorpiaoTerminaEm = MonthDay.of(11,21);

        if (verificarSeEstaEntreDatas(aniversario, leaoComecaEm, leaoTerminaEm)) return "Leão";

        if (verificarSeEstaEntreDatas(aniversario, sagitarioComecaEm, sagitarioTerminaEm)) return "Sagitário";

        if (verificarSeEstaEntreDatas(aniversario, aquarioComecaEm, aquarioTerminaEm)) return "Aquário";

        if (verificarSeEstaEntreDatas(aniversario, escorpiaoComecaEm, escorpiaoTerminaEm)) return "Escorpião";

        if (verificarSeEstaEntreDatas(aniversario, cancerComecaEm, cancerTerminaEm)) return "Câncer";

        return null;
    }


    static String definirGeracao(Year anoDeNascimento) {
        Year boomerInicio = Year.of(1940);
        Year boomerFim = Year.of(1960);

        Year xInicio = Year.of(1961);
        Year xFim = Year.of(1980);

        Year yInicio = Year.of(1981);
        Year yFim = Year.of(1995);

        Year zInicio = Year.of(1996);
        Year zFim = Year.of(2010);

        if (verificarSeEstaEntreAnos(anoDeNascimento, boomerInicio, boomerFim)) return "Boomer";

        if (verificarSeEstaEntreAnos(anoDeNascimento, xInicio, xFim)) return "X";

        if (verificarSeEstaEntreAnos(anoDeNascimento, yInicio, yFim)) return "Y";

        if (verificarSeEstaEntreAnos(anoDeNascimento, zInicio, zFim)) return "Z";

        return null;
    }

}
