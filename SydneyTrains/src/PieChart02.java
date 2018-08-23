

import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;

/**
 * Pie Chart with 4 Slices
 *
 * <p>Demonstrates the following:
 *
 * <ul>
 *   <li>Pie Chart
 *   <li>ChartBuilderPie
 *   <li>Setting Non-circular to match container aspect ratio
 */
public class PieChart02 {

  public static void main(String[] args) {

    PieChart02 exampleChart = new PieChart02();
    PieChart chart = exampleChart.getChart();
    new SwingWrapper<PieChart>(chart).displayChart();
  }

  public PieChart getChart() {

    // Create Chart
    PieChart chart =
        new PieChartBuilder().width(800).height(600).title("Year 2014 Offence Report Number of PNs").build();

    // Customize Chart
    chart.getStyler().setCircular(false);

    // Series
    chart.addSeries("Parking Offence", 91891);
    chart.addSeries("Fare Evasion/ False Information", 69705);
    chart.addSeries("Compliance/ Safety/ Anti-Social/ Offensive Behavior", 32189);
    chart.addSeries("Vehicle Offence", 781);
    chart.addSeries("Feet on Seat", 617);
    chart.addSeries("Smoking Offence", 450);
    chart.addSeries("Littering Offence", 167);
    chart.addSeries("Animal Offence", 123);
    

    return chart;
  }
}
