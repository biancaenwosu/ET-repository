import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.PieSectionEntity;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.HashNMap;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import java.awt.*;

public class PieChartPanel extends JPanel {

    private Comparable lastHoveredSection = null; 
    private JPopupMenu hoverPopup;
    private static DefaultPieDataset dataset;
    private static JFreeChart pieChart; 
  
    public  PieChartPanel(String chartTitle, DefaultPieDataset dataset) {
       PieChartPanel.dataset = dataset;
       pieChart = createPieChart(chartTitle, dataset);

       
        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setPreferredSize(new Dimension(800, 600));

        hoverPopup = new JPopupMenu();
        hoverPopup.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        hoverPopup.add(new JLabel("")); 
       
        chartPanel.addChartMouseListener(new ChartMouseListener() {
            @Override
            public void chartMouseClicked(ChartMouseEvent event) {
                System.out.println("Clicked");
                popup.main(null); // shows popup page
                
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


    public static void updateDataset() {
        HashMap<String, Double> dataMap = DataHandler.returnCurrentValueProfile();
        dataset.clear(); // Clear the old data
        for (Map.Entry<String, Double> entry : dataMap.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }
        pieChart.fireChartChanged(); // Notify the chart panel to update
    }

    public void addData(String key, double value) {
        dataset.setValue(key, value); // Add new value
        pieChart.fireChartChanged();  // Notify the chart of the change
    }

    public void removeData(String key) {
        dataset.remove(key); // Remove the value
        pieChart.fireChartChanged(); // Notify the chart of the change
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
      
        Color[] purpleShades = {
            new Color(200, 160, 255), // Light lavender
            new Color(180, 130, 255), // Light medium orchid
            new Color(160, 100, 255), // Light dark orchid
            new Color(140, 70, 255),  // Light deep purple
            new Color(120, 40, 255),  // Medium deep purple
            new Color(100, 10, 255),  // Dark purple
            new Color(80, 0, 255),    // Very dark purple
            new Color(60, 0, 255),    // Nearly black purple
            new Color(40, 0, 255),    // Almost black purple
            new Color(20, 0, 255)     // Very dark violet
        };

        // Set colors to sections
        String[] sectionLabels = {
            "Rent", "Groceries", "Household bills", "Going out", "Transport",
            "Takeaways and eating out", "Clothes and shopping", "Holidays and events",
            "Health and wellbeing", "Other", "Mobile phone", "Course materials",
            "Gifts and charity", "Friends and family"
        };

        for (int i = 0; i < sectionLabels.length; i++) {
            plot.setSectionPaint(sectionLabels[i], purpleShades[i % purpleShades.length]);
        }
        chart.removeLegend();
        plot.setLabelGenerator(null);
        return chart;
    }

    public JFreeChart getPieChart(){
        return pieChart;
    }
  


    public static DefaultPieDataset createExpenseDataset() {
        HashMap<String,Double> currentValueProfile = DataHandler.returnCurrentValueProfile();
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Rent",1); //currentValueProfile.get("Rent") 
        dataset.setValue("Groceries",currentValueProfile.get("Groceries"));
        dataset.setValue("Household bills", currentValueProfile.get("Household bills"));
        dataset.setValue("Going out", currentValueProfile.get("Going out"));
        dataset.setValue("Transport", currentValueProfile.get("Transport"));
        dataset.setValue("Takeaways and eating out",currentValueProfile.get("Takeaways and eating out"));
        dataset.setValue("Clothes and shopping", currentValueProfile.get("Clothes and shopping"));
        dataset.setValue("Holidays and events", currentValueProfile.get("Holidays and events"));
        dataset.setValue("Health and wellbeing", currentValueProfile.get("Health and wellbeing"));
        dataset.setValue("Other", currentValueProfile.get("Other"));
        dataset.setValue("Mobile phone", currentValueProfile.get("Mobile phone"));
        dataset.setValue("Course materials", currentValueProfile.get("Course materials"));
        dataset.setValue("Gifts and charity", currentValueProfile.get("Gifts and charity"));
        dataset.setValue("Friends and family", currentValueProfile.get("Friends and family"));
        return dataset;
    }

  
 
}
