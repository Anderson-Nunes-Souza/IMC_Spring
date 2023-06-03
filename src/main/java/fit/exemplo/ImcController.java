package fit.exemplo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImcController {

    @PostMapping("/calcula")
    public String calcularIMC(@RequestBody ImcRequest request) {
        double imc = request.getPeso() / Math.pow(request.getAltura(), 2);
        String resultado;

        if (imc < 18.5) {
            resultado = "Abaixo do peso";
        } else if (imc < 25) {
            resultado = "Peso normal";
        } else if (imc < 30) {
            resultado = "Sobrepeso";
        } else {
            resultado = "Obesidade";
        }

        return "Seu IMC é: " + imc + ". " + resultado;
    }
}
