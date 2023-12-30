package org.ull.dap.modelo.buisness.apicrypto.notifier;


import org.ull.dap.modelo.buisness.apicrypto.user.IObserver;

public interface Observable {

    void subscribe(IObserver observer);

    void unsubscribe(IObserver observer);

    void notifyObservers();
}
