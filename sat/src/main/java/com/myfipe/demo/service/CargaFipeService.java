package com.myfipe.demo.service;

import com.myfipe.demo.dto.*;
import com.myfipe.demo.entity.*;
import com.myfipe.demo.repository.AnoRepository;
import com.myfipe.demo.repository.DadosRepository;
import com.myfipe.demo.repository.MarcaRepository;
import com.myfipe.demo.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargaFipeService {

    @Autowired
    private FipeService fipeService;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private AnoRepository anoRepository;

    @Autowired
    private DadosRepository dadosRepository;

    // Não limitei pra fazer um 'backup' de tudo, mas a API só deixa 1000 requisições por dia. :(
    public void executarCarga() throws InterruptedException {

        for (TipoVeiculo tipo : TipoVeiculo.values()) {

            List<MarcaDTO> marcas = fipeService.buscarMarcas(tipo.getPath());

            for (MarcaDTO marcaDTO : marcas) {

                Marca marca = salvarMarca(marcaDTO);

                List<ModeloDTO> modelos =
                        fipeService.buscarModelos(tipo.getPath(), marcaDTO.getCodigo());

                for (ModeloDTO modeloDTO : modelos) {

                    Modelo modelo = salvarModelo(modeloDTO, marca);

                    List<AnoDTO> anos =
                            fipeService.buscarAnos(tipo.getPath(), marcaDTO.getCodigo(), modeloDTO.getCodigo().toString());

                    for (AnoDTO anoDTO : anos) {
                        Thread.sleep(150);

                        Ano ano = salvarAno(anoDTO, modelo);

                        DadosDTO dadosDTO = fipeService.buscarDados(
                                tipo.getPath(),
                                marcaDTO.getCodigo(),
                                modeloDTO.getCodigo(),
                                anoDTO.getCodigo()
                        );

                        salvarDados(dadosDTO, ano);
                    }
                }
            }
        }
    }

    private Marca salvarMarca(MarcaDTO dto) {
        return marcaRepository.findByCodigo(dto.getCodigo())
                .orElseGet(() -> {
                    Marca m = new Marca();
                    m.setCodigo(dto.getCodigo());
                    m.setNome(dto.getNome());
                    return marcaRepository.save(m);
                });
    }

    private Modelo salvarModelo(ModeloDTO dto, Marca marca) {
        return modeloRepository.findByCodigo(dto.getCodigo())
                .orElseGet(() -> {
                    Modelo m = new Modelo();
                    m.setCodigo(dto.getCodigo());
                    m.setNome(dto.getNome());
                    m.setMarca(marca);
                    return modeloRepository.save(m);
                });
    }

    private Ano salvarAno(AnoDTO dto, Modelo modelo) {
        return anoRepository.findByCodigo(dto.getCodigo())
                .orElseGet(() -> {
                    Ano a = new Ano();
                    a.setCodigo(dto.getCodigo());
                    a.setNome(dto.getNome());
                    a.setModelo(modelo);
                    return anoRepository.save(a);
                });
    }

    private Dados salvarDados(DadosDTO dto, Ano ano) {
        Dados dados = new Dados();
        dados.setPrecoVeiculo(dto.getVhPrice());
        dados.setRefMes(dto.getReMonth());
        dados.setCodigoFipe(dto.getCdFipe());
        dados.setAcronimoGasolina(dto.getFuAcronym());
        dados.setTipoGasolina(dto.getFuType());
        dados.setTipoVeiculo(dto.getVhType());
        dados.setMarcaVeiculo(dto.getVhBrand());
        dados.setModeloVeiculo(dto.getVhModel());
        dados.setAnoModelo(dto.getMdYear());
        dados.setAno(ano);

        return dadosRepository.save(dados);
    }
}
