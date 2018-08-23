

import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.PieSeries.PieSeriesRenderStyle;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.PieStyler.AnnotationType;
import org.knowm.xchart.style.colors.BaseSeriesColors;

/**
 * Pie Chart with Donut Style and sum.
 *
 * <p>Demonstrates the following:
 *
 * <ul>
 *   <li>Donut Chart
 *   <li>PieChartBuilder
 *   <li>XChart Theme
 */
public class PieChart08 {

  public static void main(String[] args) {

    PieChart08 exampleChart = new PieChart08();
    PieChart chart = exampleChart.getChart();
    new SwingWrapper<PieChart>(chart).displayChart();
  }

  public PieChart getChart() {

    // Create Chart
    PieChart chart =
        new PieChartBuilder()
            .width(800)
            .height(600)
            .title("Total Offence Category Face Values")
            .build();

    // Customize Chart
    chart.getStyler().setLegendVisible(false);
    chart.getStyler().setAnnotationType(AnnotationType.Label);
    chart.getStyler().setAnnotationDistance(.82);
    chart.getStyler().setPlotContentSize(.9);
    chart.getStyler().setDefaultSeriesRenderStyle(PieSeriesRenderStyle.Donut);
    chart.getStyler().setDecimalPattern("#");

    chart.getStyler().setSeriesColors(new BaseSeriesColors().getSeriesColors());

    chart.getStyler().setSumVisible(true);
    chart.getStyler().setSumFontSize(20f);

    // Series
    chart.addSeries("2013", 28111641);
    chart.addSeries("2014", 29896253);
   
    return chart;
  }
}
