package spike;
import hex.genmodel.easy.EasyPredictModelWrapper;
import hex.genmodel.easy.RowData;
import hex.genmodel.MojoModel;
import hex.genmodel.easy.prediction.RegressionModelPrediction;
import java.io.IOException;
import io.javalin.Javalin;

public class App {
  public static void main(String[] args) throws IOException {
    String modelPath = args[0];
    EasyPredictModelWrapper model = new EasyPredictModelWrapper(MojoModel.load(modelPath));
    Javalin app = Javalin.start(8080);

    app.get("/predict", ctx -> {
      RowData params = new RowData();
      ctx.queryParamMap().forEach((param, value) -> {
        params.put(param, ctx.queryParam(param));
      });
      RegressionModelPrediction prediction = model.predictRegression(params);
      ctx.result("prediction: "+ prediction.value);
    });
    //http://localhost:8080/predict?age=19&sex=male&bmi=27.9&children=0&region=southwest
  }
}
