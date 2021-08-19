package br.ufsc.ine.ppgcc.service.implementation;

import br.ufsc.ine.ppgcc.service.implementation.service.SummarizationService;
import br.ufsc.ine.ppgcc.service.interfaces.IFiveIonsManager;

public class FiveIonsManager implements IFiveIonsManager {

    private final SummarizationService summarizationService;

    public FiveIonsManager(){
        summarizationService = new SummarizationService();
    }

    @Override
    public void executionProcess() {
        String summary = summarizationService.summarize();
        System.out.println("Five Ions Manager working...");
        System.out.println(summary);
    }
}
