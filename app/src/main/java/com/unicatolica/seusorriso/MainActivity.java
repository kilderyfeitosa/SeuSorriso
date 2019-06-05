package com.unicatolica.seusorriso;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.loadData("<html>\n" +
                        "<head>\n" +
                        "    <meta charset=\"utf-8\" />\n" +
                        "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                        "    <title>Page Title</title>\n" +
                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                        "    <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"main.css\" />\n" +
                        "    <script src=\"main.js\"></script>\n" +
                        "    <style type=\"text/css\">\n" +
                        "        \n" +
                        "        .corpo {\n" +
                        "        padding: 1vh;\n" +
                        "        text-align: justify;\n" +
                        "        font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;\n" +
                        "        \n" +
                        "        }\n" +
                        "\n" +
                        "        h4{\n" +
                        "        background-color: #d00a1e;\n" +
                        "        color: #FFFFFF;\n" +
                        "        border-radius: 2vh;\n" +
                        "        padding: 3vh;\n" +
                        "        font-size: 4vh;\n" +
                        "        text-align: center;\n" +
                        "        margin-top: 3vh;\n" +
                        "        margin-bottom: 0px;\n" +
                        "        }\n" +
                        "\n" +
                        "         h5{\n" +
                        "        background-color: #d00a1e;\n" +
                        "        color: #FFFFFF;\n" +
                        "        padding: 3vh;\n" +
                        "        width: auto;\n" +
                        "        border-radius: 5vh;\n" +
                        "        font-size: 3vh;\n" +
                        "        text-align:center;\n" +
                        "        margin: 0px;\n" +
                        "        }\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "        .texto{\n" +
                        "        padding: 3vh;\n" +
                        "        background-color: #0b0b5f;\n" +
                        "        color: #ffffff;\n" +
                        "        font-size: 3.5vh;\n" +
                        "        border-radius: 2vh;\n" +
                        "        text-indent: 1.5em;\n" +
                        "        }\n" +
                        "    \n" +
                        "    </style>\n" +
                        "</head>\n" +
                        "<body style='background-color: #1D1D1D;'>\n" +
                        "    <div class=\"corpo\">\n" +
                        "        <h4>DICAS PARA QUEM QUER E/OU PRECISA PARAR DE FUMAR</h4>\n" +
                        "        <div class=\"texto\">\n" +
                        "            <p>\n" +
                        "                Para parar de fumar, as pessoas precisam mudar seu \n" +
                        "                comportamento e para mudar... é preciso mudar! Isso \n" +
                        "                deve levar a um primeiro questionamento e a uma \n" +
                        "                reflexão: o fumante quer, realmente, mudar sua \n" +
                        "                identidade de “fumante” para “não fumante”?\n" +
                        "            </p>\n" +
                        "            <p>\n" +
                        "                Os fumantes estão sendo leva- dos a parar de fumar \n" +
                        "                por diversos motivos, pois está se tornando muito \n" +
                        "                difícil manter o tabagismo – desde a proibição de \n" +
                        "                fumar em ambientes fechados, inclusive no próprio \n" +
                        "                domicílio, até uma verdadeira avalanche de informações \n" +
                        "                sobre danos veiculada pela mídia. Tudo converge para a cessação.\n" +
                        "            </p>\n" +
                        "            <p>\n" +
                        "                O senso crítico está cercando os fumantes – com \n" +
                        "                tantas informações, o sentimento de preservação \n" +
                        "                e a afetividade dos entes queridos está falando \n" +
                        "                mais alto. Isso constrange e in- duz os fumantes \n" +
                        "                a tomar a iniciativa de parar de fumar.\n" +
                        "            </p>\n" +
                        "        </div>\n" +
                        "\n" +
                        "        <h4>COMO PARAR DE FUMAR?</h4>       \n" +
                        "        <div class=\"texto\">\n" +
                        "            <p>\n" +
                        "                Para que o paciente seja bem-sucedido, o melhor \n" +
                        "                é que queira parar de fumar e, se necessário, \n" +
                        "                tenha o acompanhamento de um médico e, quando \n" +
                        "                indicado, use medicações.\n" +
                        "            </p>\n" +
                        "\n" +
                        "            <h5>Na abordagem individual, é fundamental:</h5>\n" +
                        "            \n" +
                        "            <p>\n" +
                        "                - Mostrar os malefícios do fumo, por meio de \n" +
                        "                informações científicas, cursos e debates \n" +
                        "                e, também, salientar como é bom não fumar e ter saúde.\n" +
                        "            </p>\n" +
                        "            <p>\n" +
                        "                - Se o fumante já apresentar sintomas e/ou \n" +
                        "                anormalidades na espirometria, esse poderá \n" +
                        "                ser um forte argumento para convencê-lo da \n" +
                        "                necessidade de cessar o tabagismo.\n" +
                        "            </p>\n" +
                        "            <p>\n" +
                        "                - Deixar bem claro que ele, o fumante, é quem \n" +
                        "                deve decidir parar de fumar.\n" +
                        "            </p>\n" +
                        "            <p>\n" +
                        "                - Embora a maneira de parar de fumar possa ser \n" +
                        "                decidida de acordo com as necessidades \n" +
                        "                individuais, como regra, é preferível \n" +
                        "                aconselhar que a parada seja abrupta, \n" +
                        "                devendo ser marcado o “dia D”.\n" +
                        "            </p>\n" +
                        "            <p>\n" +
                        "                - Avaliar o suporte familiar: se o cônjuge \n" +
                        "                ou outra pessoa do convívio domiciliar for \n" +
                        "                tabagista, deve aderir ao programa ou, \n" +
                        "                pelo menos, não fumar na presença do paciente.\n" +
                        "            </p>\n" +
                        "            <p>\n" +
                        "                - Com recursos e objetivos definidos, deve \n" +
                        "                ser estabelecido um programa \n" +
                        "                individualizado para parar de fumar.\n" +
                        "            </p>\n" +
                        "            <p>\n" +
                        "                Não existe um momento ideal, mas é preferível \n" +
                        "                que o fumante se prepare para a cessação quando \n" +
                        "                não estiver vivendo situações muito estressantes. \n" +
                        "                Porém, se o estresse faz parte da vida do fumante, \n" +
                        "                e é uma constante, então, o melhor é não esperar mais!\n" +
                        "            </p>\n" +
                        "        </div>\n" +
                        "\n" +
                        "        <h4>O MELHOR É MARCAR UMA DATA PRÓXIMA PARA A PARADA (O “DIA D”)</h4>\n" +
                        "        <div class=\"texto\">\n" +
                        "            <p>\n" +
                        "                Recomenda-se a parada abrupta, ou seja, \n" +
                        "                o fumante deixa de fumar de uma só vez, \n" +
                        "                cessando totalmente o uso de cigarros \n" +
                        "                de uma hora para outra. Nesse caso, \n" +
                        "                se seu grau de dependência for elevado, \n" +
                        "                existem recursos para diminuir o \n" +
                        "                desconforto da abstinência, como \n" +
                        "                reposição de nicotina (adesivo e \n" +
                        "                goma de mascar), bloqueador de \n" +
                        "                receptor nicotínico e medicamentos psicoativos.\n" +
                        "            </p>\n" +
                        "            <p>\n" +
                        "                Outra forma de parar é a parada gradual, \n" +
                        "                em que o fumante diminui o número de \n" +
                        "                cigarros durante uma semana até parar \n" +
                        "                definitivamente ou vai adiando a hora \n" +
                        "                do primeiro cigarro do dia. A parada \n" +
                        "                gradual não deve durar mais de 1 a 2 semanas, \n" +
                        "                caso contrário poderá virar uma forma de adiar, \n" +
                        "                e não de parar. O melhor é marcar uma data limite.\n" +
                        "            </p>\n" +
                        "        \n" +
                        "            <h5>  \n" +
                        "                Inicialmente, deve ser avaliado o grau \n" +
                        "                de dependência da nicotina.\n" +
                        "            </h5>\n" +
                        "            <p>\n" +
                        "                Se você fuma poucos cigarros por dia \n" +
                        "                (menos de 10) e pode ficar muitas \n" +
                        "                horas ou até dias sem fumar, sem \n" +
                        "                grandes dificuldades, sua dependência \n" +
                        "                é mínima, e você terá boa chance de \n" +
                        "                parar de fumar por conta própria. \n" +
                        "                Marque um determinado dia e pare de vez.\n" +
                        "            </p>\n" +
                        "            <p>\n" +
                        "                Se fuma muito (20 cigarros ou mais por dia) \n" +
                        "                e se quando fica algumas horas sem fumar \n" +
                        "                se sente mal, ansioso, compulsivo, \n" +
                        "                procure um médico especializado \n" +
                        "                em tabagismo. Médicos, principalmente \n" +
                        "                pneumologistas, estão desenvolvendo \n" +
                        "                programas qualificados de tratamento. \n" +
                        "                Deverá ser avaliado o melhor programa \n" +
                        "                para você parar de fumar. Conforme \n" +
                        "                a situação, poderá ser indicado \n" +
                        "                o uso de medicamentos.\n" +
                        "            </p>\n" +
                        "        </div>\n" +
                        "\n" +
                        "        <h4>O QUE PODERÁ OCORRER NO PERÍODO DA CESSAÇÃO?</h4>\n" +
                        "            <div class=\"texto\">\n" +
                        "            <p>Como o fumante ficou dependente da nicotina, da mesma forma que com outras substâncias de dependência, como álcool, cocaína e heroína, os primeiros dias sem cigarros costumam ser os mais difíceis. Algumas pessoas, quando param de fumar podem apresentar irritabilidade, desejo intenso de fumar, ansiedade e outras manifestações orgânicas e emocionais. A isso é chamado “síndrome de abstinência”. A maioria desses sintomas tem início algumas horas após parar de fumar e atinge intensidade máxima depois de 24 a 48 horas, diminuindo gradativamente nas semanas seguintes. A terapia de reposição de nicotina e certos medicamentos ajudam a controlar esses sintomas.\n" +
                        "            </p>\n" +
                        "            <h5>Sempre será importante fugir das armadilhas que levam à recaída. Veja algumas dicas:</h5>\n" +
                        "            <p>\n" +
                        "                - Marcar o dia para parar de fumar (o “dia D”).\n" +
                        "            </p>\n" +
                        "            <p> \n" +
                        "                - Evitar contato com fumantes, pelo menos no período inicial da cessação (manter distância). \n" +
                        "            </p>\n" +
                        "            <p>\n" +
                        "                - Comprar apenas uma carteira de cigarros de cada vez (não comprar mais pacotes inteiros)\n" +
                        "            </p>\n" +
                        "            <p>\n" +
                        "                - Não fumar dentro do lar (eliminar cinzeiros e o odor de cigarros). \n" +
                        "            </p>\n" +
                        "            <p>\n" +
                        "                - Beber bastante água e outros líquidos (muitos copos por dia).\n" +
                        "            </p>\n" +
                        "            <p>\n" +
                        "                - Alimentar-se com uma dieta apropriada (evitar o ganho de peso). \n" +
                        "            </p>\n" +
                        "            <p>\n" +
                        "                - Comer frutas cítricas. ␣\tMastigar balas ou chicletes sem açúcar. \n" +
                        "            </p>    \n" +
                        "            <p>\n" +
                        "                - Evitar café e bebidas alcoólicas. ␣\tEscovar os dentes imediatamente após as refeições. \n" +
                        "            </p>\n" +
                        "            <p>\n" +
                        "                - Ficar atento às situações de estresse (o cigarro não resolverá seus problemas). \n" +
                        "            </p>\n" +
                        "            <p>\n" +
                        "                - Praticar alguma atividade física do seu agrado (caminhadas, exercícios, esportes).\n" +
                        "            </p>\n" +
                        "            <p>\n" +
                        "                - Fazer exercícios de relaxamento (respirar fundo e procurar relaxar os músculos). \n" +
                        "            </p>\n" +
                        "            <p>   \n" +
                        "                - Manter sua decisão de parar de fumar.\n" +
                        "            </p>\n" +
                        "            <p></p>\n" +
                        "            Modificar hábitos antigos que o levam a fumar. Procurar atividades alternativas para o lazer. O uso da reposição de nicotina ou de outro medicamento pode facilitar a parada, diminuindo os sintomas de abstinência – conversar com profissional especializado.\n" +
                        "\n" +
                        "        </div>\n" +
                        "        \n" +
                        "    </div>\n" +
                        "\n" +
                        "</body>\n" +
                        "</html>",
                "text/html", "utf-8");
    }

    public void simular(View view){
        Intent i = new Intent(this, MouthActivity.class);
        startActivity(i);
    }
}