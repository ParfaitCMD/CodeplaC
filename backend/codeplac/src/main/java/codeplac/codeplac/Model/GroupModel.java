package codeplac.codeplac.Model;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import codeplac.codeplac.Utils.JsonListConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "equipe")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_Equipe")
  private int idEquipe;

  @Column(name = "data_inscricao")
  private Instant dataInscricao;

  @Convert(converter = JsonListConverter.class)
  private List<Member> membros;

  @Column(name = "nome_equipe")
  private String nomeEquipe;

  @Column(name = "nome-lider")
  private String nomeLider;

  @OneToMany(mappedBy = "equipe")
  private List<RankingModel> classificacoes;

  @JsonIgnore
  @ManyToMany(mappedBy = "equipes")
  private List<UsersModel> usuarios;
}