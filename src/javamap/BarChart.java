/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamap;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import org.jfree.chart.renderer.category.BarRenderer;
 
public class BarChart extends JFrame{

//    public ChartPanel initUI() {
//        JFreeChart chart = createChart(createDataset());
//        ChartPanel x;
//        x = new ChartPanel(chart);
////        x.setPreferredSize(new Dimension(1000, 1000));
//        return x;
//        
//    }
    
    
    public CategoryDataset createDataset(ArrayList<Mapping> location ) {
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(Mapping s : location){
        dataset.setValue(s.getPop() , "population" ,s.getEmp());
        }


        return dataset;
         
        
        
    }
    public static JFreeChart createChart(CategoryDataset dataset) {

        JFreeChart barChart = ChartFactory.createBarChart(
                "population de l'Algerie",
                "population",
                "willaya",
                dataset,
                PlotOrientation.HORIZONTAL,
                false, true, false);
                
        return barChart;
    }
    
}
