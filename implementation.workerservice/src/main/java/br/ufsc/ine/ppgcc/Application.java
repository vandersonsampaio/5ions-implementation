package br.ufsc.ine.ppgcc;

import br.ufsc.ine.ppgcc.service.implementation.FiveIonsManager;
import br.ufsc.ine.ppgcc.worker.StandardWorker;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        StandardWorker worker = new StandardWorker(new FiveIonsManager());
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        ScheduledFuture<?> future = executor.scheduleAtFixedRate(worker,
                0, 20, TimeUnit.SECONDS);

        Thread.sleep(60000);

        future.cancel(true);
        executor.shutdown();
    }
}
