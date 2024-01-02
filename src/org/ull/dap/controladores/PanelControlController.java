package org.ull.dap.controladores;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.ull.dap.modelo.BusinessException;
import org.ull.dap.modelo.buisness.BuisnessFactory;
import org.ull.dap.modelo.buisness.seguimiento.SeguimientosService.SeguimientoBLDto;
import org.ull.dap.vistas.MainWindow;
import org.ull.dap.vistas.PanelControl;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;


public class PanelControlController {
    public void crearSeguimiento(MainWindow m, PanelControl pn){
        var user = m.getUserlog();
        try {
            var crypto = BuisnessFactory.forCryptoService().findCryptoByName(pn.getTxElegir().getText());
            if (crypto.isPresent()) {
                var seguimiento = BuisnessFactory.forSeguimientoService().findSeguimientoByIds(user.id,crypto.get().id);
                if (!seguimiento.isPresent()) {
                    SeguimientoBLDto s = new SeguimientoBLDto();
                    s.id_usuario = user.id;
                    s.id_crypto = crypto.get().id;
                    BuisnessFactory.forSeguimientoService().addSeguimiento(s);
                    pn.crearSeguimiento(pn.getTxElegir().getText());
                    pn.revalidate();
                    pn.repaint();
                }else{
                    JOptionPane.showMessageDialog(m, "Ya sigues a esta coin", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
                pn.getTxElegir().setText("");
            }else{
                JOptionPane.showMessageDialog(m, "No existe ese coin o no esta registrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }catch (BusinessException e){
            JOptionPane.showMessageDialog(m, "No existe ese coin o no esta registrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void cambiarCryproSeleccionada(MainWindow m, String nombreCrypto){
        m.cryptoSelected = nombreCrypto;
        double maximo = Collections.max(m.precios.get(nombreCrypto));
        double minimo = Collections.min(m.precios.get(nombreCrypto));
        m.pnControl.txMaximo.setText(0+"");
        m.pnControl.txMinimo.setText(0+"");
        m.pnControl.lblCrypto.setText("Crypto: "+nombreCrypto);
        pintarExtremos(m, maximo);
        pintarExtremos(m, minimo);

        if (!m.cryptoSelected.isBlank()){
            String text = "";
            for (Double d: m.precios.get(m.cryptoSelected)){
                text = text+d+"\n";
            }
            m.pnControl.txaHistorico.setText(text);
            crearGrafico(m,nombreCrypto);
        }
    }

    public void pintarHistorico(MainWindow m, String nameCrypto ,double price){
        if (!m.precios.containsKey(nameCrypto)){
            m.precios.put(nameCrypto, new ArrayList<Double>());
        }
        m.precios.get(nameCrypto).add(price);
        if (!m.cryptoSelected.isBlank() && m.cryptoSelected.equals(nameCrypto)){
            pintarExtremos(m, price);
            String text = "";
            for (Double d: m.precios.get(m.cryptoSelected)){
                 text = text+d+"\n";
            }
            m.pnControl.txaHistorico.setText(text);
            crearGrafico(m, nameCrypto);
        }
    }

    private void crearGrafico(MainWindow m, String nameCrypto) {
        TimeSeries series = new TimeSeries("Datos de Ejemplo");

        // Añadir datos a la serie
        Date initialTime = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(initialTime);
        for (double precio: m.precios.get(nameCrypto)) {
            series.add(new Second(calendar.getTime()), precio);
            calendar.add(Calendar.SECOND, 40);
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Gráfico de Líneas en Precio/Tiempo de "+nameCrypto,
                "Tiempo",
                "Valor",
                dataset,
                false,
                true,
                false);

        // Crear un panel del gráfico
        ChartPanel chartPanel = new ChartPanel(chart);

        // Crear y mostrar un marco para ver el gráfico
        m.pnControl.getPnGrafica().removeAll();
        m.pnControl.getPnGrafica().add(chartPanel, BorderLayout.CENTER);
        m.pnControl.getPnGrafica().revalidate();
        m.pnControl.getPnGrafica().repaint();
    }

    private void pintarExtremos(MainWindow m, double price) {
        if (Double.parseDouble(m.pnControl.txMaximo.getText()) < price || Double.parseDouble(m.pnControl.txMaximo.getText()) == 0){
            m.pnControl.txMaximo.setText(price+"");
        }
        if (Double.parseDouble(m.pnControl.txMinimo.getText()) > price || Double.parseDouble(m.pnControl.txMinimo.getText()) == 0){
            m.pnControl.txMinimo.setText(price+"");
        }
    }
}
