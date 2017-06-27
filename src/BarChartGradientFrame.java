import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategorySeriesLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarChartGradientFrame extends ApplicationFrame   
{   
    private static final long serialVersionUID = -4316075518094318809L;   
                
    public BarChartGradientFrame(String title){   
        super(title);   
        JPanel jpanel = createDemoPanel();   
        jpanel.setPreferredSize(new Dimension(270, 500));   
        setContentPane(jpanel);   
    }   
                
    JPanel createDemoPanel()   
    {   
        JFreeChart jfreechart = createChart(createDataset());   
        return new ChartPanel(jfreechart);   
    }   
                
    public static void main(String[] args){   
        BarChartGradientFrame barchartdemo = new BarChartGradientFrame("机台用量统计");   
        barchartdemo.pack();   
        RefineryUtilities.centerFrameOnScreen(barchartdemo);   
        barchartdemo.setVisible(true);   
                
    } 
    private static CategoryDataset createDataset() {   
        double[][] ds = { { 2,8,5 },   //几列表示有几个机台，几行表示有几个因数
                        };   
        String[] times = {"time"};
        String[] machine = {"1#","2#","3#"};
        return DatasetUtilities.createCategoryDataset(times,machine,ds);   
    }   
             
    private static JFreeChart createChart(CategoryDataset categorydataset) {   
        JFreeChart jfreechart = ChartFactory.createBarChart("demo",   
                "Category", "Score (%)", categorydataset,   
                PlotOrientation.VERTICAL, true, true, false);   
        jfreechart.setBackgroundPaint(Color.white);   
        CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();   
        categoryplot.setBackgroundPaint(Color.lightGray);   
        categoryplot.setRangeGridlinePaint(Color.white);   
        categoryplot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);   
        NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();   
        //设置值域范围   
        numberaxis.setRange(0.0, 10.0);   
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());   
        BarRenderer barrenderer = (BarRenderer) categoryplot.getRenderer();   
        barrenderer.setDrawBarOutline(false);   
        barrenderer.setLegendItemToolTipGenerator(new StandardCategorySeriesLabelGenerator("Tooltip: {0}"));   
        return jfreechart;   
    }


    
    
}