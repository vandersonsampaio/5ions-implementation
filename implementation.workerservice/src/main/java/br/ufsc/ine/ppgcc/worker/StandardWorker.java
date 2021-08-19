package br.ufsc.ine.ppgcc.worker;

import br.ufsc.ine.ppgcc.service.implementation.FiveIonsManager;
import br.ufsc.ine.ppgcc.service.interfaces.IFiveIonsManager;

public class StandardWorker implements Runnable {
    private final IFiveIonsManager manager;

    public StandardWorker(IFiveIonsManager manager) {
        this.manager = manager;
    }

    public void run() {
        manager.executionProcess();
    }
}
