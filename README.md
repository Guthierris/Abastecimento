# Abastecimento <img align="center" alt="Gut-Js" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/javascript/javascript-plain.svg"><img align="center" alt="Gut-Android" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/androidstudio/androidstudio-original.svg">
O programa soluciona uma grande duvida da atualidade, ele vai solicitar ao usuario que digite o valor atual da gasolina e o preço atual do etanol, logo dentro de uma condição, ele retorna se é 
melhor o usuario abastecer com gasolina ou etanol.
Para funcionar o programa você precisa emular o codigo no android studio, e utilizar de um android connectado usb ou em ambiente virtual.
#
📱 Inteface: você deve criar 2 EditText com id = EdittextAlcool e EdittextGasolina, um botão para utilizar a função Onlick (CalcularPreço).
#
Codigo Fonte:

    private EditText PreçoAlcool, PreçoGasolina;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PreçoAlcool = findViewById(R.id.textalcool);
        PreçoGasolina = findViewById(R.id.textgasolina);
        resultado = findViewById(R.id.resultado);

    }

    public void CalcularPreço(View view) {

        String EdittextAlcool = PreçoAlcool.getText().toString();
        String EdittextGasolina = PreçoGasolina.getText().toString();
        boolean CamposValidos = validarCampos(EdittextAlcool, EdittextGasolina);
        if (CamposValidos) {
            Double ValorAlcool = Double.parseDouble(EdittextAlcool);
            Double ValorGasolina = Double.parseDouble(EdittextGasolina);
            Double resul = ValorAlcool / ValorGasolina;
            if (resul >= 0.7) {
                resultado.setText("É melhor utilizar gasolina");
            } else {
                resultado.setText("É melhor utilizar Etanol");
            }
        } else {
            resultado.setText("Preencha os campos primeiro");
        }
    }

    public boolean validarCampos(String pAlcool, String pGasolina) {
        boolean camposValidos = true;
        if (pAlcool == null || pAlcool.equals("")) {
            camposValidos = false;
        } else if (pGasolina == null || pGasolina.equals("")) {
            camposValidos = false;
        }
        return camposValidos;
    }
