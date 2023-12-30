package org.ull.dap.modelo.buisness.apicrypto.notifier;


import org.ull.dap.modelo.buisness.apicrypto.connections.CryptocurrencyAPI;
import org.ull.dap.modelo.buisness.apicrypto.connections.IConnectionAPI;
import org.ull.dap.modelo.buisness.apicrypto.enitity.Asset;
import org.ull.dap.modelo.buisness.apicrypto.user.IObserver;
import org.ull.dap.modelo.buisness.apicrypto.user.User;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class CryptocurrencyNotifier implements Observable {

    private List<IObserver> observers;

    private IConnectionAPI connectionAPI;

    private List<String> namesCryptocurrencies;

    private List<Asset> assets;

    private final int TIME_TO_NOTIFY = 40;

    public CryptocurrencyNotifier() {
        this.observers = new ArrayList<>();
        this.connectionAPI = new CryptocurrencyAPI();
        this.namesCryptocurrencies = List.of("bitcoin", "ethereum", "litecoin", "cardano");
        this.assets = new ArrayList<>();
    }



    public List<IObserver> getObservers() {
        return observers;
    }

    @Override
    public void subscribe(IObserver observer) {
        if (!this.observers.contains(observer)) {
            this.observers.add(observer);
        }
    }

    @Override
    public void unsubscribe(IObserver observer) {
        if (this.observers.contains(observer)) {
            this.observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        //VentanaNotificacion v;
        for (IObserver observer : observers) {
            //v = new VentanaNotificacion();
            Map<String, Double> cryptoPrices = ((User) observer).getCryptoPrices();
            for (Asset asset : assets) {
                String assetId = asset.getData().getId();

                if (observer.getNameCryptos().contains(assetId)) {
                    Double previousPrice = cryptoPrices.getOrDefault(assetId, 0.0);
                    Double currentPrice = asset.getData().getPriceUsd();

                    if (!Objects.equals(previousPrice, currentPrice)) {
                        observer.update(assetId, currentPrice);//observer.update(assetId, currentPrice, v);
                        //v.setVisible(true);
                        cryptoPrices.put(assetId, currentPrice);

                    }
                }
            }
        }
    }

    //Inicia las tareas programadas para obtener los datos de las criptomonedas cada 40 segundos
    public void start() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        ScheduledFuture<?> scheduledFuture = executorService.scheduleAtFixedRate(() -> {
            assets.clear();
            try {
                for (String nameCrypto : namesCryptocurrencies) {
                    Asset asset = ((CryptocurrencyAPI) connectionAPI).getAssetData(nameCrypto);
                    assets.add(asset);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Assets:\n ");
            assets.forEach(v -> System.out.println(v.getData().getName() + " " + v.getData().getPriceUsd()));
            System.out.println("\n");

            System.out.println("Notifying observers...\n");
            notifyObservers();
        }, 0, TIME_TO_NOTIFY, TimeUnit.SECONDS);

        try {
            scheduledFuture.get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
