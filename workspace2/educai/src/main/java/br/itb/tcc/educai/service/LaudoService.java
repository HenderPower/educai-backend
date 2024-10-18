package br.itb.tcc.educai.service;
import br.itb.tcc.educai.model.Laudo;
import java.util.List;
public interface LaudoService {
    public Laudo salvarLaudo(Laudo laudo);
    public Laudo buscarLaudoPorId(Long id);
    public Laudo atualizarLaudo(Laudo laudo, Long id);
    public List<Laudo> listarTodosLaudos();
    public boolean deletarLaudo(Long id);

}