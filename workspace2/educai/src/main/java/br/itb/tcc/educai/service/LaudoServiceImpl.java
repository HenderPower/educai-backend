package br.itb.tcc.educai.service;


import br.itb.tcc.educai.exceptions.BadRequest;
import br.itb.tcc.educai.exceptions.NotFound;
import br.itb.tcc.educai.model.Laudo;
import br.itb.tcc.educai.repository.LaudoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class LaudoServiceImpl implements LaudoService {
    private final LaudoRepository laudoRepository;

    public LaudoServiceImpl(LaudoRepository laudoRepository) {
        this.laudoRepository = laudoRepository;
    }
    @Override
    @Transactional
    public Laudo salvarLaudo(Laudo laudo) {
        if(!laudo.validarLaudo()){
            throw new BadRequest(laudo.getMensagemErro());
        }
        return laudoRepository.save(laudo);
    }

@Override
    public Laudo buscarLaudoPorId(Long id) {
        try{
            return laudoRepository.findById(id).get();
        }catch (Exception ex){
            throw new NotFound("Laudo não encontrado com o id " + id);
        }
}

    @Override
    @Transactional
    public Laudo atualizarLaudo(Laudo laudo, Long id) {
        try {
            if(!laudo.validarLaudo()) {
                throw new BadRequest(laudo.getMensagemErro());
            }
            Laudo laudoBd = laudoRepository.findById(id).get();
            //
            laudoBd.setCod_laudo(laudoBd.getCod_laudo());
            laudoBd.setNome_laudo(laudo.getNome_laudo());
            laudoBd.setTipo_defic(laudo.getTipo_defic());
            laudoBd.setObs_laudo(laudo.getObs_laudo());
            laudoBd.setData_laudo(laudo.getData_laudo());
            laudoBd.setRm_aluno(laudo.getRm_aluno());
            laudoBd.setCod_prof(laudo.getCod_prof());


            return laudoRepository.save(laudoBd);  // save : Update para objetos já existentes no Banco de dados

        }catch (Exception ex){
            throw new NotFound("Produto não encontrado com o id " + id);
        }

    }

    @Override
    public List<Laudo> listarTodosLaudos() {
        return laudoRepository.findAll();
    }

    @Override
    @Transactional
    public boolean deletarLaudo(Long id) {
        if(!laudoRepository.existsById(id)){
            throw new NotFound("Produto não encontrado com o id " + id);
        }
        laudoRepository.deleteById(id);
        return true;
    }



}

