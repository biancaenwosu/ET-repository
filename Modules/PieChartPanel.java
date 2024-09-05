import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.PieSectionEntity;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;

import javax.swing.*;
import java.awt.*;

public class PieChartPanel extends JPanel {

  
    public PieChartPanel(String chartTitle, DefaultPieDataset dataset) {

     
        JFreeChart pieChart = createPieChart(chartTitle, dataset);
        
        
    
        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setPreferredSize(new Dimension(800, 600));

 
        chartPanel.addChartMouseListener(new ChartMouseListener() {
            @Override
            public void chartMouseClicked(ChartMouseEvent event) {
                ChartEntity entity = event.getEntity();
                if (entity instanceof PieSectionEntity) {
                    PieSectionEntity pieEntity = (PieSectionEntity) entity;
                    Comparable key = pieEntity.getSectionKey();  
                    Number value = dataset.getValue(key);        
                    System.out.println("Clicked on: " + key + " - Value: " + value);
                }
            }

            @Override
            public void chartMouseMoved(ChartMouseEvent event) {
                ChartEntity entity = event.getEntity();
                if (entity instanceof PieSectionEntity) {
                    PieSectionEntity pieEntity = (PieSectionEntity) entity;
                    Comparable key = pieEntity.getSectionKey(); 
                    System.out.println("Mouse over: " + key);
                }
            }
        });

        this.setLayout(new BorderLayout());
        this.add(chartPanel, BorderLayout.CENTER);
    }


    private JFreeChart createPieChart(String title, DefaultPieDataset dataset) {
  
        JFreeChart chart = ChartFactory.createPieChart(
                title,                
                dataset,              
                true,                
                true,
                false
        );


   



        return chart;
    }


    public static DefaultPieDataset createExpenseDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Rent", 439.00);
        dataset.setValue("Groceries", 133.00);
        dataset.setValue("Household bills", 79.00);
        dataset.setValue("Going out", 69.00);
        dataset.setValue("Transport", 69.00);
        dataset.setValue("Takeaways and eating out", 66.00);
        dataset.setValue("Clothes and shopping", 48.00);
        dataset.setValue("Holidays and events", 36.00);
        dataset.setValue("Health and wellbeing", 26.00);
        dataset.setValue("Other", 25.00);
        dataset.setValue("Mobile phone", 24.00);
        dataset.setValue("Course materials", 24.00);
        dataset.setValue("Gifts and charity", 21.00);
        dataset.setValue("Friends and family", 19.00);
        return dataset;
    }

   
}
