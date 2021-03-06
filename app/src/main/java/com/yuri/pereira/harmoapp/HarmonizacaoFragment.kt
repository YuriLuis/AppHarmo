package com.yuri.pereira.harmoapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.yuri.pereira.harmoapp.databinding.FragmentHarmonizacaoBinding

class HarmonizacaoFragment : Fragment(R.layout.fragment_harmonizacao) {
    private lateinit var binding: FragmentHarmonizacaoBinding
    private var adapter = ListaPratosAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHarmonizacaoBinding.bind(view)
        configuraRecyclerView()
        eventoPesquisaPersonagemSearchView()
    }

    private fun configuraRecyclerView() {
        binding.recycclerviewPratos.layoutManager =
            LinearLayoutManager(context)
        binding.recycclerviewPratos.adapter = adapter
        adapter.setListaPratos(getListaPratos())
    }

    private fun eventoPesquisaPersonagemSearchView() {
        binding.searchViewPesquisaPratos.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                adapter.setListaPratos(getPratosPorNome(query.toString()))
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.equals("")) {
                    adapter.setListaPratos(getListaPratos())
                }
                return true
            }
        })
    }

    private fun getPratosPorNome(params: String): List<Prato> {
        val listaCervejaPorNome = mutableListOf<Prato>()
        getListaPratos().forEach { prato ->
            if (prato.nome.contains(params, true)) {
                listaCervejaPorNome.add(prato)
            }
        }
        return listaCervejaPorNome
    }

    private fun getListaPratos(): List<Prato> {
        return mutableListOf(
            Prato(
                nome = "Amendoin",
                foto = "https://www.casamissao.com.br/wp-content/uploads/2020/07/amendoim-sem-pele-torrado-com-sal.jpg",
                listaCervejas = listOf(
                    Cerveja(
                        nome = "AntarcticaCristal",
                        descricao = "Antarctica Cristal foi a primeira cerveja brasileira com " +
                                "garrafa transparente, destacando, assim sua colora????o clara, " +
                                "t??pica das Pale Lagers. A Cristal possui aroma acentuado, sabor " +
                                "encorporado e levemente amargo, mas n??o deixa a refresc??ncia de lado " +
                                "- aspecto importante desde tipo de cerveja",
                        tipo = "American Larger",
                        ingredientes = "??gua, malte, milho e l??pulo",
                        alergicos = "Cont??m cevada e gl??ten",
                        mililitros = "355ml",
                        harmonizacao = "Combina com petiscos como queijos leves, castanhas, amendoins.",
                        teorAlcoolico = "5.4% vol",
                        ibu = "12",
                        foto = "https://www.damataleo.com.br/upload/produto/b22d63b779cc4eb899476f862ef57cc7.jpg"
                    ),
                    Cerveja(
                        nome = "Brahma Duplo Malte",
                        descricao = "O malte Munich ?? o respons??vel pela leveza, enquanto o malte Munich " +
                                "?? o respons??vel pelo sabor. O resultado disso ?? uma cerveja de cor dourada " +
                                "e espuma cremosa. Uma cerveja que tem mas sabor, mas ainda mant??m a leveza.",
                        tipo = "Premium American Larger",
                        ingredientes = "??gua, malte e l??pulo",
                        alergicos = "Cont??m cevada e gl??ten",
                        mililitros = "330ml",
                        harmonizacao = "Harmoniza com amendoim, croquete de carne e batata frita",
                        teorAlcoolico = "4.7% vol",
                        ibu = "11",
                        foto = "https://images.squarespace-cdn.com/content/v1/51ef2bf2e4b02bcf8471333b/1601496596051-9XND5XRN860DN3OHMERM/brahma-duplo-malte-longneck.jpg?format=1000w"
                    ),
                    Cerveja(
                        nome = "Colorado Cauim",
                        descricao = "Seu nome Cauim vem do Tupi e se refere a uma antiga bebida " +
                                "fermentada de cereais e mandioca, fabricada pelos ??ndios brasileiros. " +
                                "N??o por acaso esta deliciosa cerveja combina fermento alem??o, l??pulo tcheco, " +
                                "cevada maltada holandesa e, ?? claro, a brasileir??ssima mandioca.",
                        tipo = "Premium American Lager",
                        ingredientes = "??gua, malte, f??cula de mandioca e l??pulo.",
                        alergicos = "Cont??m cevada e gl??ten. Pode conter trigo",
                        mililitros = "600ml",
                        harmonizacao = "Combina com comidas leves como peixes e frango (carnes magras), petiscos, como amendoim, por exemplo, e saladas.",
                        teorAlcoolico = "4.5% vol",
                        ibu = "18",
                        foto = "https://www.cervejariacolorado.com.br/sites/g/files/wnfebl5201/files/styles/webp/public/paragraphs/product_size/2021-08/600%20ml_0.png.webp?itok=Eg0pGM9X"
                    ),
                    Cerveja(
                        nome = "Legitima",
                        descricao = "Feita no Cear?? para os cearences, com mandioca do interior que traz leveza e refresc??ncia para a cerveja. ",
                        tipo = "American Lager",
                        ingredientes = "??gua, malte, milho, mandioca e l??pulo.",
                        alergicos = "Cont??m cevada e gl??ten.",
                        mililitros = "600ml",
                        harmonizacao = "Por ser uma cerveja leve vai bem com frutos do mar, peixes e amendoim.",
                        teorAlcoolico = "4.4% vol",
                        ibu = "8",
                        foto = "https://courier-images-prod.imgix.net/produc_variant/00010273_52fcec1f-0350-4cc8-8915-626511f05932.jpg?auto=compress,format&fit=max&w=undefined&h=undefined&dpr=2"
                    ),
                    Cerveja(
                        nome = "Polar",
                        descricao = "Produzida a partir de maltes e l??pulos selecionados, Polar Export tem cor clara, " +
                                "processo de baixa fermenta????o, com aroma, sabor e amargor suaves. " +
                                "?? uma heran??a do Rio Grande do Sul, onde foi lan??ado em 1929, na cidade de Estrela. " +
                                "Em 1972 o controle da Cervejaria Polar foi adquirido pela Cia. Paulista Antarctica.",
                        tipo = "American Lager",
                        ingredientes = "??gua, malte, milho e l??pulo.",
                        alergicos = "Cont??m cevada e gl??ten.",
                        mililitros = "600ml",
                        harmonizacao = "Por ser uma cerveja leve, n??o deve ser harmonizada com pratos de sabor muito forte. " +
                                "Combina com petiscos como queijos leves, castanhas, amendoins e tamb??m com frutos do mar como camar??o, lula, mariscos e peixe.",
                        teorAlcoolico = "4.9% vol",
                        ibu = "9.5",
                        foto = "https://mullerbebidas.com.br/images/virtuemart/product/Polar-600ml.jpg"
                    )
                )
            ),
            Prato(
                nome = "Aves",
                foto = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQMJSyVdpNW3Ek71uG4eypom8z4DCWFSTbu_iIzy-XwCIVJDKzJFWhGePfSWIfwJpWZ-Hg&usqp=CAU",
                listaCervejas = listOf(
                    Cerveja(
                        nome = "Colorado Cauim",
                        descricao = "Seu nome Cauim vem do Tupi e se refere a uma antiga bebida " +
                                "fermentada de cereais e mandioca, fabricada pelos ??ndios brasileiros. " +
                                "N??o por acaso esta deliciosa cerveja combina fermento alem??o, l??pulo tcheco, " +
                                "cevada maltada holandesa e, ?? claro, a brasileir??ssima mandioca.",
                        tipo = "Premium American Lager",
                        ingredientes = "??gua, malte, f??cula de mandioca e l??pulo.",
                        alergicos = "Cont??m cevada e gl??ten. Pode conter trigo",
                        mililitros = "600ml",
                        harmonizacao = "Combina com comidas leves como peixes e frango (carnes magras), petiscos, como amendoim, por exemplo, e saladas.",
                        teorAlcoolico = "4.5% vol",
                        ibu = "18",
                        foto = "https://www.cervejariacolorado.com.br/sites/g/files/wnfebl5201/files/styles/webp/public/paragraphs/product_size/2021-08/600%20ml_0.png.webp?itok=Eg0pGM9X"
                    ),
                    Cerveja(
                        nome = "Goose Island Midway",
                        descricao = "A Goose Island Midway ?? uma Session IPA leve e refrescante. " +
                                "Ela tem sua hist??ria toda ligada ?? Chicago. Seu nome ?? origin??rio da Feira Mundial da cidade, " +
                                "de 1893. Em seu centro, estava a Midway Plaisance, uma ??rea que exibia a primeira roda gigante do mundo, " +
                                "reunindo visitantes de todas as nacionalidades. Nesse esp??rito, a cerveja ?? uma session pronta para reunir " +
                                "amantes de cerveja de todos os cantos do planeta com seu aroma tropical de l??pulo e um agrad??vel final maltado.",
                        tipo = "Session IPA",
                        ingredientes = "??gua, malte e l??pulo.",
                        alergicos = "Cont??m cevada e gl??ten.",
                        mililitros = "355ml",
                        harmonizacao = "Harmoniza com comida mexicana (tacos, quesadilla), chicken wings e hamb??rguer.",
                        teorAlcoolico = "4.1% vol",
                        ibu = "30",
                        foto = "https://dlp.agilecdn.com.br/008254_1.jpg"
                    ),
                    Cerveja(
                        nome = "Hoegaarden Wit Blanche",
                        descricao = "Hoegaarden ?? uma Witbier belga feita de trigo, n??o filtrada e de cor clara. " +
                                "As sementes de coentro e raspas de casca de laranja, utilizadas em sua receita, " +
                                "conferem um sabor refrescante, suave e ao mesmo tempo doce e levemente c??trico. " +
                                "Com um aroma marcante e sabor original, Hoegaarden ganhou o World Beer Cup?? Gold Award " +
                                "6 vezes e, harmoniza perfeitamente com peixes e frutos do mar.",
                        tipo = "Witbier",
                        ingredientes = "??gua, malte de cevada, trigo, semente de coentro, casca de laranja, l??pulo e estabilizante pectina de fruta.",
                        alergicos = "Cont??m cevada e gl??ten.",
                        mililitros = "330ml",
                        harmonizacao = "Cervejas arom??ticas como a Hoegaarden real??am o sabor de peixes, frango grelhado e ceviche." +
                                "A leve acidez da cerveja ajuda a quebrar a gordura de pratos mais gordurosos, como feijoada.",
                        teorAlcoolico = "4.9% vol",
                        ibu = "13",
                        foto = "https://www.ambev.com.br/conteudo/uploads/2019/03/hoegaarden_wit-blanche_330ml.png"
                    ),
                )
            ),
            Prato(
                nome = "Hamburguer",
                foto = "https://media.istockphoto.com/photos/snacks-hamburger-isolated-on-white-background-picture-id635875304?b=1&k=20&m=635875304&s=170667a&w=0&h=cRx1kKLLb81d0YMfDWKj3ZE6HY-9Ls56_F_DfKsbtpE=",
                listaCervejas = listOf(
                    Cerveja(
                        nome = "Budweiser",
                        descricao = "O processo de produ????oda Budweiser ?? diferenciado, por utilizar lascas " +
                                "de Beechwood (madeira especial) durante os processos de fermenta????o e matura????o. " +
                                "O resultado ?? um cerveja de sabor ??nico e com equil??brio perfeito: marcante no in??cio e suave no final.",
                        tipo = "American Lager",
                        ingredientes = "??gua, malte, arroz e l??pulo.",
                        alergicos = "Cont??m cevada e gl??ten.",
                        mililitros = "550ml",
                        harmonizacao = "O sabor marcante no come??o e suave no final de Budweiser pede que ela harmonize com hamb??rguer cl??ssico, presunto cozido e mix de castanhas.",
                        teorAlcoolico = "5% vol",
                        ibu = "10",
                        foto = "https://www.imigrantesbebidas.com.br/bebida/images/products/full/87278-cerveja-budweiser-550ml.jpg"
                    ),
                    Cerveja(
                        nome = "Goose Island Midway",
                        descricao = "A Goose Island Midway ?? uma Session IPA leve e refrescante. " +
                                "Ela tem sua hist??ria toda ligada ?? Chicago. Seu nome ?? origin??rio da Feira Mundial da cidade, " +
                                "de 1893. Em seu centro, estava a Midway Plaisance, uma ??rea que exibia a primeira roda gigante do mundo, " +
                                "reunindo visitantes de todas as nacionalidades. Nesse esp??rito, a cerveja ?? uma session pronta para reunir " +
                                "amantes de cerveja de todos os cantos do planeta com seu aroma tropical de l??pulo e um agrad??vel final maltado.",
                        tipo = "Session IPA",
                        ingredientes = "??gua, malte e l??pulo.",
                        alergicos = "Cont??m cevada e gl??ten.",
                        mililitros = "355ml",
                        harmonizacao = "Harmoniza com comida mexicana (tacos, quesadilla), chicken wings e hamb??rguer.",
                        teorAlcoolico = "4.1% vol",
                        ibu = "30",
                        foto = "https://dlp.agilecdn.com.br/008254_1.jpg"
                    )
                )
            ),
            Prato(
                nome = "Pizza",
                foto = "https://i.pinimg.com/736x/30/74/75/3074756e1c21d6a7e8e14ee339df13e7.jpg",
                listaCervejas = listOf(
                    Cerveja(
                        nome = "Colorado Cauim",
                        descricao = "Seu nome Cauim vem do Tupi e se refere a uma antiga bebida " +
                                "fermentada de cereais e mandioca, fabricada pelos ??ndios brasileiros. " +
                                "N??o por acaso esta deliciosa cerveja combina fermento alem??o, l??pulo tcheco, " +
                                "cevada maltada holandesa e, ?? claro, a brasileir??ssima mandioca.",
                        tipo = "Premium American Lager",
                        ingredientes = "??gua, malte, f??cula de mandioca e l??pulo.",
                        alergicos = "Cont??m cevada e gl??ten. Pode conter trigo",
                        mililitros = "600ml",
                        harmonizacao = "Combina com comidas leves como peixes e frango (carnes magras), petiscos, como amendoim, por exemplo, e saladas.",
                        teorAlcoolico = "4.5% vol",
                        ibu = "18",
                        foto = "https://www.cervejariacolorado.com.br/sites/g/files/wnfebl5201/files/styles/webp/public/paragraphs/product_size/2021-08/600%20ml_0.png.webp?itok=Eg0pGM9X"
                    )
                )
            ),
            Prato(
                nome = "Queijos",
                foto = "https://s1.1zoom.me/big0/856/Cheese_Many_White_485197.jpg",
                listaCervejas = listOf(
                    Cerveja(
                        nome = "AntarcticaCristal",
                        descricao = "Antarctica Cristal foi a primeira cerveja brasileira com " +
                                "garrafa transparente, destacando, assim sua colora????o clara, " +
                                "t??pica das Pale Lagers. A Cristal possui aroma acentuado, sabor " +
                                "encorporado e levemente amargo, mas n??o deixa a refresc??ncia de lado " +
                                "- aspecto importante desde tipo de cerveja",
                        tipo = "American Larger",
                        ingredientes = "??gua, malte, milho e l??pulo",
                        alergicos = "Cont??m cevada e gl??ten",
                        mililitros = "355ml",
                        harmonizacao = "Combina com petiscos como queijos leves, castanhas, amendoins.",
                        teorAlcoolico = "5.4% vol",
                        ibu = "12",
                        foto = "https://www.damataleo.com.br/upload/produto/b22d63b779cc4eb899476f862ef57cc7.jpg"
                    ),
                    Cerveja(
                        nome = "Polar",
                        descricao = "Produzida a partir de maltes e l??pulos selecionados, Polar Export tem cor clara, " +
                                "processo de baixa fermenta????o, com aroma, sabor e amargor suaves. " +
                                "?? uma heran??a do Rio Grande do Sul, onde foi lan??ado em 1929, na cidade de Estrela. " +
                                "Em 1972 o controle da Cervejaria Polar foi adquirido pela Cia. Paulista Antarctica.",
                        tipo = "American Lager",
                        ingredientes = "??gua, malte, milho e l??pulo.",
                        alergicos = "Cont??m cevada e gl??ten.",
                        mililitros = "600ml",
                        harmonizacao = "Por ser uma cerveja leve, n??o deve ser harmonizada com pratos de sabor muito forte. " +
                                "Combina com petiscos como queijos leves, castanhas, amendoins e tamb??m com frutos do mar como camar??o, lula, mariscos e peixe.",
                        teorAlcoolico = "4.9% vol",
                        ibu = "9.5",
                        foto = "https://mullerbebidas.com.br/images/virtuemart/product/Polar-600ml.jpg"
                    ),

                )
            )
        )
    }


}