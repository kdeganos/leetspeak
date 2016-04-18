import java.io.Console;

import java.util.Map;
import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class Leetspeak {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/leetspeakOutput", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/leetspeakOutput.vtl");

      String inputString = request.queryParams("inputString");
      inputString = leetspeak(inputString);
      model.put("inputString", inputString);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static String leetspeak(String sentence) {
    // ArrayList<String> outputList = new ArrayList<String>();
    char[] charSentence = sentence.toCharArray();

    for (int index = 0; index < charSentence.length; index++) {
      if (charSentence[index] == 'e' || charSentence[index] == 'E') {
        charSentence[index] = '3';
      } else if (charSentence[index] == 'o' || charSentence[index] == 'O') {
        charSentence[index] = '0';
      } else if (charSentence[index] == 'I') {
        charSentence[index] = '1';
      } else if (index != 0 && charSentence[index - 1] != ' ' && (charSentence[index] == 's' || charSentence[index] == 'S')) {
        charSentence[index] = 'z';
      }
    }
    sentence = String.valueOf(charSentence);
    return sentence;
  }
}
