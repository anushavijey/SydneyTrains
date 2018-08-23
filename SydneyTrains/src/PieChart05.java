

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
public class PieChart05 {

  public static void main(String[] args) {

    PieChart05 exampleChart = new PieChart05();
    PieChart chart = exampleChart.getChart();
    new SwingWrapper<PieChart>(chart).displayChart();
  }

  public PieChart getChart() {

    // Create Chart
    PieChart chart =
        new PieChartBuilder()
            .width(800)
            .height(600)
            .title("Year 2013 Offence Category Face Values")
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
    chart.addSeries("Parking Offence", 8136122);
    chart.addSeries("Fare Evasion/ False Information", 13038900);
    chart.addSeries("Compliance/ Safety/ Anti-Social/ Offensive Behavior", 6652750);
    chart.addSeries("Vehicle Offence", 121359);
    chart.addSeries("Feet on Seat", 35000);
    chart.addSeries("Smoking Offence", 87500);
    chart.addSeries("Littering Offence", 17860);
    chart.addSeries("Animal Offence", 22150);

    return chart;
  }
}
