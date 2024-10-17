package br.itb.tcc.educai.repository;
import br.itb.tcc.educai.model.Laudo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface LaudoRepository extends JpaRepository<Laudo, Long> {
}
