

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
public class PieChart06 {

  public static void main(String[] args) {

    PieChart06 exampleChart = new PieChart06();
    PieChart chart = exampleChart.getChart();
    new SwingWrapper<PieChart>(chart).displayChart();
  }

  public PieChart getChart() {

    // Create Chart
    PieChart chart =
        new PieChartBuilder()
            .width(800)
            .height(600)
            .title("Year 2014 Offence Category Face Values")
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
    chart.addSeries("Parking Offence", 9297100);
    chart.addSeries("Fare Evasion/ False Information", 13038900);
    chart.addSeries("Compliance/ Safety/ Anti-Social/ Offensive Behavior", 7131850);
    chart.addSeries("Vehicle Offence", 212132);
    chart.addSeries("Feet on Seat", 61700);
    chart.addSeries("Smoking Offence", 100250);
    chart.addSeries("Littering Offence", 29150);
    chart.addSeries("Animal Offence", 25171);

    return chart;
  }
}
