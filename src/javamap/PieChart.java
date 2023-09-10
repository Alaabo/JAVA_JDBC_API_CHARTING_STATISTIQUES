/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamap;

import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Z0n3x
 */
public class PieChart {
//    public ChartPanel initUI() {
//        JFreeChart chart = createChart(createDataset());
//        ChartPanel x;
//        x = new ChartPanel(chart);
////        x.setPreferredSize(new Dimension(1000, 1000));
//        return x;
//        
//    }
    
    
     public static DefaultPieDataset createDataset(ArrayList<Mapping> location) {
         
        DefaultPieDataset dataset = new DefaultPieDataset();
        for(Mapping s : location){
        dataset.setValue(s.getEmp() , s.getSpc());
        }
        
        return dataset;
    }

    public static JFreeChart createChart(DefaultPieDataset dataset) {

        JFreeChart pieChart = ChartFactory.createPieChart(
                "espace geographic de l'algerie",
                dataset,
                false, true, false);

        return pieChart;
    }
}
