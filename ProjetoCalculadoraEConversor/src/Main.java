import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main extends Application {
    @Override
    public void start(Stage primeiroPalco) {
        Label lblResposta = new Label("Resposta");
        lblResposta.setAlignment(Pos.CENTER);
        lblResposta.setStyle("-fx-border-color: #000; -fx-padding: 5px; -fx-width: 30px;");
        lblResposta.setPrefHeight(45);
        lblResposta.setPrefWidth(310);

        TextField tfNum1 = new TextField();
        tfNum1.setPrefWidth(150);

        TextField tfNum2 = new TextField();
        tfNum2.setPrefWidth(150);

        Button btnAdicao = new Button("+");
        btnAdicao.setPrefHeight(35);
        btnAdicao.setPrefWidth(150);

        Button btnSubtracao = new Button("-");
        btnSubtracao.setPrefHeight(35);
        btnSubtracao.setPrefWidth(150);

        Button btnMultiplicacao = new Button("*");
        btnMultiplicacao.setPrefHeight(35);
        btnMultiplicacao.setPrefWidth(150);

        Button btnDivisao = new Button("/");
        btnDivisao.setPrefHeight(35);
        btnDivisao.setPrefWidth(150);

        Button btnLimpar = new Button("Limpar");
        btnLimpar.setPrefWidth(310);

        Button btnTemperatura = new Button("Conversor de Temperatura");
        btnTemperatura.setPrefHeight(35);
        btnTemperatura.setPrefWidth(310);
        btnTemperatura.setStyle("-fx-background-radius: 0; -fx-border-color: #483D8B; -fx-border-width: 1 2 2 1; -fx-background-insets: 0;");

        //Eventos do Botão Adição
        btnAdicao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double num1 = Double.parseDouble(tfNum1.getText());
                double num2 = Double.parseDouble(tfNum2.getText());
                double resposta = num1 + num2;
                lblResposta.setText(num1 + " + " + num2 + " = " + resposta);
            }
        });

        //Eventos do Botão Subtração
        btnSubtracao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               double num1 = Double.parseDouble(tfNum1.getText());
               double num2 = Double.parseDouble(tfNum2.getText());
               double resposta = num1 - num2;
               lblResposta.setText(num1 + " - " + num2 + " = " + resposta);
            }
        });

        //Eventos do Botão Multiplicação
        btnMultiplicacao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double num1 = Double.parseDouble(tfNum1.getText());
                double num2 = Double.parseDouble(tfNum2.getText());
                double resposta = num1 * num2;
                lblResposta.setText(num1 + " * " + num2 + " = " + resposta);
            }
        });

        //Eventos do Botão Divisão
        btnDivisao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double num1 = Double.parseDouble(tfNum1.getText());
                double num2 = Double.parseDouble(tfNum2.getText());
                double resposta = num1 / num2;
                lblResposta.setText(num1 + " / " + num2 + " = " + resposta);
            }
        });

        //Eventos do Botão Limpar
        btnLimpar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tfNum1.setText("");
                tfNum2.setText("");
                lblResposta.setText("Resposta");
                tfNum1.requestFocus();
            }
        });

        //Eventos do Botão Temperatura (Conversor Temperatura)
        btnTemperatura.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label lblResultado = new Label("Resultado");
                TextField tfTemperatura = new TextField();
                Button btnCparaF = new Button("°C para °F");
                Button btnFparaC = new Button("°F para °C");

                //Eventos do Botão 'C para F'
                btnCparaF.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        double temperatura = Double.parseDouble(tfTemperatura.getText());
                        double resposta = ((temperatura * 1.8) + 32);
                        BigDecimal respostaBD = new BigDecimal(resposta).setScale(1, RoundingMode.HALF_EVEN);
                        lblResultado.setText(temperatura + " °C = " + respostaBD + " °F");
                    }
                });

                //Eventos do Botão 'F para C'
                btnFparaC.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        double temperatura = Double.parseDouble(tfTemperatura.getText());
                        double resposta = ((temperatura - 32) / 1.8);
                        BigDecimal respostaBD = new BigDecimal(resposta).setScale(1, RoundingMode.HALF_EVEN);
                        lblResultado.setText(temperatura + " °F = " + respostaBD + " °C");
                    }
                });

                GridPane lytTemperatura = new GridPane();
                lytTemperatura.setStyle("-fx-background-color: #483D8B; -fx-background-radius: 0; -fx-border-width: 3 3 3 3; -fx-background-insets: 0; -fx-focus-color: rgba(255,0,0,1);");
                lytTemperatura.setAlignment(Pos.CENTER);
                lytTemperatura.setHgap(6);
                lytTemperatura.setVgap(6);
                lytTemperatura.add(lblResultado, 0, 1);
                
                lblResultado.setAlignment(Pos.CENTER);
                lblResultado.setStyle("-fx-background-color: #FFF; -fx-border-color: #000; -fx-padding: 15px; -fx-width: 30px;");
                lblResultado.setPrefWidth(290);
                
                lytTemperatura.add(tfTemperatura, 0, 2);
                tfTemperatura.setAlignment(Pos.CENTER);
                lytTemperatura.add(btnCparaF, 0, 3);
                lytTemperatura.add(btnFparaC, 0, 4);

                btnCparaF.setPrefWidth(290);
                btnFparaC.setPrefWidth(290);

                Scene cenaNova = new Scene(lytTemperatura, 325, 175);
                Stage stgNovaJanela = new Stage();
                stgNovaJanela.setTitle("Conversor de Temperatura");
                stgNovaJanela.setScene(cenaNova);
                stgNovaJanela.setX(primeiroPalco.getX()+200);
                stgNovaJanela.setY(primeiroPalco.getY()+100);
                stgNovaJanela.show();
            }
        });

        //Criando Layout 'raiz' em Grade
        GridPane raiz = new GridPane();
        raiz.setHgap(10);
        raiz.setVgap(10);
        raiz.setAlignment(Pos.CENTER);

        raiz.add(lblResposta, 0, 0, 2, 1);
        raiz.add(tfNum1, 0, 1);
        raiz.add(tfNum2, 1, 1);
        raiz.add(btnAdicao, 0, 2);
        raiz.add(btnSubtracao, 1, 2);
        raiz.add(btnMultiplicacao, 0, 3);
        raiz.add(btnDivisao, 1, 3);
        raiz.add(btnLimpar, 0, 5, 2, 1);
        raiz.add(btnTemperatura, 0, 9, 2, 1);

        //Criando Cenário 'cena'
        Scene cena = new Scene(raiz, 350, 300);
        primeiroPalco.setTitle("Calculadora JavaFX v1.5");
        primeiroPalco.setScene(cena);
        primeiroPalco.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
