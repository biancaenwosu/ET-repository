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

    private Comparable lastHoveredSection = null; 
    private JPopupMenu hoverPopup;

    public PieChartPanel(String chartTitle, DefaultPieDataset dataset) {
       
        JFreeChart pieChart = createPieChart(chartTitle, dataset);

       
        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setPreferredSize(new Dimension(800, 600));

        hoverPopup = new JPopupMenu();
        hoverPopup.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        hoverPopup.add(new JLabel("")); 
       
        chartPanel.addChartMouseListener(new ChartMouseListener() {
            @Override
            public void chartMouseClicked(ChartMouseEvent event) {
                
            }

            @Override
            public void chartMouseMoved(ChartMouseEvent event) {
                ChartEntity entity = event.getEntity();
                if (entity instanceof PieSectionEntity) {
                    PieSectionEntity pieEntity = (PieSectionEntity) entity;
                    Comparable key = pieEntity.getSectionKey();  
                    Number value = dataset.getValue(key);

                   
                    if (!key.equals(lastHoveredSection)) {
                        updatePopup(key, value, event.getTrigger().getXOnScreen(), event.getTrigger().getYOnScreen(), chartPanel);
                        System.out.println("Hovering over: " + key + " - Value: " + value);
                        lastHoveredSection = key; 
                    }
                } else {
                    hoverPopup.setVisible(false);
                    lastHoveredSection = null; 
                }
            }
        });

     
        this.setLayout(new BorderLayout());
        this.add(chartPanel, BorderLayout.CENTER);
    }

    private void updatePopup(Comparable key, Number value, int x, int y, ChartPanel chartPanel) {
        hoverPopup.setVisible(false); 

     
        String content = key + ": " + value;
        ((JLabel) hoverPopup.getComponent(0)).setText(content);

        hoverPopup.show(chartPanel, x - chartPanel.getLocationOnScreen().x, y - chartPanel.getLocationOnScreen().y);
    }

    private JFreeChart createPieChart(String title, DefaultPieDataset dataset) {

        JFreeChart chart = ChartFactory.createPieChart(
                title,                
                dataset,              
                true,                
                true,
                false
        );

        PiePlot plot = (PiePlot) chart.getPlot();

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
